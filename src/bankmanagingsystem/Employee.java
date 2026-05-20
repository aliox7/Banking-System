package bankmanagingsystem;

public abstract class Employee extends Person {
    protected int employeeID;
    public static int EID = 1000;
    protected double salary;        

    public Employee() { 
    }

    public Employee(String name, int age, String nationality, double salary) {
        super(name, age, nationality);
        this.employeeID = EID;
        this.salary = salary;
        EID++;
    }

    public abstract void performDuties();

    @Override
    public void displayInfo() {
        System.out.println("Name\t\t" + name + "\nID \t\t" + employeeID + "\nAge \t\t" + age + "\nNationality \t" + nationality + "\nSalary  \t" + salary);
    }
}