package com.smartfinance.api.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartfinance.api.exception.NotFoundException;
import com.smartfinance.api.model.IncomeEnity;
import com.smartfinance.api.repository.IncomeRepository;
import jakarta.transaction.Transactional;

@Service
public class IncomeService {
    
    @Autowired
    IncomeRepository incomeRepository; 

    public IncomeEnity saveUser(IncomeEnity incomeEnity){
        return incomeRepository.save(incomeEnity);
    }

    public List<IncomeEnity> allUsers(){
        return incomeRepository.findAll();
    }

    @Transactional
    public void deleteUser(UUID id){
        if (!incomeRepository.existsById(id)) {
            throw new NotFoundException("This user doesn't exist in our system");
        }

        incomeRepository.deleteById(id);
        incomeRepository.flush();
    }
}
