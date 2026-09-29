package com.example.demo.Controllers;
/**Controllers handle incoming HTTP requests, interact with clients and services methods to perform business logic**/


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.Withdrawal;
import com.example.demo.Services.WithdrawalService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

// @Api(tags = "withdrawals")  
@Tag(name = "Withdrawal Controller", description = "Endpoints for managing withdrawals") 
@RestController
@RequestMapping("/withdrawals")
public class WithdrawalController {

    private final WithdrawalService withdrawalService;

    @Autowired
    public WithdrawalController(WithdrawalService withdrawalService) {
        this.withdrawalService = withdrawalService;
    }

    @PostMapping("/{productId}/create")
    @Operation(summary = "Post withdrawal using products id")   
    public ResponseEntity<String> createWithdrawal(
            @PathVariable Long productId,
            @RequestBody Withdrawal withdrawals) {

        //aag problem with id
//        Long investorId = null;
        Long investorId = withdrawals.getInvestorId();


        boolean withdrawalSuccessful = withdrawalService.createWithdrawal(investorId, productId, withdrawals);
        if (withdrawalSuccessful) {
            return new ResponseEntity<>("Withdrawal created successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Withdrawal failed", HttpStatus.BAD_REQUEST);
        }
    }
}