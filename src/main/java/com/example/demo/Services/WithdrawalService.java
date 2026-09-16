package com.example.demo.Services;
/** services encapsulate the business logic.Methods perform specific operations on the data, **/

import com.example.demo.Models.Investor;
import com.example.demo.Models.Products;
import com.example.demo.Models.Withdrawal;
import com.example.demo.repos.InvestorRepository;
import com.example.demo.repos.ProductRepository;
import com.example.demo.repos.WithdrawalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
public class WithdrawalService {

    private final ProductRepository productRepository;
    private final WithdrawalRepository withdrawalRepository;
    private final InvestorRepository investorRepository;
    private final ProductService productService;

    @Autowired
    public WithdrawalService(ProductRepository productRepository, WithdrawalRepository withdrawalRepository,
                             InvestorRepository investorRepository,  ProductService productService1) {
        this.productRepository = productRepository;
        this.withdrawalRepository = withdrawalRepository;
        this.investorRepository = investorRepository;
        this.productService = productService1;
    }

    //withdrawals & withdrawal--variables:)
    public boolean createWithdrawal(Long investorId, Long productId, Withdrawal withdrawals) {
        // Find the investor by ID
        Investor investor = investorRepository.findById(investorId).orElse(null);
        if (investor == null) {
            return false; // Investor not found
        }

        // Find the product by ID
        Products product = productService.getProductById(productId);
        if (product == null || product.getInvestor().getId() != investorId) {
            return false; // Product not found or not associated with the investor
        }

        // Check if the withdrawal amount is valid
        //used BigInt and BigDec to correctly compare oprator other methods were not working-life problems
        if (withdrawals.getAmount().compareTo(BigDecimal.ZERO) <= 0 ||
                withdrawals.getAmount().toBigInteger().compareTo(product.getBalance().toBigInteger()) > 0) {
            return false;
        }
        //Check if investor is eligible for retirement withdrawal
        if ("RETIREMENT".equals(product.getProductType())) {
            if (investor.calculateAge() <= 65) {
                return false; //
            }

        }
        //Check Withdrawal amount exceeds current balance
        BigDecimal currentBalance = product.getBalance();
        BigDecimal withdrawalAmount = withdrawals.getAmount();

        if (withdrawalAmount.compareTo(currentBalance) > 0) {
            return false;
        }
        // Check Withdrawal amount exceeds 90% of the current balance
        BigDecimal maxWithdrawalAmount = currentBalance.multiply(BigDecimal.valueOf(0.9)); // 90% of the current balance
        if (withdrawalAmount.compareTo(maxWithdrawalAmount) > 0) {
            return false;
        }

        // Create new withdrawal record
        Withdrawal newWithdrawal = new Withdrawal();
        newWithdrawal.setAmount(withdrawals.getAmount());
        newWithdrawal.setProduct();

        // Save withdrawal record
        withdrawalRepository.save(newWithdrawal);

        // Update product's balance
        BigDecimal newBalance = product.getBalance().subtract(withdrawals.getAmount());
        product.setBalance(newBalance);
        productService.saveProduct(product);

        return true; // Withdrawal successful
    }
}
