package multithreading.Pool;

import java.util.concurrent.*;

public class ThreadPool {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // TODO Auto-generated method stub
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<?> future1 = executorService.submit(new MyRunnable());
        Future<Integer> future2 = executorService.submit(new MyCallable());
        System.out.println("Runnable Future: " + future1.get());
        System.out.println("Callable Future: " + future2.get());
        // executorService.execute(new MyRunnable()); // old method

        executorService.shutdown();
    }

    public static class MyRunnable implements Runnable {
        @Override
        public void run() {
            // todo
            int res = 0;
            for (int i = 0; i < 10; i++) {
                res += i;
            }
            // return
            System.out.println("Runnable " + res);
        }
    }

    public static class MyCallable implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            // todo
            int res = 0;
            for (int i = 0; i < 10; i++) {
                res += i;
            }
            // return
            return  res;
        }
    }

}
