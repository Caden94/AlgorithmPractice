package oop.achivementSystem.observer;

import oop.achivementSystem.Event;

public class LevelObserver implements Observer {

    @Override
    public void onNotify(Event event) {
        if (event == Event.LEVEL) {
            System.out.println("Congratulate! " + Event.LEVEL.getVal());
        }
    }
}
