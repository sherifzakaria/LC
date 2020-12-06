package com.leetcode.easy;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int[] result = twoSum(nums, 9);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static int[] twoSum(int[] nums, int target) {

        int[] sums = new int[2];
        outerloop:
        for (int i = 0; i < nums.length; i++) {

            for (int j = 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    sums[0] = i;
                    sums[1] = j;
                    break outerloop;
                }
            }
        }
        return sums;
    }
}
