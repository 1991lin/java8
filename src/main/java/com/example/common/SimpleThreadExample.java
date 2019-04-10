package com.example.common;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @program: java8
 * @author: Eric
 * @create: 2019-04-09 01:22
 **/
public class SimpleThreadExample {


    private static Logger logger = Logger.getLogger(SimpleThreadExample.class.getSimpleName());

    public static void main(String[] arg){

        //匿名内部类
        Thread one = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Testing");

                if (logger.isLoggable(Level.WARNING)){
                    logger.warning("Testig");
                }


                logger.warning(()->"Testing");
            }
        });

        //Lambada
        Thread two = new Thread(() -> System.out.println("Testing"));

        ArrayList<Integer> integers = Lists.newArrayList(1,2,3,4,5,6);


        System.out.println("---------------我是分割线---------------");

        integers.stream().peek(System.out::println)
                .filter(x -> x % 2 ==0)
                .peek(System.out::println)
                .map(x -> x + 1)
                .forEach(System.out::println);



    }
}
