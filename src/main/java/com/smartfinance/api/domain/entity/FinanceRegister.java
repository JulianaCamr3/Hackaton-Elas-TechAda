package com.smartfinance.api.domain.entity;

import java.math.BigDecimal;

public class FinanceRegister {
    private String name;
    private String email;
    private String service;
    private String category;
    private BigDecimal monthValue;
    private int activeMonths;
    private BigDecimal totalSpent;

    public FinanceRegister(String name, String email, String service, String category, double monthValue, int activeMonths) {
        this.name = name;
        this.email = email;
        this.service = service;
        this.category = category;
        this.monthValue = BigDecimal.valueOf(monthValue);
        this.activeMonths = activeMonths;
        this.totalSpent = this.monthValue.multiply(BigDecimal.valueOf(activeMonths));
    }
}
