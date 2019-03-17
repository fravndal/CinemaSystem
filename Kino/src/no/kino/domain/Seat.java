package no.kino.domain;

import java.util.Date;

public class Seat {
	private int rowNr;
    private int seatNr;
    private int movieTheaterNr;
    private boolean isSet;
    // Konstruktør for Place
    public Seat(int rowNr, int seatNr, int movieTheaterNr){
        this.rowNr = rowNr;
        this.seatNr = seatNr;
        this.movieTheaterNr = movieTheaterNr;
        
    }

    
    
    public int getrowNr() { return rowNr; }

    public void setRowNr(int rowNr) { this.rowNr =  rowNr; }

    public int getseatNr() { return seatNr; }

    public void setSeatNr(int seatNr) { this.seatNr = seatNr; }

    public int getMovieTheaterNr() { return movieTheaterNr; }

    public void setMovieTheaterNr(int movieTheaterNr) { this.movieTheaterNr = movieTheaterNr; }

    public boolean isSet() {
        return isSet;
    }

    public void setSet(boolean set) {
        isSet = set;
    }
    
    
    
    @Override
    public String toString() {
        return "Seat{" +
                "rowNr='" + rowNr + '\'' +
                ", seatNr='" + seatNr + '\'' +
                ", movieTheaterNr='" + movieTheaterNr + '\'' +
                '}';
    }



}


