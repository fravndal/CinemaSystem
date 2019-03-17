package no.kino.domain;

public class TakenSeat {
    private int showingNumber;
    private int cinemaRoomNumber;
    private String ticketCode;
    private int rowNumber;
    private int SeatNumber;

    public TakenSeat(int showingNumber, int cinemaRoomNumber, String ticketCode, int rowNumber, int seatNumber) {
        this.showingNumber = showingNumber;
        this.cinemaRoomNumber = cinemaRoomNumber;
        this.ticketCode = ticketCode;
        this.rowNumber = rowNumber;
        this.SeatNumber = seatNumber;
    }

    public int getShowingNumber() {
        return showingNumber;
    }

    public void setShowingNumber(int showingNumber) {
        this.showingNumber = showingNumber;
    }

    public int getCinemaRoomNumber() {
        return cinemaRoomNumber;
    }

    public void setCinemaRoomNumber(int cinemaRoomNumber) {
        this.cinemaRoomNumber = cinemaRoomNumber;
    }

    public String getTicketCode() {
        return ticketCode;
    }

    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public int getSeatNumber() {
        return SeatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        SeatNumber = seatNumber;
    }

    @Override
    public String toString() {
        return "TakenSeat{" +
                "showingNumber=" + showingNumber +
                ", cinemaRoomNumber=" + cinemaRoomNumber +
                ", ticketCode='" + ticketCode + '\'' +
                ", rowNumber=" + rowNumber +
                ", SeatNumber=" + SeatNumber +
                '}';
    }
}
