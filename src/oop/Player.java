package oop;

/**
 * Created by lujianyu on 7/11/17.
 */
public abstract class Player {

    private int hp;
    private String name;


    public Player(String name, int hp) {
        this.hp = hp;
        this.name = name;
    }

    public abstract void sayHello();

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
