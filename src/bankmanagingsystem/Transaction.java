package bankmanagingsystem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private static int nextId = 1;
    private int id;
    private String type; 
    private double amount;
    private LocalDateTime date;
    
    public Transaction() {
    }

    public Transaction(String type, double amount) {
        this.id = nextId++;
        this.type = type;
        this.amount = amount;
        this.date = LocalDateTime.now();
    }

    public String getDetailsString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return "ID: " + id + " | " + type + " | Amount: $" + amount + " | Date: " + date.format(formatter);
    }
}
