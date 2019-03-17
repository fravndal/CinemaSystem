package no.kino.gui.adminContent;

import no.kino.control.Control;
import no.kino.domain.Movie;
import no.kino.domain.Showing;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;



public class ChangeMovie extends JDialog implements ActionListener {
    Control control = Control.getInstance();
    private javax.swing.JButton changeMovieButton;
    private javax.swing.JButton closeButton;
    private javax.swing.JButton deleteMovieButton;
    private javax.swing.JLabel headingEastLabel;
    private javax.swing.JLabel headingLabel;
    private javax.swing.JLabel headingWest1Label;
    private javax.swing.JLabel headingWest2Label;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel movieNameLabel;
    private javax.swing.JTextField movieNameText;
    private javax.swing.JComboBox<Integer> movieNumberComboBox;
    private javax.swing.JLabel movieNumberLabel;
    private javax.swing.JTable movieTable;

    public ChangeMovie(String title) {
        setTitle(title);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setResizable(true);
        initComponents();
        fillComboBox();
        createMovieTable();
    }



    private void initComponents() {

        headingLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        movieNumberLabel = new javax.swing.JLabel();
        movieNumberComboBox = new javax.swing.JComboBox<>();
        movieNameLabel = new javax.swing.JLabel();
        movieNameText = new javax.swing.JTextField();
        headingWest1Label = new javax.swing.JLabel();
        headingEastLabel = new javax.swing.JLabel();
        headingWest2Label = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        changeMovieButton = new javax.swing.JButton();
        deleteMovieButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        movieTable = new javax.swing.JTable();

        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

        headingLabel.setText("Endre/slett en film");

        movieNumberLabel.setText("Filmnr:");

        movieNumberComboBox.setModel(new DefaultComboBoxModel<>(fillComboBox()));

        movieNameLabel.setText("Filmnavn:");

        headingWest1Label.setText("Velg en film som skal endres eller slettes");

        headingEastLabel.setText("Filmer som ikke har blitt vist");

        headingWest2Label.setText("For sletting, velg filmnr og klikk slett.");

        changeMovieButton.setText("Endre film");
        changeMovieButton.addActionListener(this);

        deleteMovieButton.setText("Slett film");
        deleteMovieButton.addActionListener(this);

        closeButton.setText("Tilbake");
        closeButton.addActionListener(this);


        movieTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                movieTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(movieTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator1)
                        .addComponent(jSeparator2)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(29, 29, 29)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(headingWest1Label)
                                                                        .addComponent(headingWest2Label)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(movieNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(movieNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGap(34, 34, 34)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                        .addComponent(movieNameText)
                                                                                        .addComponent(movieNumberComboBox, 0, 103, Short.MAX_VALUE))))
                                                                .addGap(86, 86, 86)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(headingEastLabel)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(262, 262, 262)
                                                                .addComponent(headingLabel)))
                                                .addGap(0, 39, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(44, 44, 44)
                                                .addComponent(changeMovieButton)
                                                .addGap(45, 45, 45)
                                                .addComponent(deleteMovieButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(closeButton)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(headingLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(headingWest1Label)
                                        .addComponent(headingEastLabel))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(headingWest2Label)
                                                .addGap(42, 42, 42)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(movieNumberLabel)
                                                        .addComponent(movieNumberComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(movieNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(movieNameLabel)))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(changeMovieButton)
                                        .addComponent(deleteMovieButton)
                                        .addComponent(closeButton))
                                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }

    private void movieTableMouseClicked(MouseEvent evt) {
        int index = movieTable.getSelectedRow();
        TableModel model = movieTable.getModel();
        int value1 = Integer.parseInt(model.getValueAt(index, 0).toString());
        movieNumberComboBox.setSelectedItem(value1);
    }

    public void actionPerformed(ActionEvent e) {
        String choice = e.getActionCommand();
        if (choice.equals("Endre film")) {
            changeMovie();
            createMovieTable();
        }
        else if(choice.equals("Slett film")) {
            deleteMovie();
            fillComboBox();
            movieNumberComboBox.setModel(new DefaultComboBoxModel<>(fillComboBox()));
            createMovieTable();
        }
        else {
            setVisible(false);
        }

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
        ArrayList<Movie> movieList = createMovieListWithoutShowings();
        Object[][] content = new Object[movieList.size()][2];

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

    private ArrayList<Movie> createMovieListWithoutShowings() {
        ArrayList<Movie> movieListWithoutShowings = new ArrayList<>();

        ArrayList<Movie> movieList = control.getMovieList();
        ArrayList<Showing> showingsList = control.getShowingsList();
        int counter = 0;
        boolean isFound = false;
        for (Movie m : movieList) {
            for (Showing s : showingsList) {
                if (m.getMovieNumber() == s.getMovieNumber()) {
                    isFound = true;
                }
            }
            if(!isFound) {
                movieListWithoutShowings.add(counter, m);
                counter++;
            }
            isFound = false;

        }
        System.out.println(movieListWithoutShowings);
        return movieListWithoutShowings;
    }

    public Integer[] fillComboBox() {
        ArrayList<Movie> movieList = createMovieListWithoutShowings();
        Integer[] movieNumberArray = new Integer[movieList.size()];
        int counter = 0;
        for(Movie m : movieList) {
            movieNumberArray[counter] = m.getMovieNumber();
            counter++;
        }
        return movieNumberArray;
    }

    private void changeMovie() {
        ArrayList<Movie> movieList = control.getMovieChangeList();

        Integer movieNumber = (Integer) movieNumberComboBox.getSelectedItem();
        String movieName = movieNameText.getText();

        for (Movie m : movieList) {
            if (movieNumber == m.getMovieNumber()) {
                Movie movie = new Movie(movieNumber, movieName);
                movieList.set(findIndexInMovieListWithoutShowings(movieNumber), movie);
            }
        }

        if (movieNumber != null) {

        }
    }

    private void deleteMovie() {
        ArrayList<Movie> movieList = control.getMovieList();
        ArrayList<Movie> movieDeleteList = control.getMovieDeleteList();
        ArrayList<Movie> movieListWithoutShowings = createMovieListWithoutShowings();
        Integer movieNumber = (Integer) movieNumberComboBox.getSelectedItem();
        for(Movie s:movieListWithoutShowings) {
            if(movieNumber != null) {
                if(movieNumber == s.getMovieNumber()) {
                    movieDeleteList.add(s);
                    movieList.remove(findIndexInMovieList(s.getMovieNumber()));
                    System.out.println(movieDeleteList);
                }
            }
        }
    }

    private int findIndexInMovieList(int movieNumber) {
        ArrayList<Movie> movieList = control.getMovieList();
        int counter = 0;
        for(Movie m: movieList) {
            if(m.getMovieNumber() == movieNumber) {
                return counter;
            }
            counter++;
        }
        return -1;
    }

    private int findIndexInMovieListWithoutShowings(int movieNumber) {
        ArrayList<Movie> movieListWithoutShowings = createMovieListWithoutShowings();
        int counter = 0;
        for(Movie m: movieListWithoutShowings) {
            if(m.getMovieNumber() == movieNumber) {
                return counter;
            }
            counter++;
        }
        return 0;
    }

    public JComboBox<Integer> getMovieNumberComboBox() {
        return movieNumberComboBox;
    }

    public void setMovieNumberComboBox(JComboBox<Integer> movieNumberComboBox) {
        this.movieNumberComboBox = movieNumberComboBox;
    }
}
