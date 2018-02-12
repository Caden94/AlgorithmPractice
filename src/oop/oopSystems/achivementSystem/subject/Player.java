package oop.achivementSystem.subject;

import oop.achivementSystem.Event;
import oop.achivementSystem.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class Player implements Subject {
    private int id;
    private int level;
    private int score;
    private List<Observer> observerList;

    public Player(int id) {
        this.id = id;
        this.level = 1;
        this.score = 0;
        this.observerList = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        this.observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.observerList.remove(observer);
    }

    @Override
    public void notifyObservers(Event event) {
        for (Observer observer : observerList) {
            observer.onNotify(event);
        }
    }

    public int getId() {
        return id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
        if (this.level >= 10) { notifyObservers(Event.LEVEL); }
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
        if (this.score >= 50) { notifyObservers(Event.SCORE); }
    }
}
