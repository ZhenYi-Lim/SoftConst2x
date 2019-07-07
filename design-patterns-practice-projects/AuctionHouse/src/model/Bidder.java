package model;

import java.util.Random;

import static java.lang.StrictMath.floor;

public class Bidder implements Observer {
    private String name;
    private double personalBid;
    private double currentBid;
    private double maxBid;

    public Bidder(String name, double maxBid) {
        this.name = name;
        this.personalBid = 0;
        this.currentBid = 0;
        this.maxBid = maxBid;
    }

    public String getName() {
        return name;
    }

    public double getPersonalBid() {
        return personalBid;
    }

    public double getCurrentBid() {
        return currentBid;
    }

    public double getMaxBid() {
        return maxBid;
    }

    @Override
    public void update(Subject auctioneer, Object obj) {
        currentBid = (double) obj;
        System.out.println("Bidder "+name+" has been updated with the most recent high bid.");
        if(currentBid < maxBid) {
            makeBid(currentBid);
        } else {
            System.out.println("I can't bid any higher!");
        }
    }

    public void makeBid(double currentBid) {
        double leeway = maxBid - currentBid;
        Random random = new Random();
        double increment = floor(random.nextDouble()*9+1);
        if (increment < leeway) {
            this.personalBid = currentBid+increment;
        } else {
            this.personalBid = this.maxBid;
        }
    }
}
