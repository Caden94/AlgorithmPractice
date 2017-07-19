package multithreading.producerAndConsumer;

/**
 * Created by lujianyu on 7/19/17.
 */
public class GetExcutor implements Runnable {
    private Bucket bucket;
    private int num;

    public GetExcutor(Bucket bucket, int num) {
        this.bucket = bucket;
        this.num = num;
    }

    @Override
    public void run() {
        int count = 0;
        while (count < num) {
            System.out.println("Take: " + Thread.currentThread().getName() + " From " + bucket.getToken());
        }
    }
}
