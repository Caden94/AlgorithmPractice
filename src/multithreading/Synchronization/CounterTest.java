package multithreading.Synchronization;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by lujianyu on 7/23/17.
 */
public class CounterTest {
    private int count = 0;

    public static void main(String[] args) throws InterruptedException {
        CounterTest myCounter = new CounterTest();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        // thread pool will choose one thread to execute the task
        Future<?> future = null;
        for (int i = 0; i < 10; i++) {
            future = executorService.submit(() -> {
                myCounter.increase();
                System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().hashCode());
            });
        }
        for (int i = 0; i < 10; i++) {
            future = executorService.submit(() -> {
                myCounter.decrease();
                System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().hashCode());
            });
        }
        while (future != null && !future.isDone()) {}
        executorService.shutdown();
        System.out.println(myCounter.getCount());
    }

    synchronized void increase() {
        count++;
    }

    synchronized public void decrease() {
        count--;
    }

    synchronized public int getCount() {
        return count;
    }
}
