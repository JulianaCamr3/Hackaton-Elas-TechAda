package com.smartfinance.api.repository;

import java.util.UUID;

import com.smartfinance.api.model.IncomeEnity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeRepository extends JpaRepository<IncomeEnity, UUID > {
    
}
