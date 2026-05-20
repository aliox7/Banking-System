package bankmanagingsystem;

public class BusinessAccount extends Account {
    public BusinessAccount() {
    }

    public BusinessAccount(double balance, Client owner) {
        super(balance, owner);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactions.add(new Transaction("Business Withdrawal", amount));
        }
    }
}