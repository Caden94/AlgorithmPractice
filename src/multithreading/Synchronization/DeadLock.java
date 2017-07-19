package multithreading.Synchronization;

public class DeadLock {
    static private Object lock1 = new Object();
    static private Object lock2 = new Object();

    static private class Thread1 extends Thread {
        public void run() {
            synchronized (lock1) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {

                }
                synchronized (lock2) {
                    System.out.println("Thread 1");
                }
            }
        }
    }

    static private class Thread2 extends Thread {
        public void run() {
            synchronized (lock2) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {

                }
                synchronized (lock1) {
                    System.out.println("Thread 2");
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();
        t1.start();
        t2.start();
    }

//	static class Friend {
//		private final String name;
//
//		public Friend(String name) {
//			this.name = name;
//		}
//
//		public String getName() {
//			return this.name;
//		}
//		// synchronized 方法之间互斥，必须等一个方法调用完才能调用其他synchronized的方法
//		public synchronized void bow(Friend bower) {
//			System.out.format("%s: %s" + "  has bowed to me!%n", this.name, bower.getName());
//			// 如果当前是 Alphonse， 则bow方法需要调用Gaston的bowback方法才能结束。
//			// 可是Gaston正在执行bow方法，bowBack不能被其他进程所调用，于是形成deadlock
//			bower.bowBack(this);
//		}
//
//		public synchronized void bowBack(Friend bower) {
//			System.out.format("%s: %s" + " has bowed back to me!%n", this.name, bower.getName());
//		}
//	}
//
//	public static void main(String[] args) {
//		final Friend alphonse = new Friend("Alphonse");
//		final Friend gaston = new Friend("Gaston");
//		new Thread(new Runnable() {
//			public void run() {
//				alphonse.bow(gaston);
//			}
//		}).start();
//		new Thread(new Runnable() {
//			public void run() {
//				gaston.bow(alphonse);
//			}
//		}).start();
//	}
}
