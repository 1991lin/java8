package com.example.streamApi;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @program: java8
 * @author: Eric
 * @create: 2019-04-07 11:25
 **/
public class LambadaExample {

    public static void main(String[] arg){

        List<Integer> integers = Lists.newArrayList(1,2,3,4,5,6);

        //命令式
        for(Integer integer : integers){
            if (integer % 2 ==0){
                System.out.println(integer);
            }
        }

        //Stream
        integers.stream().filter(x -> x % 2 ==0).forEach(System.out::println);




    }
}
