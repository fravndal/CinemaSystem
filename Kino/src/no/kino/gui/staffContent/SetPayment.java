package no.kino.gui.staffContent;

import no.kino.control.Control;
import no.kino.domain.Ticket;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SetPayment extends JDialog implements ActionListener {
    Control control = Control.getInstance();
    private javax.swing.JButton closeButton;
    private javax.swing.JButton executeButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField ticketNumberInput;
    private javax.swing.JTable ticketTable;

    public SetPayment(String title) throws Exception {
        initComponents();
        setTitle(title);
        fillSearch();
    }

    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ticketTable = new javax.swing.JTable();
        searchButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        ticketNumberInput = new javax.swing.JTextField();
        executeButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        closeButton = new javax.swing.JButton();

        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);


        jScrollPane1.setViewportView(ticketTable);

        searchButton.setText("Søk");

        searchButton.addActionListener(this);

        jLabel1.setText("Skriv inn billettnr:");

        ticketNumberInput.addActionListener(this);

        executeButton.setText("Utfør betaling");

        executeButton.addActionListener(this);

        jLabel2.setText("Registrer betaling for en billett");

        closeButton.setText("Lukk");
        closeButton.addActionListener(this);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator1)
                        .addComponent(jSeparator2)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(ticketNumberInput, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(30, 30, 30)
                                                .addComponent(searchButton))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(22, 22, 22)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(27, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(executeButton)
                                                .addGap(18, 18, 18)
                                                .addComponent(closeButton)
                                                .addGap(29, 29, 29))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(177, 177, 177))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(searchButton)
                                        .addComponent(jLabel1)
                                        .addComponent(ticketNumberInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(executeButton)
                                        .addComponent(closeButton))
                                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>

    public void actionPerformed(ActionEvent event) {
        String choice = event.getActionCommand();

        switch (choice) {
            case "Søk":
                fillSearch();
                break;
            case "Utfør betaling":
                editTicketToPaid();
                fillSearch();
                break;
            default:
                setVisible(false);
                break;
        }
    }

    public void editTicketToPaid() {
        ArrayList<Ticket> ticketList = control.getTicketList();
        Ticket ticket = returnTicket(ticketNumberInput.getText());
        ticket = new Ticket(ticket.getTicketNumber(), ticket.getShowingNumber(), 1);
        int counter = 0;
        for(Ticket t : ticketList) {
            if(ticketNumberInput.getText().equals(t.getTicketNumber())) {
                ticketList.set(counter, ticket);
            }
            counter++;
        }
    }

    public Ticket returnTicket(String ticketCode) {
        ArrayList<Ticket> ticketList = control.getTicketList();
        try{
            for(Ticket t : ticketList){
                if(ticketCode.equals(t.getTicketNumber())) {
                    return t;
                }

            }
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }


    public void fillSearch() {
        Object[][] table = searchList();
        ticketTable.setModel(new javax.swing.table.DefaultTableModel(table,
                new String [] {
                        "VisningNr", "Billettkode", "ErBetalt"
                }
        ));
    }

    public Object[][] searchList() {
        ArrayList<Ticket> ticketList = control.getTicketList();
        Object[][] content = new Object[1][3];
        int counter = 0;
        String ticketCode = ticketNumberInput.getText();
        try {

            for (Ticket t : ticketList) {
                if (t.getTicketNumber().equals(ticketCode)) {
                    int showingNumber = t.getShowingNumber();
                    int isPaid = t.getIsPaid();

                    content[counter][0] = ticketCode;
                    content[counter][1] = showingNumber;
                    content[counter][2] = isPaid;
                    counter++;
                }
            }
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Klarte ikke opprette tabell");
        }
        return content;
    }
}