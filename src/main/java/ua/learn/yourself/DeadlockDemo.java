package ua.learn.yourself;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class DeadlockDemo {

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random(100_000_000_0);
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 100_000_000_0; i++) {
            integers.add(random.nextInt());
        }

        /*long start = System.nanoTime();
        List<Integer> sequential = integers.stream().filter(i -> i % 3 == 0).collect(Collectors.toList());
        long finish = System.nanoTime() - start;
        System.out.println(finish);*/

        long start1 = System.nanoTime();
        List<Integer> parallel = integers.stream().parallel().filter(i -> i % 3 == 0).collect(Collectors.toList());
        long finish1 = System.nanoTime() - start1;
        System.out.println(finish1);


    }
}
