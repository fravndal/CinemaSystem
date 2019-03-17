package no.kino.domain;

import java.sql.Time;
import java.util.Date;

public class OrderConfirmation {
    private String movieName;
    private int movieTheaterNumber;
    private Date date;
    private String time;
    private double price;
    private int rowNumber;
    private int seatNumber;
    private int showingNumber;

    public OrderConfirmation(String movieName, int movieTheaterNumber, Date date, String time, double price, int rowNumber, int seatNumber, int showingNumber){
        this.movieName = movieName;
        this.movieTheaterNumber = movieTheaterNumber;
        this.date = date;
        this.time = time;
        this.price = price;
        this.rowNumber = rowNumber;
        this.seatNumber = seatNumber;
        this.showingNumber = showingNumber;

    }

    private OrderConfirmation newOrderConfirmation(String movieName, int movieTheaterNumber, Date date, String time, double price, int rowNumber, int seatNumber, int showingNumber){
        return new OrderConfirmation(movieName, movieTheaterNumber, date, time, price, rowNumber, seatNumber, showingNumber);
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getMovieTheaterNumber() {
        return movieTheaterNumber;
    }

    public void setMovieTheaterNumber(int movieTheaterNumber) {
        this.movieTheaterNumber = movieTheaterNumber;
    }

    public Date getDate() {
        return date;
    }

    public int getShowingNumber() {
        return showingNumber;
    }

    public void setShowingNumber(int showingNumber) {
        this.showingNumber = showingNumber;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderConfirmation{" +
                "movieName='" + movieName + '\'' +
                ", movieTheaterNumber=" + movieTheaterNumber +
                ", date=" + date +
                ", time=" + time +
                ", rowNumber=" + rowNumber +
                ", seatNumber=" + seatNumber +
                '}';
    }

}
