package bankmanagingsystem;
import java.util.ArrayList;
public class Bank {
    private final String name = "Financial Engine";
    private ArrayList<Client> clients = new ArrayList<>();
    private ArrayList<Employee> employees = new ArrayList<>();

    public void addClient(Client c) {
        clients.add(c);
    }

    public void addEmployee(Employee e) {
        employees.add(e);
    }

    public Client searchClientById(int searchId) {
        for (Client c : clients) {
            if (c.getID() == searchId) return c;
        }
        return null;
    }

    public Employee searchEmployeeById(int searchId) {
        for (Employee e : employees) {
            if (e.employeeID == searchId) return e;
        }
        return null;
    }

    public Account searchAccountByNumber(int accNum) {
        for (Client c : clients) {
            for (Account acc : c.getAccounts()) {
                if (acc.getAccountNumber() == accNum) return acc;
            }
        }
        return null;
    }
    public ArrayList<Client> getClients() {
        return clients;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }
}
