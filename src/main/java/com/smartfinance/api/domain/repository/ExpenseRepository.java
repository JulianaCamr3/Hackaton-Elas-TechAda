package com.smartfinance.api.domain.repository;

import java.time.LocalDateTime;
import java.util.UUID;

import com.smartfinance.api.domain.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.smartfinance.api.domain.entity.User;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, UUID > {
    
    // soma dos gastos por categoria
    @Query("SELECT SUM(e.amount) FROM Expense e WHERE e.expense_user =: expense_user AND  e.category = :category")
    Double sumAmountByUserAndCategory(@Param("user") User user, @Param("category") String category);
    
    // soma dos gastos por período
    @Query("SELECT SUM(e.date) FROM Expense e WHERE e.expense_user =: expense_user AND e.date >= date")
    Double sumTotalSpentLast30Days(@Param("user") User user, @Param("date") LocalDateTime date);
}
