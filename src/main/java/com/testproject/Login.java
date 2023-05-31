package com.testproject;


import javax.swing.*;
import java.awt.*;
import static java.awt.Color.gray;
import java.awt.event.*;
import java.awt.Font.*;

public class Login extends JFrame {
    private JLabel userLabel, passLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private Container c;
    private Font f;

    public Login() {
        this.setTitle("Login Page");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 50, 420, 350);
        this.setLocation(600, 150);
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(gray);
        
        f = new Font("Arial",Font.BOLD,18);
        
        userLabel = new JLabel("User Name");
        userLabel.setBounds(50, 120, 150, 50);
        userLabel.setFont(f);
        c.add(userLabel);
        
        usernameField = new JTextField();
        usernameField.setBounds(170, 50, 200, 50);
        c.add(usernameField);
        
        passLabel = new JLabel("User Name");
        passLabel.setBounds(50, 50, 150, 50);
        passLabel.setFont(f);
        c.add(passLabel);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(170, 120, 200, 50);
        c.add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(200, 190, 90, 50);
        loginButton.setFont(f);
        c.add(loginButton);
        
        loginButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName =  usernameField.getText();
                String password =  passwordField.getText();
                
                if(userName.equals("admin") && password.equals("1234")){
                   
                    JOptionPane.showMessageDialog(null, "Login Successful");
                   Home  home = new Home();
                    home.setVisible(true);
                    dispose();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Incorrect username or password");
                }
            }
        
        
        
        });
        
    }

   

    public static void main(String[] args) {
        Login frame = new Login();
        frame.setVisible(true);
}
 }

