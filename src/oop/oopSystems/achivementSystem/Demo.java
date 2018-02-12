package oop.achivementSystem;

import oop.achivementSystem.observer.LevelObserver;
import oop.achivementSystem.observer.ScoreObserver;
import oop.achivementSystem.subject.Player;

public class Demo {
    public static void main(String[] args) {
        Player player = new Player(0);
        LevelObserver levelObserver = new LevelObserver();
        ScoreObserver scoreObserver = new ScoreObserver();
        player.addObserver(levelObserver);
        player.addObserver(scoreObserver);

        // @Test
        player.setLevel(5);
        player.setLevel(10);
        player.setScore(50);
    }
}
