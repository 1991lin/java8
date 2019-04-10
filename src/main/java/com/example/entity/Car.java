package com.example.entity;

import java.util.Optional;

/**
 * @program: java8
 * @author: Eric
 * @create: 2019-04-09 22:13
 **/
public class Car {


    private Integer carNumber;
    private Optional<CarFactory> carFactory;

    public Integer getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(Integer carNumber) {
        this.carNumber = carNumber;
    }

    public Optional<CarFactory> getCarFactory() {
        return carFactory;
    }

    public void setCarFactory(Optional<CarFactory> carFactory) {
        this.carFactory = carFactory;
    }
}
