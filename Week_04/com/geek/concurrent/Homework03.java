package com.geek.concurrent;

import java.util.concurrent.*;

public class Homework03 {

    public static void main(String[] args) throws ExecutionException, InterruptedException, BrokenBarrierException {

        long start = System.currentTimeMillis();
        // 在这里创建一个线程或线程池，
        CyclicBarrier cyclicBarrier = new CyclicBarrier(1, new Runnable() {
            @Override
            public void run() {
                int result = sum();
                System.out.println("异步计算结果为：" + result);
            }
        });
        cyclicBarrier.await();
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
    }

    //future阻塞
    public void method1() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> future = executorService.submit(() -> sum());
        int result = future.get();
        executorService.shutdown();
        System.out.println("异步计算结果为：" + result);
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
    }

    //countDownLatch
    public void method2() throws InterruptedException {
        long start = System.currentTimeMillis();
        CountDownLatch cdl = new CountDownLatch(1);
        new Thread(() -> {
            int result = sum();
            System.out.println("异步计算结果为：" + result);
            cdl.countDown();
        }).start();
        cdl.await();
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
    }

    //CyclicBarrier
    public void method3() throws BrokenBarrierException, InterruptedException {
        long start = System.currentTimeMillis();
        // 在这里创建一个线程或线程池，
        CyclicBarrier cyclicBarrier = new CyclicBarrier(1, new Runnable() {
            @Override
            public void run() {
                int result = sum();
                System.out.println("异步计算结果为：" + result);
            }
        });
        cyclicBarrier.await();
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
    }

    //Thread.currentThread().getThreadGroup()
    public void method4() {
        long start = System.currentTimeMillis();
        // 在这里创建一个线程或线程池，
        new Thread(() -> {
            int result = sum();
            System.out.println("异步计算结果为：" + result);
        }).start();
        if (Thread.currentThread().getThreadGroup().activeCount() == 2) {
            System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
        }
    }


    private static int sum() {
        return fibo(42);
    }

    private static int fibo(int a) {
        if (a < 2)
            return 1;
        return fibo(a - 1) + fibo(a - 2);
    }

}
