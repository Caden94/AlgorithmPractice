package multithreading.producerAndConsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by lujianyu on 7/19/17.
 */
public class RWLock {
    public static final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    public Lock readLock = readWriteLock.readLock();
    public Lock writeLock = readWriteLock.writeLock();

    private List<Integer> list = new ArrayList<>();

    public void addElement(int element) {
        writeLock.lock();
        try {
            list.add(element);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }

    public void getElement(int index) {
        readLock.lock();
        try {
            int element = list.get(index);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }
    }
}
