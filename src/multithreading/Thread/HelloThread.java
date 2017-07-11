package multithreading.Thread;

public class HelloThread implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("hello world.");
	}
	
	public static void main(String[] args) {
		(new Thread(new HelloThread())).start();
	}
}
