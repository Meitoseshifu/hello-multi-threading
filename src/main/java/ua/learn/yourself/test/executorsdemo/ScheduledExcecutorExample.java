package ua.learn.yourself.test.executorsdemo;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledExcecutorExample {
    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();

        Runnable runnableTask = () -> System.out.println("Runnable task");
        Callable<String> callableTask = () -> "Callable Task";

        ScheduledFuture<?> r1 = service.schedule(runnableTask, 10, TimeUnit.SECONDS);
        ScheduledFuture<?> r2 = service.schedule(callableTask, 8, TimeUnit.MINUTES);

        service.scheduleAtFixedRate(runnableTask, 5, 1, TimeUnit.MINUTES);
        service.scheduleWithFixedDelay(runnableTask, 0, 2, TimeUnit.MINUTES);


    }
}
