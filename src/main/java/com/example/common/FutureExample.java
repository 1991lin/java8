package com.example.common;

import java.util.concurrent.*;

/**
 * @program: java8
 * @author: Eric
 * @create: 2019-04-10 20:29
 **/
public class FutureExample {


    public static void main(String[] arg) throws ExecutionException, InterruptedException, TimeoutException {

        ExecutorService executorService = new ThreadPoolExecutor(2,10,30, TimeUnit.MINUTES,new ArrayBlockingQueue<>(10));
        Future<Integer> result = executorService.submit(() -> doSomething());
        System.out.println(result.get(10,TimeUnit.SECONDS));

    }


    public static Integer doSomething() throws InterruptedException {
        TimeUnit.SECONDS.sleep(7);
        return 666;

    }
}
