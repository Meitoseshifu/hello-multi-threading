package ua.learn.yourself;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class MJinActionDemo {
    public static void main(String[] args) {
        long[] numbers = LongStream.rangeClosed(1, 10).toArray();
        ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Long result = forkJoinPool.invoke(task);
        System.out.println(result);
    }
}
