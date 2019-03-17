package no.kino.gui.customerContent;

import no.kino.control.Control;
import no.kino.domain.OrderConfirmation;
import no.kino.domain.Ticket;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;

public class ConfirmOrder extends javax.swing.JFrame{
    Control control = Control.getInstance();
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;

    public ConfirmOrder(String title, ArrayList<OrderConfirmation> arrayList){
        initComponents();
        createOrderTable();
    }

    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        jScrollPane1.setViewportView(jTable1);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jButton1.setText("OK");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Husk å hente billetten minst 30 minutter før visningen starter");
        jLabel1.setAlignmentX(0.5F);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Din billettkode er: ");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField1.setText(getTicketNumber());
        jTextField1.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(125, 125, 125)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 783, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 732, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(91, 91, 91)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
    }

    public void createOrderTable() {
        ArrayList<OrderConfirmation> orderConfirmation = control.getOrderConfirmation();
        Object[][] table = createReceiptList();
        jTable1.setModel(new javax.swing.table.DefaultTableModel(table,
                new String [] {
                        "Filmnavn", "Kinosalnr", "Dato", "Tidspunkt", "Pris", "Radnr", "Setenr"
                }
        ));

    }

    public String getTicketNumber() {
        ArrayList<Ticket> ticketsList = control.getNewTicketsList();
        String ticketList = "";
        for (Ticket t : ticketsList) {
            if (t.getIsPaid() == 0)
            ticketList = t.getTicketNumber();
        }
        return ticketList;
    }

    // fyller listen med ordre som er bekreftet
    public Object[][] createReceiptList() {
        ArrayList<OrderConfirmation> orderConfirmation = control.getOrderConfirmation();
        Object[][] content = new Object[control.getOrderConfirmation().size()][7];

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

                counter++;
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Klarte ikke opprette tabell");
        }
        return content;
    }

}
