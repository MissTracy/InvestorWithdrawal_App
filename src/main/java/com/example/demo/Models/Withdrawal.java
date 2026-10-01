package com.example.demo.Models;
/** Models represent the application's data as Java objects.
 * They are mapped to database tables using JPA annotations.
 */

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

//class used to represent withdrawal request data
@Entity
public class Withdrawal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long withdrawalId;

    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "investor_id")
    private Investor investor;

    public Long getWithdrawalId() {
        return withdrawalId;
    }

    public Investor getInvestor() {
        return investor;
    }

    public void setInvestor(Investor investor) {
        this.investor = investor;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setProduct() {
    }

}