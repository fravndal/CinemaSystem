package no.kino.gui.adminContent;

import no.kino.control.Control;
import no.kino.domain.Cinema;
import no.kino.domain.Movie;
import no.kino.domain.Showing;
import no.kino.domain.Ticket;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class ChangeShowing extends JDialog implements ActionListener {
    Control control = Control.getInstance();
    private javax.swing.JButton changeShowingButton;
    private javax.swing.JLabel cinemaNumberLabel;
    private javax.swing.JTextField cinemaNumberText;
    private javax.swing.JTable cinemaTable;
    private javax.swing.JButton closeButton;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JTextField dateText;
    private javax.swing.JButton delShowingButton;
    private javax.swing.JLabel headingEastLabel;
    private javax.swing.JLabel headingTextLabel;
    private javax.swing.JLabel headingTopLabel;
    private javax.swing.JLabel headingWestLabel;
    private javax.swing.JLabel headingWestLabel2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel movieNumberLabel;
    private javax.swing.JTextField movieNumberText;
    private javax.swing.JTable movieTable;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JTextField priceText;
    private javax.swing.JComboBox<Integer> showingNumberComboBox;
    private javax.swing.JLabel showingNumberLabel;
    private javax.swing.JTable showingTable;
    private javax.swing.JLabel startTimeLabel;
    private javax.swing.JTextField startTimeText;



    public ChangeShowing(String title) throws Exception {
        setTitle(title);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setResizable(true);
        createView();
        fillComboBoxes();
        createShowingTable();
        createMovieTable();
        createCinemaTable();



    }

    private void createView() {
        headingTopLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        showingNumberComboBox = new javax.swing.JComboBox<>();
        headingWestLabel = new javax.swing.JLabel();
        headingEastLabel = new javax.swing.JLabel();
        headingWestLabel2 = new javax.swing.JLabel();
        headingTextLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        movieNumberText = new javax.swing.JTextField();
        cinemaNumberText = new javax.swing.JTextField();
        dateText = new javax.swing.JTextField();
        startTimeText = new javax.swing.JTextField();
        priceText = new javax.swing.JTextField();
        showingNumberLabel = new javax.swing.JLabel();
        movieNumberLabel = new javax.swing.JLabel();
        cinemaNumberLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        startTimeLabel = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        changeShowingButton = new javax.swing.JButton();
        delShowingButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        showingTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        movieTable = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        cinemaTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

        headingTopLabel.setText("Endre en visning");

        jScrollPane1.setViewportView(showingTable);

        showingNumberComboBox.setModel(new DefaultComboBoxModel<>(fillComboBoxes()));

        headingWestLabel.setText("Velg visning som skal endres eller slettes:");

        headingEastLabel.setText("Visninger uten reserverte billetter");

        showingTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showingTable_ClickMouseClicked(evt);
            }
        });

        movieTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                movieTable_ClickMouseClicked(evt);
            }
        });

        dateLabel.setText("Dato(yyyy-MM-dd):");

        headingTextLabel.setText("Fyll inn alle felter:");

        startTimeLabel.setText("Starttid(HH:mm:ss):");

        priceLabel.setText("Pris:");

        showingNumberLabel.setText("Visningnr:");

        changeShowingButton.setText("Endre visning");
        changeShowingButton.addActionListener(this);

        closeButton.setText("Tilbake");
        closeButton.addActionListener(this);

        delShowingButton.setText("Slett visning");
        delShowingButton.addActionListener(this);

        headingWestLabel2.setText("For sletting, velg visning og klikk slett.");

        cinemaNumberLabel.setText("Kinosalnr:");


        movieNumberLabel.setText("Filmnr:");

        jScrollPane2.setViewportView(movieTable);

        jLabel1.setText("Alle filmer");

        cinemaTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cinemaTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(cinemaTable);

        jLabel2.setText("Alle kinosaler");

        movieNumberText.setNextFocusableComponent(cinemaNumberText);

        cinemaNumberText.setNextFocusableComponent(dateText);

        dateText.setNextFocusableComponent(startTimeText);

        startTimeText.setNextFocusableComponent(priceText);

        priceText.setNextFocusableComponent(changeShowingButton);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator1)
                        .addComponent(jSeparator2)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(150, 150, 150)
                                .addComponent(changeShowingButton)
                                .addGap(77, 77, 77)
                                .addComponent(delShowingButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(closeButton)
                                .addGap(42, 42, 42))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(48, 48, 48)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(headingWestLabel2)
                                                        .addComponent(headingWestLabel))
                                                .addGap(0, 67, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(headingEastLabel)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(showingNumberLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(movieNumberLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(cinemaNumberLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(dateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(startTimeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                                                        .addComponent(priceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(headingTextLabel)
                                                                        .addComponent(showingNumberComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(movieNumberText, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(cinemaNumberText, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(dateText, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(startTimeText, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(priceText, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(jLabel1)
                                                                                .addGap(190, 190, 190))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(32, 32, 32)))
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel2)
                                                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                .addGap(55, 55, 55))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(310, 310, 310)
                                .addComponent(headingTopLabel)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(headingTopLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(headingWestLabel)
                                        .addComponent(headingEastLabel))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel2))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGap(17, 17, 17)
                                                .addComponent(headingWestLabel2)
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(showingNumberLabel)
                                                        .addComponent(showingNumberComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(34, 34, 34)
                                                .addComponent(headingTextLabel)
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(movieNumberText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(movieNumberLabel))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(cinemaNumberText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(cinemaNumberLabel))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(dateText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(dateLabel))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(startTimeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(startTimeLabel))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(priceText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(priceLabel))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(changeShowingButton)
                                        .addComponent(delShowingButton)
                                        .addComponent(closeButton))
                                .addGap(22, 22, 22))
        );

        pack();
    }

    private void cinemaTableMouseClicked(java.awt.event.MouseEvent evt) {
        int index = cinemaTable.getSelectedRow();
        TableModel model = cinemaTable.getModel();
        String value1 = model.getValueAt(index, 0).toString();
        cinemaNumberText.setText(value1);
    }

    private void movieTable_ClickMouseClicked(MouseEvent evt) {
        int index = movieTable.getSelectedRow();
        TableModel model = movieTable.getModel();
        String value1 = model.getValueAt(index, 0).toString();
        movieNumberText.setText(value1);
    }

    private void showingTable_ClickMouseClicked(MouseEvent evt) {
        int index = showingTable.getSelectedRow();
        TableModel model = showingTable.getModel();
        int value1 = Integer.parseInt(model.getValueAt(index, 0).toString());
        showingNumberComboBox.setSelectedItem(value1);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String choice = e.getActionCommand();
        if (choice.equals("Endre visning")) {
            try {
                changeShowing();
                createShowingTable();
            } catch (ParseException e1) {
                e1.printStackTrace();
            }

        }
        else if(choice.equals("Slett visning")) {
            deleteShowing();
            fillComboBoxes();
            showingNumberComboBox.setModel(new DefaultComboBoxModel<>(fillComboBoxes()));
            createShowingTable();
        }
        else{
            setVisible(false);
        }

    }

    public void createShowingTable() {
        Object[][] table = makeShowingList();
        showingTable.setModel(new javax.swing.table.DefaultTableModel(table,
                new String [] {
                        "VisningsNr", "FilmNr", "KinosalNr", "Dato", "Starttid", "Pris"
                }
        ));


    }

    private Object[][] makeShowingList() {
        ArrayList<Showing> showingsWithoutSalesList = createShowingsWithoutSales();
        Object[][] content = new Object[showingsWithoutSalesList.size()][6];
        int counter = 0;
        try {
            for (Showing m : showingsWithoutSalesList) {
                int showingNumberContent = m.getShowingNumber();
                int movieNumberContent = m.getMovieNumber();
                int cinemaNumber = m.getCinemaNumber();
                Date date = m.getDate();
                Time startingTime = m.getStartingTime();
                double price = m.getPrice();

                content[counter][0] = showingNumberContent;
                content[counter][1] = movieNumberContent;
                content[counter][2] = cinemaNumber;
                content[counter][3] = date;
                content[counter][4] = startingTime;
                content[counter][5] = price;
                counter++;
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Klarte ikke opprette tabell");
        }
        return content;
    }

    private ArrayList<Showing> createShowingsWithoutSales() {
        ArrayList<Showing> showingsListWithoutSales = new ArrayList<>();
        ArrayList<Showing> showingsList = control.getShowingsList();
        ArrayList<Ticket> ticketList = control.getTicketList();

        boolean isFound = false;
        for (Showing m : showingsList) {
            for (Ticket t : ticketList) {
                if(m.getShowingNumber() == t.getShowingNumber()) {
                    isFound = true;
                }
            }
            if(!isFound) {
                showingsListWithoutSales.add(m);
            }
            isFound=false;
        }
        return showingsListWithoutSales;
    }

    public void createMovieTable() {
        Object[][] table = makeMovieList();
        movieTable.setModel(new javax.swing.table.DefaultTableModel(table,
                new String [] {
                        "Filmnr", "Filmnavn"
                }
        ));

    }

    public Object[][] makeMovieList() {
        Object[][] content = new Object[control.getMovieList().size()][2];
        ArrayList<Movie> movieList = control.getMovieList();

        int counter = 0;
        try {
            for (Movie m : movieList) {
                int movieNumber = m.getMovieNumber();
                String movieName = m.getMovieName();
                content[counter][0] = movieNumber;
                content[counter][1] = movieName;
                counter++;
            }


        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Klarte ikke opprette tabell");
        }
        return content;
    }

    public void createCinemaTable() {
        Object[][] table = makeCinemaList();
        cinemaTable.setModel(new javax.swing.table.DefaultTableModel(table,
                new String [] {
                        "Kinosalnr", "Kinonavn", "Kinosalnavn"
                }
        ));


    }

    private Object[][] makeCinemaList() {
        ArrayList<Cinema> cinemaList = control.getCinemaList();
        Object[][] content = new Object[cinemaList.size()][3];
        int counter = 0;
        try {
            for (Cinema c : cinemaList) {
                int cinemaNumber = c.getCinemaNumber();
                String cinemaName = c.getCinemaName();
                String cinemaRoomName = c.getCinemaRoomName();
                content[counter][0] = cinemaNumber;
                content[counter][1] = cinemaName;
                content[counter][2] = cinemaRoomName;
                counter++;
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Klarte ikke opprette tabell");
        }
        return content;
    }


    private Integer[] fillComboBoxes() {
        ArrayList<Showing> showingsList = createShowingsWithoutSales();
        Integer[] showingNumberArray = new Integer[showingsList.size()];
        int counter = 0;
        for(Showing n : showingsList) {
            showingNumberArray[counter] = n.getShowingNumber();
            counter++;
        }
        return showingNumberArray;
    }

    private void changeShowing() throws ParseException {
        ArrayList<Showing> showingsList = control.getShowingsList();
        ArrayList<Showing> showingsChangeList = control.getShowingsChangeList();
        Integer showingNumber = (Integer) showingNumberComboBox.getSelectedItem();

        int movieNumber = Integer.parseInt(movieNumberText.getText());
        int cinemaNumber = Integer.parseInt(cinemaNumberText.getText());

        Date date1 = stringToDateConvert();
        System.out.println(date1);

        Time startingTime = new Time(new SimpleDateFormat("HH:mm:ss").parse(startTimeText.getText()).getTime());
        double price = Double.parseDouble(priceText.getText());

        if (showingNumber != null) {
            Showing showing = new Showing(showingNumber, movieNumber, cinemaNumber, date1, startingTime, price);
            showingsList.set(findIndexInShowingsWithoutSalesList(showingNumber), showing);
            showingsChangeList.add(showing);
        }
    }

    public Date stringToDateConvert() {
        String date = dateText.getText();
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date date1 = java.sql.Date.valueOf(date);
        String formattedDate = formatter.format(date1);
        return date1;
    }


    private void deleteShowing() {
        ArrayList<Showing> showingsList = control.getShowingsList();
        ArrayList<Showing> showingsDeleteList = control.getShowingsDeleteList();
        ArrayList<Showing> showingsWithoutSalesList = createShowingsWithoutSales();
        Integer showingNumber = (Integer) showingNumberComboBox.getSelectedItem();
        for(Showing s:showingsWithoutSalesList) {
            if(showingNumber != null) {
                if(showingNumber == s.getShowingNumber()) {
                    showingsDeleteList.add(s);
                    showingsList.remove(findIndexInShowingsList(s.getShowingNumber()));
                }
            }
        }
    }

    private int findIndexInShowingsList(int showingsNumber) {
        ArrayList<Showing> showingsList = control.getShowingsList();
        int counter = 0;
        for(Showing s: showingsList) {
            if(s.getShowingNumber() == showingsNumber) {
                return counter;
            }
            counter++;
        }
        return -1;
    }

    private int findIndexInShowingsWithoutSalesList(int showingsNumber) {
        ArrayList<Showing> showingListWithoutSales = createShowingsWithoutSales();
        int counter = 1;
        for(Showing s: showingListWithoutSales) {
            if(s.getShowingNumber() == showingsNumber) {
                return counter;
            }
            counter++;
        }
        return -1;
    }


}
