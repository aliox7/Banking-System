package bankmanagingsystem;

import java.util.ArrayList;

public abstract class Account implements Transactable {
    protected int accountNumber;
    protected double balance;
    public static int AN = 1000;
    protected Client owner;
    protected ArrayList<Transaction> transactions = new ArrayList<>();
    public Account() {
    }
    public Account(double balance, Client owner) {
        this.balance = balance;
        this.owner = owner;
        this.accountNumber = AN;
        AN++;
     
        transactions.add(new Transaction("Initial Deposit", balance));
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add(new Transaction("Deposit", amount));
        }
    }

    public void forceWithdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactions.add(new Transaction("Withdrawal (Manager Approved)", amount));
        }
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
}