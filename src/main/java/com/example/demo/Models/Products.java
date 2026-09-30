package com.example.demo.Models;
/** Models represent the application's data as Java objects.
 * They are mapped to database tables using JPA annotations.
 */

import java.math.BigDecimal;

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

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    private String productName;
    private BigDecimal balance;

    @Enumerated(EnumType.STRING) // Use EnumType.STRING for storing enum values as strings
    private ProductType productType;

    @ManyToOne
    @JoinColumn(name = "investorId" , insertable = false, updatable = false)
    private Investor investor;

    public Products() {
        // Default constructor
    }

    public Products(String productName, BigDecimal balance, ProductType productType) {
        this.productName = productName;
        this.balance = balance;
        this.productType = productType;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }


    public enum ProductType {
        RETIREMENT(1, "Retirement Account", BigDecimal.valueOf(500000.00)),
        SAVINGS(2, "Savings Account", BigDecimal.valueOf(36000.00));

        private final int productId;
        private final String productName;
        private final BigDecimal initialBalance;


        ProductType(int productId, String productName, BigDecimal initialBalance) {
            this.productId = productId;
            this.productName = productName;
            this.initialBalance = initialBalance;
        }


        public int getProductId() {
            return productId;
        }

        public String getProductName() {
            return productName;
        }

        public BigDecimal getInitialBalance() {
            return initialBalance;
        }
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Investor getInvestor() {
        return investor;
    }

    public void setInvestor(Investor investor) {
        this.investor = investor;
    }

}