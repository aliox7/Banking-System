package bankmanagingsystem;

public class SavingAccount extends Account {
    public SavingAccount() {
    }

    public SavingAccount(double balance, Client owner) {
        super(balance, owner);
    }

    @Override
    public void withdraw(double amount) {
        if (amount >= 100000) {
         
            System.out.println("Pending Manager Approval.");
        } else if (amount <= balance) {
            balance -= amount;
            transactions.add(new Transaction("Withdrawal", amount));
        }
    }
}