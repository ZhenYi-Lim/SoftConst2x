package exceptions;

public class StaleCoffeeException extends Exception {
    private int timeSince;

    public StaleCoffeeException(int timeSince) {
        super("Coffee was last brewed "+String.valueOf(timeSince)+" minutes ago, and is now stale.");
    }
}
