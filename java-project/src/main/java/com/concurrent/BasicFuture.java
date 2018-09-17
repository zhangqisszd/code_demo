package com.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class BasicFuture {


    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Integer> f = executorService.submit(()->{

            return 10;
        });


        System.out.println(f.get());
    }
}
