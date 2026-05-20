package bankmanagingsystem;

import java.util.ArrayList;

public class Client extends Person {
    private int ID;
    public static int CID = 26000;
    
   
    private ArrayList<Account> accounts = new ArrayList<>();

    public Client() {
    }

    public Client(int age, String name, String nationality) {
        super(name, age, nationality);
        this.ID = CID;
        CID++;
    }

    public void addAccount(Account acc) {
        accounts.add(acc);
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public double getTotalBalance() {
        double total = 0;
        for (Account acc : accounts) {
            total += acc.getBalance();
        }
        return total;
    }

    public int getID() {
        return ID;
    }

    @Override
    public void displayInfo() {
        System.out.println("Name\t" + name + "\nAge\t" + age + "\nID\t" + ID + "\nNationality\t" + nationality);
    }
}