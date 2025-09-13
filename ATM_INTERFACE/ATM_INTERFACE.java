import javax.swing.*;
import java.awt.*;

public class ATM_INTERFACE {
    private BANKACCOUNT acc;

    public ATM_INTERFACE(BANKACCOUNT acc){
        this.acc = acc;
        showLoginScreen();
    }

    private void showLoginScreen() {
       JFrame loginFrame = new JFrame("LOGIN");
       loginFrame.setSize(500,300);
       loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       loginFrame.setLayout(new GridLayout(3,2));

       JLabel cardLabel = new JLabel("card number:");
       JTextField cardField = new JTextField();
       JLabel pinLabel = new JLabel("Pin:");
       JPasswordField pinField = new JPasswordField();
       JButton loginButton = new JButton("login");

       loginFrame.add(cardLabel);
       loginFrame.add(cardField);
       loginFrame.add(pinLabel);
       loginFrame.add(pinField);
       loginFrame.add(new JLabel());
       loginFrame.add(loginButton);

       loginButton.addActionListener(e ->{
        String card =  cardField.getText();
        String pin = new String(pinField.getPassword());
        if(card.equals("12345")&& pin.equals("12345")){
            loginFrame.dispose();
            showMenu();
        }
        else{
            JOptionPane.showMessageDialog(loginFrame,"INVALID ENTRY");
        }
        });

       loginFrame.setVisible(true);
    }

    private void showMenu(){
        JFrame menuFrame = new JFrame("ATM menu");
        menuFrame.setSize(500,300);
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setLayout(new GridLayout(4,1));

        JButton withdraButton = new JButton("Withdraw");
        JButton depButton = new JButton("Deposit");
        JButton balButton = new JButton("Check balance");
        JButton exitButton = new JButton("Exit");

        menuFrame.add(withdraButton);
        menuFrame.add(depButton);
        menuFrame.add(balButton);
        menuFrame.add(exitButton);

        withdraButton.addActionListener(e -> WithdrawMoney(menuFrame));
        depButton.addActionListener(e -> depositMoney(menuFrame));
        balButton.addActionListener(e -> checkbalance(menuFrame));
        exitButton.addActionListener(e -> System.exit(0));

        menuFrame.setVisible(true);
    }

    private void WithdrawMoney(JFrame parent){
        String amString = JOptionPane.showInputDialog("Enter amount to withdraw:");
        if (amString!= null) {
            try {
                double amount = Double.parseDouble(amString);
                if (acc.withdraw(amount)) {
                    JOptionPane.showMessageDialog(parent, "Withdrawal successfull");
                }else{
                    JOptionPane.showMessageDialog(parent, "Invalid amount");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(parent, "Please enter a valid amount or check balance and try again");
            }
        }
    }

    private void depositMoney(JFrame parent){
        String amString = JOptionPane.showInputDialog(parent,"enter amount to deposit:");
        if (amString != null) {
            try {
                double amount = Double.parseDouble(amString);
                if (acc.deposit(amount)) {
                    JOptionPane.showMessageDialog(parent, "Deposit successfull");
                }else{
                    JOptionPane.showMessageDialog(parent, "Invalid amount. Try again!");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(parent, "Please enter a valid amount!");
            }
        }
    }

    private void checkbalance(JFrame parent){
        JOptionPane.showMessageDialog(parent, "current balance: " + acc.getBalance());
    }

    public static void main(String[] args) {
        BANKACCOUNT acc = new BANKACCOUNT(10000);
        new ATM_INTERFACE(acc);
    }
}
