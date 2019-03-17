package no.kino.domain;

import no.kino.control.Control;

import java.sql.Time;
import java.util.Date;

public class Sort {
    private int showingNumber;
    private String movieName;
    private int cinemaNumber;
    private Date date;
    private Time startingTime;
    private double price;

    public Sort(int showingNumber, String movieNumber, int cinemaNumber, Date date, Time startingTime, double price) throws Exception {
        this.showingNumber = showingNumber;
        this.movieName = movieNumber;
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

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
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
        return "Sort{" +
                ", showingNumber=" + showingNumber +
                ", movieName='" + movieName + '\'' +
                ", cinemaNumber=" + cinemaNumber +
                ", date=" + date +
                ", startingTime=" + startingTime +
                ", price=" + price +
                '}';
    }
}
