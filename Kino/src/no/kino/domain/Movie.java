package no.kino.domain;

import java.util.ArrayList;

public class Movie {
    int movieNumber;
    String movieName;
    ArrayList<Ticket> tickets;

    public Movie(int movieNumber, String movieName) {
        this.movieNumber = movieNumber;
        this.movieName = movieName;
        this.tickets = new ArrayList<>();
    }





    public Movie createMovie(int movieNumber, String movieName) {
        return new Movie(movieNumber, movieName);

    }

    public int getMovieNumber() {
        return movieNumber;
    }

    public void setMovieNumber(int movieNumber) {
        this.movieNumber = movieNumber;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieNumber=" + movieNumber +
                ", movieName='" + movieName + '\'' +
                '}';
    }
}
