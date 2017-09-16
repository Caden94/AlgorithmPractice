package oop.achivementSystem.observer;

import oop.achivementSystem.Event;

public interface Observer {
    void onNotify(Event event); // respond base on event
}
