package no.kino.domain;

public class SeatTicket {
    private int movieTheaterNumber;
    private String ticketCode;
    private int rowNr;
    private int seatNr;


    public SeatTicket(int rowNr, int seatNr, int movieTheaterNumber, String ticketCode) {
        this.rowNr = rowNr;
        this.seatNr = seatNr;
        this.movieTheaterNumber = movieTheaterNumber;
        this.ticketCode = ticketCode;
    }

    private SeatTicket newTicketplace(int rowNr, int seatNr, int moviePlaceNr, String ticketCode){
        return new SeatTicket(rowNr, seatNr, moviePlaceNr, ticketCode);
    }

    public int getRowNr() {
        return rowNr;
    }

    public void setRowNr(int rowNr) {
        this.rowNr = rowNr;
    }

    public int getSeatNr() {
        return seatNr;
    }

    public void setSeatNr(int seatNr) {
        this.seatNr = seatNr;
    }

    public int getMovieTheaterNumber() {
        return movieTheaterNumber;
    }

    public void setMovieTheaterNumber(int movieTheaterNumber) {
        this.movieTheaterNumber = movieTheaterNumber;
    }

    public String getTicketCode() {
        return ticketCode;
    }

    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;

    }

    @Override
    public String toString() {
        return "ticketPlace{" +
                "rowNr=" + rowNr +
                ", seatNr=" + seatNr +
                ", movieTheaterNumber=" + movieTheaterNumber +
                ", ticketCode='" + ticketCode + '\'' +
                '}';
    }
}
