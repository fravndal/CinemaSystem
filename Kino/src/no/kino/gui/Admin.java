package no.kino.gui;

import no.kino.control.Control;
import no.kino.gui.adminContent.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin extends JDialog implements ActionListener {
    private NewMovie newMovie = new NewMovie("Legg inn en ny film");
    private ChangeMovie changeMovie = new ChangeMovie("Endre/slett en film");
    private NewShowing newShowing = new NewShowing("Legg inn en ny visning");
    private ChangeShowing changeShowing = new ChangeShowing("Endre/slett en visning");
    private Statistics statistics = new Statistics("Statistikker om billettsalg");

    Admin(String title) throws Exception {
        setTitle(title);
        setLayout(new GridLayout(2, 1));
        JPanel adminPanel = new JPanel();
        add(adminPanel);
        adminPanel.setLayout(new GridLayout(3, 2));


        JPanel buttonPanel = new JPanel();
        add(buttonPanel);
        JButton addMovie = new JButton("Legg til en ny film");
        addMovie.addActionListener(this);
        buttonPanel.add(addMovie);
        JButton changeMovie = new JButton("Endre/slett en film");
        changeMovie.addActionListener(this);
        buttonPanel.add(changeMovie);
        JButton addShowing = new JButton("Legg til en ny visning");
        addShowing.addActionListener(this);
        buttonPanel.add(addShowing);
        JButton changeShowing = new JButton("Endre/slett en visning");
        changeShowing.addActionListener(this);
        buttonPanel.add(changeShowing);
        JButton statistics = new JButton("Statistikk om billettsalg");
        statistics.addActionListener(this);
        buttonPanel.add(statistics);
        JButton closeButton = new JButton("Lukk");
        closeButton.addActionListener(this);
        buttonPanel.add(closeButton);
        setLocation(300, 300);
        pack();
    }

    public void actionPerformed(ActionEvent evt) {
        String choice = evt.getActionCommand();
        try {
            switch (choice) {
                case "Legg til en ny film":
                    newMovie.createMovieMap();
                    newMovie.setVisible(true);
                    break;
                case "Endre/slett en film":
                    changeMovie.createMovieTable();
                    changeMovie.getMovieNumberComboBox().setModel(new DefaultComboBoxModel<>(changeMovie.fillComboBox()));
                    changeMovie.setVisible(true);
                    break;
                case "Legg til en ny visning":
                    newShowing.createShowingMap();
                    newShowing.fillComboBoxes();
                    newShowing.setVisible(true);
                    break;
                case "Endre/slett en visning":
                    changeShowing.createShowingTable();
                    changeShowing.createMovieTable();
                    changeShowing.setVisible(true);
                    break;
                case "Statistikk om billettsalg":
                    statistics.setVisible(true);
                    break;
                default:
                    System.exit(0);
            }
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}