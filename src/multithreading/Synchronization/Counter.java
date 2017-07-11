package multithreading.Synchronization;

public class Counter {
	private int c = 0;

	public void increment() {
		c++;
	}

	public void decrement() {
		c--;
	}

	public int value() {
		return c;
	}

	public static void main(String[] args) throws InterruptedException {
		Counter counter = new Counter();

		for (int i = 0; i < 1000; i++) {
			Thread t1 = new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					counter.increment();
				}
			});

			Thread t2 = new Thread(new Runnable() {
				public void run() {
					counter.decrement();
				}
			});
			t1.start();
			t2.start();
			t1.join();
			t2.join();
			System.out.println(counter.value());
		}
	}
}
