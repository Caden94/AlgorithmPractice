package multithreading.producerAndConsumer.lockImplementation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lujianyu on 7/19/17.
 */
public class PCDemo {
    public static void main(String[] args) {
        multithreading.producerAndConsumer.lockImplementation.Bucket bucket = new Bucket(20, 200);
        PutExcutor putExcutor = new PutExcutor(bucket);
        GetExcutor getExcutor = new GetExcutor(bucket, 6);

        List<Thread> putThreads = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            putThreads.add(new Thread(putExcutor));
        }

        List<Thread> getThread = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            getThread.add(new Thread(getExcutor));
        }

        for (Thread thread : putThreads) {
            thread.start();
        }

        for (Thread thread : getThread) {
            thread.start();
        }
    }
}
