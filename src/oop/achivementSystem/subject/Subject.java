package oop.achivementSystem.subject;

import oop.achivementSystem.Event;
import oop.achivementSystem.observer.Observer;

public interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(Event event); // call all observers onNotify methods
}
