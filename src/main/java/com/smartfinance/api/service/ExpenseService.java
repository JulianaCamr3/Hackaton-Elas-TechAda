package com.smartfinance.api.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.smartfinance.api.domain.entity.Expense;
import com.smartfinance.api.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartfinance.api.exception.NotFoundException;
import com.smartfinance.api.domain.repository.ExpenseRepository;
import jakarta.transaction.Transactional;

@Service
public class ExpenseService {
    
    @Autowired
    ExpenseRepository expenseRepository;
    private Expense expenseEntity;

    public Double sumAmountByUserAndCategory(User userEntity, String category){
        Double total = expenseRepository.sumAmountByUserAndCategory(userEntity, category);
        return (total != null) ? total : 0.0;
    }
    
    public Double sumAmountBy30Days(User userEntity){
        LocalDateTime days_30 = LocalDateTime.now().minusDays(30);
        Double total = expenseRepository.sumTotalSpentLast30Days(userEntity,days_30);
        return (total != null) ? total : 0.0;
        }

    public Expense saveExpense(Expense expenseEntity){
        this.expenseEntity = expenseEntity;
        return expenseRepository.save(expenseEntity);
    }

    public List<Expense> allExpense(){
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
