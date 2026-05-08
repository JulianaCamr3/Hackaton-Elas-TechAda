package com.smartfinance.api.service;

import com.smartfinance.api.domain.entity.User;
import com.smartfinance.api.domain.repository.UserRepository;
import com.smartfinance.api.dto.request.LoginRequest;
import com.smartfinance.api.dto.request.RegisterRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final JWTService jwtService;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, JWTService jwtService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }

    public User register(RegisterRequest req) {
        User user = User
                .builder()
                .username(req.username())
                .email(req.email())
                .password(passwordEncoder.encode(req.password()))
                .build();

        return userRepository.save(user);
    }

    public String login(LoginRequest req) {
        User user = userRepository.findByEmail(req.email())
                .orElseThrow(() -> new RuntimeException("Não há nenhum usuário com esse e-mail cadastrado"));

        if (!passwordEncoder.matches(req.password(), user.getPassword())) {
            throw new RuntimeException("Senha inválida! Tente novamente");
        }

        return jwtService.generateToken(user.getEmail());
    }


}
