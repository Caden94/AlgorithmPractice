package multithreading.Thread;

public class HelloWorld {

	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(new Hello());
		thread.start();
		// if we annotate next line, system will print "Success" at first.
		thread.join();
		System.out.println("Success");
	}

	public static class Hello implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("Hello");
		}

	}
}
