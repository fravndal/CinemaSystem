package no.kino.gui;

import no.kino.control.Control;
import no.kino.gui.staffContent.AddSale;
import no.kino.gui.staffContent.SetPayment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Staff extends JDialog implements ActionListener {
    Control control = Control.getInstance();
    private JButton delOrderButton, setOrderButton, addSaleButton, closeButton;
    AddSale addSale = new AddSale("Legg til salg");
    SetPayment setPayment = new SetPayment("Sett bestilling som betalt");



    public Staff(String title) throws Exception {
        setTitle(title);
        setLayout(new GridLayout(2, 1));
        JPanel staffPanel = new JPanel();
        add(staffPanel);
        staffPanel.setLayout(new GridLayout(3, 2));

        JPanel buttonPanel = new JPanel();
        add(buttonPanel);

        //Button for deleting an unpaid payment
        delOrderButton = new JButton("Slett en ubetalt bestilling");
        delOrderButton.addActionListener(this);
        buttonPanel.add(delOrderButton);

        //Button for setting payment as paid
        setOrderButton = new JButton("Sett bestilling som betalt");
        setOrderButton.addActionListener(this);
        buttonPanel.add(setOrderButton);

        //Button for adding a direct sale
        addSaleButton = new JButton("Legg til direkte salg");
        addSaleButton.addActionListener(this);
        buttonPanel.add(addSaleButton);

        //Button for closing the window
        closeButton = new JButton("Lukk");
        closeButton.addActionListener(this);
        buttonPanel.add(closeButton);
        setLocation(300, 300);
        pack();
    }

    public void actionPerformed(ActionEvent ev) {
        String choice = ev.getActionCommand();
        try {
            if (choice.equals("Slett en ubetalt bestilling")) {
                control.findNotPaid();
            } else if (choice.equals("Sett bestilling som betalt")) {
                setPayment.setVisible(true);
            } else if (choice.equals("Legg til direkte salg")) {
                addSale.setVisible(true);
            } else if (choice.equals("Lukk")) {
                System.exit(0);
            }
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}