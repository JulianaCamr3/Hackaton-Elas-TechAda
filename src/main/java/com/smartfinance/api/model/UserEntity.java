package com.smartfinance.api.model;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.Collate;

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
    
    @OneToMany(mappedBy = "expense_user")
    private List<ExpenseEntity> expenses_user;
    
    @OneToMany(mappedBy = "income_user")
    private List<IncomeEntity> incomes_user;
    
}
