package com.smartfinance.api.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.Column ;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Getter
@Setter
@Entity
@Table(name = "expense")
public class ExpenseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "userID")
    private UUID userId;

    @Column(name = "category")
    private String category;

    LocalDateTime transitionDate = LocalDateTime.now();
    @Column(name = "date")
    private String date = transitionDate.toString();

    @Column(name = "description")
    private String description;
}
