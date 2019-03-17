package no.kino.domain;

// Klassen Ticket med attributter og tilgangsmetoder
public class Statistic {
    private int cinemaNr;
    private String movie;
    private int showingNumber;
    private String count;
    private String percent;
    private String countPaid;


    // Konstruktør for Ticket
    public Statistic(int cinemaNr, String movie, int showingNumber, String count, String percent, String countPaid) {
        this.cinemaNr = cinemaNr;
        this.movie = movie;
        this.showingNumber = showingNumber;
        this.count = count;
        this.percent = percent;
        this.countPaid = countPaid;

    }

    // Metoden newTicket
    private Statistic newStatistic(int cinemaNr, String movie, int showingNumber, String count, String percent, String countPaid){
        return new Statistic(cinemaNr, movie, showingNumber, count, percent, countPaid);
    }

    public int getCinemaNr() {
        return cinemaNr;
    }

    public void setCinemaNr(int cinemaNr) { this.cinemaNr = cinemaNr; }

    public String getmovie() {
        return movie;
    }

    public void setmovie(String movie) { this.movie = movie; }

    public int getshowingNumber() {
        return showingNumber;
    }

    public void setshowingNumber(int showingNumber) { this.showingNumber = showingNumber; }

    public String getCount() { return count; }

    public void setCount(String count) { this.count = count; }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }

    public String getCountPaid() { return countPaid; }

    public void setCountPaid(String countPaid) { this.countPaid = countPaid; }

    @Override
    public String toString() {
        return "Statistic{" +
                "cinemaNr='" + cinemaNr +
                "percent='" + percent +
                '}';
    }
}
