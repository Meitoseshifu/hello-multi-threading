package ua.learn.yourself;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

public class Demo {
    @SneakyThrows
    public static void main(String[] args) {
        Thread newState = new Thread(System::nanoTime);
        System.out.println(newState.getState());
        newState.interrupt();

        Thread runnableState = new Thread(System::nanoTime);
        runnableState.start();
        System.out.println(runnableState.getState());

        Thread waitingState = Thread.currentThread();
        Object mimicSharedResource = new Object();
        Thread waitingHelper = new Thread(() -> {
            synchronized (mimicSharedResource) {
                System.out.println(waitingState.getState());
                mimicSharedResource.notify();
            }
        });
        synchronized (mimicSharedResource) {
            waitingHelper.start();
            mimicSharedResource.wait();
        }

        Runnable mimicBlocked = Demo::blockMePlz;
        Thread blockedHelper = new Thread(mimicBlocked);
        Thread blockedState = new Thread(mimicBlocked);
        blockedHelper.start();
        blockedState.start();
        sleep(2L);
        System.out.println(blockedState.getState());

        Runnable timedWaitingHelper = () -> sleep(2L);
        Thread timedWaitingState = new Thread(timedWaitingHelper);
        timedWaitingState.start();
        sleep(1L);
        System.out.println(timedWaitingState.getState());

        Thread terminatedState = new Thread(System::nanoTime);
        terminatedState.start();
        sleep(1L);
        System.out.println(terminatedState.getState());

        System.exit(0);
    }

    private static void sleep(long sec) {
        try {
            TimeUnit.SECONDS.sleep(sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static synchronized void blockMePlz() {
        while (true) {}
    }

}
