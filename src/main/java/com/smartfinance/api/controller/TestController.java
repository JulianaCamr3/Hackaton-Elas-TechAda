package com.smartfinance.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/test-ingestion")
public String test() {
    UserEntity user = userRepository.findAll().get(0); // Pega o primeiro usuário existente
    ingestionService.runIngestion(user);
    return "Ingestão disparada! Verifique o console e o banco.";
}
}
