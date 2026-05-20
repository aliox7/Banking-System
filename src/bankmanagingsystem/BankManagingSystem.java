package bankmanagingsystem;

public class BankManagingSystem {
    public static void main(String[] args) {
        System.out.println("Starting Bank Management System UI Application Node...");
        
        // Setup database hub structure instances
        Bank centralBank = new Bank();

        // Launch Application Frame passing central database registry
        new BankGUI(centralBank); 
    }
}