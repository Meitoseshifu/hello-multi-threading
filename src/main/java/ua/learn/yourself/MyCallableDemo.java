package ua.learn.yourself;

public class MyCallableDemo {
    public static void main(String[] args) throws Exception {
        MyCallable callable = new MyCallable();
        System.out.println(callable.call());
    }
}
