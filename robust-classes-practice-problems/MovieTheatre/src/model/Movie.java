package model;

public class Movie {

    private String title;
    private int ageRestriction;
    private int currentSeating;
    private int maxSeating;

    public Movie(String title, int ageRestriction, int seating) {
        this.title = title;
        this.ageRestriction = ageRestriction;
        this.currentSeating = 0;
        this.maxSeating = seating;
    }

    //getters
    public String getTitle() {
        return this.title;
    }
    public int getAgeRestriction() {
        return this.ageRestriction;
    }
    public int getCurrentSeating() {
        return this.currentSeating;
    }
    public int getMaxSeating() {
        return this.maxSeating;
    }

    //EFFECTS: returns true if the movie is at full capacity, else return false
    public boolean isFull() {
        return (currentSeating == maxSeating);
    }

    //EFFECTS: increment the currentSeating field by 1
    public void addViewer() {
        currentSeating++;
    }


}
