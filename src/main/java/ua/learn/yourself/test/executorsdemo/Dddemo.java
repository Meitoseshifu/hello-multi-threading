package ua.learn.yourself.test.executorsdemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Dddemo {
    public static void main(String[] args) {
        Runnable printInventory = () -> System.out.println("Printing zoo inventory");
        Runnable printRecords = () -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("Printing recors: " + i);
            }
        };

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        try {
            System.out.println("begin");
            executorService.execute(printInventory);

            Future<?> future = executorService.submit(() -> "Hello");

            executorService.execute(printRecords);
            executorService.execute(printInventory);
            System.out.println("end");
        } finally {
            executorService.shutdown();
        }
    }
}
