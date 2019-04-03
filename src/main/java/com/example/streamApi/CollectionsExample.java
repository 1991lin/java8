package com.example.streamApi;

import com.example.entity.Person;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * @program: java8
 * @author: Eric
 * @create: 2019-04-03 21:38
 **/
public class CollectionsExample {


    public static void main(String[] arg) {

        List<Person> personList = Lists.newArrayList(
                new Person("赵", "shanghai", 21),
                new Person("钱", "Shanghai", 22),
                new Person("孙", "Beijing", 34),
                new Person("李", "Hangzhou", 98)
        );


        //(1)找出在城市在上海的
        for (int i = 0; i < personList.size(); i++) {
            if ("Shanghai".equalsIgnoreCase(personList.get(i).getCity())) {
                System.out.println(personList.get(i).getName());
            }
        }


        personList
                .parallelStream()
                .filter(x -> "Shanghai".equalsIgnoreCase(x.getCity()))
                .forEach(y -> System.out.println(y.getName()));





        //(2)计算在上海的而且年龄大于21岁的,输出他的名字
        for (int i = 0; i < personList.size(); i++) {
            Person person = personList.get(i);
            if ("Shanghai".equalsIgnoreCase(person.getCity()) && 21 < person.getAge()) {
                System.out.println(person.getName());
            }
        }


        //(3)输出在上海的人的年龄的总和
        int shanghai_sum = 0;
        for (int i = 0; i < personList.size(); i++) {
            Person person = personList.get(i);
            if ("Shanghai".equalsIgnoreCase(person.getCity())) {
                shanghai_sum = shanghai_sum + person.getAge();
            }
        }

        System.out.println("在上海的人年龄总和是" + shanghai_sum);


    }

}
