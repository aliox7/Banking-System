package bankmanagingsystem;

public class Manager extends Employee {
    public Manager() {
    }

    public Manager(String name, int age, String nationality, double salary) {
        super(name, age, nationality, salary);
    }

    @Override
    public void performDuties() {
        System.out.println(name + " is authorizing structural overrides and auditing large cash transfers.");
    }
}