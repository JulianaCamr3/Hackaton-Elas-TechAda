package com.smartfinance.api.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.smartfinance.api.model.UserEntity;
import com.smartfinance.api.repository.UserRepository;
import com.smartfinance.api.service.IngestionService;

@RestController
public class TestController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private IngestionService ingestionService;

@GetMapping("/ingestion/{userId}")
public String test(@PathVariable UUID userId) { // Use UUID aqui se o seu banco usa UUID
    UserEntity user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("Usuário não encontrado com o ID: " + userId));
    
    ingestionService.runIngestion(user);
    return "Ingestão disparada para: " + user.getUsername();
}
}
