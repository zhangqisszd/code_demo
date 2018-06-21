package com.code.demo.algorithm;

/**
 * {6,-3,-2,7,-15,1,2,2}，连续子数组的最大和为 8（从第 0 个开始，到第 3 个为止）。
 */
public class FindGreatestSumOfSubArray {

    public static void main(String[] args){

        int[] nums = {6,-3,-2,7,-15,1,2,-1,7,8,9};

        FindGreatestSumOfSubArray fs = new FindGreatestSumOfSubArray();

        int maxSum  =  fs.FindGreatestSumOfSubArray(nums);

        System.out.println(maxSum);
    }

    public int FindGreatestSumOfSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int ret = Integer.MIN_VALUE;
        int sum = 0;
        for (int val : nums) {
            sum = sum <= 0 ? val : sum + val;
            ret = Math.max(ret, sum);
        }
        return ret;
    }
}
