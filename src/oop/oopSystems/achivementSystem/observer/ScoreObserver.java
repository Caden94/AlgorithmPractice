package oop.achivementSystem.observer;

import oop.achivementSystem.Event;

public class ScoreObserver implements Observer {
    @Override
    public void onNotify(Event event) {
        if (event == Event.SCORE) {
            System.out.println("Congratulate! " + Event.SCORE.getVal());
        }
    }
}
