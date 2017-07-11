package oop;

/**
 * Created by lujianyu on 7/11/17.
 */
public class Warrior extends Player {


    public Warrior(String name, int hp) {
        super(name, hp);
    }

    @Override
    public void sayHello() {
        System.out.println("I am warroir named: " + this.getName());
    }
}
