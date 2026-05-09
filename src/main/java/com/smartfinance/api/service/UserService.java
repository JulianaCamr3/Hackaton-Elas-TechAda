package com.smartfinance.api.service;

import java.util.List;
import java.util.UUID;

import com.smartfinance.api.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartfinance.api.exception.NotFoundException;
import com.smartfinance.api.domain.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
    
    @Autowired
    UserRepository userRepository; 

    public User saveUser(User userEntity){
        return userRepository.save(userEntity);
    }

    public List<User> allUsers(){
        return userRepository.findAll();
    }

    @Transactional
    public void deleteUser(UUID id){
        if (!userRepository.existsById(id)) {
            throw new NotFoundException("This user doesn't exist in our system");
        }

        userRepository.deleteById(id);
        userRepository.flush();
    }
}
