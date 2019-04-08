package com.example.streamApi;

import com.example.entity.Person;
import com.example.stream.collectors.AgeCollectors;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @program: java8
 * @author: Eric
 * @create: 2019-04-03 21:38
 */
public class CollectionsExample {
    public static void main(String[] arg) {
        List<Person> personList = Lists.newArrayList(new Person("赵", "Shanghai", 21),
                new Person("钱", "Shanghai", 22),
                new Person("孙", "Beijing", 34),
                new Person("李", "Hangzhou", 98));

        // (1)找出在城市在上海的
        for (Person aPersonList : personList) {
            if ("Shanghai".equalsIgnoreCase(aPersonList.getCity())) {
                System.out.println(aPersonList.getName());
            }
        }

        personList.parallelStream()
                .filter(x -> "Shanghai".equalsIgnoreCase(x.getCity()))
                .forEach(y -> System.out.println(y.getName()));

        // (2)计算在上海的而且年龄大于21岁的,输出他的名字
        for (Person person : personList) {
            if ("Shanghai".equalsIgnoreCase(person.getCity()) && (21 < person.getAge())) {
                System.out.println(person.getName());
            }
        }

        // (3)输出在上海的人的年龄的总和
        int shanghai_sum = 0;

        for (int i = 0; i < personList.size(); i++) {
            Person person = personList.get(i);

            if ("Shanghai".equalsIgnoreCase(person.getCity())) {
                shanghai_sum = shanghai_sum + person.getAge();
            }
        }

        System.out.println("在上海的人年龄总和是" + shanghai_sum);

        Map<String, List<Person>> listMap = personList.stream()
                .collect(Collectors
                        .groupingBy(p -> p.getCity()
                        )
                );

        listMap.forEach((x,y) -> {
            System.out.println(x);
            y.forEach(z -> System.out.println(z.getName()));
        });


        Map<Boolean, List<Person>> personLists = personList.stream().collect(
                Collectors.partitioningBy(x -> "Shanghai".equalsIgnoreCase(x.getCity())));




        System.out.println("The Collectors which is defined by ourselves!");

        List<Integer> ageList = Lists.newArrayList(23,4,5,2,67,42);

        ageList.stream().collect(new AgeCollectors()).forEach(System.out::println);




    }
}


//~ Formatted by Jindent --- http://www.jindent.com
