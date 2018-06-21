package com.code.demo.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 输入链表的第一个节点，从尾到头反过来打印出每个结点的值。
 */
public class PrintLinkReverse {

    public static void main(String[] args){


    }

    /**
     * 使用栈
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead(LinkedList<Integer> listNode) {
        Stack<Integer> stack = new Stack<Integer>();
        while (listNode.peek() != null) {
            stack.add(listNode.poll());
        }
        ArrayList<Integer> ret = new ArrayList<Integer>();
        while (!stack.isEmpty()) {
            ret.add(stack.pop());
        }
        return ret;
    }
}
