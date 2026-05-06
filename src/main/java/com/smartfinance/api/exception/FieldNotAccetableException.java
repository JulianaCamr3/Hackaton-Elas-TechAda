package com.smartfinance.api.exception;

import lombok.Getter;

@Getter
public class FieldNotAccetableException extends RuntimeException {
    public FieldNotAccetableException(String message) {
        super(message);
    }
}