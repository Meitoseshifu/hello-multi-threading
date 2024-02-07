package ua.learn.yourself.test.executorsdemo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorFutureAndCallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        try {
            Future<Integer> futureResult = executorService.submit(() -> 30 + 11);
            System.out.println(futureResult.get());
        } finally {
            executorService.shutdown();
        }
    }
}
