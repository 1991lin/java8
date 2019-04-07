package com.example.streamApi;

import com.google.common.collect.Lists;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @program: java8
 * @author: Eric
 * @create: 2019-04-03 23:16
 **/
public class StreamExample {


    public static void main(String[] arg) throws IOException {
        List<Integer> integers = Lists.newArrayList(
                1, 2, 3, 4, 5, 6, 2, 3, 4
        );


        List<String> StringList = Lists.newArrayList(
                "o n e", "t w o", "t h r e e", "f o u r l l l", "f i v e"
        );


        Stream.of(1, 2, 3, 4, 5).forEach(System.out::println);


        integers.parallelStream()
                .filter(x -> x % 2 == 0) //很明显，取偶数
                .distinct()//不重复
                .forEach(System.out::println);


        integers.parallelStream()
                .limit(2)
                .forEach(System.out::println);


        System.out.println("------------");
        integers.stream()
                .skip(3)
                .forEach(System.out::println);

        StringList.stream().map(x -> x.toString().length()).forEach(System.out::println);

        //输出每一个字符

        StringList.stream().map(x -> x.split(" "))
                .flatMap(Arrays::stream)
                .distinct()
                .forEach(System.out::println);


        System.out.println(integers.parallelStream()
                .filter(x -> x > 1000)
                .findAny().orElse(1000));


        int value = integers.stream().reduce(0, (a, b) -> a + b);

        //int value = integers.stream().reduce(0 , Integer::sum);
        System.out.println("Sum is " + value);


        try (Stream<String> lines = Files.lines(Paths.get("//Users//eric//IdeaProjects//java8//pom.xml"))) {

            lines
                    .flatMap(y -> Arrays.stream(y.split(" ")))
                    .distinct()
                    .count();

        }
        ;


        System.out.println("Collection -----------");

//        Set<Integer> integerDouble = integers.stream()
//                .map(x -> x * 2)
//                .collect(Collectors.toSet());
//
//        integers.stream()
//                .collect(Collectors.toSet())
//                .forEach(x -> System.out.println(x*2));




//        System.out.println(integers.stream()
//                .collect(Collectors.counting()).intValue());


        StringList.stream().collect(Collectors.maxBy(
                (Comparator<String>) (o1, o2) -> {
                    int o1_lengh = o1.split(" ").length;
                    int o2_lengh = o2.split(" ").length;
                    if (o1_lengh > o2_lengh) {
                        return 1;
                    } else if (o1_lengh == o2_lengh){
                        return 0;
                    }else {
                        return -1;
                    }
                }
        )).ifPresent(s -> System.out.println(s));




    }
}
