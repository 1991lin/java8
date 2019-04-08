package com.example.common;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @program: java8
 * @author: Eric
 * @create: 2019-04-08 23:52
 **/
public class ForkJoinPoolExample extends RecursiveTask<Integer> {


    private List<Integer> list;
    private int start;
    private int end;
    private final static int threshold = 4;

    public ForkJoinPoolExample(List<Integer> data) {
        this(data, 0, data.size());
    }

    public ForkJoinPoolExample(List<Integer> data, int start, int end) {
        this.list = data;
        this.start = start;
        this.end = end;

    }


    @Override
    protected Integer compute() {
        int len = end - start;
        //阀值
        if (len <= threshold) {
            return computerSequentially();
        }

        ForkJoinPoolExample left = new ForkJoinPoolExample(list, start, start + len / 2);
        left.fork();

        ForkJoinPoolExample right = new ForkJoinPoolExample(list, start + len / 2, end);
        right.fork();
        return left.join() + right.join();

    }


    public Integer computerSequentially() {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum = sum + list.get(i);
        }
        return sum;
    }


    public static void main(String[] arg) {

        ForkJoinPool forkJoinPool = new ForkJoinPool();

        List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6);

        ForkJoinPoolExample forkJoinPoolExample = new ForkJoinPoolExample(list);

        Integer sum = forkJoinPool.invoke(forkJoinPoolExample);

        System.out.println("The sum is " + sum);


    }
}
