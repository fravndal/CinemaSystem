package no.kino.gui.adminContent;

import no.kino.control.Control;
import no.kino.domain.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Statistics extends JDialog implements ActionListener {
    Control control = Control.getInstance();
    private javax.swing.JButton btnAverageSale;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnTicketOrder;
    public static javax.swing.JComboBox<Integer> chooseCinemaComboBox;
    public static javax.swing.JComboBox<String> chooseMovieComboBox;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparatorHeader;
    private javax.swing.JLabel lblCinema;
    private javax.swing.JLabel lblCinemaPlace;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblMovie;
    private javax.swing.JLabel lblStatistics;
    private javax.swing.JTable tableStatistics;


    public Statistics(String title) {
        initComponents();
        fillComboBoxes();

       /* setTitle(title);
        setLayout(new GridLayout(2, 1));
        JPanel adminPanel = new JPanel();
        add(adminPanel);
        adminPanel.setLayout(new GridLayout(3, 2));
        JPanel buttonPanel = new JPanel();
        add(buttonPanel);
        JButton closeButton = new JButton("Lukk");
        closeButton.addActionListener(this);
        buttonPanel.add(closeButton);
        setLocation(300, 300);
       */
        pack();
    }

    private void initComponents() {

        btnAverageSale = new javax.swing.JButton();
        btnTicketOrder = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableStatistics = new javax.swing.JTable();
        jSeparatorHeader = new javax.swing.JSeparator();
        lblHeader = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblStatistics = new javax.swing.JLabel();
        lblMovie = new javax.swing.JLabel();
        lblCinema = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        lblCinemaPlace = new javax.swing.JLabel();
        chooseMovieComboBox = new javax.swing.JComboBox<>();
        chooseCinemaComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

        btnTicketOrder.setText("Statistikk film");
        btnTicketOrder.addActionListener(this);

        btnAverageSale.setText("Statistikk kinosal");
        btnAverageSale.addActionListener(this);

        btnBack.setText("Tilbake");
        btnBack.addActionListener(this);



        jScrollPane1.setViewportView(tableStatistics);

        lblHeader.setText("Statistiske oversikter");

        lblStatistics.setText("Statistikk for billett og salg");

        lblMovie.setText("Velg film:");

        lblCinema.setText("Statistikk for kinosal ");

        lblCinemaPlace.setText("Velg kinosal:");

        chooseMovieComboBox.setModel(new DefaultComboBoxModel<>(new String[] {  }));

        chooseCinemaComboBox.setModel(new DefaultComboBoxModel<>(new Integer[] {  }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparatorHeader)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap(1132, Short.MAX_VALUE)
                                                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(23, 23, 23)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(btnTicketOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(lblCinemaPlace)
                                                                        .addGap(18, 18, 18)
                                                                        .addComponent(chooseCinemaComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                .addComponent(btnAverageSale, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jSeparator2)
                                                                .addComponent(lblCinema, javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                        .addComponent(lblMovie)
                                                                        .addGap(36, 36, 36)
                                                                        .addComponent(chooseMovieComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(lblStatistics))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 923, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addGap(345, 345, 345)
                                .addComponent(lblHeader)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(lblHeader)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparatorHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblStatistics)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(8, 8, 8)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(lblMovie)
                                                        .addComponent(chooseMovieComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnTicketOrder)
                                                .addGap(27, 27, 27)
                                                .addComponent(lblCinema)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(11, 11, 11)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lblCinemaPlace)
                                                        .addComponent(chooseCinemaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnAverageSale)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(btnBack)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String choice = e.getActionCommand();

        if (choice.equals("Statistikk film")) {
            try {
                control.statisticMovie();
                createMovieTable();

            } catch (Exception e1) {
                e1.printStackTrace();
            }

        }
        else if(choice.equals("Statistikk kinosal")) {
            try {
                control.statisticCinema();
                createCinemaTable();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        else{
            setVisible(false);
        }

    }

    public void createMovieTable() {
        Object[][] table = makeStatisticList();
        tableStatistics.setModel(new DefaultTableModel(table,
                new String [] {
                        "Filmnavn", "Visningnr", "Antall bestillinger", "Antall betalte", "Prosent antall bestilt", "Prosent antall betalt"
                }
        ));


    }

    private Object[][] makeStatisticList() {
        ArrayList<Statistic> statisticListMovie = control.getMovieStatisticList();
        Object[][] content = new Object[statisticListMovie.size()][6];
        int counter = 0;
        try {
            for (Statistic s : statisticListMovie) {
                String movieName = s.getmovie();
                int showingNumber = s.getshowingNumber();
                String order = s.getCount();
                String paid = s.getCountPaid();
                String percent = s.getPercent();
                float percent1 = Integer.parseInt(percent);
                int count1 = Integer.parseInt(order);
                int countPaid1 = Integer.parseInt(paid);
                float percentCount = count1/percent1;
                float percentPaid = countPaid1/percent1;
                float percentCount1 = percentCount*100;
                float percentPaid1 = percentPaid*100;
                content[counter][0] = movieName;
                content[counter][1] = showingNumber;
                content[counter][2] = order;
                content[counter][3] = paid;
                content[counter][4] = percentCount1;
                content[counter][5] = percentPaid1;
                counter++;
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Klarte ikke opprette tabell");
        }
        return content;
    }

    public void createCinemaTable() {
        Object[][] table = makeStatisticCinemaList();
        tableStatistics.setModel(new DefaultTableModel(table,
                new String [] {
                        "Kinosal", "Prosent",
                }
        ));


    }

    private Object[][] makeStatisticCinemaList() {
        ArrayList<Statistic> statisticList = control.getCinemaStatisticList();
        Object[][] content = new Object[statisticList.size()][2];
        int counter = 0;
        try {
            for (Statistic s : statisticList) {
                int cinemaNumber = s.getCinemaNr();
                String percent = s.getPercent();
                float percent1 = Float.parseFloat(percent);
                float percent2 = percent1*100;
                content[counter][0] = cinemaNumber;
                content[counter][1] = percent2;
                counter++;
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return content;
    }
    //Går igjennom listen statisticCinema, tar vare på verdiene, skriver ut kinosalnummer og prosent av plassene som ble solgt.
    public Statistic statisticCinema() throws Exception {
        control.statisticCinema();
        ArrayList<Statistic> cinemaStatisticList = control.getCinemaStatisticList();
        for(Statistic key : cinemaStatisticList) {
            String percentString = key.getPercent();
            if(key.getPercent() != null) {
                float percent = Float.parseFloat(percentString);
                int cinemaNr = key.getCinemaNr();
                float percent1 = percent * 100;
                JOptionPane.showMessageDialog(null, "Kinosalnummer: " + cinemaNr + "\n" + "Prosent av plassene solgt: " + percent1 + "%");
            } else {
                int percent = 0;
                int cinemaNr = key.getCinemaNr();
                JOptionPane.showMessageDialog(null, "Kinosalnummer: " + cinemaNr + "\n" + "Prosent av plassene solgt: " + percent + "%");
            }
        } return null;
    }

    //Går igjennom listen over movieSatistic, tar vare på verdiene, deler bestillinger og betalte bestillinger med
    // antall plasser i kinosalen, for så å skrive ut.
    public Statistic statisticMovie() throws Exception {
        control.statisticMovie();
        ArrayList<Statistic> movieStatisticList = control.getMovieStatisticList();
        for(Statistic key : movieStatisticList) {
            String movie = key.getmovie();
            int showingNumber = key.getshowingNumber();
            String count = key.getCount();
            String percent = key.getPercent();
            String countPaid = key.getCountPaid();
            float percent1 = Integer.parseInt(percent);
            int count1 = Integer.parseInt(count);
            int countPaid1 = Integer.parseInt(countPaid);
            float percentCount = count1/percent1;
            float percentPaid = countPaid1/percent1;
            float percentCount1 = percentCount*100;
            float percentPaid1 = percentPaid*100;


        } return null;
    }

    public void fillComboBoxes() {
        ArrayList<Movie> movieList = control.getMovieList();
        ArrayList<Cinema> cinemaList = control.getCinemaList();
        int counter = 0;

        for(Movie name : movieList) {
            chooseMovieComboBox.insertItemAt(name.getMovieName(), counter);
            counter++;
        }

        counter = 0;
        for(Cinema number : cinemaList) {

            chooseCinemaComboBox.insertItemAt(number.getCinemaNumber(), counter);
            counter++;
        }
    }



    public JComboBox<Integer> getChooseCinemaComboBox() {
        return chooseCinemaComboBox;
    }

    public void setChooseCinemaComboBox(JComboBox<Integer> chooseCinemaComboBox) {
        this.chooseCinemaComboBox = chooseCinemaComboBox;
    }

    public JComboBox<String> getChooseMovieComboBox() {
        return chooseMovieComboBox;
    }

    public void setChooseMovieComboBox(JComboBox<String> chooseMovieComboBox) {
        this.chooseMovieComboBox = chooseMovieComboBox;
    }
}