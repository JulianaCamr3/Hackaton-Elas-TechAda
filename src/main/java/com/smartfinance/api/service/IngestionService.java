package com.smartfinance.api.service;

import java.util.List;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.smartfinance.api.dto.StreamingDTO;
import com.smartfinance.api.model.ExpenseEntity;
import com.smartfinance.api.model.UserEntity;
import com.smartfinance.api.repository.ExpenseRepository;

@Service
public class IngestionService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ExpenseRepository expenseRepository;

    public void runIngestion(UserEntity user) {
        // Lista de URLs das suas APIs simuladas (Mocks)
        List<String> urls = List.of(
            "https://api.mock.com/netflix",
            "https://api.mock.com/amazonPrime",
            "https://api.mock.com/disney",
            "https://api.mock.com/xbox",
            "https://api.mock.com/spotify"
        );

        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (String url : urls) {
                executor.submit(() -> {
                    try {
                        // 1. Consome a API e mapeia para o Record
                        StreamingDTO data = restTemplate.getForObject(url, StreamingDTO.class);
                        if (data != null) {
                            processAndSave(data, user);
                        }
                    } catch (Exception e) {
                        System.err.println("Erro ao consumir " + url + ": " + e.getMessage());
                    }
                });
            }
        }
    }

    private void processAndSave(StreamingDTO record, UserEntity user) {
        // 2. Deduplicação: Verifica se o ID externo já existe
        if (!expenseRepository.existsById(record.externalID())) {
            // 3. Normalização: Converte Record para Entity
            ExpenseEntity expense = new ExpenseEntity();
            expense.setExternalID(record.externalID());
            expense.setDescription(record.description());
            expense.setAmount(record.price());
            expense.setCategory(record.category().toUpperCase());
            expense.setExpense_user(user);
            expenseRepository.save(expense);
            System.out.println("Salvo: " + record.serviceName());
        }
    }
}