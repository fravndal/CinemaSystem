package no.kino.control;

import no.kino.domain.*;
import no.kino.gui.adminContent.Statistics;
import no.kino.gui.staffContent.DeleteUnpaidOrder;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class Control {
    private static final Control instance = new Control();
    private ArrayList<Movie> movieList = new ArrayList<>();
    private ArrayList<Movie> movieAddList = new ArrayList<>();
    private ArrayList<Movie> movieChangeList = new ArrayList<>();
    private ArrayList<Movie> movieDeleteList = new ArrayList<>();

    private ArrayList<Showing> showingsList = new ArrayList<>();
    private ArrayList<Showing> showingsAddList = new ArrayList<>();
    private ArrayList<Showing> showingsChangeList = new ArrayList<>();
    private ArrayList<Showing> showingsDeleteList = new ArrayList<>();

    private ArrayList<Ticket> ticketList = new ArrayList<>();
    private ArrayList<Ticket> newTicketsList = new ArrayList<>();

    private ArrayList<Ticket> delTicket = new ArrayList<>();

    private ArrayList<SeatTicket> seatTicketList = new ArrayList<>();
    private ArrayList<SeatTicket> newSeatTicketList = new ArrayList<>();

    private ArrayList<SeatTicket> delSeatTicket = new ArrayList<>();

    private ArrayList<Cinema> cinemaList = new ArrayList<>();

    private ArrayList<Seat> seatList = new ArrayList<>();

    ArrayList<TakenSeat> takenSeatsList = new ArrayList<>();

    private ArrayList<Sort> sortList = new ArrayList<>();

    private ArrayList<OrderConfirmation> customerOrderConfirmation = new ArrayList<>();

    ArrayList<Statistic> cinemaStatisticList = new ArrayList<>();
    ArrayList<Statistic> movieStatisticList = new ArrayList<>();




    private String databasename = "jdbc:mysql://localhost:3306/kino?useSSL=false";
    private static Connection connection;
    private ResultSet result;
    private Statement statement;

    private Control() {
        try {
            makeConnection();
            fillSortList();
            fillMovie();
            fillShowing();
            fillTicket();
            fillSeat();
            fillTicketSeat();
            fillCinema();
            findTakenSeats();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static Control getInstance() {
        return instance;
    }



    public void makeConnection() throws Exception {
        try{
            connection = DriverManager.getConnection(databasename, "Case", "Esac");
            System.out.println("kontakt med databasen!");
        } catch(Exception e) {
            throw new Exception("Kan ikke oppnå kontakt med databasen");
        }
    }

    private void closeConnection() throws Exception {
        try {
            if(connection != null) {
                connection.close();
                result.close();
                statement.close();
            }
        }catch(Exception e) {
            throw new Exception("Kan ikke lukke databaseforbindelse");
        }
    }

    public static boolean checkLoginAdmin(String username, String password) throws Exception {
        String sqlStatement = "SELECT * FROM tbllogin;";
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sqlStatement);
        while(result.next()) {
            String correctUsernameAdmin = result.getString("l_brukernavn");
            String correctPassordAdmin = result.getString("l_pinkode");
            int isAdmin = result.getInt("l_erPlanlegger");
            if(username.equals(correctUsernameAdmin) && password.equals(correctPassordAdmin) && isAdmin == 1) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkLoginStaff(String username, String password) throws SQLException {
        String sqlStatement = "SELECT * FROM tbllogin;";
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sqlStatement);
        while(result.next()) {
            String correctUsernameStaff = result.getString("l_brukernavn");
            String correctPassordStaff = result.getString("l_pinkode");
            int isAdmin = result.getInt("l_erPlanlegger");
            if(username.equals(correctUsernameStaff) && password.equals(correctPassordStaff) && isAdmin == 0) {
                return true;
            }
        }
        return false;
    }


    public void fillMovie() throws Exception {
        String sqlStatement = "SELECT * FROM tblfilm;";
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sqlStatement);
        while(result.next()) {
            int movieNumber = result.getInt("f_filmnr");
            String movieName = result.getString("f_filmnavn");

            movieList.add(new Movie(movieNumber, movieName));
        }
    }

    public void fillShowing() throws Exception {
        String sqlStatement = "SELECT * FROM tblvisning;";
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sqlStatement);
        while(result.next()) {
            int showingNumber = result.getInt("v_visningnr");
            int movieNumber = result.getInt("v_filmnr");
            int cinemaNumber = result.getInt("v_kinosalnr");
            Date date = result.getDate("v_dato");
            Time startingTime = result.getTime("v_starttid");
            double price = result.getDouble("v_pris");

            showingsList.add(new Showing(showingNumber, movieNumber, cinemaNumber, date, startingTime, price));
        }
    }

    public void fillTicket() throws Exception {
        String sqlStatement = "SELECT * FROM tblbillett;";
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sqlStatement);
        while(result.next()) {
            String ticketCode = result.getString("b_billettkode");
            int showingNumber = result.getInt("b_visningsnr");
            int isPaid = result.getInt("b_erBetalt");

            ticketList.add(new Ticket(ticketCode, showingNumber, isPaid));
        }
    }

    public void fillSeat() throws Exception {
        String sqlStatement = "SELECT * FROM tblplass;";
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sqlStatement);
        while(result.next()) {
            int rowNumber = result.getInt("p_radnr");
            int seatNumber = result.getInt("p_setenr");
            int cinemaNumber = result.getInt("p_kinosalnr");

            seatList.add(new Seat(rowNumber, seatNumber, cinemaNumber));
        }
    }

    public void fillTicketSeat() throws Exception {
        String sqlStatement = "SELECT * FROM tblplassbillett;";
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sqlStatement);
        while(result.next()) {
            int rowNumber = result.getInt("pb_radnr");
            int seatNumber = result.getInt("pb_setenr");
            int cinemaNumber = result.getInt("pb_kinosalnr");
            String ticketCode = result.getString("pb_billettkode");

            seatTicketList.add(new SeatTicket(rowNumber, seatNumber, cinemaNumber, ticketCode));
        }
    }

    public void fillCinema() throws Exception {
        String sqlStatement = "SELECT * FROM tblkinosal;";
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sqlStatement);
        while(result.next()) {
            int cinemaNumber = result.getInt("k_kinosalnr");
            String cinemaName = result.getString("k_kinonavn");
            String cinemaRoomName = result.getString("k_kinosalnavn");

            cinemaList.add(new Cinema(cinemaNumber, cinemaName, cinemaRoomName));
        }
    }

    public void fillSortList() throws Exception {
        String sqlStatement = "SELECT v_visningnr, f_filmnavn, v_kinosalnr, v_dato, v_starttid, v_pris\n" +
                "FROM tblvisning, tblfilm WHERE v_filmnr = f_filmnr;";
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sqlStatement);
        while(result.next()) {
            int showingNumber = result.getInt("v_visningnr");
            String movieName = result.getString("f_filmnavn");
            int cinemaNumber = result.getInt("v_kinosalnr");
            Date date = result.getDate("v_dato");
            Time time = result.getTime("v_starttid");
            double price = result.getDouble("v_pris");

            sortList.add(new Sort(showingNumber, movieName, cinemaNumber, date, time, price));
        }
    }

    //Finner kinosalnummer ut fra input, teller hvor mange billetter ble solgt for den salen og deler det på hvor mange seter
    //det er i kinosalen hvis visningsdatoen er senest fra igår.
    public void statisticCinema() throws Exception {
        Integer cinemaNr = (Integer) Statistics.chooseCinemaComboBox.getSelectedItem();

        String sqlStatement = "SELECT (SELECT COUNT(pb_kinosalnr) FROM tblplassbillett where pb_kinosalnr="+cinemaNr+")\n" +
                "                / (SELECT count(p_setenr) from tblplass\n" +
                "                left join tblvisning on p_kinosalnr=v_kinosalnr \n" +
                "                where p_kinosalnr="+cinemaNr+"\n" +
                "                and v_dato < curdate()" +
                "                or p_kinosalnr="+cinemaNr+"" +
                "                and v_dato = curdate()" +
                "                and v_starttid >= now())  AS Prosent;";
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sqlStatement);

        while(result.next()) {

            String percent = result.getString("Prosent");
            cinemaStatisticList.add(new Statistic(cinemaNr, null, 0, null,  percent, null));


        }
    }

    //Finner film ut fra input, og hvilken kinosal visningen vises, for så å telle bestillinger, betalte bestillinger
    //og til slutt hvor mange plasser det er i kinosalen.
    public void statisticMovie() throws Exception {
        String movieName = (String) Statistics.chooseMovieComboBox.getSelectedItem();
        String sqlStatement = "select f_filmnavn, v_visningnr, v_kinosalnr from tblfilm, tblvisning\n" +
                "where f_filmnavn= '"+movieName+"' \n" +
                "and f_filmnr = v_filmnr;";
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sqlStatement);
        while(result.next()) {
            String movieName1 = result.getString("f_filmnavn");
            int cinemaNr = result.getInt("v_kinosalnr");
            int showingNumber = result.getInt("v_visningnr");
            String sqlStatement1 = "select count(b_visningsnr) as Antall from tblbillett\n" +
                    "where b_visningsnr="+showingNumber+";";
            Statement statement1 = connection.createStatement();
            ResultSet result1 = statement1.executeQuery(sqlStatement1);
            while(result1.next()){
                String count = result1.getString("Antall");

                    String sqlStatement2 = "select count(b_visningsnr) as AntallBetalt from tblbillett\n" +
                            "where b_visningsnr="+showingNumber+" and b_erBetalt=1;";
                    Statement statement2 = connection.createStatement();
                    ResultSet result2 = statement2.executeQuery(sqlStatement2);
                    while(result2.next()) {
                        String countPaid = result2.getString("AntallBetalt");
                        String sqlStatement3 = "select count(p_setenr) as prosent from tblplass\n" +
                                "where p_kinosalnr= "+cinemaNr+";";
                        Statement statement3 = connection.createStatement();
                        ResultSet result3 = statement3.executeQuery(sqlStatement3);
                        while(result3.next()) {
                            String percent = result3.getString("Prosent");
                                movieStatisticList.add(new Statistic(0, movieName1, showingNumber,
                                        count, percent, countPaid));


                        }

                    }



            }


        }
    }

    //Legger alle bestillinger som ikke er betalt 30min før visning i slettinger.dat og arraylister
    public ResultSet findNotPaid() throws Exception {
        DeleteUnpaidOrder Writer = new DeleteUnpaidOrder();
        ArrayList<Ticket> deletedTickets = new ArrayList<>();

        try {
            String sqlFind = "select b_billettkode, b_visningsnr, b_erBetalt from tblvisning\n" +
                    "LEFT join tblbillett on b_visningsnr=v_visningnr where b_erBetalt=0 and \n" +
                    "v_starttid < date_sub(now(), interval -31 minute) and v_dato <= curdate()\n" +
                    "or b_erBetalt=0 and v_dato < curdate()\n" +
                    "ORDER BY b_visningsnr" ;
            java.sql.Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sqlFind);
            while(result.next()) {
                String ticketNumber = result.getString("b_billettkode");
                int showNumber = result.getInt("b_visningsnr");
                int isPaid = result.getInt("b_erBetalt");
                Ticket del = new Ticket(ticketNumber, showNumber, isPaid);
                SeatTicket delSeat = new SeatTicket(1, 1, 1, ticketNumber);
                if(!deletedTickets.contains(ticketNumber)) {
                    delTicket.add(del);
                    delSeatTicket.add(delSeat);
                    try {
                        deletedTickets.add(del);
                        Writer.writer(deletedTickets);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }


            }
        } catch(Exception e) {
            throw new Exception(e);
        }
        return result;
    }

    //Sletter alt som ligger i arraylistene for ikke betalte bestiller fra databasen.
    public void delNotPaid() throws Exception {
        for (SeatTicket key1 : delSeatTicket) {
            String ticketNumber1 = key1.getTicketCode();
            String sqlDelete1 = "DELETE FROM kino.tblplassbillett WHERE pb_billettkode = '" + ticketNumber1 + "';";
            Statement delDB1 = connection.prepareStatement(sqlDelete1);
            delDB1.executeUpdate(sqlDelete1);
            for (Ticket key : delTicket) {
                String ticketNumber =  key.getTicketNumber();
                String sqlDelete = "DELETE FROM kino.tblbillett WHERE b_billettkode = '"+ticketNumber+"';";
                Statement delDB = connection.prepareStatement(sqlDelete);
                delDB.executeUpdate(sqlDelete);
            }
        }
    }

    public void findTakenSeats() {
        int counter = 0;
        for(Showing s: showingsList) {
            for(Ticket t: ticketList) {
                if(s.getShowingNumber()==t.getShowingNumber()) {
                    for(SeatTicket m : seatTicketList) {
                        if(t.getTicketNumber().equals(m.getTicketCode())) {
                            TakenSeat takenSeat = new TakenSeat(t.getShowingNumber(), m.getMovieTheaterNumber(), m.getTicketCode(), m.getRowNr(), m.getSeatNr());
                            takenSeatsList.add(counter, takenSeat);
                            counter++;
                        }
                    }
                }
            }
        }
    }

    public void saveData() throws SQLException {
        addMovieToDatabase();
        changeMovieToDatabase();
        deleteMoviesFromDatabase();
        addShowingsToDatabase();
        changeShowingsToDatabase();
        deleteShowingsFromDatabase();
        addTicketsToDatabase();
        addSeatTicketsToDatabase();


    }

    private void addMovieToDatabase() throws SQLException {
        for (Movie m : movieAddList) {
            String sqlNewRow = "INSERT INTO tblfilm VALUES (0, ?)";
            PreparedStatement pstmt = connection.prepareStatement(sqlNewRow);
            pstmt.setString(1, m.getMovieName());
            pstmt.executeUpdate();
        }
    }

    private void changeMovieToDatabase() throws SQLException {
        System.out.println("2" + movieChangeList);
        for (Movie m : movieChangeList) {
                String sqlChangeRow = "UPDATE kino.tblfilm SET f_filmnr = ?, f_filmnavn = ? WHERE f_filmnr = ?";
                PreparedStatement pstmt = connection.prepareStatement(sqlChangeRow);
                pstmt.setInt(1, m.getMovieNumber());
                pstmt.setString(2, m.getMovieName());
                pstmt.setInt(3, m.getMovieNumber());
                pstmt.executeUpdate();
        }
    }



    private void deleteMoviesFromDatabase() throws SQLException {
        for (Movie m : movieDeleteList) {
            String sqlDeleteRow = "DELETE FROM kino.tblfilm WHERE f_filmnr = ?";
            PreparedStatement pstmt = connection.prepareStatement(sqlDeleteRow);
            pstmt.setInt(1, m.getMovieNumber());
            pstmt.executeUpdate();
        }
    }

    private void addShowingsToDatabase() throws SQLException {
        for (Showing s : showingsAddList) {
            System.out.println(s);
            String sqlNewRow = "INSERT INTO tblvisning " +
                    "VALUES (v_visningnr = ?, v_filmnr = ?, v_kinosalnr = ?, v_dato = ?, v_starttid = ?, v_pris = ?)";
            PreparedStatement pstmt = connection.prepareStatement(sqlNewRow);
            pstmt.setInt(1, s.getShowingNumber());
            pstmt.setInt(2, s.getMovieNumber());
            pstmt.setInt(3, s.getCinemaNumber());
            pstmt.setDate(4, (Date) s.getDate());
            pstmt.setTime(5, s.getStartingTime());
            pstmt.setDouble(6, s.getPrice());
            pstmt.executeUpdate();
        }
    }

    private void changeShowingsToDatabase() throws SQLException {
        for (Showing s : showingsChangeList) {
            String sqlChangeRow = "UPDATE kino.tblvisning " +
                    "SET v_filmnr = ?, v_kinosalnr = ?, v_dato = ?, v_starttid = ?, v_pris = ? " +
                    "WHERE v_visningnr = ?";
            PreparedStatement pstmt = connection.prepareStatement(sqlChangeRow);
            pstmt.setInt(1, s.getMovieNumber());
            pstmt.setInt(2, s.getCinemaNumber());
            pstmt.setDate(3, (Date) s.getDate());
            pstmt.setTime(4, s.getStartingTime());
            pstmt.setDouble(5, s.getPrice());
            pstmt.setInt(6, s.getShowingNumber());
            pstmt.executeUpdate();

        }
    }

    private void deleteShowingsFromDatabase() throws SQLException {
        for (Showing s : showingsDeleteList) {
            String sqlDeleteRow = "DELETE FROM kino.tblvisning WHERE v_visningnr = ?";
            PreparedStatement pstmt = connection.prepareStatement(sqlDeleteRow);
            pstmt.setInt(1, s.getShowingNumber());
            pstmt.executeUpdate();
        }
    }

    public void addTicketsToDatabase() throws SQLException {
        for (Ticket t : newTicketsList) {
            String sqlAddTickets = "INSERT INTO tblbillett VALUES(?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(sqlAddTickets);
            pstmt.setString(1, t.getTicketNumber());
            pstmt.setInt(2, t.getShowingNumber());
            pstmt.setInt(3, t.getIsPaid());
            pstmt.executeUpdate();
        }
    }

    public void addSeatTicketsToDatabase() throws SQLException {
        for (SeatTicket t : newSeatTicketList) {
            String sqlAddSeatTickets = "INSERT INTO tblplassbillett VALUES(?, ?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(sqlAddSeatTickets);
            pstmt.setInt(1, t.getRowNr());
            pstmt.setInt(2, t.getSeatNr());
            pstmt.setInt(3, t.getMovieTheaterNumber());
            pstmt.setString(4, t.getTicketCode());
            pstmt.executeUpdate();
        }
    }



    public ArrayList<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(ArrayList<Movie> movieList) {
        this.movieList = movieList;
    }

    public ArrayList<Movie> getMovieAddList() {
        return movieAddList;
    }

    public void setMovieAddList(ArrayList<Movie> movieAddList) {
        this.movieAddList = movieAddList;
    }

    public ArrayList<Movie> getMovieChangeList() {
        return movieChangeList;
    }

    public void setMovieChangeList(ArrayList<Movie> movieChangeList) {
        this.movieChangeList = movieChangeList;
    }

    public ArrayList<Movie> getMovieDeleteList() {
        return movieDeleteList;
    }

    public void setMovieDeleteList(ArrayList<Movie> movieDeleteList) {
        this.movieDeleteList = movieDeleteList;
    }

    public ArrayList<Showing> getShowingsList() {
        return showingsList;
    }

    public void setShowingsList(ArrayList<Showing> showingsList) {
        this.showingsList = showingsList;
    }

    public ArrayList<Showing> getShowingsAddList() {
        return showingsAddList;
    }

    public void setShowingsAddList(ArrayList<Showing> showingsAddList) {
        this.showingsAddList = showingsAddList;
    }

    public ArrayList<Showing> getShowingsChangeList() {
        return showingsChangeList;
    }

    public void setShowingsChangeList(ArrayList<Showing> showingsChangeList) {
        this.showingsChangeList = showingsChangeList;
    }

    public ArrayList<Showing> getShowingsDeleteList() {
        return showingsDeleteList;
    }

    public void setShowingsDeleteList(ArrayList<Showing> showingsDeleteList) {
        this.showingsDeleteList = showingsDeleteList;
    }

    public ArrayList<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(ArrayList<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    public ArrayList<Ticket> getDelTicket() {
        return delTicket;
    }

    public void setDelTicket(ArrayList<Ticket> delTicket) {
        this.delTicket = delTicket;
    }

    public ArrayList<SeatTicket> getSeatTicketList() {
        return seatTicketList;
    }

    public void setSeatTicketList(ArrayList<SeatTicket> seatTicketList) {
        this.seatTicketList = seatTicketList;
    }

    public ArrayList<SeatTicket> getDelSeatTicket() {
        return delSeatTicket;
    }

    public void setDelSeatTicket(ArrayList<SeatTicket> delSeatTicket) {
        this.delSeatTicket = delSeatTicket;
    }

    public ArrayList<Cinema> getCinemaList() {
        return cinemaList;
    }

    public void setCinemaList(ArrayList<Cinema> cinemaList) {
        this.cinemaList = cinemaList;
    }

    public ArrayList<Seat> getSeatList() {
        return seatList;
    }

    public void setSeatList(ArrayList<Seat> seatList) {
        this.seatList = seatList;
    }

    public ArrayList<TakenSeat> getTakenSeatsList() {
        return takenSeatsList;
    }

    public void setTakenSeatsList(ArrayList<TakenSeat> takenSeatsList) {
        this.takenSeatsList = takenSeatsList;
    }

    public ArrayList<Sort> getSortList() {
        return sortList;
    }

    public void setSortList(ArrayList<Sort> sortList) {
        this.sortList = sortList;
    }

    public ArrayList<OrderConfirmation> getOrderConfirmation() {
        return customerOrderConfirmation;
    }

    public void setOrderConfirmation(ArrayList<OrderConfirmation> orderConfirmation) {
        this.customerOrderConfirmation = orderConfirmation;
    }

    public ArrayList<Statistic> getCinemaStatisticList() { return cinemaStatisticList; }

    public void setCinemaStatisticList(ArrayList<Statistic> cinemaStatisticList) { this.cinemaStatisticList = cinemaStatisticList; }

    public ArrayList<Statistic> getMovieStatisticList() { return movieStatisticList; }

    public void setMovieStatisticList(ArrayList<Statistic> movieStatisticList) { this.movieStatisticList = movieStatisticList; }

    public ArrayList<SeatTicket> getNewSeatTicketList() {
        return newSeatTicketList;
    }

    public void setNewSeatTicketList(ArrayList<SeatTicket> newSeatTicketList) {
        this.newSeatTicketList = newSeatTicketList;
    }

    public ArrayList<Ticket> getNewTicketsList() {
        return newTicketsList;
    }

    public void setNewTicketsList(ArrayList<Ticket> newTicketsList) {
        this.newTicketsList = newTicketsList;
    }

}


