package model;

public class Task extends Doable {

    private String description;
    private String date;
    private String location;
//    private boolean status;

    public Task(String description, String date, String location) {
        super();
        this.description = description;
        this.date = date;
        this.location = location;
//        status = false;
    }

    // getters
    public String getDate() { return date; }
    public String getLocation() { return location; }
//    public boolean getStatus() { return status; }

    // setters
    public void setDate(String date) { this.date = date; }
    public void setLocation(String location) { this.location = location; }

    public String getDescription() {
        return description + " on " + getDate() + " @" + getLocation();
    }

    public void complete() {
        if (!complete) {
            complete = true;
        }
    }

    public void display(String indentSpace) {
        System.out.println(indentSpace + this.getDescription());
    }


}