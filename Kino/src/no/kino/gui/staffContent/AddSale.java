package no.kino.gui.staffContent;

import no.kino.control.Control;
import no.kino.domain.Movie;
import no.kino.domain.OrderConfirmation;
import no.kino.domain.Showing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;


public class AddSale extends JDialog implements ActionListener {
    Control control = Control.getInstance();
    private javax.swing.JButton closeButton;
    private javax.swing.JLabel headingLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton nextButton;
    private javax.swing.JTable showingsTable;

    public AddSale(String title){
        initComponents();
        createDirectSaleTable();
    }

    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        showingsTable = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        nextButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        headingLabel = new javax.swing.JLabel();

        jScrollPane1.setViewportView(showingsTable);

        nextButton.setText("Neste");
        nextButton.addActionListener(this);

        closeButton.setText("Avbryt");
        closeButton.addActionListener(this);

        headingLabel.setText("Velg hvilken visning du vil lage en billett på");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jSeparator1))
                                        .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(141, 141, 141)
                                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(265, 265, 265)
                                                                .addComponent(headingLabel))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(235, 235, 235)
                                                                .addComponent(nextButton)
                                                                .addGap(124, 124, 124)
                                                                .addComponent(closeButton)))
                                                .addGap(0, 133, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(headingLabel)
                                .addGap(18, 18, 18)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(nextButton)
                                        .addComponent(closeButton))
                                .addGap(50, 50, 50))
        );

        pack();
    }

    public int selectedRow() throws Exception {
        Integer test = (Integer) showingsTable.getValueAt(showingsTable.getSelectedRow(), 0);
        return test;

    }

    public void createDirectSaleTable() {
        Object[][] table = makeDirectSaleList();
        showingsTable.setModel(new javax.swing.table.DefaultTableModel(table,
                new String [] {
                        "Visningsnr", "Filmnr", "Kinosalnr", "Dato", "Starttid", "Pris"
                }
        ));

    }

    // objektet som vises i visningstabellen fylles
    public Object[][] makeDirectSaleList() {
        Object[][] content = new Object[control.getShowingsList().size()][6];
        ArrayList<Showing> showingList = control.getShowingsList();
        ArrayList<Movie> movieList = control.getMovieList();

        int counter = 0;
        try {
            for (Showing s : showingList) {
                int showingNumber = s.getShowingNumber();
                int movieNumber = s.getMovieNumber();
                int cinemaRoomNumber = s.getCinemaNumber();
                Date date = s.getDate();
                Time startTime = s.getStartingTime();
                double price = s.getPrice();
                for (Movie m : movieList) {
                    if (movieNumber == m.getMovieNumber()) {
                        String movieName = m.getMovieName();
                        content[counter][1] = movieName;
                    }
                }
                content[counter][0] = showingNumber;
                content[counter][2] = cinemaRoomNumber;
                content[counter][3] = date;
                content[counter][4] = startTime;
                content[counter][5] = price;
                counter++;
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Klarte ikke opprette tabell for visninger");
        }
        return content;
    }


    public void actionPerformed(ActionEvent event) {
        String choice = event.getActionCommand();
        try {
            if (choice.equals("Neste")) {
                AddSaleSeatMap addSaleSeatMap = new AddSaleSeatMap("Kinokart", selectedRow());
                addSaleSeatMap.setVisible(true);
            }
            else if(choice.equals("Avbryt")){
                System.exit(0);
            }


        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
