package algorithmsAndDataStructures.linear;

import java.util.ArrayDeque;

/**
 * Created by lujianyu on 7/25/17.
 */
public class Queue<E> {
    private Object[] elements;
    private int head, tail;
    public Queue(int size) {
        this.elements = new Object[size];
        this.head = 0;
        this.tail = 0;
    }

    private void offer(E e) {

    }

    private E poll() {
        return null;
    }

    private boolean isEmpty() {
        return false;
    }

    private int size() {
        return -1;
    }

//    ArrayDeque

//    E result = (E) elements[t];
}
