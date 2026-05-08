package com.smartfinance.api.dto;

import java.util.UUID;

public record StreamingDTO(
    UUID externalID, 
    String category, 
    String serviceName,
    String description,
    Double price,
    String billingDate
) {
}
