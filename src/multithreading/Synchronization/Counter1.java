package multithreading.Synchronization;

import java.util.concurrent.*;

/**
 * Created by lujianyu on 7/22/17.
 */
public class Counter1 implements Callable<Integer> {
    private static int count;

    public Counter1(int count) {
        this.count = count;
    }

    synchronized static void increase() {
        count++;
    }

    synchronized static public void decrease() {
        count--;
    }

    synchronized static public int getCount() {
        return count;
    }

    @Override
    public Integer call() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " value = " + count);
            count++;
        }
        return count;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Counter1 counter = new Counter1(5);
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future<?> future = executorService.submit(counter);
        if (future.isDone()) {
            System.out.println(future.get());
            System.out.println(counter.getCount());
        }
    }
}
