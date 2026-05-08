package com.smartfinance.api.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Getter
@Setter
@Entity
@Table(name = "expense")
//  Expense é o gasto para manter operações ou estilo de vida
public class ExpenseEntity {
    private static final long serialVersionUID = 1L;
   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    
    @Column(name = "category")
    private String category;
    
    @Column(name = "externalID")
    private UUID externalID;
    
    @Column(name = "date")
    private LocalDateTime date = LocalDateTime.now();
        
    @ManyToOne
    @JoinColumn(name = "expense_user", nullable = false)
    private UserEntity expense_user;

    @Column(name = "amount")
    private double amount;

    @Column(name = "description")
    private String description;
}
