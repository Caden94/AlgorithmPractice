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

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int count = 0;
        long startTime = System.nanoTime();
        for (int i = 0; i < 10000000; i++) {
            count++;
        }
        long endTime = System.nanoTime();
        System.out.println(count + " " + (endTime - startTime));

        Counter1 counter = new Counter1(0);
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        startTime = System.nanoTime();
        Future<?> future = executorService.submit(counter);
        endTime = System.nanoTime();
        System.out.println(count + " " + (endTime - startTime));
        executorService.shutdown();

    }

    @Override
    public Integer call() {
        for (int i = 0; i < 10000000; i++) {
            count++;
        }
        return count;
    }
}
