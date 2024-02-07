package ua.learn.yourself;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class DeadLockInExecutorService {
    public static void main(String[] args) {
        Runnable runnableTask = () -> {
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };


        Callable<String> callableTask = () -> {
            TimeUnit.MILLISECONDS.sleep(300);
            return "Task's execution";
        };

    }
}
