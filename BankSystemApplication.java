package com.bankingsystem;

import java.util.Scanner;

public class BankSystemApplication {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BankService bank = new BankService();

        int choice;

        do {
        	System.out.println("\n==================================");
            System.out.println("     Welcom to Banking System");
            System.out.println("==================================");
            System.out.println("1. Create Account");
            System.out.println("2. Display All Accounts");
            System.out.println("3. Search Account");
            System.out.println("4. Deposit Money");
            System.out.println("5. Withdraw Money");
            System.out.println("6. Check Balance");
            System.out.println("7. Transaction History");
            System.out.println("8. Delete Account");
            System.out.println("9. Exit");

            choice = readInt(sc, "Enter your choice:");

            try {

                switch (choice) {

                    case 1:

                        System.out.println("\n--- Create Account ---\n");

                        int accNo = readInt(
                                sc, "Enter Account Number:");

                        System.out.println(
                                "Enter Account Holder Name:");

                        String name = sc.nextLine().trim();

                        double balance = readDouble(
                                sc, "Enter Opening Balance:");

                        bank.createAccount(accNo, name, balance);

                        break;

                    case 2:

                        System.out.println("\n--- All Bank Accounts ---\n");

                        bank.displayAllAccounts();

                        break;

                    case 3:

                        System.out.println("\n--- Search Account ---\n");

                        int searchAccNo = readInt(
                                sc, "Enter Account Number:");

                        bank.searchAccount(searchAccNo);

                        break;

                    case 4:

                        System.out.println("\n--- Deposit Money ---\n");

                        int depositAccNo = readInt(
                                sc, "Enter Account Number:");

                        double depositAmount = readDouble(
                                sc, "Enter Deposit Amount:");

                        bank.deposit(depositAccNo, depositAmount);

                        break;

                    case 5:

                        System.out.println("\n--- Withdraw Money ---\n");

                        int withdrawAccNo = readInt(
                                sc, "Enter Account Number:");

                        double withdrawAmount = readDouble(
                                sc, "Enter Withdrawal Amount:");

                        bank.withdraw(withdrawAccNo, withdrawAmount);

                        break;

                    case 6:

                        System.out.println("\n--- Check Balance ---\n");

                        int balanceAccNo = readInt(
                                sc, "Enter Account Number:");

                        bank.checkBalance(balanceAccNo);

                        break;

                    case 7:

                        System.out.println("\n--- Transaction History ---\n");

                        int historyAccNo = readInt(
                                sc, "Enter Account Number:");

                        bank.displayTransactionHistory(historyAccNo);

                        break;

                    case 8:

                        System.out.println("\n--- Delete Account ---\n");

                        int deleteAccNo = readInt(
                                sc, "Enter Account Number:");

                        bank.deleteAccount(deleteAccNo);

                        break;

                    case 9:

                        System.out.println(
                                "Thank you for using Banking System Application!!");

                        break;

                    default:

                        System.out.println(
                                "Invalid choice! Please select 1 to 9.");
                }

            } catch (DuplicateAccountException |
                     AccountNotFoundException |
                     InvalidAmountException |
                     InsufficientBalanceException e) {

                System.out.println("Error: " + e.getMessage());

            } catch (IllegalArgumentException e) {

                System.out.println("Error: " + e.getMessage());
            }

        } while (choice != 9);
 
    }
	// Read integer safely
    private static int readInt(Scanner sc, String message) {

        while (true) {

            System.out.println(message);

            try {

                return Integer.parseInt(sc.nextLine().trim());

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid input! Please enter a valid integer.");
            }
        }
    }

    // Read double safely
    private static double readDouble(Scanner sc, String message) {

        while (true) {

            System.out.println(message);

            try {

                double value = Double.parseDouble(
                        sc.nextLine().trim());

                if (!Double.isFinite(value)) {

                    System.out.println(
                            "Please enter a finite number.");

                    continue;
                }

                return value;

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid input! Please enter a valid amount.");
            }
        }
    }


}
