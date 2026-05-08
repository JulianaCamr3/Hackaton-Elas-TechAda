package com.smartfinance.api.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartfinance.api.exception.NotFoundException;
import com.smartfinance.api.model.ExpenseEntity;
import com.smartfinance.api.repository.ExpenseRepository;
import jakarta.transaction.Transactional;

@Service
public class ExpenseService {
    
    @Autowired
    ExpenseRepository expenseRepository; 

    public ExpenseEntity saveUser(ExpenseEntity expenseEntity){
        return expenseRepository.save(expenseEntity);
    }

    public List<ExpenseEntity> allUsers(){
        return expenseRepository.findAll();
    }

    @Transactional
    public void deleteUser(UUID id){
        if (!expenseRepository.existsById(id)) {
            throw new NotFoundException("This user doesn't exist in our system");
        }

        expenseRepository.deleteById(id);
        expenseRepository.flush();
    }
}
