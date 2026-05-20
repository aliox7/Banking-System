package bankmanagingsystem;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.*;
import java.awt.*;

public class BankGUI {

    private Bank centralBank;
    private Client currentClient;

    private JFrame frame;
    private JPanel mainPanel;

    private Font titleFont = new Font("Segoe UI Semibold", Font.PLAIN, 24);
    private Font standardFont = new Font("Segoe UI", Font.PLAIN, 15);

    public BankGUI(Bank centralBank) {
        FlatDarkLaf.setup();
        UIManager.put("defaultFont", standardFont);

        this.centralBank = centralBank;

        frame = new JFrame("Promax Banking System");
        frame.setSize(1080, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(new Color(25, 27, 35));
        frame.add(mainPanel);

        showHomeScreen();
        frame.setVisible(true);
    }
    private void styleButton(JButton btn, boolean isPrimary) {
        btn.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        if (isPrimary) {
            btn.putClientProperty(FlatClientProperties.STYLE, "arc: 10; background: #0078D7; foreground: #FFFFFF;");
        } else {
            btn.putClientProperty(FlatClientProperties.STYLE, "arc: 10; background: #333645; foreground: #E0E0E0;");
        }
    }

    private void styleTextField(JTextField field, String placeholder) {
        field.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, placeholder);
        field.putClientProperty(FlatClientProperties.STYLE, "arc: 10; margin: 5,10,5,10; background: #1E1F29;");
    }

