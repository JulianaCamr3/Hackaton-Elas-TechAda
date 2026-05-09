package com.smartfinance.api.model;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
@NoArgsConstructor
public class UserEntity  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    
    @Column(name ="username", nullable = false)
    private String username;
    
    @Column(name ="hash", nullable = false)
    private String hash;
    
    @Column(name ="email", nullable = false)
    private String email;
    
    @OneToMany(mappedBy = "expenseUser")
    @JsonManagedReference
    private List<ExpenseEntity> expensesUser;
    
    @OneToMany(mappedBy = "incomeUser")
    private List<IncomeEntity> incomesUser;
    
}
