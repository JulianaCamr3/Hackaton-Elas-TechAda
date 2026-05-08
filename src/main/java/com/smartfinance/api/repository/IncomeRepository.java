package com.smartfinance.api.repository;

import java.util.UUID;

import com.smartfinance.api.model.IncomeEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeRepository extends JpaRepository<IncomeEntity, UUID > {
    
}
