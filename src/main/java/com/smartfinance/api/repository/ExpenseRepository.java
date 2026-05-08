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
public interface ExpenseRepository extends JpaRepository<ExpenseEntity, UUID > {
    
    // soma dos gastos por categoria
    @Query("SELECT SUM(e.amount) FROM ExpenseEntity e WHERE e.expense_user =: expense_user AND  e.category = :category")
    Double sumAmountByUserAndCategory(@Param("user") UserEntity user, @Param("category") String category);
    
    // soma dos gastos por período
    @Query("SELECT SUM(e.date) FROM ExpenseEntity e WHERE e.expense_user =: expense_user AND e.date >= date")
    Double sumTotalSpentLast30Days(@Param("user") UserEntity user, @Param("date") LocalDateTime date);
}
