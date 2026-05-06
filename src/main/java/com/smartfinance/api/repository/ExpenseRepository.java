package com.smartfinance.api.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartfinance.api.model.ExpenseEntity;

public interface ExpenseRepository extends JpaRepository<ExpenseEntity, UUID > {
    
}
