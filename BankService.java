package com.bankingsystem;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.ArrayList;

public class BankService {

	HashMap<Integer, BankAccount> accounts = new HashMap<>();
	ArrayList<Transaction> transactions = new ArrayList<>();

	public BankService() {
	    loadData();
	}

    // Save account and transaction data
    private void saveData() {

        try (ObjectOutputStream oos =
                     new ObjectOutputStream(
                             new FileOutputStream("bankdata.txt"))) {

            oos.writeObject(accounts);
            oos.writeObject(transactions);
            oos.flush();
            System.out.println("Data saved successfully.");

        } catch (IOException e) {

            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    // Load account and transaction data
    private void loadData() {

        try (ObjectInputStream ois =
                     new ObjectInputStream(
                             new FileInputStream("bankdata.txt"))) {

            accounts = (HashMap<Integer, BankAccount>) ois.readObject();

            transactions =
                    (ArrayList<Transaction>) ois.readObject();

            System.out.println("Bank data loaded successfully.");

        } catch (FileNotFoundException e) {

            System.out.println(
                    "No previous bank records found. Starting fresh."+ e.getMessage());

        } catch (IOException | ClassNotFoundException |
                 ClassCastException e) {

            System.out.println(
                    "Error loading bank data: " + e.getMessage());

            accounts = new HashMap<>();
            transactions = new ArrayList<>();
        }
    }

    // Create account
    public void createAccount(int accountNumber, String name,
                              double openingBalance)
            throws DuplicateAccountException,
                   InvalidAmountException {

        if (accountNumber <= 0) {
            throw new IllegalArgumentException(
                    "Account number must be positive.");
        }

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Account holder name cannot be empty.");
        }

        if (!Double.isFinite(openingBalance) || openingBalance < 0) {
            throw new InvalidAmountException(
                    "Opening balance cannot be negative or invalid.");
        }

        if (accounts.containsKey(accountNumber)) {
            throw new DuplicateAccountException(
                    "Account number already exists.");
        }

        BankAccount account = new BankAccount(
                accountNumber, name.trim(), openingBalance);

        accounts.put(accountNumber, account);

        saveData();

        System.out.println("Account created successfully.");
    }

    // Display all accounts
    public void displayAllAccounts() {

        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
            return;
        }

        for (BankAccount account : accounts.values()) {
            account.displayAccountDetails();
        }
    }

    // Search account
    public void searchAccount(int accountNumber)
            throws AccountNotFoundException {

        BankAccount account = accounts.get(accountNumber);

        if (account == null) {
            throw new AccountNotFoundException(
                    "Account not found.");
        }

        account.displayAccountDetails();
    }

    // Deposit money
    public void deposit(int accountNumber, double amount)
            throws AccountNotFoundException,
                   InvalidAmountException {

        BankAccount account = accounts.get(accountNumber);

        if (account == null) {
            throw new AccountNotFoundException(
                    "Account not found.");
        }

        if (!Double.isFinite(amount) || amount <= 0) {
            throw new InvalidAmountException(
                    "Deposit amount must be positive and valid.");
        }

        account.deposit(amount);

        Transaction transaction = new Transaction(
                accountNumber, "Deposit", amount);

        transactions.add(transaction);

        saveData();

        System.out.println("Amount deposited successfully.");
        System.out.println("Updated Balance: " + account.getBalance());
    }

    // Withdraw money
    public void withdraw(int accountNumber, double amount)
            throws AccountNotFoundException,
                   InvalidAmountException,
                   InsufficientBalanceException {

        BankAccount account = accounts.get(accountNumber);

        if (account == null) {
            throw new AccountNotFoundException(
                    "Account not found.");
        }

        if (!Double.isFinite(amount) || amount <= 0) {
            throw new InvalidAmountException(
                    "Withdrawal amount must be positive and valid.");
        }

        if (amount > account.getBalance()) {
            throw new InsufficientBalanceException(
                    "Insufficient account balance.");
        }

        account.withdraw(amount);

        Transaction transaction = new Transaction(
                accountNumber, "Withdrawal", amount);

        transactions.add(transaction);

        saveData();

        System.out.println("Amount withdrawn successfully.");
        System.out.println("Remaining Balance: " + account.getBalance());
    }

    // Check balance
    public void checkBalance(int accountNumber)
            throws AccountNotFoundException {

        BankAccount account = accounts.get(accountNumber);

        if (account == null) {
            throw new AccountNotFoundException(
                    "Account not found.");
        }

        System.out.println("Account Number: "
                + account.getAccountNumber());

        System.out.println("Account Holder: "
                + account.getAccountHolderName());

        System.out.println("Available Balance: "
                + account.getBalance());
    }

    // Display transaction history
    public void displayTransactionHistory(int accountNumber)
            throws AccountNotFoundException {

        if (!accounts.containsKey(accountNumber)) {
            throw new AccountNotFoundException(
                    "Account not found.");
        }

        boolean found = false;

        for (Transaction transaction : transactions) {

            if (transaction.getAccountNumber() == accountNumber) {

                transaction.displayTransaction();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No transactions found for this account.");
        }
    }

    // Delete account
    public void deleteAccount(int accountNumber)
            throws AccountNotFoundException {

        if (!accounts.containsKey(accountNumber)) {
            throw new AccountNotFoundException(
                    "Account not found.");
        }

        accounts.remove(accountNumber);

        saveData();

        System.out.println("Account deleted successfully.");
    }
}
