package com.example.common;

import com.example.streamApi.ParalleStreamExample;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * @program: java8
 * @author: Eric
 * @create: 2019-04-08 20:16
 **/


@BenchmarkMode({Mode.AverageTime,Mode.Throughput})
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Benchmark)

public class MicroBenchMarkExample {


    public static void main(String[] arg) throws RunnerException {

        Options options = new OptionsBuilder()
                .include(ParalleStreamExample.class.getSimpleName())
                .forks(10)
                .warmupIterations(10)
                .measurementIterations(5)
                .build();



        new Runner(options).run();

    }


}
