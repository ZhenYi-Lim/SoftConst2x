package exceptions;

public class WaterException extends Exception {
    private double amtWaterCups;

    public WaterException(double amtWaterCups) {
        super(amtWaterCups+" is not enough water.");
    }
}
