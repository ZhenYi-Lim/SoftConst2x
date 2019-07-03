package tests;

import exceptions.*;
import model.CoffeeMaker;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CoffeeMakerTest {
    private CoffeeMaker coffeeMaker;

    @Before
    public void setup() {
        coffeeMaker = new CoffeeMaker();
    }

    @Test (expected = NotEnoughBeansException.class)
    public void brewFailNotEnoughBeans() throws NotEnoughBeansException, TooManyBeansException, WaterException {
        coffeeMaker.brew(1.2,0);
    }

    @Test (expected = TooManyBeansException.class)
    public void brewFailTooManyBeans() throws NotEnoughBeansException, TooManyBeansException, WaterException {
        coffeeMaker.brew(3.4,0);
    }

    @Test (expected = WaterException.class)
    public void brewFailNotEnoughWater() throws NotEnoughBeansException, TooManyBeansException, WaterException {
        coffeeMaker.brew(2.3,0);
    }

    @Test
    public void brewPass() {
        try {
            goodBrew();
        } catch (Exception e) {
            fail("Shouldn't catch any exceptions.");
        }
    }

    @Test (expected = StaleCoffeeException.class)
    public void pourStale() throws StaleCoffeeException, NoCupsRemainingException, NotEnoughBeansException, TooManyBeansException, WaterException {
        goodBrew();
        coffeeMaker.setTimeSinceLastBrew(70);
        coffeeMaker.pourCoffee();
    }

    @Test (expected = NoCupsRemainingException.class)
    public void pourNoCupsLeft () throws StaleCoffeeException, NoCupsRemainingException, NotEnoughBeansException, TooManyBeansException, WaterException {
        goodBrew();
        coffeeMaker.pourCoffee();
        coffeeMaker.pourCoffee();
        coffeeMaker.pourCoffee();
        coffeeMaker.pourCoffee();
        coffeeMaker.pourCoffee();
        coffeeMaker.pourCoffee();
    }

    @Test
    public void pourPass() {
        try {
            goodBrew();
        } catch (Exception e) {
            fail("Shouldn't catch any exceptions.");
        }
        assertEquals(5, coffeeMaker.getCupsRemaining());
        try {
            coffeeMaker.pourCoffee();
            coffeeMaker.pourCoffee();
        } catch (Exception e) {
            fail("Shouldn't catch any exceptions.");
        }

        assertEquals(3, coffeeMaker.getCupsRemaining());
    }

    private void goodBrew() throws NotEnoughBeansException, TooManyBeansException, WaterException {
        coffeeMaker.brew(2.3, 4.5);
    }
}
