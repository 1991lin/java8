package com.example.common;

import com.example.entity.Car;

import java.util.Optional;

/**
 * @program: java8
 * @author: Eric
 * @create: 2019-04-09 21:55
 **/
public class OptionalExample {


    private static class OptionalTest {
        private String name;
        private String password;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }


    private static class OptionalTestTwo {
        private Optional<Car> car;


        public OptionalTestTwo(Optional<Car> car) {
            this.car = car;
        }

        public Optional<Car> getCar() {
            return car;
        }

        public void setCar(Optional<Car> car) {
            this.car = car;
        }
    }

    public static void main(String[] arg) {

//        OptionalTest optionalTest = new OptionalTest();
//
//        System.out.println("The name is : " + optionalTest.getName().toUpperCase());

        Car car = new Car();

        OptionalTestTwo two = new OptionalTestTwo(Optional.ofNullable(car));

        int number = Optional.ofNullable(two)
                .flatMap(OptionalTestTwo::getCar)
                .map(x -> x.getCarNumber())
                .orElse(12);
        System.out.println(number);


    }
}


