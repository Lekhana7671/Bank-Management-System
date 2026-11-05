package com.bankingsystem;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction implements Serializable {

    private int accountNumber;
    private String transactionType;
    private double amount;
    private LocalDateTime dateTime;

    public Transaction(int accountNumber, String transactionType, double amount) {

        this.accountNumber = accountNumber;
        this.transactionType = transactionType;
        this.amount = amount;
        this.dateTime = LocalDateTime.now();
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void displayTransaction() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        System.out.println("Account Number: " + accountNumber);
        System.out.println("Transaction Type: " + transactionType);
        System.out.println("Amount: " + amount);
        System.out.println("Date and Time: " + dateTime.format(formatter));
        System.out.println("--------------------------------");
    }
}
