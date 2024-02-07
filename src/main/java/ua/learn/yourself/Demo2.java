package ua.learn.yourself;

import java.util.concurrent.TimeUnit;

public class Demo2 {

    private static boolean stopRequested;

    public static void main(String[] args)
            throws InterruptedException {
        //заячі вуха як порахувати к-ть вух без додавання та множення та циклів
        //Jackson розібратися
        System.out.println(Thread.currentThread().getName() + " in main(1)");
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
        stopRequested = true;
    }
}
