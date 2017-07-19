package multithreading.producerAndConsumer;

import java.util.concurrent.BlockingQueue;

/**
 * Created by lujianyu on 7/19/17.
 */
public class PutExcutor implements Runnable {
    private Bucket bucket;
    public PutExcutor(Bucket bucket) {
        this.bucket = bucket;
    }

    @Override
    public void run() {
        int count = 0;
        while (count < 10) {
            bucket.putToken(new Token(count, Thread.currentThread().getName()));
            System.out.println("Put: " + Thread.currentThread().getName() + " " + count++);
        }
    }
}
