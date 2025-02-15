package model;

import java.util.ArrayList;
import java.util.List;

public class Server extends FOHEmployee{

    private static final double DISH_PRICE = 10.00;
    private static final String PREFIX = "SERVER - ";

    private List<Order> orders;
    private double cash;
    private int currentOrderNumber;
//    private Dish dish;

    public Server(Dish dish) {
        super(dish);
        this.orders = new ArrayList<>();
        currentOrderNumber = 100;
    }

    //getter
    public List<Order> getActiveOrders() {
        return orders;
    }

    public double getCash() { return cash; }

    //MODIFIES: this
    //EFFECTS: creates new order with the dish on the menu
    public Order takeOrder() {
        System.out.println(PREFIX + "Taking order...");
        Order o = new Order(this.dish, currentOrderNumber++);
        orders.add(o);
        System.out.print("Order taken: ");
        o.print();
        return o;
    }

    @Override
    public String getPrefix() {
        return PREFIX;
    }

    //EFFECTS: prints out a description of the dish on the menu
//    public void describeDish() {
//        System.out.println(dish.getDescription());
//    }

    //EFFECTS: prints out a greeting
//    public void greet() {
//        System.out.println("\"Hello and welcome to Busy's, the home of the trendy turkey club sandwich.\"");
//    }

    //MODIFIES: this
    //EFFECTS: takes payment for the guest and removes order from system
    public void takePayment(Order order) {
        System.out.println(PREFIX + "Taking payment...");
        orders.remove(order);
        cash += DISH_PRICE;
        System.out.println("\"Thanks for visiting Busy's Diner!\"");
    }

    //MODIFIES: this, order
    //EFFECTS: logs order as served and brings to table
//    public void deliverFood(Order order) {
//        order.setIsServed();
//        System.out.print(PREFIX + "Delivered food: ");
//        order.print();
//    }

}
