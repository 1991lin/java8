package com.example.stream.collectors;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;

import static java.util.stream.Collector.Characteristics.IDENTITY_FINISH;

/**
 * @program: java8
 * @author: Eric
 * @create: 2019-04-06 18:09
 **/

/**
 * 收集年龄大于超过23的人，最终返回值是这些人的年龄总和
 */
public class AgeCollectors implements Collector<Integer, List<Integer>, List<Integer>> {



    public Predicate<Integer> isBiggerThan(Integer y){
            return integer -> y > 23;
    }




    @Override
    public Supplier<List<Integer>> supplier() {
        return () -> new ArrayList<Integer>();
    }

    @Override
    public BiConsumer<List<Integer>, Integer> accumulator() {
        return (List<Integer> list, Integer ele) -> {
            if(isBiggerThan(ele).test(ele)){
                list.add(ele);
            }
        };
    }

    @Override
    public BinaryOperator<List<Integer>> combiner() {
        return (List<Integer> x ,List<Integer> y) -> {
            x.addAll(y);
            return x;
        };
    }

    @Override
    public Function<List<Integer>, List<Integer>> finisher() {
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {

        return Collections.unmodifiableSet(EnumSet.of(IDENTITY_FINISH));
    }
}
