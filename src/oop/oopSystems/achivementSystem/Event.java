package oop.achivementSystem;

public enum Event {
    SCORE("Score is more than 50"), LEVEL("Level is more than 10");

    private final String val;

    Event(String val) { this.val = val; }

    public String getVal() {
        return val;
    }
}
