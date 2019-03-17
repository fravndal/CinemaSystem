package no.kino.domain;

import java.sql.Time;
import java.util.Date;
// Klassen Showing med attributter og tilgangsmetoder
public class Showing {
    private int showingNumber;
    private int movieNumber;
    private int cinemaNumber;
    private Date date;
    private Time startingTime;
    private double price;
    // Konstruktør for Showing


    public Showing(int showingNumber, int movieNumber, int cinemaNumber, Date date, Time startingTime, double price) {
        this.showingNumber = showingNumber;
        this.movieNumber = movieNumber;
        this.cinemaNumber = cinemaNumber;
        this.date = date;
        this.startingTime = startingTime;
        this.price = price;
    }

    public int getShowingNumber() {
        return showingNumber;
    }

    public void setShowingNumber(int showingNumber) {
        this.showingNumber = showingNumber;
    }

    public int getMovieNumber() {
        return movieNumber;
    }

    public void setMovieNumber(int movieNumber) {
        this.movieNumber = movieNumber;
    }

    public int getCinemaNumber() {
        return cinemaNumber;
    }

    public void setCinemaNumber(int cinemaNumber) {
        this.cinemaNumber = cinemaNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(Time startingTime) {
        this.startingTime = startingTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Showing{" +
                "showingNumber=" + showingNumber +
                ", movieNumber=" + movieNumber +
                ", cinemaNumber=" + cinemaNumber +
                ", date=" + date +
                ", startingTime=" + startingTime +
                ", price=" + price +
                '}';
    }
}
