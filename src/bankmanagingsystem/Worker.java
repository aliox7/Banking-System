
package bankmanagingsystem;

public class Worker extends Employee {
    public Worker() {
    }

    public Worker(String name, int age, String nationality, double salary) {
        super(name, age, nationality, salary);
    }

    @Override
    public void performDuties() {
        System.out.println(name + " is processing customer registrations and opening standard accounts.");
    }
}