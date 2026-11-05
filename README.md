# 🏦 Banking Management System

**Name:** Yarnakula Lekhana\
**Institute:** Codegnan\
**Batch:** JFS-ONR-004\
**Domain:** Java Full Stack Development\
**Project Type:** Core Java Console-Based Mini Project\
**Mentor:** Sairam Sahini

------------------------------------------------------------------------

## 📝 About the Project

### 📌 Overview

**Banking Management System** is a menu-driven,
console-based application developed using Core Java to demonstrate basic
banking operations.

The application allows users to create bank accounts, display and search
account details, deposit money, withdraw money, check account balances,
view transaction history, and delete accounts.

The project demonstrates Object-Oriented Programming (OOP), the
Collection Framework, exception handling, user-defined checked
exceptions, loops, switch statements, console input with `Scanner`, and
Java file I/O through object serialization.

Account and transaction data are stored in Java collections and
serialized to `bankdata.txt`. When the application starts again, the
saved records can be loaded from this file.

## 🎯 Objectives

-   Develop a menu-driven banking application using Core Java.
-   Create and manage bank accounts.
-   Store account information using the Collection Framework.
-   Perform deposit and withdrawal operations with validation.
-   Handle banking errors using exception handling.
-   Implement user-defined checked exceptions.
-   Maintain transaction history.
-   Save and reload account and transaction data using Java object
    streams.
-   Apply OOP concepts in a practical mini-project.

## 📊 Project Structure

The Java source files are organized under the `com.bankingsystem` package.

``` text
BankManagementSystem
└── src
    └── com.bankingsystem
        ├── BankSystemApplication.java
        ├── BankAccount.java
        ├── BankService.java
        ├── Transaction.java
        └── CustomExceptions.java
```

### Class Description

  -------------------------------------------------------------------------
  Class                                 Description
  ------------------------------------- -----------------------------------
  `BankSystemApplication.java`            Main class that handles the console
                                        menu, user input, and exception
                                        handling.

  `BankAccount.java`                    Stores account number, account
                                        holder name, and balance.

  `BankService.java`                    Manages banking operations,
                                        collections, and saving/loading
                                        data.

  `Transaction.java`                    Stores transaction details such as
                                        account number, transaction type,
                                        amount, and date-time.

  `CustomExceptions.java`               Handles input output errors.
  
  -------------------------------------------------------------------------

## 🛠️ Tools & Technologies Used

-   **Java / Core Java** -- Application development and program logic.
-   **Eclipse IDE** -- Writing and running Java code.
-   **Scanner** -- Reading user input from the console.
-   **Collection Framework** -- Managing account and transaction data.
-   **HashMap** -- Storing bank accounts using account numbers as keys.
-   **ArrayList** -- Storing transaction records.
-   **Exception Handling** -- Handling errors during banking operations.
-   **User-Defined Checked Exceptions** -- Representing specific banking
    errors.
-   **Java I/O and Serialization** -- Saving and restoring data.
-   **`ObjectOutputStream`** -- Writing serialized objects to a file.
-   **`ObjectInputStream`** -- Reading serialized objects from a file.
-   **`FileInputStream`** -- Reading bytes from a file.
-   **`FileoutputStream`** -- Writing bytes into a file.
-   **`bankdata.txt`** -- Runtime data file used to persist account and
    transaction records.

## 🧪 Methodology

### 1. Account Creation

-   Accept the account number, account holder name, and opening balance.
-   Check whether the account number already exists.
-   Prevent duplicate account creation.
-   Store the new account in the account collection.

### 2. Account Management

-   Display all available bank accounts.
-   Search for an account using its account number.
-   Check the current account balance.
-   Delete an existing account.

### 3. Deposit Money

-   Accept an account number and deposit amount.
-   Validate that the amount is positive.
-   Update the account balance.
-   Add the deposit to transaction history.

### 4. Withdraw Money

-   Accept an account number and withdrawal amount.
-   Validate that the amount is positive.
-   Check whether the account has sufficient funds.
-   Update the balance if the withdrawal is valid.
-   Add the withdrawal to transaction history.

### 5. Transaction History

-   Store deposit and withdrawal records in an `ArrayList`.
-   Display transaction details for an account.
-   Keep transaction records available to the application and save them
    with the other data.

### 6. Exception Handling

The application uses user-defined checked exceptions to report
banking-related errors:

-   `InvalidAmountException`
-   `InsufficientBalanceException`
-   `AccountNotFoundException`
-   `DuplicateAccountException`

### 7. File Handling and Data Persistence

-   The `BankAccount` and `Transaction` model classes implement
    `Serializable`.
