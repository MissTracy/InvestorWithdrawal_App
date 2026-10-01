package com.example.demo.Models;

import java.math.BigDecimal;

public class WithdrawalRequest {

    private Long investorId;
    private BigDecimal amount;

    public Long getInvestorId() {
        return investorId;
    }

    public void setInvestorId(Long investorId) {
        this.investorId = investorId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}