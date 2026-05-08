package com.smartfinance.api.repository;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartfinance.api.model.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID > {
    
}
