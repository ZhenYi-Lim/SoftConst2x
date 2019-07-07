package model;

public abstract class Doable {
    protected boolean complete;

    public Doable() {
        this.complete = false;
    }

    public boolean getComplete() { return this.complete; }

    public abstract String getDescription();

    public abstract void complete();

    public abstract void display(String indentSpace);
}
