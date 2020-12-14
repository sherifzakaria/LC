package com.leetcode.easy;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1, 1, 2}));
        System.out.println(removeDuplicates(new int[]{1, 1, 2, 3, 4}));
        System.out.println(removeDuplicates(new int[]{1, 1, 1, 2, 2, 3, 3, 4}));
        System.out.println(removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
        System.out.println("********************************");
        System.out.println(enhancedRemoveDuplicates(new int[]{1, 1, 2}));
        System.out.println(enhancedRemoveDuplicates(new int[]{1, 1, 2, 3, 4}));
        System.out.println(enhancedRemoveDuplicates(new int[]{1, 1, 1, 2, 2, 3, 3, 4}));
        System.out.println(enhancedRemoveDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }

    public static int enhancedRemoveDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int i = 0;

        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }

    public static int removeDuplicates(int[] nums) {
        int count = (int) Arrays.stream(nums).distinct().count();

        int count1 = 0;
        for (int i = 1; i < nums.length - 1 && count1 < count - 1; i++) {
            while (nums[i] == nums[i - 1]) {
                leftShiftArr(nums, i);
            }
            count1++;
        }

        for (int i = 0; i < count; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();

        return count;
    }

    private static int[] leftShiftArr(int[] nums, int startingIndex) {
        for (int i = startingIndex; i < nums.length - 1; i++) {
            nums[i] = nums[i + 1];
        }
        return nums;
    }
}
