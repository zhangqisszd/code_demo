package com.code.demo.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。例如，如果输入长度为 7 的数组 {2, 3, 1, 0, 2, 5, 3}，
 * 那么对应的输出是第一个重复的数字 2。
 * 要求复杂度为 O(N) + O(1)，时间复杂度 O(N)，空间复杂度 O(1)。因此不能使用排序的方法，也不能使用额外的标记数组。
 *
 */
public class RepeatNumber {


    /**
     * 思路
     * 这种数组元素在 [0, n-1] 范围内的问题，可以将值为 i 的元素放到第 i 个位置上。
     *
     * position-0 : (2,3,1,0,2,5) // 2 <-> 1              nums[0](2) != 1 值为2的元素与第2个位置上的元素不相同
     *              (1,3,2,0,2,5) // 1 <-> 3              nums[0](1) != 3 值为1的元素与第1个位置上的元素不相同
     *              (3,1,2,0,2,5) // 3 <-> 0              nums[0](3) != 0 值为3的元素与第3个位置上的元素不相同
     *              (0,1,2,3,2,5) // already in position  nums[0](0) = 0  值为0的元素与第0个位置上的元素相同
     * position-1 : (0,1,2,3,2,5) // already in position  nums[1](1) = 1  值为1的元素与第1个位置上的元素相同
     * position-2 : (0,1,2,3,2,5) // already in position  nums[2](2) = 2  值为2的元素与第2个位置上的元素相同
     * position-3 : (0,1,2,3,2,5) // already in position  nums[3](3) = 3  值为3的元素与第3个位置上的元素相同
     * position-4 : (0,1,2,3,2,5) // nums[i] == nums[nums[i]], exit nums[4](2) == nums[2](2)
     *
     */
    public static void main(String[] args){

        int[] nums = {2,3,1,0,2,5};

        RepeatNumber repeatNumber = new RepeatNumber();

        repeatNumber.duplicate(nums);
    }
    public void  duplicate(int[] nums) {
        if (nums == null || nums.length <= 0) {
            System.out.println("无重复");
        }

        List duplication = new ArrayList<Integer>();

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i && nums[i] != nums[nums[i]]) {
                swap(nums, i, nums[i]);
            }
            if (nums[i] != i && nums[i] == nums[nums[i]]) {
                duplication.add(nums[i]);
            }
        }
        System.out.println(nums.toString());
        System.out.println(duplication);

    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i]; nums[i] = nums[j]; nums[j] = t;
    }
}
