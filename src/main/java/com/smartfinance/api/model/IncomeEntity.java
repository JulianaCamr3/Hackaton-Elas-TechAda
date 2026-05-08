package com.smartfinance.api.model;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "income")
//  Income é o dinheiro ganho (salário, vendas)
public class IncomeEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "income_user", nullable = false)
    @JsonBackReference
    private UserEntity income_user;

    @Column(name = "amount")
    private double amount;

    @Column(name = "date")
     private LocalDateTime transitionDate = LocalDateTime.now();
}
