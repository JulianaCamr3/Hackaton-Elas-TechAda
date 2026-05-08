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
        "NETFLIX", "ASSINATURA MENSAL", 55.90,
        "25-09"
    );
    }
    @GetMapping("/disney")
    public StreamingDTO getDisneyData() {
        return new StreamingDTO(
        UUID.fromString("6f7d2e9a-4a1d-4e9b-8c7a-9b8c7d6e5f4a"),
        "MOVIE",
        "DISNEY+", "ASSINATURA MENSAL", 46.90,
        "10-10"
    );
    }
    @GetMapping("/spotify")
    public StreamingDTO getSpotifyData() {
        return new StreamingDTO(
        UUID.fromString("8h9f4g1c-6c3f-6g1d-0e9c-1d0e9f8g7h6c"),
        "MUSIC",
        "SPOTIFY", "ASSINATURA MENSAL", 9.99,
        "15-10"
    );
    }
  
    @GetMapping("/amazonPrime")
    public StreamingDTO getAmazonPrimeData() {
         return new StreamingDTO(
        UUID.fromString("6f7d2e9a-4a1d-4e9b-8c7a-9b8c7d6e5f4a"),
        "MOVIE",
        "NETFLIX", "ASSINATURA MENSAL", 55.90,
        "25-09"
    );
    }
    @GetMapping("/xbox")
    public StreamingDTO getXboxData() {
        return new StreamingDTO(
            UUID.fromString("9i0g5h2d-7d4g-7h2e-1f0d-2e1f0g9h8i7d"),
            "GAMING",
            "XBOX", "ASSINATURA MENSAL", 76.90,
            "20-10"
        );
    }
}
