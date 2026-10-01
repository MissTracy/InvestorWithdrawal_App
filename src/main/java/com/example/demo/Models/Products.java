package com.example.demo.Models;
/** Models represent the application's data as Java objects.
 * They are mapped to database tables using JPA annotations.
 */

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    private String productName;
    private BigDecimal balance;

    @Enumerated(EnumType.STRING) // Use EnumType.STRING for storing enum values as strings
    private ProductType productType;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "investorId", insertable = false, updatable = false)
    private Investor investor;

    public Products() {
        // Default constructor
    }

    public Products(String productName, BigDecimal balance, ProductType productType) {
        this.productName = productName;
        this.balance = balance;
        this.productType = productType;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public Investor getInvestor() {
        return investor;
    }

    public void setInvestor(Investor investor) {
        this.investor = investor;
    }

    public enum ProductType {
        RETIREMENT("Retirement Account", BigDecimal.valueOf(500000.00)),
        SAVINGS("Savings Account", BigDecimal.valueOf(36000.00));

        private final String productName;
        private final BigDecimal initialBalance;

        ProductType(String productName, BigDecimal initialBalance) {
            this.productName = productName;
            this.initialBalance = initialBalance;
        }

        public String getProductName() {
            return productName;
        }

        public BigDecimal getInitialBalance() {
            return initialBalance;
        }
    }
}