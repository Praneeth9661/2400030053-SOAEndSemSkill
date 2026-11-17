package com.example.controller;

import com.example.model.Account;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/internal/accounts")
public class AccountController {

    // Sample account data
    private final List<Account> accounts = Arrays.asList(

        new Account(101, "Arun", "Savings", 25000),

        new Account(102, "Rahul", "Current", 50000),

        new Account(103, "Kiran", "Savings", 35000)

    );

    // Get all accounts
    @GetMapping
    public List<Account> getAllAccounts() {

        return accounts;
    }

    // Get account by ID
    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable int id) {

        return accounts.stream()
                .filter(account -> account.getAccountId() == id)
                .findFirst()
                .orElseThrow(() ->
                    new RuntimeException("Account not found: " + id)
                );
    }

    // Check backend path
    @GetMapping("/test")
    public String test() {

        return "Request successfully reached /internal/accounts/test";
    }

}