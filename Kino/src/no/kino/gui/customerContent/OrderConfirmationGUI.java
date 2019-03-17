package no.kino.gui.customerContent;


import no.kino.control.Control;
import no.kino.control.RandomTicketNr;
import no.kino.domain.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

public class OrderConfirmationGUI extends javax.swing.JFrame implements ActionListener {
    Control control = Control.getInstance();
    private javax.swing.JButton cancelButton;
    private javax.swing.JTable confiramtionTable;
    private javax.swing.JButton confirmationButton;
    private javax.swing.JLabel headingLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel totalPriceLabel;
    private javax.swing.JTextField totalPriceText;
    private javax.swing.JLabel totalSeatsLabel;
    private javax.swing.JTextField totalSeatsText;

    public OrderConfirmationGUI(String title, ArrayList<OrderConfirmation> arrayList) throws Exception{
        initComponents();
        createOrderTable();
        setTotalPriceAndSeats();
    }

    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        confiramtionTable = new javax.swing.JTable();
        headingLabel = new javax.swing.JLabel();
        confirmationButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        totalPriceLabel = new javax.swing.JLabel();
        totalPriceText = new javax.swing.JTextField();
        totalSeatsLabel = new javax.swing.JLabel();
        totalSeatsText = new javax.swing.JTextField();

        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

        jScrollPane1.setViewportView(confiramtionTable);

        headingLabel.setText("Bekreft din bestilling eller avbryt");

        confirmationButton.setText("Bekreft");
        confirmationButton.addActionListener(this);

        cancelButton.setText("Avbryt");
        cancelButton.addActionListener(this);

        totalPriceLabel.setText("Total pris:");

        totalSeatsLabel.setText("Antall seter:");

        totalPriceText.setEditable(false);
        totalSeatsText.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jSeparator1)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(302, 302, 302)
                                                                .addComponent(headingLabel))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(234, 234, 234)
                                                                .addComponent(confirmationButton)
                                                                .addGap(150, 150, 150)
                                                                .addComponent(cancelButton))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(135, 135, 135)
                                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(134, 134, 134)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(totalPriceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(totalSeatsLabel))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(totalPriceText, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(totalSeatsText, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addGap(0, 138, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(headingLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(33, 33, 33)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                                                .addComponent(totalPriceLabel))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(totalSeatsText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(totalSeatsLabel))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(totalPriceText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(confirmationButton)
                                        .addComponent(cancelButton))
                                .addGap(27, 27, 27))
        );

        pack();
    }


    // bestillingstablet blir laget
    public void createOrderTable() {
        Object[][] table = makeOrderConfirmationList();
        confiramtionTable.setModel(new javax.swing.table.DefaultTableModel(table,
                new String [] {
                        "Filmnavn", "Kinosalnr", "Dato", "Tidspunkt", "Pris", "Radnr", "Setenr", "Visningsnr"
                }
        ));

    }

    // setter antall seter og totalpris i GUI
    public void setTotalPriceAndSeats() {
        ArrayList<OrderConfirmation> orderConfirmation = control.getOrderConfirmation();
        int antallBilletter = 1;
        for (OrderConfirmation o : orderConfirmation) {
            double price = o.getPrice();
            double totPrice = price * antallBilletter;
            String totPriceString = String.valueOf(totPrice);
            String totSeatsString = String.valueOf(antallBilletter);

            totalPriceText.setText(totPriceString);
            totalSeatsText.setText(totSeatsString);
            antallBilletter++;
        }

    }

    // fyller listen med ordre som er bekreftet
    public Object[][] makeOrderConfirmationList() {
        ArrayList<OrderConfirmation> orderConfirmation = control.getOrderConfirmation();
        Object[][] content = new Object[control.getOrderConfirmation().size()][8];

        int counter = 0;
        try {
            for (OrderConfirmation o : orderConfirmation) {
                int showingNumber = o.getShowingNumber();
                String movieName = o.getMovieName();
                int movieTheaterNumber = o.getMovieTheaterNumber();
                Date date = o.getDate();
                String time = o.getTime();
                double price = o.getPrice();
                int rowNumber = o.getRowNumber();
                int seatNumber = o.getSeatNumber();

                content[counter][0] = movieName;
                content[counter][1] = movieTheaterNumber;
                content[counter][2] = date;
                content[counter][3] = time;
                content[counter][4] = price;
                content[counter][5] = rowNumber+1;
                content[counter][6] = seatNumber+1;
                content[counter][7] = showingNumber;

                counter++;

            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Klarte ikke opprette tabell");
        }
        return content;
    }

    public void createTicket() {
        ArrayList<OrderConfirmation> orderConfirmation = control.getOrderConfirmation();
        ArrayList<Ticket> ticketsList = control.getNewTicketsList();
        RandomTicketNr randomTicket = new RandomTicketNr();
        for (OrderConfirmation o : orderConfirmation) {
            String ticketNumber = randomTicket.getLetters(4) + randomTicket.getNumebers(2);
            Ticket ticket = new Ticket(ticketNumber, o.getShowingNumber(), 0);
            ticketsList.add(ticket);
            System.out.println(ticketsList);
            break;
        }
    }

    public void createSeatTicket() {
        ArrayList<Ticket> ticketArrayList = control.getNewTicketsList();
        ArrayList<OrderConfirmation> orderConfirmationArrayList = control.getOrderConfirmation();
        ArrayList<SeatTicket> seatTicketArrayList = control.getNewSeatTicketList();

        for (Ticket t : ticketArrayList) {
            String ticketNumber = t.getTicketNumber();
            for (OrderConfirmation o : orderConfirmationArrayList) {
                if (t.getShowingNumber() == o.getShowingNumber()) {
                    int seatNumber = o.getSeatNumber() + 1;
                    int rowNumber = o.getRowNumber() + 1;
                    int movieTheaterNumber = o.getMovieTheaterNumber();

                    SeatTicket newSeatTicket = new SeatTicket(rowNumber, seatNumber, movieTheaterNumber, ticketNumber);
                    seatTicketArrayList.add(newSeatTicket);
                }
            }

        }

    }

    // håndterer valg av knapper
    public void actionPerformed(ActionEvent ev) {
        String choice = ev.getActionCommand();
        try {
            if (choice.equals("Bekreft")) {
                createTicket();
                createSeatTicket();
                ConfirmOrder confirmOrder = new ConfirmOrder("Gjennomfør bestilling", control.getOrderConfirmation());
                confirmOrder.setVisible(true);
            }
            else{
                System.out.println("hoi");
            }
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}


