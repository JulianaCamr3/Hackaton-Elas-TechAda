package com.smartfinance.api.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartfinance.api.dto.StreamingDTO;

@RestController
@RequestMapping("/stream-api")
public class StreamingsController {

    @GetMapping("/netflix")
    public StreamingDTO getNetflixData() {
        return new StreamingDTO(
            UUID.fromString("6f7d2e9a-4a1d-4e9b-8c7a-9b8c7d6e5f4a"),
            "MOVIE",
            "NETFLIX", 
            "ASSINATURA MENSAL", 
            55.90,
            "2026-05-10"
        );
    }

    @GetMapping("/disney")
    public StreamingDTO getDisneyData() {
        return new StreamingDTO(
            UUID.fromString("7f8e3f0b-5b2e-4f0c-9d8b-0c9d8e7f6a5b"),
            "MOVIE",
            "DISNEY+", 
            "ASSINATURA MENSAL", 
            46.90,
            "2026-05-12"
        );
    }

    @GetMapping("/spotify")
    public StreamingDTO getSpotifyData() {
        return new StreamingDTO(
            UUID.fromString("8a9f4e1c-6c3f-4a1d-0e9c-1d0e9f8a7b6c"),
            "MUSIC",
            "SPOTIFY", 
            "ASSINATURA MENSAL", 
            9.99,
            "2026-05-15"
        );
    }

    @GetMapping("/amazonPrime")
    public StreamingDTO getAmazonPrimeData() {
        return new StreamingDTO(
            UUID.fromString("9a0f5e2d-7d4a-4b2e-1f0d-2e1f0a9b8c7d"),
            "MOVIE",
            "AMAZON PRIME", 
            "ASSINATURA MENSAL", 
            19.90,
            "2026-05-18"
        );
    }

    @GetMapping("/xbox")
    public StreamingDTO getXboxData() {
        return new StreamingDTO(
            UUID.fromString("a1b2c3d4-e5f6-4a5b-8c7d-9e0f1a2b3c4d"),
            "GAMING",
            "XBOX GAME PASS", 
            "ASSINATURA MENSAL", 
            76.90,
            "2026-05-20"
        );
    }
}