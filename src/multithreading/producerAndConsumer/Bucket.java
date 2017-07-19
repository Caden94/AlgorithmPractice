package multithreading.producerAndConsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by lujianyu on 7/19/17.
 */
public class Bucket {
    private BlockingQueue<Token> queue;
    private int rate;

    public Bucket(int size, int rate) {
        this.queue = new ArrayBlockingQueue<Token>(size);
        this.rate = rate;
    }

    public void putToken(Token token) {
        try {
            Thread.sleep(this.rate);
            queue.put(token); // put is synchronized
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Token getToken() {
        try {
            Thread.sleep(100);
            return queue.take(); // take is synchronized
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
