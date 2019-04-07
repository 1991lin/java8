package com.example.streamApi;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @program: java8
 * @author: Eric
 * @create: 2019-04-07 09:30
 **/
public class FunctionInterfaceExample {


    public static void main(String[] arg) {


        Supplier<Integer> supplier = () -> ThreadLocalRandom.current().nextInt();
        System.out.println(supplier.get());



        Consumer<Integer> consumer = (Integer x) -> {
            System.out.println(x);
        };
        consumer.accept(5);



        Function<Integer, Integer> function = integer -> {
            return 100;
        };

        System.out.println(function.apply(99));





        Predicate<Integer> integerPredicate = x -> {
            if (x > 23) {
                return false;
            } else {
                return true;
            }
        };


        System.out.println(integerPredicate.test(22));



        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread");
            }
        });



        thread = new Thread(() -> {
            System.out.println("Thread two");
        });


        thread.start();

    }


}
