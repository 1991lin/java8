package com.example.streamApi;

import com.google.common.collect.Lists;
import org.openjdk.jmh.annotations.Benchmark;

import java.util.List;

/**
 * @program: java8
 * @author: Eric
 * @create: 2019-04-07 23:19
 **/
public class ParalleStreamExample {


    public static List<Integer> list = Lists.newArrayList(1,2,3,4,5,6,7,8,91,2,3,4,4,4,4,4,4,6);



    @Benchmark
    public static void testParallel(){
        list.parallelStream().filter(x -> x % 2 ==0)
                .filter(x -> x > 8)
                .forEach(System.out::println);
    }


    @Benchmark
    public static void testSequence(){
        list.stream().filter(x -> x % 2 ==0)
                .filter(x -> x > 8)
                .forEach(System.out::println);
    }





    public static void testSequenceModel(){

    }

    public static void testParellelModel(){

    }

}
