/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication;

  import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Pattern;

public class JavaApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        JFrame frame = new JFrame("Data Validation Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(10, 20, 80, 25);
        panel.add(nameLabel);

        JTextField nameText = new JTextField(20);
        nameText.setBounds(100, 20, 165, 25);
        panel.add(nameText);
        nameText.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if (nameText.getText().length() < 3) {
                    nameText.setToolTipText("Name must be at least 3 characters long");
                } else {
                    nameText.setToolTipText(null);
                }
            }
        });

        JLabel EmailLabel = new JLabel("E-mail:");
        EmailLabel.setBounds(10, 50, 80, 25);
        panel.add(EmailLabel);

        JTextField emailText = new JTextField(20);
        emailText.setBounds(100, 50, 165, 25);
        panel.add(emailText);
        emailText.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if (!Pattern.matches("^[A-Za-z0-9+_.-]+@(.+)$", emailText.getText())) {
                    emailText.setToolTipText("Your E-mail must be in the format example@example.com");
                } else {
                    emailText.setToolTipText(null);
                }
            }
        });

        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setBounds(10, 80, 80, 25);
        panel.add(phoneLabel);

        JTextField phoneNumber = new JTextField(20);
        phoneNumber.setBounds(100, 80, 165, 25);
        panel.add(phoneNumber);
        phoneNumber.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if (!Pattern.matches("\\d{10}", phoneNumber.getText())) {
                    phoneNumber.setToolTipText("Phone number must be 10 digits long");
                } else {
                    phoneNumber.setToolTipText(null);
                }
            }
        });

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 110, 80, 25);
        panel.add(passwordLabel);

        JPasswordField PassWordText = new JPasswordField(20);
        PassWordText.setBounds(100, 110, 165, 25);
        panel.add(PassWordText);
        PassWordText.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                String password = new String(PassWordText.getPassword());
                if (!Pattern.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$", password)) {
                    PassWordText.setToolTipText("Password must be at least 8 characters long and include at least one uppercase letter, one lowercase letter, and one digit");
                } else {
                    PassWordText.setToolTipText(null);
                }
            }
        });

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(10, 140, 80, 25);
        panel.add(submitButton);
        submitButton.addActionListener(e -> {
            String name = nameText.getText();
            String email = emailText.getText();
            String phone = phoneNumber.getText();
            String password = new String(PassWordText.getPassword());

            if (name.length() >= 3 &&
                Pattern.matches("^[A-Za-z0-9+_.-]+@(.+)$", email) &&
                Pattern.matches("\\d{10}", phone) &&
                Pattern.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$", password)) {
                JOptionPane.showMessageDialog(panel, "Form submitted successfully!");
            } else {
                JOptionPane.showMessageDialog(panel, "Please input the correct format in the above fields", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        frame.setVisible(true);
    }
}

    
    

