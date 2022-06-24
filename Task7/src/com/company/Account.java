package com.company;

public class Account {

    private Long accountNumber;
    private Double balance;

    public Account(Long accountNumber) {
        this.accountNumber = accountNumber;
        balance = 0.0;
    }

    public Account(Long accountNumber, Double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public Double getBalance() {
        return balance;
    }

}


