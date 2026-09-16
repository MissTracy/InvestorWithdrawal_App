package com.example.demo.Controllers;

/**Controllers handle incoming HTTP requests, interact with clients and services methods to perform business logic**/

import com.example.demo.Models.Investor;
import com.example.demo.Models.Products;
import com.example.demo.Services.InvestorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Investor Controller", description = "Endpoints for managing investors")
@RestController
@RequestMapping("/api/investors")
public class InvestorController {

    private final InvestorService investorService;

    @Autowired
    public InvestorController(InvestorService investorService) {
        this.investorService = investorService;
    }

    // Retrieve investor information by ID
    @GetMapping("/{id}")
    @Operation(summary = "Get investor by ID")
    public ResponseEntity<Investor> getInvestorById(@PathVariable Long id) {
        Investor investor = investorService.getInvestorById(id);
        if (investor != null) {
            return new ResponseEntity<>(investor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Retrieve a list of products for a given investor
    @GetMapping("/{id}/products")
    @Operation(summary = "Get products for specified investor")
    public ResponseEntity<List<Products>> getInvestorProducts(@PathVariable Long id) {
        List<Products> products = investorService.getInvestorProducts(id);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}