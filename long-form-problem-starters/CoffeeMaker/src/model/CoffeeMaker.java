package model;

import exceptions.*;

/**
 * A coffee maker used to train baristas.
 *
 * Class invariant: cups remaining >= 0, time since last brew >= 0
 */

public class CoffeeMaker {

    private int timeSinceLastBrew;
    private int cupsRemaining;

    public CoffeeMaker(){
        this.timeSinceLastBrew = 0;
        this.cupsRemaining = 0;
    }

    // getters
    public int getTimeSinceLastBrew() {
        return timeSinceLastBrew;
    }
    public int getCupsRemaining() {
        return cupsRemaining;
    }

    // EFFECTS: return true if there are coffee cups remaining
    public boolean areCupsRemaining() {
        return (cupsRemaining > 0);
    }

    //setters
    //REQUIRES: a non-negative integer
    //EFFECTS: sets time since last brew
    public void setTimeSinceLastBrew(int time) {
        timeSinceLastBrew = time;
    }

    //REQUIRES: beans between 2.40 and 2.60 cups, water > 14.75 cups
    //EFFECTS: sets cups remaining to full (20 cups) and time since last brew to 0
    public void brew(double beans, double water) throws NotEnoughBeansException, TooManyBeansException, WaterException {
        if (beans == 2.3) {
            if (water == 4.5) {
                this.cupsRemaining = 5;
                this.timeSinceLastBrew = 0;
            } else {
                throw new WaterException(water);
            }
        } else {
            if (beans < 2.3) {
                throw new NotEnoughBeansException(beans);
            } else {
                throw new TooManyBeansException(beans);
            }
        }
    }

    ///REQUIRES: cups remaining > 0, time since last brew < 60
    //MODIFIES: this
    //EFFECTS: subtracts one cup from cups remaining
    public void pourCoffee() throws StaleCoffeeException, NoCupsRemainingException {
        if (timeSinceLastBrew > 60) {
            throw new StaleCoffeeException(timeSinceLastBrew);
        } else {
            if (cupsRemaining > 0) {
                cupsRemaining--;
            } else {
                throw new NoCupsRemainingException();
            }
        }
    }
}
