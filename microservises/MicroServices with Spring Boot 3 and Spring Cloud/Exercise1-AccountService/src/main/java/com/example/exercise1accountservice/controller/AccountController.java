package com.example.exercise1accountservice.controller;

import com.example.exercise1accountservice.model.Account;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @GetMapping("/account")
    public Account getAccount() {

        Account account = new Account();

        account.setAccountNumber("ACC1001");
        account.setAccountHolder("Ankit Pandey");
        account.setBalance(50000);

        return account;
    }
}