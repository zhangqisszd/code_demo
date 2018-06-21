package com.code.demo.algorithm;

/**
 * 输入数字 n，按顺序打印出从 1 最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数即 999。
 */
public class Print1ToMaxOfNDigits {

    public static void main(String[] args){

        Print1ToMaxOfNDigits print1ToMaxOfNDigits = new Print1ToMaxOfNDigits();

        print1ToMaxOfNDigits.print1ToMaxOfNDigits(2);
    }

    public void print1ToMaxOfNDigits(int n) {
        if (n <= 0)
            return;
        char[] number = new char[n];  // char[2]
        print1ToMaxOfNDigits(number, -1);
    }

    private void print1ToMaxOfNDigits(char[] number, int digit) {
        if (digit == number.length - 1) {  // char[2],-1  number长度为0结束 0-1==-1
            printNumber(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[digit + 1] = (char) (i + '0');  // number[-1+1] = number[0] = 0-9
            print1ToMaxOfNDigits(number, digit + 1);
        }
    }

    private void printNumber(char[] number) {
        int index = 0;
        while (index < number.length && number[index] == '0')
            index++;
        while (index < number.length)
            System.out.print(number[index++]);
        System.out.println();
    }
}
