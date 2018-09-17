package com.concurrent;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

public class ForkJoin extends RecursiveTask<Long> {

    private Long start;
    private Long end;

    private static final Long critical = 5l;

    public ForkJoin(Long start,Long end){
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {

        Long length = end-start;
        if(length<=critical){
            Long sum = 0L;
            for(Long i =start;i<=end;i++){
                System.out.println(Thread.currentThread().getName()+" "+i);
                sum += i;
            }
            return sum;
        }
        else {
            Long middle = (end+start)/2;
            ForkJoin left = new ForkJoin(start,middle);
            left.fork();
            ForkJoin right = new ForkJoin(middle+1,end);
            right.fork();
            return left.join()+right.join();
        }

    }

    public static void main(String[] args){

        long l = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> forkJoin = new ForkJoin(0L,6l);
        Long result = forkJoinPool.invoke(forkJoin);

        long e = System.currentTimeMillis();
        System.out.println((e-l)+": "+result);

        l = System.currentTimeMillis();
        result = LongStream.rangeClosed(0l,6l).parallel().reduce(0,Long::sum);
        e = System.currentTimeMillis();
        System.out.println((e-l)+": "+result);
    }
}
