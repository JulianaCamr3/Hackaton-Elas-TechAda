package com.smartfinance.api.controller;

import java.util.List;
import java.util.UUID;

import com.smartfinance.api.domain.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity; 

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smartfinance.api.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveUser(@RequestBody User userEntity ){
        userService.saveUser(userEntity);

        return ResponseEntity
        .status(HttpStatus.CREATED)
        .body("The user is saved in the database");
    }

    @GetMapping("/list")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity
        .status(HttpStatus.ACCEPTED)
        .body(userService.allUsers());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") UUID id){
        userService.deleteUser(id);
        return ResponseEntity
        .status(HttpStatus.ACCEPTED)
        .body("It's already deleted");
    }
}
