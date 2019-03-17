package no.kino.gui;

import no.kino.control.Control;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JDialog implements ActionListener {

    private Admin admin = new Admin("Admin");
    private Staff staff = new Staff("Staff");
    private JTextField inputUsername;
    private JPasswordField inputPassword;
    private String guiToOpen;


    public Login(String title) throws Exception {
        setTitle(title);
        setLayout(new GridLayout(2, 1));
        JPanel loginPanel = new JPanel();
        add(loginPanel);
        loginPanel.setLayout(new GridLayout(3, 2));
        loginPanel.add(new JLabel("Brukernavn:"));
        inputUsername = new JTextField(20);
        loginPanel.add(inputUsername);
        loginPanel.add(new JLabel("Passord:"));
        inputPassword = new JPasswordField(20);
        loginPanel.add(inputPassword);
        JPanel buttonPanel = new JPanel();
        add(buttonPanel);
        JButton loginButton = new JButton("Logg inn");
        loginButton.addActionListener(this);
        buttonPanel.add(loginButton);
        JButton closeButton = new JButton("Lukk");
        closeButton.addActionListener(this);
        buttonPanel.add(closeButton);
        setLocation(300, 300);
        pack();
    }

    public void actionPerformed(ActionEvent event) {
        String username = inputUsername.getText();
        char[] passordChar = inputPassword.getPassword();
        String password = String.valueOf(passordChar);
        String choice = event.getActionCommand();
        if (choice.equals("Logg inn")) {
            try {
                if(Control.checkLoginAdmin(username, password) && "Administrator".equals(guiToOpen)) {
                    admin.setVisible(true);
                    setVisible(false);
                } else
                    if (Control.checkLoginStaff(username, password) && "Kinobetjent".equals(guiToOpen)) {
                        staff.setVisible(true);
                        setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Feil brukernavn eller passord, prøv igjen...");
                    }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (choice.equals("Lukk")) {
            setVisible(false);
        }
    }



    public void setGuiToOpen(String guiToOpen) {
        this.guiToOpen = guiToOpen;
    }
}
