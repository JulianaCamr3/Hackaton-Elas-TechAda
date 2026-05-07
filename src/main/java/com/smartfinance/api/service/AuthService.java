package com.smartfinance.api.service;

import com.smartfinance.api.domain.entity.User;
import com.smartfinance.api.domain.repository.UserRepository;
import com.smartfinance.api.dto.request.LoginRequest;
import com.smartfinance.api.dto.request.RegisterRequest;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final JWTService jwtService;

    public AuthService(UserRepository userRepository, JWTService jwtService) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    public User register(RegisterRequest req) {
        //userRepository.findByEmail(req.email()).orElseThrow(() -> new RuntimeException("Já existe usuário com esse e-mail cadastrado!"));

        User user = User
                .builder()
                .username(req.username())
                .email(req.email())
                .password(req.password())
                .build();

        return userRepository.save(user);
    }

    public String login(LoginRequest req) {
        User user = userRepository.findByEmail(req.email())
                .orElseThrow(() -> new RuntimeException("Não há nenhum usuário com esse e-mail cadastrado"));

        if (!user.getPassword().equals(req.password())) {
            throw new RuntimeException("Senha inválida! Tente novamente");
        }

        return jwtService.generateToken(user.getEmail());
    }


}
