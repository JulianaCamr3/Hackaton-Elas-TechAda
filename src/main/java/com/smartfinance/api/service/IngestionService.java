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
        "http://localhost:8080/stream-api/netflix",
        "http://localhost:8080/stream-api/disney",
        "http://localhost:8080/stream-api/spotify",
        "http://localhost:8080/stream-api/amazonPrime",
        "http://localhost:8080/stream-api/xbox"
        );
    try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
        for (String url : urls) {
            executor.submit(() -> {
                try {
                    // O RestTemplate chama o seu próprio Controller
                    System.out.println("Consumindo: " + Thread.currentThread().getName() + " - " + url);
                    StreamingDTO data = restTemplate.getForObject(url, StreamingDTO.class);
                    if (data != null) {
                        processAndSave(data, user);
                    }
                } catch (Exception e) {
                    System.err.println("Error when consuming " + url + ": " + e.getMessage());
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