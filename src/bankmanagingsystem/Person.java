
package bankmanagingsystem;
import java.util.ArrayList;
public abstract class Person {
    protected String name;
    protected int age;
    protected String nationality;

    public Person() {
    }

    public Person(String name, int age, String nationality) {
        this.name = name;
        this.age = age;
        this.nationality = nationality;
    }

    public abstract void displayInfo();
} 