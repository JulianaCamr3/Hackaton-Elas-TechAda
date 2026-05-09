package com.smartfinance.api.domain.repository;

import java.util.UUID;

import com.smartfinance.api.domain.entity.Income;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeRepository extends JpaRepository<Income, UUID > {
    
}
