package bankmanagingsystem;

public class CurrentAccount extends Account {
    public CurrentAccount() {
    }

    public CurrentAccount(double balance, Client owner) {
        super(balance, owner);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactions.add(new Transaction("Withdrawal", amount));
        }
    }
}