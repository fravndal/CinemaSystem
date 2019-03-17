package no.kino.domain;

import java.util.ArrayList;

public class Cinema {
    private int cinemaNumber;
    private String cinemaName;
    private String cinemaRoomName;
    ArrayList<Movie> movies;

    public Cinema(int cinemaNumber, String cinemaName, String cinemaRoomName) {
        this.cinemaNumber = cinemaNumber;
        this.cinemaName = cinemaName;
        this.cinemaRoomName = cinemaRoomName;
        this.movies = new ArrayList<>();
    }

    private Cinema newCinema(int cinemaNumber, String cinemaName, String cinemaRoomName){
        return new Cinema(cinemaNumber, cinemaName, cinemaRoomName);
    }

    public int getCinemaNumber() {
        return cinemaNumber;
    }

    public void setCinemaNumber(int cinemaNumber) {
        this.cinemaNumber = cinemaNumber;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getCinemaRoomName() {
        return cinemaRoomName;
    }

    public void setCinemaRoomName(String cinemaRoomName) {
        this.cinemaRoomName = cinemaRoomName;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "cinemaNumber=" + cinemaNumber +
                ", cinemaName='" + cinemaName + '\'' +
                ", cinemaRoomName='" + cinemaRoomName + '\'' +
                '}';
    }
}
