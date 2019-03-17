package no.kino.gui.adminContent;

import no.kino.control.Control;
import no.kino.domain.Cinema;
import no.kino.domain.Movie;
import no.kino.domain.Showing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class NewShowing extends JDialog implements ActionListener {
    Control control = Control.getInstance();
    private JButton addShowButton;
    private javax.swing.JComboBox<Integer> cinemaNumberCombo;
    private javax.swing.JLabel cinemaNumberLabel;
    private javax.swing.JButton closeButton;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JTextPane dateText;
    private javax.swing.JLabel headingLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JComboBox<String> movieNumberCombo;
    private javax.swing.JLabel movieNumberLabel;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JTextPane priceText;
    private javax.swing.JTable showingsTable;
    private javax.swing.JLabel startingTimeLabel;
    private javax.swing.JTextPane startingTimeText;


    public NewShowing(String title) throws Exception {
        initComponents();

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setTitle(title);
        setResizable(true);
        setSize(1025, 550);
        createShowingMap();
        fillComboBoxes();
    }

    private void initComponents() {
        jScrollPane1 = new javax.swing.JScrollPane();
        showingsTable = new javax.swing.JTable();
        headingLabel = new javax.swing.JLabel();
        movieNumberLabel = new javax.swing.JLabel();
        cinemaNumberLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        startingTimeLabel = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        addShowButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        movieNumberCombo = new javax.swing.JComboBox<>();
        cinemaNumberCombo = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        dateText = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        startingTimeText = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        priceText = new javax.swing.JTextPane();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1.setViewportView(showingsTable);

        headingLabel.setText("Legg til visninger i systemet");

        movieNumberLabel.setText("FilmNr:");

        cinemaNumberLabel.setText("KinosalNr:");

        dateLabel.setText("Dato(yyyy-MM-dd):");

        startingTimeLabel.setText("Starttid(HH:mm:ss):");

        priceLabel.setText("Pris:");

        addShowButton.setText("Legg til visning");
        addShowButton.addActionListener(this);

        closeButton.setText("Tilbake");
        closeButton.addActionListener(this);

        jLabel1.setText("Fyll inn alle felter:");

        movieNumberCombo.setModel(new DefaultComboBoxModel<>(new String[] { }));
        cinemaNumberCombo.setModel(new DefaultComboBoxModel<>(new Integer[] { }));


        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane2.setViewportView(dateText);

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane3.setViewportView(startingTimeText);

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane4.setViewportView(priceText);

        jLabel2.setText("Alle registrerte visninger");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(354, 354, 354)
                                .addComponent(headingLabel)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jSeparator3)
                                                .addContainerGap())
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(115, 115, 115)
                                                .addComponent(addShowButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(closeButton)
                                                .addGap(324, 324, 324))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jSeparator2)
                                                                        .addComponent(jLabel1))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(dateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(startingTimeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(cinemaNumberLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(movieNumberLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(priceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(16, 16, 16)
                                                                                .addComponent(movieNumberCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(18, 18, 18)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(cinemaNumberCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(jLabel2))
                                                .addGap(22, 22, 22))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(headingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(movieNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(movieNumberCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(22, 22, 22)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(cinemaNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(cinemaNumberCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(startingTimeLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(priceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(28, 28, 28)
                                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(addShowButton)
                                        .addComponent(closeButton))
                                .addGap(26, 26, 26))
        );

        movieNumberLabel.getAccessibleContext().setAccessibleName("");
        pack();

    }// </editor-fold>

    @Override
    public void actionPerformed(ActionEvent e) {
        String choice = e.getActionCommand();
        if (choice.equals("Legg til visning")) {
            try {
                System.out.println(control.getMovieList());
                addShowingArrayList();
                createShowingMap();

                dateText.setText("");
                startingTimeText.setText("");
                priceText.setText("");
            }
            catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        else setVisible(false);
    }

    private void addShowingArrayList() throws Exception {
        ArrayList<Movie> movieList = control.getMovieList();
        ArrayList<Showing> showingsList = control.getShowingsList();
        ArrayList<Showing> showingsNewList = control.getShowingsAddList();

        int showingNumber = findLastShowingNumber()+1;
        int movieNumberInput = 0;
        for(Movie m : movieList) {
            if(m.getMovieName().equals(movieNumberCombo.getSelectedItem())){
                movieNumberInput = m.getMovieNumber();
            }
        }

        Integer cinemaNumber = (Integer) cinemaNumberCombo.getSelectedItem();

        Date date = stringToDateConvert();

        String startingTimeInput = startingTimeText.getText();
        DateFormat format = new SimpleDateFormat("HH:mm:ss");
        Time startingTime = new Time(format.parse(startingTimeInput).getTime());

        String priceInput = priceText.getText();
        double price = Double.parseDouble(priceInput);

        if(cinemaNumber != null) {
            showingsList.add(new Showing(showingNumber, movieNumberInput, cinemaNumber, date, startingTime, price));
            showingsNewList.add(new Showing(showingNumber, movieNumberInput, cinemaNumber, date, startingTime, price));
            System.out.println(showingsList);
            System.out.println("1"+showingsNewList);
        }
    }

    private int findLastShowingNumber(){
        ArrayList<Showing> showingsList = control.getShowingsList();
        int firstShowingNumber = 0;
        for(Showing s:showingsList){
            if(firstShowingNumber<s.getShowingNumber()) {
                firstShowingNumber = s.getShowingNumber();
            }
            else return s.getShowingNumber();
        }
        return firstShowingNumber;
    }

    public Date stringToDateConvert() {
        String date = dateText.getText();
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date date1 = java.sql.Date.valueOf(date);
        String formattedDate = formatter.format(date1);
        return date1;
    }

    public void fillComboBoxes() {
        ArrayList<Movie> movieList = control.getMovieList();
        ArrayList<Cinema> cinemaList = control.getCinemaList();
        int counter = 0;
        System.out.println(movieList);
        movieNumberCombo.removeAllItems();
        for(Movie name : movieList) {

            movieNumberCombo.insertItemAt(name.getMovieName(), counter);
            counter++;
        }
        counter = 0;
        cinemaNumberCombo.removeAllItems();
        for(Cinema number : cinemaList) {

            cinemaNumberCombo.insertItemAt(number.getCinemaNumber(), counter);
            counter++;
        }
    }

    public void createShowingMap() {
        Object[][] table = makeList();
        showingsTable.setModel(new javax.swing.table.DefaultTableModel(table,
                new String [] {
                        "VisningsNr", "FilmNr", "KinosalNr", "Dato", "Starttid", "Pris"
                }
        ));


    }

    private Object[][] makeList() {
        ArrayList<Showing> showingsList = control.getShowingsList();
        Object[][] content = new Object[showingsList.size()][6];


        int counter = 0;
        try {
            for (Showing m : showingsList) {
                int showingNumber = m.getShowingNumber();
                int movieNumber = m.getMovieNumber();
                int cinemaNumber = m.getCinemaNumber();
                Date date = m.getDate();
                Time startingTime = m.getStartingTime();
                double price = m.getPrice();
                content[counter][0] = showingNumber;
                content[counter][1] = movieNumber;
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


    public void setAddShowButton(JButton addShowButton) {
        this.addShowButton = addShowButton;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public void setShowingsTable(JTable showingsTable) {
        this.showingsTable = showingsTable;
    }
}