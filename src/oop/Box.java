package oop;

/**
 * Created by lujianyu on 7/11/17.
 *
 * Generic
 * T -> Type
 * E -> Element
 * K -> Key
 * V -> Value
 */
public class Box <T> {
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
