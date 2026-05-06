package com.smartfinance.api.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorDetails {
    private String message;
    private java.sql.Date timestamp;
}
