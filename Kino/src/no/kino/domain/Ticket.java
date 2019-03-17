package no.kino.domain;

// Klassen Ticket med attributter og tilgangsmetoder
public class Ticket {
    private String ticketNumber;
    private int showingNumber;
    private int isPaid;

    // Konstruktør for Ticket
    public Ticket(String ticketNumber, int showNumber, int isPaid) {
        this.ticketNumber = ticketNumber;
        this.showingNumber = showNumber;
        this.isPaid = isPaid;
    }

    // Metoden newTicket
    private Ticket newTicket(String ticketNumber, int showNumber, int isPaid){
        return new Ticket(ticketNumber, showNumber, isPaid);
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public int getShowingNumber() {
        return showingNumber;
    }

    public void setShowingNumber(int showNumber) {
        this.showingNumber = showNumber;
    }

    public int getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(int isPaid) {
        this.isPaid = isPaid;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketNumber='" + ticketNumber + '\'' +
                ", showNumber=" + showingNumber +
                ", isPaid=" + isPaid +
                '}';
    }
}
