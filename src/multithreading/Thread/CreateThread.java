package multithreading.Thread;

import java.util.concurrent.*;

public class CreateThread {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
	    // todo: create a class implement runnable interface
		Thread thread = new Thread(new Hello());
		thread.start();
		// if we annotate next line, system will print "Success" at first.
		thread.join();
		System.out.println("Success");

        // todo: lambada expression
        Thread thread1 = new Thread(() -> System.out.println("Hello from Runnable 1"));
        thread1.start();
        thread1.join();
        System.out.println("Success");

        // todo: implement run method in the runnable interface
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from Runnable 2");
            }
        });
        thread2.start();
        thread2.join();
        System.out.println("Success");

        // todo: create a thread class
		Thread thread3 = new HelloThread();
        thread3.start();
        thread3.join();
        System.out.println("Success");

        // todo: use thread pool (executor)
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Future<?> future = newSingleThreadExecutor.submit(new Hello());
        System.out.println("Future " + future.get());

    }

	public static class Hello implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("Hello");
		}

	}

	public static class HelloThread extends Thread {
	    public void run() {
            System.out.println("Hello from Thread");
        }
    }
}
