package no.kino.gui;
// 148258 og bla bla og bla bla har laget denne klassen
import no.kino.control.Control;
import no.kino.domain.*;
import no.kino.gui.customerContent.CustomerOrder;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.*;

public class Customer extends JDialog implements ActionListener {
    Control control = Control.getInstance();
    private JTable showingsTable;
    private final String[] colNames = {"Visningsnummer", "Filmnavn", "Kinosalnr", "Dato", "Starttid", "Pris", "Ledige seter"};
    private javax.swing.JCheckBox seat;

    public Customer(String title) throws Exception {
        setTitle(title);
        setLayout(new GridLayout(1, 1));
        JPanel adminPanel = new JPanel();
        add(adminPanel);
        adminPanel.setLayout(new GridLayout(1, 2));
        JPanel buttonPanel = new JPanel();
        add(buttonPanel);

        JButton executeButton = new JButton("Velg visning");
        executeButton.addActionListener(this);
        buttonPanel.add(executeButton);

        JButton sortTimeButton = new JButton("Sorter tid");
        sortTimeButton.addActionListener(this);
        buttonPanel.add(sortTimeButton);

        JButton sortMovieNameButton = new JButton("Sorter etter filmnavn");
        sortMovieNameButton.addActionListener(this);
        buttonPanel.add(sortMovieNameButton);

        JButton searchTicketButton = new JButton("Søk etter billett");
        searchTicketButton.addActionListener(this);
        buttonPanel.add(searchTicketButton);

        JButton closeButton = new JButton("Lukk");
        closeButton.addActionListener(this);
        buttonPanel.add(closeButton);

        Object[][] defaultTable = new Object[2][6];
        DefaultTableModel tableContent = new DefaultTableModel(defaultTable, colNames);
        showingsTable = new JTable(tableContent);
        adminPanel.add(showingsTable);
        JScrollPane scrollPane = new JScrollPane(showingsTable);
        adminPanel.add(scrollPane);
        createShowingsTable();

        setLocation(300, 300);
        pack();
    }

    // metode for å returnere brukers valgte visningnummer
    public int selectedRow() throws Exception {
        Integer test = (Integer) showingsTable.getValueAt(showingsTable.getSelectedRow(), 0);
        return test;
    }

    // metode for å lage visningstabellen, igangsetter metoden som fyller objektet content
    public void createShowingsTable() {
        Object[][] table = fillTable();
        showingsTable.setModel(new DefaultTableModel(table, colNames));
    }

    // sortering av listen etter tid
    public int compare(Showing s1, Showing s2) {
        Time firstTime = s1.getStartingTime();
        Time secondTime = s2.getStartingTime();
        return firstTime.compareTo(secondTime);
    }

    public ArrayList<Showing> sortListByTime() {
        ArrayList<Showing> showingList = control.getShowingsList();
        Collections.sort(showingList, this::compare);
        System.out.println(showingList);

        showingsTable.setModel(new DefaultTableModel(fillTable(), colNames));
        return showingList;
    }
    // sortering etter tid slutt

    // sortering etter filmnavn
    public int compareTo(Sort s1, Sort s2) {
        String firstMovieName = s1.getMovieName();
        String secondMovieName = s2.getMovieName();
        return firstMovieName.compareTo(secondMovieName);
    }

    // initierer sorteringen
    public ArrayList<Sort> sortInit() {
        ArrayList<Sort> sortList = control.getSortList();
        fillTable();
        Collections.sort(sortList, this::compareTo);
        System.out.println(sortList);
        showingsTable.setModel(new DefaultTableModel(fillSort(), colNames));
        return sortList;
    }

