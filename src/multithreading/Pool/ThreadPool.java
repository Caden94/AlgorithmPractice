package multithreading.Pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPool {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
		Future<?> future1 = singleThreadPool.submit(new MyRunnable());
		Future<Integer> future2 = singleThreadPool.submit(new MyCallable());
        System.out.println("Runnable Future: " + future1.get());
        System.out.println("Callable Future: " + future2.get());
        singleThreadPool.execute(new MyRunnable); // old method

        singleThreadPool.shutdown();
    }

}
