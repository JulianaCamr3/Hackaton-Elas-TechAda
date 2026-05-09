package com.smartfinance.api.service;

import java.util.List;
import java.util.UUID;

import com.smartfinance.api.domain.entity.Income;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartfinance.api.exception.NotFoundException;
import com.smartfinance.api.domain.repository.IncomeRepository;
import jakarta.transaction.Transactional;

@Service
public class IncomeService {
    
    @Autowired
    IncomeRepository incomeRepository; 

    public Income saveIncome(Income incomeEntity){
        return incomeRepository.save(incomeEntity);
    }

    public List<Income> allIncomes(){
        return incomeRepository.findAll();
    }

    @Transactional
    public void deleteIncome(UUID id){
        if (!incomeRepository.existsById(id)) {
            throw new NotFoundException("This user doesn't exist in our system");
        }

        incomeRepository.deleteById(id);
        incomeRepository.flush();
    }
}
