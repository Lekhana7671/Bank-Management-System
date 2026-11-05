package com.bankingsystem;

class DuplicateAccountException extends Exception {
    private String message;

    public DuplicateAccountException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

class InvalidAmountException extends Exception {
    private String message;

    public InvalidAmountException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

class AccountNotFoundException extends Exception {
    private String message;

    public AccountNotFoundException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

class InsufficientBalanceException extends Exception {
    private String message;

    public InsufficientBalanceException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
