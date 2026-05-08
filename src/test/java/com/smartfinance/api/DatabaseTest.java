package com.smartfinance.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.smartfinance.api.model.UserEntity;
import com.smartfinance.api.repository.UserRepository;

import static org.assertj.core.api.Assertions.assertThat;
public class DatabaseTest {
    
    @Autowired
    private UserRepository userRepository;

    @Test
    void saveUser(){
        UserEntity userEntity = new UserEntity();

        userEntity.setEmail("email");
        userEntity.setHash("null");
        userEntity.setUsername("name");

        UserEntity userSaved = userRepository.save(userEntity);

        assertThat(userSaved).isNotNull();
        assertThat(userSaved.getId()).isNotNull();
        assertThat(userSaved.getUsername()).isEqualTo("João");

    }
}
