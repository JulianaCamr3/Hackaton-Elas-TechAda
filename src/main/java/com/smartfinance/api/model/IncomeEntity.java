package com.smartfinance.api.model;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name = "income", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"income_user"}) // Nome da coluna física no banco
})
public class IncomeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "income_user", nullable = false) // Use snake_case para evitar erros no SQL
    @JsonBackReference
    private UserEntity incomeUser;

    private double amount;
    private LocalDateTime transitionDate = LocalDateTime.now();
}