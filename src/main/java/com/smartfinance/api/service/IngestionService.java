package com.smartfinance.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// implementação do virtual threads

import com.smartfinance.api.model.UserEntity;
import com.smartfinance.api.repository.ExpenseRepository;
@Service
public class IngestionService  {
    
    @Autowired
    ExpenseRepository expenseRepository;

    public void virtualThreads(UserEntity userEntity){
        String apiNetflix =
    }
}
