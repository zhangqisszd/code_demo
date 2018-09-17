package com.concurrent;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ApplicationTest {

    public static void main(String[] args){
/*
        BigDecimal fee = new BigDecimal("127485");

        System.out.println(fee.toPlainString());

        System.out.println(fee.toString());

        System.out.println(fee.toEngineeringString());

        AtomicInteger atomicInteger = new AtomicInteger(0);

        BigDecimal a = new BigDecimal("7");

        BigDecimal b = new BigDecimal("30");

        *//*BigDecimal d = a.divide(b).setScale(0, BigDecimal.ROUND_HALF_UP);

        System.out.println(d.toEngineeringString());*//*

        String s ="abcd";

        System.out.println(s.toCharArray());

        System.out.println("c".toCharArray());

        System.out.println(s.indexOf("c"));*/

        twoToOn();

    }

    public static void twoToOn(){

        int[] left = new int[]{6,7,8,9};

        int[] right = new int[]{1,2,3};

        int[] temp = new int[left.length+right.length];

        int middle = (left.length+right.length)/2;

        int left_index = 0;

        int right_index = 0;

        int temp_index = 0;

        while (left_index<left.length && right_index<right.length){
           if(left[left_index]<right[right_index]){
               temp[temp_index++] =left[left_index++];
           }
           else {
               temp[temp_index++] = right[right_index++];
           }
        }
        while (left_index<left.length){
            temp[temp_index++] = left[left_index++];
        }
        while (right_index<right.length){
            temp[temp_index++] = right[right_index++];
        }

        for(int i : temp){
            System.out.print(i);
        }


    }
}
