package com.smartfinance.api.dto;

import java.util.UUID;

public record StreamingDTO(
    UUID externalID, 
    String category, 
    String serviceName,
    Double price,
    String billingDate
) {
}
