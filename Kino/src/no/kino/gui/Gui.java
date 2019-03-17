package no.kino.gui;

import no.kino.control.Control;
import no.kino.gui.staffContent.AddSale;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Gui extends JFrame implements ActionListener {
    private Login login = new Login("Legg til salg");
    private Customer customer = new Customer("Kunde");
    private Control control = Control.getInstance();


    public Gui(String title) throws Exception {
        super.setTitle(title);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        JPanel tableWindow = new JPanel();
        add(tableWindow, BorderLayout.CENTER);
        JPanel buttonWindow = new JPanel();
        add(buttonWindow, BorderLayout.SOUTH);

        JButton admin = new JButton("Administrator");
        admin.addActionListener(this);
        buttonWindow.add(admin);
        JButton staff = new JButton("Kinobetjent");
        staff.addActionListener(this);
        buttonWindow.add(staff);
        JButton customer = new JButton("Kunde");
        customer.addActionListener(this);
        buttonWindow.add(customer);
        JButton cancel = new JButton("Avslutt");
        cancel.addActionListener(this);
        buttonWindow.add(cancel);


        pack();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    control.saveData();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    public void actionPerformed(ActionEvent evt) {
        String choice = evt.getActionCommand();
        try {
            switch (choice) {
                case "Administrator":
                    login.setGuiToOpen("Administrator");
                    login.setVisible(true);
                    break;
                case "Kinobetjent":
                    login.setGuiToOpen("Kinobetjent");
                    login.setVisible(true);
                    break;
                case "Kunde":
                    customer.setVisible(true);
                    break;
                default:
                    System.exit(0);
            }
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }



}