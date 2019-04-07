package com.example.streamApi;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @program: java8
 * @author: Eric
 * @create: 2019-04-07 23:19
 **/
public class ParalleStreamExample {


    public static void main(String[] arg){


        List<Integer> list = Lists.newArrayList(1,2,3,4,5,6,7,8,9);

        list.stream().filter(x -> x % 2 ==0)
                .filter(x -> x > 8)
                .forEach(System.out::println);


        list.parallelStream().filter(x -> x % 2 ==0)
                .filter(x -> x > 8)
                .forEach(System.out::println);

    }

}
