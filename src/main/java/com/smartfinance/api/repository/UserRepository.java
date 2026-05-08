package com.smartfinance.api.repository;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartfinance.api.model.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID > {
    
}
