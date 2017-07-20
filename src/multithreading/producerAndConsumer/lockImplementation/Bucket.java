package multithreading.producerAndConsumer.lockImplementation;

import multithreading.producerAndConsumer.synchronizedMethod.Token;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lujianyu on 7/19/17.
 */
public class Bucket {
    private Lock lock = new ReentrantLock(); // means write/read cannot happen at the same time
    // define read and write condition for lock
    private Condition condition1 = lock.newCondition(); // write
    private Condition condition2 = lock.newCondition(); // read

    private Deque<Token> queue;
    private int rate;
    private int size;

    public Bucket(int size, int rate) {
        this.queue = new ArrayDeque<>();
        this.rate = rate;
        this.size = size;
    }

    public void putToken(Token token) {
        lock.lock();
        try {
            while (queue.size() == size) {
                condition1.await();
            }
            queue.offer(token);
            Thread.sleep(this.rate);
            condition2.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public Token getToken() {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                condition2.await();
            }
            Thread.sleep(100);
            Token token = queue.poll();
            condition1.signalAll();
            return token; // take is synchronized
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        } finally {
            lock.unlock();
        }
    }
}
