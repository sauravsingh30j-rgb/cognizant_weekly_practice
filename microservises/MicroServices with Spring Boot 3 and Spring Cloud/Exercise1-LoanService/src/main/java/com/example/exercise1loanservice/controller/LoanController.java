package com.example.exercise1loanservice.controller;

import com.example.exercise1loanservice.model.Loan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {

    @GetMapping("/loan")
    public Loan getLoanDetails() {

        Loan loan = new Loan();

        loan.setLoanId("LN1001");
        loan.setLoanType("Education Loan");
        loan.setAmount(300000);

        return loan;
    }
}