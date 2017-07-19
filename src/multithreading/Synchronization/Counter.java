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
public class Counter {
    private int c = 0;

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
            // todo: add happens-before relationships
//            t1.join();
//            t2.join();
            System.out.println(counter.value());
        }
    }

    public void increment() {
        c++;
    }

    public void decrement() {
        c--;
    }

    public int value() {
        return c;
    }

    // synchronized methods.
//    public synchronized void increment() {
//        c++;
//    }
//
//    public synchronized void decrement() {
//        c--;
//    }
//
//    public synchronized int value() {
//        return c;
//    }

}
