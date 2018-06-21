package com.concurrent;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchApplication {

    public static void main(String[] args){
        final CountDownLatch countDownLatch = new CountDownLatch(2);

        try {
            new Writer(countDownLatch).start();
            new Writer(countDownLatch).start();
            System.out.println("等待2个子线程执行完毕...");
            countDownLatch.await();
            System.out.println("2个子线程已经执行完毕");
            System.out.println("继续执行主线程");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    static class Writer extends Thread{

        private CountDownLatch countDownLatch;

        public Writer(CountDownLatch countDownLatch){
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            try{

                System.out.println("线程"+Thread.currentThread().getName()+".....");
                Thread.sleep(3000);
                System.out.println("线程"+Thread.currentThread().getName()+"is ok");
                countDownLatch.countDown();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