    private void showHomeScreen() {
        mainPanel.removeAll();

        JLabel titleLabel = new JLabel("Central Bank System", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI Bold", Font.PLAIN, 28));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(0, 200, 1080, 40);
        mainPanel.add(titleLabel);

        JButton adminButton = new JButton("Admin Portal (Setup)");
        adminButton.setBounds(390, 280, 300, 50);
        styleButton(adminButton, false);
        mainPanel.add(adminButton);

        JButton loginButton = new JButton("Client Portal (Login)");
        loginButton.setBounds(390, 350, 300, 50);
        styleButton(loginButton, true);
        mainPanel.add(loginButton);

        adminButton.addActionListener(e -> showAdminScreen());
        loginButton.addActionListener(e -> showLoginScreen());

        mainPanel.revalidate();
        mainPanel.repaint();
    }

    private void showAdminScreen() {
        mainPanel.removeAll();

        JLabel title = new JLabel("Admin Portal", SwingConstants.CENTER);
        title.setFont(titleFont);
        title.setForeground(new Color(0, 120, 215));
        title.setBounds(0, 20, 1080, 40);
        mainPanel.add(title);

        JButton backBtn = new JButton("← Back to Home");
        backBtn.setBounds(30, 20, 150, 35);
        styleButton(backBtn, false);
        mainPanel.add(backBtn);
        backBtn.addActionListener(e -> showHomeScreen());

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setBounds(90, 80, 900, 280);
        mainPanel.add(tabbedPane);

        // --- TAB 1: CLIENTS & ACCOUNTS ---
        JPanel clientTab = new JPanel(null);
        clientTab.setBackground(new Color(30, 33, 40));
        
        // FIXED: Properly spaced Client Info Fields
        JTextField nameField = new JTextField(); styleTextField(nameField, "Full Name");
        nameField.setBounds(30, 30, 180, 40); clientTab.add(nameField);
        
        JTextField ageField = new JTextField(); styleTextField(ageField, "Age");
        ageField.setBounds(220, 30, 80, 40); clientTab.add(ageField);
        
        JTextField natField = new JTextField(); styleTextField(natField, "Nationality");
        natField.setBounds(310, 30, 150, 40); clientTab.add(natField);
        
        JButton createClientBtn = new JButton("Register Client");
        createClientBtn.setBounds(480, 30, 180, 40); styleButton(createClientBtn, true);
        clientTab.add(createClientBtn);

        // Account Opening Row
        JTextField idField = new JTextField(); styleTextField(idField, "Client ID");
        idField.setBounds(30, 120, 150, 40); clientTab.add(idField);
        
        JComboBox<String> typeDropdown = new JComboBox<>(new String[]{"CurrentAccount", "SavingAccount", "BusinessAccount"});
        typeDropdown.setBounds(190, 120, 180, 40); clientTab.add(typeDropdown);
        
        JTextField depositField = new JTextField(); styleTextField(depositField, "Deposit $");
        depositField.setBounds(380, 120, 150, 40); clientTab.add(depositField);
        
        JButton createAccBtn = new JButton("Open Account");
        createAccBtn.setBounds(540, 120, 180, 40); styleButton(createAccBtn, true);
        clientTab.add(createAccBtn);

        tabbedPane.addTab("Clients & Accounts", clientTab);

        // --- TAB 2: EMPLOYEES ---
        JPanel empTab = new JPanel(null);
        empTab.setBackground(new Color(30, 33, 40));

        // FIXED: Added Age and Nationality for Employees
        JTextField empName = new JTextField(); styleTextField(empName, "Full Name");
        empName.setBounds(30, 40, 150, 40); empTab.add(empName);

        JTextField empAge = new JTextField(); styleTextField(empAge, "Age");
        empAge.setBounds(190, 40, 80, 40); empTab.add(empAge);

        JTextField empNat = new JTextField(); styleTextField(empNat, "Nationality");
        empNat.setBounds(280, 40, 120, 40); empTab.add(empNat);

        JComboBox<String> roleDropdown = new JComboBox<>(new String[]{"Worker", "Accountant", "Manager"});
        roleDropdown.setBounds(410, 40, 150, 40); empTab.add(roleDropdown);

        JTextField empSalary = new JTextField(); styleTextField(empSalary, "Salary $");
        empSalary.setBounds(570, 40, 100, 40); empTab.add(empSalary);

        JButton hireBtn = new JButton("Hire Staff");
        hireBtn.setBounds(680, 40, 150, 40); styleButton(hireBtn, true);
        empTab.add(hireBtn);

        tabbedPane.addTab("Employees", empTab);

        // --- TAB 3: SEARCH & ACTIONS ---
        JPanel searchTab = new JPanel(null);
        searchTab.setBackground(new Color(30, 33, 40));

        JTextField searchIdField = new JTextField(); styleTextField(searchIdField, "Enter ID or Account #");
        searchIdField.setBounds(30, 20, 300, 40); searchTab.add(searchIdField);

        JButton searchBtn = new JButton("Search Records");
        searchBtn.setBounds(350, 20, 180, 40); styleButton(searchBtn, true);
        searchTab.add(searchBtn);

        JButton viewClientsBtn = new JButton("View All Clients");
        viewClientsBtn.setBounds(30, 80, 200, 40); styleButton(viewClientsBtn, false);
        searchTab.add(viewClientsBtn);

        JButton viewEmpsBtn = new JButton("View All Employees");
        viewEmpsBtn.setBounds(250, 80, 200, 40); styleButton(viewEmpsBtn, false);
        searchTab.add(viewEmpsBtn);

        JLabel mgrLabel = new JLabel("Manager Override (Approvals for Pending Requests):");
        mgrLabel.setForeground(Color.WHITE); mgrLabel.setBounds(30, 140, 500, 20); searchTab.add(mgrLabel);

        JTextField forceAccField = new JTextField(); styleTextField(forceAccField, "Acc Num");
        forceAccField.setBounds(30, 170, 150, 40); searchTab.add(forceAccField);

        JTextField forceAmountField = new JTextField(); styleTextField(forceAmountField, "Amount $");
        forceAmountField.setBounds(200, 170, 150, 40); searchTab.add(forceAmountField);

        JButton forceWithdrawBtn = new JButton("Approve & Force Out");
        forceWithdrawBtn.setBounds(370, 170, 220, 40); styleButton(forceWithdrawBtn, true);
        forceWithdrawBtn.putClientProperty(FlatClientProperties.STYLE, "background: #C62828; foreground: #FFFFFF;");
        searchTab.add(forceWithdrawBtn);

        tabbedPane.addTab("Search & Approvals", searchTab);

        // --- ADMINISTRATIVE GLOBAL MONITOR ---
        JTextArea adminConsole = new JTextArea();
        adminConsole.setEditable(false);
        adminConsole.putClientProperty(FlatClientProperties.STYLE, "background: #181A21; border: 1,1,1,1,#333645;");
        JScrollPane scrollPane = new JScrollPane(adminConsole);
        scrollPane.setBounds(90, 380, 900, 260); 
        mainPanel.add(scrollPane);

        // --- ACTION LISTENERS ---
        createClientBtn.addActionListener(e -> {
            try {
                int age = Integer.parseInt(ageField.getText().trim());
                String name = nameField.getText().trim();
                String nat = natField.getText().trim();
                
                Client c = new Client(age, name, nat); 
                centralBank.addClient(c);
                
                adminConsole.append("👤 Client Registered -> Name: " + c.name + " | Master Login ID: " + c.getID() + "\n");
                
                nameField.setText("");
                ageField.setText("");
                natField.setText("");
                
            } catch (NumberFormatException ex) {
                adminConsole.append("❌ Verification Failure: Please make sure Age is a valid number.\n");
            } catch (Exception ex) {
               
                adminConsole.append("❌ System Error: " + ex.getMessage() + "\n"); 
            }
        });

        createAccBtn.addActionListener(e -> {
            try {
                Client c = centralBank.searchClientById(Integer.parseInt(idField.getText()));
                if (c != null) {
                    double dep = Double.parseDouble(depositField.getText());
                    Account acc;
                    if (typeDropdown.getSelectedItem().equals("CurrentAccount")) acc = new CurrentAccount(dep, c);
                    else if (typeDropdown.getSelectedItem().equals("SavingAccount")) acc = new SavingAccount(dep, c);
                    else acc = new BusinessAccount(dep, c);

                    c.addAccount(acc);
                    adminConsole.append("🏦 Ledger Updated -> Type: " + typeDropdown.getSelectedItem() + " | Acc Linked: " + acc.getAccountNumber() + "\n");
                } else { adminConsole.append("❌ Operations Halt: Master Client ID not registered.\n"); }
            } catch (Exception ex) { adminConsole.append("❌ Verification Failure: Numeric data checks missing.\n"); }
        });

        hireBtn.addActionListener(e -> {
            try {
                // FIXED: Now properly extracts Age and Nationality instead of hardcoding "25" and "Local"
                String name = empName.getText();
                int age = Integer.parseInt(empAge.getText());
                String nat = empNat.getText();
                double salary = Double.parseDouble(empSalary.getText());
                String role = (String) roleDropdown.getSelectedItem();
                
                Employee emp;
                if (role.equals("Worker")) emp = new Worker(name, age, nat, salary);
                else if (role.equals("Accountant")) emp = new Accountant(name, age, nat, salary);
                else emp = new Manager(name, age, nat, salary);

                centralBank.addEmployee(emp);
                adminConsole.append("💼 Employee Hired -> Role: " + role + " | Name: " + emp.name + " | Assigned ID: " + emp.employeeID + "\n");
            } catch (Exception ex) { adminConsole.append("❌ Verification Failure: Enter numerical age and salary formats.\n"); }
        });

        searchBtn.addActionListener(e -> {
            try {
                int id = Integer.parseInt(searchIdField.getText());
                adminConsole.append("\n--- Running DB Audit Log for Item Identification Key: " + id + " ---\n");
                Client c = centralBank.searchClientById(id);
                Employee emp = centralBank.searchEmployeeById(id);
                Account acc = centralBank.searchAccountByNumber(id);
                
                if (c != null) adminConsole.append("🔍 Profile Match [Client]: " + c.name + " | Age: " + c.age + " | Nat: " + c.nationality + " | Wealth: $" + c.getTotalBalance() + "\n");
                if (emp != null) adminConsole.append("🔍 Profile Match [Employee]: " + emp.name + " | Age: " + emp.age + " | Nat: " + emp.nationality + " | Role: " + emp.getClass().getSimpleName() + "\n");
                if (acc != null) adminConsole.append("🔍 Ledger Match [Account]: Type: " + acc.getClass().getSimpleName() + " | Primary Owner: " + acc.owner.name + " | Total Funds: $" + acc.getBalance() + "\n");
                if (c == null && emp == null && acc == null) adminConsole.append("❌ No matching records found inside core storage tables.\n");
            } catch (Exception ex) { adminConsole.append("❌ Parsing Interrupted: Input must be a valid key index integer.\n"); }
        });

        // --- VIEW ALL CLIENTS LOGIC ---
        viewClientsBtn.addActionListener(e -> {
            adminConsole.append("\n--- CLIENT DATABASE COMMAND EXECUTED ---\n");
            
            if (centralBank.getClients().isEmpty()) {
                adminConsole.append("Database Empty: No clients registered yet.\n");
            } else {
                for (Client c : centralBank.getClients()) {
                    adminConsole.append("👤 ID: " + c.getID() + 
                                        " | Name: " + c.name + 
                                        " | Age: " + c.age + 
                                        " | Nat: " + c.nationality + 
                                        " | Total Wealth: $" + c.getTotalBalance() + "\n");
                }
            }
        });

        // --- VIEW ALL EMPLOYEES LOGIC ---
        viewEmpsBtn.addActionListener(e -> {
            adminConsole.append("\n--- EMPLOYEE DATABASE COMMAND EXECUTED ---\n");
            
            if (centralBank.getEmployees().isEmpty()) {
                adminConsole.append("Database Empty: No employees hired yet.\n");
            } else {
                for (Employee emp : centralBank.getEmployees()) {
                    adminConsole.append("💼 ID: " + emp.employeeID + 
                                        " | Name: " + emp.name + 
                                        " | Role: " + emp.getClass().getSimpleName() + 
                                        " | Salary: $" + emp.salary + "\n");
                }
            }
        });

        forceWithdrawBtn.addActionListener(e -> {
            try {
                Account acc = centralBank.searchAccountByNumber(Integer.parseInt(forceAccField.getText()));
                double amount = Double.parseDouble(forceAmountField.getText());
                if (acc != null) {
                    acc.forceWithdraw(amount);
                    adminConsole.append("🚨 OVERRIDE AUTHENTICATED: Forced transfer clearance validated for Acc: " + acc.getAccountNumber() + " | Value Disbursed: $" + amount + "\n");
                } else { adminConsole.append("❌ Operations Fault: Targeting instance not resolved inside arrays.\n"); }
            } catch (Exception ex) { adminConsole.append("❌ Operational Error processing authorization credentials tracking parameters.\n"); }
        });

        mainPanel.revalidate();
        mainPanel.repaint();
    }

    private void showLoginScreen() {
        mainPanel.removeAll();

        JButton backBtn = new JButton("← Back");
        backBtn.setBounds(30, 20, 100, 35);
        styleButton(backBtn, false);
        mainPanel.add(backBtn);

        JPanel card = new JPanel(null);
        card.setBounds(340, 210, 400, 300);
        card.putClientProperty(FlatClientProperties.STYLE, "arc: 20; background: #1E1F29; border: 1,1,1,1,#333645;");
        mainPanel.add(card);

        JLabel titleLabel = new JLabel("Client Login", SwingConstants.CENTER);
        titleLabel.setFont(titleFont);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(0, 30, 400, 40);
        card.add(titleLabel);

        JTextField idField = new JTextField();
        styleTextField(idField, "Enter Client ID (e.g. 26000)");
        idField.setHorizontalAlignment(JTextField.CENTER);
        idField.setBounds(50, 110, 300, 45);
        card.add(idField);

        JButton loginButton = new JButton("Access Accounts");
        loginButton.setBounds(50, 190, 300, 45);
        styleButton(loginButton, true);
        card.add(loginButton);

        backBtn.addActionListener(e -> showHomeScreen());

        loginButton.addActionListener(e -> {
            try {
                Client foundClient = centralBank.searchClientById(Integer.parseInt(idField.getText()));
                if (foundClient != null) {
                    currentClient = foundClient;
                    showDashboardScreen(); 
                } else {
                    JOptionPane.showMessageDialog(frame, "Client ID verification trace lookup yielded empty array records.", "Access Restriction", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Credential structure mismatch format errors.", "Verification Error", JOptionPane.WARNING_MESSAGE);
            }
        });

        mainPanel.revalidate();
        mainPanel.repaint();
    }

    private void showDashboardScreen() {
        mainPanel.removeAll();

        JPanel headerPanel = new JPanel(null);
        headerPanel.setBounds(0, 0, 1080, 120);
        headerPanel.putClientProperty(FlatClientProperties.STYLE, "background: #005A9E;"); 
        mainPanel.add(headerPanel);

        JLabel welcomeLabel = new JLabel("Welcome back, " + currentClient.name);
        welcomeLabel.setFont(new Font("Segoe UI Bold", Font.PLAIN, 24));
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setBounds(140, 30, 400, 30);
        headerPanel.add(welcomeLabel);

        JLabel wealthLabel = new JLabel("Total Wealth: $" + currentClient.getTotalBalance());
        wealthLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
        wealthLabel.setForeground(new Color(200, 230, 255));
        wealthLabel.setBounds(140, 70, 300, 30);
        headerPanel.add(wealthLabel);

        JComboBox<String> accountDropdown = new JComboBox<>();
        accountDropdown.putClientProperty(FlatClientProperties.STYLE, "arc: 10; background: #1E1F29;");
        if(currentClient.getAccounts().isEmpty()){
             accountDropdown.addItem("No Active Accounts Registered");
             accountDropdown.setEnabled(false);
        } else {
            for (Account acc : currentClient.getAccounts()) {
                accountDropdown.addItem(acc.getClass().getSimpleName() + " - " + acc.getAccountNumber() + " ($" + acc.getBalance() + ")");
            }
        }
        accountDropdown.setBounds(140, 150, 800, 45); 
        mainPanel.add(accountDropdown);

        JTextField amountField = new JTextField();
        styleTextField(amountField, "Amount ($)");
        amountField.setHorizontalAlignment(JTextField.CENTER);
        amountField.setBounds(140, 220, 250, 45);
        mainPanel.add(amountField);

        JButton depositButton = new JButton("Deposit");
        depositButton.setBounds(420, 220, 200, 45);
        styleButton(depositButton, false);
        depositButton.putClientProperty(FlatClientProperties.STYLE, "arc: 10; background: #2E7D32; foreground: #FFFFFF;"); 
        mainPanel.add(depositButton);

        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(650, 220, 200, 45);
        styleButton(withdrawButton, false);
        withdrawButton.putClientProperty(FlatClientProperties.STYLE, "arc: 10; background: #C62828; foreground: #FFFFFF;"); 
        mainPanel.add(withdrawButton);

        JTextArea consoleArea = new JTextArea();
        consoleArea.setEditable(false);
        consoleArea.setFont(standardFont);
        consoleArea.putClientProperty(FlatClientProperties.STYLE, "background: #181A21; border: 1,1,1,1,#333645;");
        JScrollPane scrollPane = new JScrollPane(consoleArea);
        scrollPane.setBounds(140, 290, 800, 250);
        mainPanel.add(scrollPane);

        JButton historyButton = new JButton("View Ledger Statements");
        historyButton.setBounds(140, 560, 250, 45);
        styleButton(historyButton, false);
        mainPanel.add(historyButton);

        JButton logoutButton = new JButton("Log Out");
        logoutButton.setBounds(690, 560, 250, 45);
        styleButton(logoutButton, false);
        logoutButton.setBackground(new Color(50, 55, 70));
        mainPanel.add(logoutButton);

        depositButton.addActionListener(e -> {
            if(!accountDropdown.isEnabled()) return;
            processTransaction("Deposit", amountField, accountDropdown, wealthLabel, consoleArea);
        });

        withdrawButton.addActionListener(e -> {
             if(!accountDropdown.isEnabled()) return;
             processTransaction("Withdraw", amountField, accountDropdown, wealthLabel, consoleArea);
        });

        historyButton.addActionListener(e -> {
            consoleArea.append("\n=================== GENERAL LEDGER TIMELINE REPORT ===================\n");
            for (Account acc : currentClient.getAccounts()) {
                consoleArea.append("Account Node Group ID: " + acc.getAccountNumber() + " [Ref Classification: " + acc.getClass().getSimpleName() + "]\n");
                if (acc.transactions == null || acc.transactions.isEmpty()) {
                    consoleArea.append("  ↳ Clear static state trace. Timeline logs empty.\n");
                } else {
                    for (Transaction t : acc.transactions) {
                        consoleArea.append("  ↳ " + t.getDetailsString() + "\n"); 
                    }
                }
            }
            consoleArea.append("=======================================================================\n");
        });

        logoutButton.addActionListener(e -> {
            currentClient = null;
            showHomeScreen();
        });

        mainPanel.revalidate();
        mainPanel.repaint();
    }

    private void processTransaction(String type, JTextField amountField, JComboBox<String> dropdown, JLabel wealthLabel, JTextArea console) {
        try {
            double amount = Double.parseDouble(amountField.getText());
            int selectedIndex = dropdown.getSelectedIndex();
            
            if (selectedIndex != -1) {
                Account selectedAccount = currentClient.getAccounts().get(selectedIndex);

                if (type.equals("Deposit")) {
                    selectedAccount.deposit(amount);
                    console.append("⬇️ Statement Credited: Added $" + amount + " into Target Node " + selectedAccount.getAccountNumber() + "\n");
                } else if (type.equals("Withdraw")) {
                    if (selectedAccount instanceof SavingAccount && amount >= 100000) {
                        JOptionPane.showMessageDialog(frame, "Transfer execution request violates strict account tier velocity constraints ($100,000).\nOperational state set to: PENDING ADMINISTRATIVE BYPASS EXEMPTION.", "Bypass Exemption Clearance Block", JOptionPane.WARNING_MESSAGE);
                        console.append("⏳ Validation Request Redirected: System holds transaction transfer for administrative clearance override panel review: $" + amount + "\n");
                    } else if (amount <= selectedAccount.getBalance()) {
                        selectedAccount.withdraw(amount);
                        console.append("⬆️ Statement Debited: Disbursed $" + amount + " from Target Node " + selectedAccount.getAccountNumber() + "\n");
                    } else {
                        JOptionPane.showMessageDialog(frame, "Target reference liquidity pool checks insufficient.", "Asset Limit Warning", JOptionPane.ERROR_MESSAGE);
                    }
                }

                wealthLabel.setText("Total Wealth: $" + currentClient.getTotalBalance());
                dropdown.removeItemAt(selectedIndex);
                dropdown.insertItemAt(selectedAccount.getClass().getSimpleName() + " - " + selectedAccount.getAccountNumber() + " ($" + selectedAccount.getBalance() + ")", selectedIndex);
                dropdown.setSelectedIndex(selectedIndex);
                amountField.setText("");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Input string conversion sequence parse failure.", "Verification Failure", JOptionPane.ERROR_MESSAGE);
        }
    }
}