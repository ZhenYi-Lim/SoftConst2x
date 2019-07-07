package model;

import model.observer_pattern.Observer;
import model.observer_pattern.Subject;
import model.random.BingoNumber;

import java.util.ArrayList;
import java.util.List;

public class Game extends Subject {

    public static final int CARD_SIZE = 25;
    public static final int SIDE_LENGTH = (int) Math.sqrt(CARD_SIZE);

    private BingoNumber currentCall;
//    private List<PlayerCard> cards;
    private boolean gameOver;

    public Game() {
        super();
//        cards = new ArrayList<>();
        callNext();
    }

    //getters
    public BingoNumber getCurrentCall(){
        return currentCall;
    }

    public boolean isGameOver(){
        return gameOver;
    }

    public List<PlayerCard> getCards() {
        List<PlayerCard> playerCards = new ArrayList<>();
        for (Observer o : getObservers()) { //NOTE: refactor this line ONLY.
            if (o.getClass().getSimpleName().equals("PlayerCard"))
                playerCards.add((PlayerCard) o);
        }
        return playerCards;
    }

    //TODO: refactor this method
    //EFFECTS: generates the next bingo call and notifies observers
    public void callNext() {
        currentCall = new BingoNumber();
        notifyObservers();
        refreshGameOver();
    }

    //TODO: refactor this method
    //MODIFIES: this
    //EFFECTS: adds observer to list of observers
//    public void addObserver(PlayerCard pc) {
//        addObserver((Observer) pc);
////        cards.add(pc);
//    }

    //EFFECTS: sets game over to true if one of the players has bingo
    public void refreshGameOver(){
        for (Observer pc : getObservers()) {
            PlayerCard p = (PlayerCard) pc;
            if (p.hasBingo()) {
                gameOver = true;
                break;
            }
        }
    }

    //EFFECTS: notifies observers of state change
    @Override
    public void notifyObservers() {
        for (Observer o : getObservers()) {
            o.update(currentCall);
        }
    }
}
