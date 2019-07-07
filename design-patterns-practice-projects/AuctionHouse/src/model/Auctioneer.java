package model;

public class Auctioneer extends Subject {
    private String name;
    private double currentBid;

    public Auctioneer(String name) {
        super();
        this.name = name;
        this.currentBid = 0;
    }

    public String getName() {
        return this.name;
    }

    public double getCurrentBid() {
        return this.currentBid;
    }

    public void acceptBid(double bid) {
        if (bid <= currentBid) {
            System.out.println("That bid isn't larger than the current bid!");
        } else {
            this.currentBid = bid;
            notifyObservers(bid);
        }
    }

    public void notifyObservers(double newBidAmt) {
        super.notifyObservers(this, newBidAmt);
    }
}
