package no.kino.gui.customerContent;

import no.kino.control.Control;
import no.kino.domain.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Date;

import static java.awt.Color.BLACK;

public class CustomerOrder extends javax.swing.JFrame implements ActionListener {
    Control control = Control.getInstance();

    JCheckBox[][] buttons;

    JPanel mPanel = new JPanel();

    JPanel bPanel = new JPanel();

    JPanel cPanel = new JPanel();

    JTextArea scoreKeeper = new JTextArea();

    Container c = getContentPane();

    int[][] intArray;



    public CustomerOrder(String title, int cinemaNumber) throws Exception {


        butGen(cinemaNumber, getCinemaRow(cinemaNumber), getCinemaSeatsPerRow(cinemaNumber));

        //cPanel.add(scoreKeeper);

        bPanel.setLayout(new GridLayout(getCinemaRow(cinemaNumber), getCinemaSeatsPerRow(cinemaNumber)));

        mPanel.setLayout(new BorderLayout());

        mPanel.add(bPanel, BorderLayout.CENTER);

        mPanel.add(cPanel, BorderLayout.SOUTH);

        c.add(mPanel);

        JButton orderButton = new JButton("Velg seter");
        orderButton.addActionListener(this);
        cPanel.add(orderButton);

        JButton cancelOrderButton = new JButton("Tilbake");
        cancelOrderButton.addActionListener(this);
        cPanel.add(cancelOrderButton);


        setTitle("ButtonMaddness");

        setSize(1000, 400);

        setLocation(200, 200);

        setVisible(true);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    }



    // metode som genererer JCheckboxes etter antall seter på en kinosal
    private void butGen(int number, int row, int column) {
        buttons = new JCheckBox[row][column];
        intArray = new int[row][column];
        ArrayList<TakenSeat> takenSeatsList = control.getTakenSeatsList();
        System.out.println(takenSeatsList);
        boolean isSeatTaken = false;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                for (TakenSeat t : takenSeatsList) {
                    if (i == t.getRowNumber() && j == t.getSeatNumber() && t.getShowingNumber() == number) {
                        isSeatTaken = true;
                    }
                }
                if(isSeatTaken) {
                    buttons[i][j] = new JCheckBox();
                    buttons[i][j].setBackground(BLACK);
                    buttons[i][j].setEnabled(false);
                    buttons[i][j].setOpaque(true);
                }
                else {
                    buttons[i][j] = new JCheckBox();

                    buttons[i][j].setActionCommand(i + "" + j);

                    buttons[i][j].setSelected(false);

                    int finalI = i;
                    int finalJ = j;
                    buttons[i][j].addItemListener(new ItemListener() {
                        @Override
                        public void itemStateChanged(ItemEvent e) {
                            Object source = e.getStateChange();
                            if (source.equals(1)) {
                                // sete er valgt
                                System.out.println(source);
                                System.out.println("Valgt sete");
                            } else {
                                // sete er ikke valgt
                                System.out.println(source);
                                System.out.println("Ikke valgt sete");
                            }
                            orderConfirmationList(number, finalI, finalJ);

                        }
                    });
                }
                bPanel.add(buttons[i][j]);
                isSeatTaken = false;
            }
        }
    }

    // metode for å returnere seter per rad
    private int getCinemaSeatsPerRow(int showingNumber) {
        ArrayList<Seat> seatList = control.getSeatList();
        ArrayList<Showing> showingsList = control.getShowingsList();
        int counter = 0;
        for(Showing showing : showingsList) {
            if (showingNumber == showing.getShowingNumber()) {
                int movieTheaterNumber = showing.getCinemaNumber();
                for(Seat s : seatList) {
                    if(movieTheaterNumber==s.getMovieTheaterNr() && 1 == s.getrowNr()) {
                        counter++;
                    }
                }
            }
        }
        return counter;
    }

    // metode for å returne antall rader
    private int getCinemaRow(int showingNumber) {
        ArrayList<Seat> seatList = control.getSeatList();
        ArrayList<Showing> showingsList = control.getShowingsList();
        int counter = 0;
        for(Showing showing : showingsList) {
            if (showingNumber == showing.getShowingNumber()) {
                int movieTheaterNumber = showing.getCinemaNumber();
                for(Seat s : seatList) {
                    if(movieTheaterNumber==s.getMovieTheaterNr() && 1 == s.getseatNr()) {
                        counter++;
                    }
                }
            }
        }
        return counter;
    }

    // legger inn valgte seter i egen liste customerOrderConfirmation
    public void orderConfirmationList(int showingNumberIn, int row, int column) {
        ArrayList<OrderConfirmation> customerOrderConfirmation = control.getOrderConfirmation();
        ArrayList<Movie> moviesList = control.getMovieList();
        ArrayList<Showing> showingsList = control.getShowingsList();
        if(buttons[row][column].isSelected()){
            for (Showing s : showingsList) {
                if (s.getShowingNumber() == showingNumberIn) {
                    for (Movie m : moviesList) {
                        if (s.getMovieNumber() == m.getMovieNumber()) {
                            String movieName = m.getMovieName();
                            int movieTheaterNumber = s.getCinemaNumber();
                            Date date = s.getDate();
                            String time = s.getStartingTime().toString();
                            double price = s.getPrice();
                            customerOrderConfirmation.add(new OrderConfirmation(movieName, movieTheaterNumber, date, time, price, row, column, showingNumberIn));
                            System.out.println("1" + customerOrderConfirmation);
                        }
                    }
                }
            }

        }
    }

    // håndtere valg av knapper
    public void actionPerformed(ActionEvent e) {
        String choice = e.getActionCommand();
        if(e.getActionCommand().contains("button"))

        {

            int i = Integer.parseInt(Character.toString(e.getActionCommand().replaceAll("button","").replaceAll("_", "").charAt(0)));

            int j = Integer.parseInt(Character.toString(e.getActionCommand().replaceAll("button","").replaceAll("_", "").charAt(1)));

            intArray[i][j]++;

        }
        // styre hvor vi sender bruker
        if (choice.equals("Velg seter")) {
//            orderConfirmationList(1,25,20);
            OrderConfirmationGUI orderConfirmationGUI = null;
            try {
                orderConfirmationGUI = new OrderConfirmationGUI("Gjennomfør bestilling", control.getOrderConfirmation());
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            orderConfirmationGUI.setVisible(true);


        }
           else if (choice.equals("Tilbake")) {
                System.exit(0);
        }
    }


}







