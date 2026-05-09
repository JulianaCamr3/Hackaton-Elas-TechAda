package com.smartfinance.api.service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.smartfinance.api.dto.StreamingDTO;
import com.smartfinance.api.model.ExpenseEntity;
import com.smartfinance.api.model.IncomeEntity;
import com.smartfinance.api.model.UserEntity;
import com.smartfinance.api.repository.ExpenseRepository;
import com.smartfinance.api.repository.IncomeRepository;

@Service
public class IngestionService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ExpenseRepository expenseRepository;
    
    @Autowired
    private IncomeRepository incomeRepository;

    public void runIngestion(UserEntity user) {
        // 1. Garantir que o usuário tenha uma receita ANTES de processar as despesas
        // Isso evita que a lógica de Income rode várias vezes dentro das threads
        ensureUserHasIncome(user);

        List<String> urls = List.of(
            "http://localhost:8080/stream-api/netflix",
            "http://localhost:8080/stream-api/disney",
            "http://localhost:8080/stream-api/spotify",
            "http://localhost:8080/stream-api/amazon-prime", // Ajustado para bater com o Controller
            "http://localhost:8080/stream-api/xbox"
        );

        Set<UUID> idsProcessados = Collections.synchronizedSet(new HashSet<>());

        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (String url : urls) {
                executor.submit(() -> {
                    try {
                        StreamingDTO data = restTemplate.getForObject(url, StreamingDTO.class);
                        
                        if (data != null && idsProcessados.add(data.externalID())) {
                            processAndSaveExpense(data, user);
                        }
                    } catch (Exception e) {
                        System.err.println("Error when consuming " + url + ": " + e.getMessage());
                    }
                });
            }
        }
    }

    private void ensureUserHasIncome(UserEntity user) {
        // Verifica se já existe receita para não duplicar
        if (!incomeRepository.existsByIncomeUser(user)) {
            IncomeEntity salary = new IncomeEntity();
            salary.setAmount(5000.00);
            salary.setTransitionDate(LocalDateTime.now());
            salary.setIncomeUser(user);
            incomeRepository.save(salary);
            System.out.println("Receita gerada automaticamente.");
        }
    }

    private void processAndSaveExpense(StreamingDTO record, UserEntity user) {
        // Agora verifica APENAS se a despesa específica já existe
        if (!expenseRepository.existsByExternalIDAndExpenseUser(record.externalID(), user)) {
            ExpenseEntity expense = new ExpenseEntity();
            expense.setExternalID(record.externalID());
            
            String desc = (record.description() != null) ? record.description() : record.serviceName();
            expense.setDescription(desc);
            
            expense.setAmount(record.price());
            expense.setCategory(record.category().toUpperCase());
            expense.setExpenseUser(user);
            
            expenseRepository.save(expense);
            System.out.println("Salvo com sucesso: " + record.serviceName());
        } else {
            System.out.println("Gasto já existente: " + record.serviceName());
        }
    }
}