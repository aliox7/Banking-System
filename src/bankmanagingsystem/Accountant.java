package bankmanagingsystem;

public class Accountant extends Employee {
    public Accountant() {
    }

    public Accountant(String name, int age, String nationality, double salary) {
        super(name, age, nationality, salary);
    }

    @Override
    public void performDuties() {
        System.out.println(name + " is auditing balances and processing daily transaction charts.");
    }
}