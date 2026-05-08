package com.smartfinance.api.controller;

import com.smartfinance.api.domain.repository.UserRepository;
import com.smartfinance.api.dto.request.LoginRequest;
import com.smartfinance.api.dto.request.RegisterRequest;
import com.smartfinance.api.dto.response.AuthResponse;
import com.smartfinance.api.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;
    private final UserRepository userRepository;

    public AuthController(AuthService authService, UserRepository userRepository) {
        this.authService = authService;
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest req) {
        String token = authService.login(req);
        return ResponseEntity.ok(new AuthResponse(token));
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest req) {

        if (userRepository.findByEmail(req.email()).isPresent()) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body("Já existe conta cadastrada com esse e-mail!");
        }
        authService.register(req);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Usuário criado com sucesso!");
    }
}