    // fyller inn JTable med listen sortert etter filmnavn
    public Object[][] fillSort() {
        Object[][] content = new Object[control.getSortList().size()][7];
        ArrayList<Sort> sortList = control.getSortList();

        int counter = 0;
        try {
            for (Sort s : sortList) {
                if (validMovieShowings(s.getDate(), s.getStartingTime())) {
                    int showingNumber = s.getShowingNumber();
                    String movieName = s.getMovieName();
                    int cinemaRoomNumber = s.getCinemaNumber();
                    Date date = s.getDate();
                    Time startTime = s.getStartingTime();
                    double price = s.getPrice();

                    content[counter][0] = showingNumber;
                    content[counter][1] = movieName;
                    content[counter][2] = cinemaRoomNumber;
                    content[counter][3] = date;
                    content[counter][4] = startTime;
                    content[counter][5] = price;
                    content[counter][6] = findTheaterSize(s.getCinemaNumber()) - findTakenSeats(s.getShowingNumber());
                    counter++;
                }
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Klarte ikke opprette tabell for visninger");
        }
        return content;
    }
    // sortering etter filmnavn slutt

    // forsvinner ikke fra listen når man unchecker JCheckbox
    // objektet som vises i visningstabellen fylles --usortert
    public Object[][] fillTable() {
        Object[][] content = new Object[control.getShowingsList().size()][7];
        ArrayList<Showing> showingList = control.getShowingsList();
        ArrayList<Movie> movieList = control.getMovieList();

        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");

        Date dateTest = new Date();
        int counter = 0;

        try {
            for (Showing s : showingList) {
                if (validMovieShowings(s.getDate(), s.getStartingTime())){
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
                    content[counter][6] = findTheaterSize(s.getCinemaNumber()) - findTakenSeats(s.getShowingNumber());
                    counter++;
                }
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Klarte ikke opprette tabell for visninger");
        }
        return content;
    }

    // test på om visningen fyller kravene om 30 min
    public boolean validMovieShowings(Date date, Time startingTime) {
        Calendar playtime = Calendar.getInstance();
        playtime.setTime(date);
        playtime.set(Calendar.HOUR, startingTime.getHours());
        playtime.set(Calendar.MINUTE, startingTime.getMinutes());
        Calendar currentTime = Calendar.getInstance();
        currentTime.add(Calendar.MINUTE, 30);

        return playtime.getTime().after(currentTime.getTime());
    }

    // finner antall seter per kinosal
    public int findTheaterSize(int movieTheaterIn) {
        ArrayList<Seat> seatsList = control.getSeatList();
        int theaterSize = 0;
        for (Seat s : seatsList) {
            if (s.getMovieTheaterNr() == movieTheaterIn) {
                theaterSize++;
            }
        }
        return theaterSize;
    }

    // finner setene som er opptatt på en kinosal
    public int findTakenSeats(int showingNumberIn) {
        ArrayList<TakenSeat> takenSeats = control.getTakenSeatsList();
        int takenSeatsInt = 0;
        for (TakenSeat s : takenSeats) {
            if (s.getShowingNumber() == showingNumberIn) {
                takenSeatsInt++;
            }
        }
        return takenSeatsInt;
    }

    //Søker etter bestilling fra arraylist og skriver ut informasjon for bestillingen hvis den blir funnet.
    public Ticket findTicket() {
        ArrayList<Ticket> ticketList = control.getTicketList();
        String ticketSearch = JOptionPane.showInputDialog("Billettkode: ");
        boolean isFound = false;
        for (Ticket key : ticketList) {
            String ticketNumber = key.getTicketNumber();
            int showNumber = key.getShowingNumber();
            int isPaid = key.getIsPaid();
            if(ticketSearch.equals(ticketNumber)) {
                if(isPaid != 0) {
                    isFound = true;
                    JOptionPane.showMessageDialog(null, "Billettkode: " + ticketNumber + "\nVisningsnummer: "
                            + showNumber + "\nBilletten er betalt");
                } else {
                    isFound = true;
                    JOptionPane.showMessageDialog(null, "Billettkode: " + ticketNumber + "\nVisningsnummer: "
                            + showNumber + "\nBilletten er ikke betalt");
                }
            }
        }
        if (!isFound) {
            JOptionPane.showMessageDialog(null, "Billetten ble ikke funnet.");
        }
        return null;
    }

    public ArrayList<OrderConfirmation> takenSeatsList() {
        ArrayList<OrderConfirmation> takenSeats = new ArrayList<>();

        return null;
    }


    // håndterer valg av knapper
    @Override
    public void actionPerformed(ActionEvent e) {
        String choice = e.getActionCommand();
        try {
            if (choice.equals("Velg visning")) {
                CustomerOrder customerOrder = new CustomerOrder("Velg plasser", selectedRow());
                customerOrder.setVisible(true);
            } else if (choice.equals("Lukk")) {
                System.exit(0);
            } else if (choice.equals("Sorter tid")) {
                sortListByTime();

            } else if (choice.equals("Sorter etter filmnavn")) {
                sortInit();
            }
            else if (choice.equals("Søk etter billett")) {
                findTicket();
            }
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}