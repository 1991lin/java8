package com.example.async;

import com.google.common.collect.Lists;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.RunnerException;

import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * @program: java8
 * @author: Eric
 * @create: 2019-04-10 21:17
 **/

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.SECONDS)
@Warmup(iterations = 5)
public class PriceService {


    /**
     * get the product price in synchronized way
     *
     * @param product
     * @return
     * @throws InterruptedException
     */
    public double getPrice(String product) {
        return calculatePrice(product);
    }


    /**
     * calculate the price.
     *
     * @param price
     * @return
     * @throws InterruptedException
     */
    public double calculatePrice(String price) {
        try {
            delay();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Random(100).nextDouble() * 100;
    }

    /**
     * get the product price in the asynchronized way
     *
     * @param product
     * @return
     */
    public CompletableFuture<Double> getPriceAsync(String product) {
        //we can refactor above code to below
        CompletableFuture<Double> future = CompletableFuture.supplyAsync(() -> {
            return calculatePrice(product);
        }, new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(), 4, 30, TimeUnit.MINUTES, new ArrayBlockingQueue<>(10), new ThreadPoolExecutor.CallerRunsPolicy()));
        return future;
    }


    /**
     * simulate the operation
     *
     * @throws InterruptedException
     */
    public void delay() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
    }


    /**
     * get the latest discount info
     *
     * @param product
     * @return
     */
    public double getLatestDiscountInfo(String product) throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        return new Random(100).nextDouble();
    }

    public static void main(String[] arg) throws InterruptedException, TimeoutException, ExecutionException, RunnerException {

//        Options options = new OptionsBuilder().include(PriceService.class.getSimpleName())
//                .shouldDoGC(true)
//                .build();
//        new Runner(options).run();

        testCombine();


    }

    @Benchmark
    public void testSyn() throws InterruptedException {
        String product = "xiangjiao";
        PriceService priceService = new PriceService();
        double price = priceService.calculatePrice(product);
        double discount = priceService.getLatestDiscountInfo(product);
    }

    @Benchmark
    public void testAsync() throws InterruptedException, TimeoutException, ExecutionException {
        String product = "xiangjiao";
        PriceService priceService = new PriceService();
        CompletableFuture<Double> futurePrice = priceService.getPriceAsync(product);
        double discountInfo = priceService.getLatestDiscountInfo(product);
        double priceAsyn = futurePrice.get(10, TimeUnit.SECONDS);
    }


    public static void testMoreQuest() {

        int requestNumber = 4;
        List<String> productList = Lists.newArrayList("apple", "orange", "pear", "grape");
        PriceService priceService = new PriceService();


        List<CompletableFuture> list = productList.parallelStream()
                .map(product -> priceService.getPriceAsync(product))
                .collect(Collectors.toList());


        list.stream().map(CompletableFuture::join).collect(Collectors.toList());


    }

    public static void testCombine() throws ExecutionException, InterruptedException {

        PriceService priceService = new PriceService();

        Future<Double> future = CompletableFuture.supplyAsync(() -> {
            return priceService.getPrice("apple");
        }).thenCombine(CompletableFuture.supplyAsync(() -> {
                    return priceService.getPrice("Grape");
                }
        ), (priceOne, priceTwo) -> priceOne + priceTwo);


        System.out.println("The sum of the price of  apple and Grade is" + future.get());


    }


}