-   `ObjectOutputStream` writes the account `HashMap` and transaction
    `ArrayList` to `bankdata.txt`.
-   `ObjectInputStream` reads the saved collections when the application
    starts.
-   This allows account records and transaction history to be restored
    between runs, provided the data file remains available.

## 📚 Core Java Concepts Implemented

  -----------------------------------------------------------------------
  Concept                             Usage
  ----------------------------------- -----------------------------------
  Classes and Objects                 Represent bank accounts,
                                      transactions, and banking services.

  Encapsulation                       Organize account data and expose
                                      access methods.

  Constructors                        Initialize account and transaction
                                      objects.

  `HashMap`                           Store accounts using account
                                      numbers as keys.

  `ArrayList`                         Maintain transaction records in
                                      sequence.

  `Scanner`                           Accept input from the user.

  Switch Statement                    Handle menu selections.

  Loops                               Repeat the menu and display
                                      records.

  Try-Catch                           Handle exceptions.

  Custom Checked Exceptions           Handle banking-specific errors.

  `Serializable`                      Allow model objects to be
                                      serialized.

  `ObjectOutputStream`                Save collections to a file.

  `ObjectInputStream`                 Load saved collections from a file.
  
  -----------------------------------------------------------------------

## 📋 Console Menu

The application displays a menu in the Eclipse console:

<img width="1917" height="1077" alt="image" src="https://github.com/user-attachments/assets/14e834fd-fb9c-4f9b-818c-aa47ceeb3e0e" />

## 📈 Sample Transaction Flow

For example, an account can be created with an opening balance of
₹5,000.

  Operation           Amount   Balance
  ----------------- -------- ---------
  Opening balance        ---    ₹5,000
  Deposit             ₹2,000    ₹7,000
  Withdraw            ₹1,000    ₹6,000

The transaction history should contain the deposit of ₹2,000 and
withdrawal of ₹1,000.

## 🧪 Testing & Expected Results

  -----------------------------------------------------------------------
  Test Case                           Expected Result
  ----------------------------------- -----------------------------------
  Create an account with a new        Account is created successfully.
  account number                      

  Create an account with a duplicate  `DuplicateAccountException` is
  account number                      handled.

  Deposit a positive amount           Balance increases and a transaction
                                      is recorded.

  Deposit zero or a negative amount   `InvalidAmountException` is
                                      handled.

  Withdraw more than the available    `InsufficientBalanceException` is
  balance                             handled.

  Search for an unknown account       `AccountNotFoundException` is
                                      handled.

  Restart the application with        Saved accounts and transaction
  `bankdata.dat` available            history are loaded.
  
  -----------------------------------------------------------------------

## 📦 Deliverables

-   Java source files organized under the `com.bankease` package.
-   Account creation and management functionality.
-   Deposit and withdrawal operations.
-   Transaction history management.
-   Collection Framework implementation using `HashMap` and `ArrayList`.
-   User-defined checked exception classes.
-   File persistence using Java object serialization.
-   Console-based, menu-driven application.
-   Project presentation.

## 🙌 Acknowledgments

This project was developed as a Core Java mini-project to practise
object-oriented programming, collection handling, exception handling,
console-based application development, and Java file I/O.

Special thanks to **Codegnan** and **Mentor Sairam Sahini** for their
guidance and support throughout the learning process.

## 🚀 How to Run

1.  Install the Java JDK (Java 17 or a compatible version).
2.  Install or open Eclipse IDE.
3.  Create or import the BankEase Java project.
4.  Ensure all Java source files are placed in the `com.bankease`
    package.
5.  Open `BankEaseApplication.java`.
6.  Run it as a **Java Application**.
7.  Use the console menu to perform banking operations.

The `bankdata.dat` file is created in the application's working
directory when the application saves its data. Keep this file if you
want to retain the saved account and transaction records between runs.

## 📌 Notes & Limitations

-   This is a console-based learning project, not a production banking
    application.
-   Account data is managed using a `HashMap`, and transaction history
    is managed using an `ArrayList`.
-   The collections are serialized to `bankdata.dat` so saved data can
    be loaded again when the application starts.
-   The application does not use a database.
-   For a real banking system, additional security, authentication,
    robust data storage, backup, and recovery mechanisms would be
    required.

------------------------------------------------------------------------

## 🏷️ Tags

`#Java` `#CoreJava` `#BankEase` `#BankingManagementSystem`
`#JavaProject` `#EclipseIDE` `#OOP` `#CollectionFramework`
`#ExceptionHandling` `#JavaIO` `#Serialization`
