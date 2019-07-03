package model;

import exceptions.ShowingFullException;
import exceptions.UnderAgeException;

public class MovieGoer {

    private String name;
    private int age;
    private Ticket ticket;
    private TicketKiosk tk;

    public MovieGoer(String name, int age,  TicketKiosk tk) {
        this.name = name;
        this.age = age;
        this.tk = tk;
        ticket = null;
    }

    // getters
    public String getName() {
        return this.name;
    }
    public int getAge() {
        return this.age;
    }
    public TicketKiosk getTicketKiosk() {
        return this.tk;
    }
    public Ticket getTicket() {
        return this.ticket;
    }

    // REQUIRES: the movie (m) must not be at full capacity, i.e. more people can watch the movie
    //           this moviegoer must be of appropriate age to watch the movie (age > m.ageRestriction)
    // MODIFIES: this
    // EFFECTS: a new ticket associated with the given movie is created, and
    //           becomes this MovieGoer's ticket
    public void buyTicket(Movie m) throws ShowingFullException, UnderAgeException {
        if(this.age < m.getAgeRestriction()) {
            throw new UnderAgeException("Buyer must be at least "+String.valueOf(m.getAgeRestriction())+" years old.");
        }
        if(m.isFull()) {
            throw new ShowingFullException("Movie is full.");
        }
        this.ticket = new Ticket(m);
        m.addViewer();
    }


}
