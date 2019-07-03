package model;

import model.exceptions.NoCookException;
import model.exceptions.NoIngredientException;
import model.exceptions.NotEnoughMoneyException;

public class Kitchen {

    private final static int INGREDIENT_PER_TACO = 3;
    private final static int DOLLAR_PER_INGREDIENT = 2;
    private int ingredient;
    private int tacoCount;
    private int balance;
    private boolean cookReady;

    public Kitchen(int initialIngredient, int initialTaco, int balance, boolean cookStatus) {
        ingredient = initialIngredient;
        tacoCount = initialTaco;
        cookReady = cookStatus;
        this.balance = balance;
    }

    // getters
    public int getIngredientCount() { return ingredient; }
    public int getTacoCount() { return tacoCount; }
    public boolean getCookState() { return cookReady; }
    public int getBalance() { return balance; }

    public void setCookStatus(boolean b) {
        cookReady = b;
    }

    // MODIFIES: this
    // EFFECTS:  number is added to tacoCount, and ingredient is decremented accordingly
    //           throws NoIngredientException if ingredients are not sufficient to make the number of tacos requested.
    //           throws NoCookException if cook is not ready.
    public void makeTaco(int number) throws NoIngredientException, NoCookException {
        int ingredientNeeded = INGREDIENT_PER_TACO * number;
        if(ingredient < ingredientNeeded) {
            throw new NoIngredientException(String.valueOf(getIngredientCount()) + " ingredients is not sufficient. Need: " + String.valueOf(ingredientNeeded));
        }
        if(!getCookState()) {
            throw new NoCookException("Cook is not ready.");
        }
        ingredient -= ingredientNeeded;
        tacoCount += number;
    }

    // MODIFIES: this
    // EFFECTS: (amount) is added to the ingredient field, and the balance field
    //          is decremented accordingly
    //          throws NotEnoughMoneyException if the balance is not sufficient to purchase the amount of ingredients requested.
    public void buyIngredients(int amount) throws NotEnoughMoneyException {
        int balanceNeeded = DOLLAR_PER_INGREDIENT * amount;
        if(getBalance() < balanceNeeded) {
            throw new NotEnoughMoneyException("$"+String.valueOf(getBalance())+" is insufficient. Need: $"+String.valueOf(balanceNeeded));
        }
        balance -= balanceNeeded;
        ingredient += amount;
    }
}
