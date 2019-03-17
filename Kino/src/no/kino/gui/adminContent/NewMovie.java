package no.kino.gui.adminContent;

import no.kino.control.Control;
import no.kino.domain.Movie;
import no.kino.domain.Showing;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class NewMovie extends JDialog implements ActionListener {
    Control control = Control.getInstance();
    private javax.swing.JButton addMovieButton;
    private javax.swing.JButton closeButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField movieNameText;
    private javax.swing.JTable movieTable;

    public NewMovie(String title) throws Exception {
        createView();


        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(title);
        setLocationRelativeTo(null);
        setResizable(true);
        createMovieMap();
    }

    private void createView() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        movieTable = new javax.swing.JTable();
        movieNameText = new javax.swing.JTextField();
        addMovieButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

        jLabel1.setText("Legg til en ny film i systemet");


        jScrollPane1.setViewportView(movieTable);

        addMovieButton.setText("Legg til film");

        addMovieButton.addActionListener(this);

        closeButton.setText("Tilbake");

        closeButton.addActionListener(this);

        jLabel2.setText("Navn på film:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator1)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(133, 133, 133)
                                                .addComponent(jLabel1)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap(33, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(addMovieButton)
                                                                        .addComponent(movieNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(67, 67, 67)
                                                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 363, Short.MAX_VALUE)
                                                                                .addComponent(closeButton)
                                                                                .addGap(14, 14, 14)))))))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(35, 35, 35)
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(movieNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(addMovieButton)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                .addComponent(closeButton)
                                .addGap(19, 19, 19))
        );

        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String choice = e.getActionCommand();
        if (choice.equals("Legg til film")) {
            try {
                addMovieArrayList();
                createMovieMap();
                movieNameText.setText("");
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        else setVisible(false);
    }

    public void addMovieArrayList() throws Exception {
        ArrayList<Movie> movieList = control.getMovieList();
        ArrayList<Movie> movieAddList = control.getMovieAddList();

        Movie movie = new Movie(findLastMovieNumber()+1, movieNameText.getText());
        movieList.add(movie);
        movieAddList.add(movie);
        System.out.println(control.getMovieList());

    }

    private int findLastMovieNumber(){
        ArrayList<Movie> movieList = control.getMovieList();
        int firstMovie = 0;
        for(Movie m:movieList){
            if(firstMovie<m.getMovieNumber()) {
                firstMovie = m.getMovieNumber();
            }
            else return m.getMovieNumber();
        }
        return firstMovie;
    }

    public void createMovieMap() {
        Object[][] table = makeList();
        movieTable.setModel(new javax.swing.table.DefaultTableModel(table,
                new String [] {
                        "Filmnr", "Filmnavn"
                }
        ));

    }

    public Object[][] makeList() {
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

    }
