package ua.learn.yourself;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

public class Demo3 {
    public static void main(String[] args) {
        new Thread(() -> System.out.println("Hello from " + Thread.currentThread().getName())).start();
        CompletableFuture.runAsync(() -> System.out.println("Hello from " + Thread.currentThread().getName()));
        ForkJoinPool.commonPool().execute(() -> System.out.println("Hello from " + Thread.currentThread().getName()));
        Executors.newCachedThreadPool().execute(() -> System.out.println("Hello from " + Thread.currentThread().getName()));
    }
}
