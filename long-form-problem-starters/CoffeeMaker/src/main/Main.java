package main;

import exceptions.*;
import model.CoffeeMaker;

public class Main {

    public static void main(String[] args){
        CoffeeMaker coffeeMaker = new CoffeeMaker();

        //Successful path
        try {
            coffeeMaker.brew(2.3, 4.5);
        } catch (NotEnoughBeansException e) {
            e.printStackTrace();
        } catch (TooManyBeansException e) {
            e.printStackTrace();
        } catch (WaterException e) {
            e.printStackTrace();
        }

        try {
            coffeeMaker.pourCoffee();
        } catch (StaleCoffeeException e) {
            e.printStackTrace();
        } catch (NoCupsRemainingException e) {
            e.printStackTrace();
        }

        coffeeMaker.setTimeSinceLastBrew(70);

        //Unsuccessful path
        try {
            coffeeMaker.brew(1.2, 3.4);
        } catch (NotEnoughBeansException e) {
            e.printStackTrace();
        } catch (TooManyBeansException e) {
            e.printStackTrace();
        } catch (WaterException e) {
            e.printStackTrace();
        }

        try {
            coffeeMaker.pourCoffee();
        } catch (StaleCoffeeException e) {
            e.printStackTrace();
        } catch (NoCupsRemainingException e) {
            e.printStackTrace();
        }

        coffeeMaker.setTimeSinceLastBrew(70);

        try {
            coffeeMaker.pourCoffee();
        } catch (StaleCoffeeException e) {
            e.printStackTrace();
        } catch (NoCupsRemainingException e) {
            e.printStackTrace();
        }
    }


}