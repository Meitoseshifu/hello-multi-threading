package ua.learn.yourself;

//todo question

/**
 * 1. The synchronized keyword ensures that only a single thread can execute a method
 *    or block at one time. Many programmers think of synchronization solely as a
 *    means of mutual exclusion, to prevent an object from being seen in an inconsistent
 *    state by one thread while it’s being modified by another. READ
 * 2. This view is correct, but it’s only half the story. Without synchronization, one
 *    thread’s changes might not be visible to other threads. Not only does synchroniza-
 *    tion prevent threads from observing an object in an inconsistent state, but it
 *    ensures that each thread entering a synchronized method or block sees the effects
 *    of all previous modifications that were guarded by the same lock. WRITE
 */
public class BlochDemo {
    private static boolean stopRequested;
    public static void main(String[] args) throws InterruptedException {
        /*System.out.println(Thread.currentThread().getName() + " in main(1)");
        Thread backgroundThread = new Thread(() -> {
            int i = 0;
            while (!stopRequested) {
                if (i==0) {
                    System.out.println(Thread.currentThread().getName() + " in run()"); //WTF?!!!
                }
                i++;
            }
            System.out.println(i);
        });
        backgroundThread.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println(Thread.currentThread().getName() + " in main(2)");
        stopRequested = true;*/
        Thread t1 = new Thread(() -> {
            while (nextSerialNumber != 100) {
                System.out.println(generateSerialNumber());
            }
        });
        Thread t2 = new Thread(() -> {
            while (nextSerialNumber != 100) {
                System.out.println(generateSerialNumber());
            }
        });
        t1.start();
        t2.start();

    }

    private static volatile int nextSerialNumber = 0;

    public static int generateSerialNumber() {
        return nextSerialNumber++;
    }


}
