package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @program: java8
 * @author: Eric
 * @create: 2019-04-03 21:35
 **/


@Data
@AllArgsConstructor
public class Person {

    private String name;
    private String city;
    private int age;

}
