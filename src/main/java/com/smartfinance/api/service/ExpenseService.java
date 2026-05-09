package com.smartfinance.api.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartfinance.api.exception.NotFoundException;
import com.smartfinance.api.model.ExpenseEntity;
import com.smartfinance.api.model.UserEntity;
import com.smartfinance.api.repository.ExpenseRepository;

import jakarta.transaction.Transactional;

@Service
public class ExpenseService {
    
    @Autowired
    ExpenseRepository expenseRepository; 
    
    public Double sumAmountByUserAndCategory(UserEntity userEntity, String category){
        Double total = expenseRepository.sumAmountByUserAndCategory(userEntity, category);
        return (total != null) ? total : 0.0;
    }
    
    public Double sumAmountBy30Days(UserEntity userEntity){
        LocalDateTime days_30 = LocalDateTime.now().minusDays(30);
        Double total = expenseRepository.sumTotalSpentSince(userEntity,days_30);
        return (total != null) ? total : 0.0;
        }

    public ExpenseEntity saveExpense(ExpenseEntity expenseEntity){
        return expenseRepository.save(expenseEntity);
    }

    public List<ExpenseEntity> allExpense(){
        return expenseRepository.findAll();
    }

    @Transactional
    public void deleteExpense(UUID id){
        if (!expenseRepository.existsById(id)) {
            throw new NotFoundException("This user doesn't exist in our system");
        }
        expenseRepository.deleteById(id);
        expenseRepository.flush();
    }
}
