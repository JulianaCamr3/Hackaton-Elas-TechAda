package com.smartfinance.api.repository;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.smartfinance.api.model.ExpenseEntity;
import com.smartfinance.api.model.UserEntity;

@Repository
public interface ExpenseRepository extends JpaRepository<ExpenseEntity, UUID> {

    // 1. Verificação de duplicidade (Corrigido para o padrão CamelCase do Spring Data)
    boolean existsByExternalIDAndExpenseUser(UUID externalID, UserEntity user);
    
    // 2. Soma dos gastos por categoria
    @Query("SELECT SUM(e.amount) FROM ExpenseEntity e WHERE e.expenseUser = :user AND e.category = :category")
    Double sumAmountByUserAndCategory(@Param("user") UserEntity user, @Param("category") String category);
    
    // 3. Soma dos gastos por período
    @Query("SELECT SUM(e.amount) FROM ExpenseEntity e WHERE e.expenseUser = :user AND e.date >= :startDate")
    Double sumTotalSpentSince(@Param("user") UserEntity user, @Param("startDate") LocalDateTime startDate);

}