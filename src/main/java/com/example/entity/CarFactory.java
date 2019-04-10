package com.example.entity;

import java.util.Optional;

/**
 * @program: java8
 * @author: Eric
 * @create: 2019-04-09 22:15
 **/
public class CarFactory {

    private Optional<String> location;
    private String name;

    public Optional<String> getLocation() {
        return location;
    }

    public void setLocation(Optional<String> location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
