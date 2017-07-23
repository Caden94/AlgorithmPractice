package multithreading.Synchronization;

/*
For each thread
1. Retrieve the current value of c.
2. Increment the retrieved value by 1.
3. Store the incremented value back in c.

Global view
1. Thread A: Retrieve c.
2. Thread B: Retrieve c.
3. Thread A: Increment retrieved value; result is 1.
4. Thread B: Decrement retrieved value; result is -1.
5. Thread A: Store result in c; c is now 1.
6. Thread B: Store result in c; c is now -1.
*/
public class Counter0 {
    // atomic variable
//    private AtomicInteger c = 0;
    private int c = 0;

    public static void main(String[] args) throws InterruptedException {
        Counter0 counter = new Counter0();

        for (int i = 0; i < 1000; i++) {
            Thread t1 = new Thread(() -> counter.increment());

            Thread t2 = new Thread(() -> counter.decrement());
            t1.start();
            t2.start();
            t1.join();
            t2.join();
            // get the value after t1, t2 finished
            System.out.println(counter.value());
        }
    }

//    public void increment() {
//        c++;
//    }
//
//    public void decrement() {
//        c--;
//    }
//
//    public int value() {
//        return c;
//    }

    // synchronized methods.
    public synchronized void increment() {
        c++;
    }

    public synchronized void decrement() {
        c--;
    }

    public synchronized int value() {
        return c;
    }

}
