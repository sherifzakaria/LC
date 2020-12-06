package com.leetcode.easy;

import java.util.Arrays;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        System.out.println(longestCommonPrefix(new String[]{}));
        System.out.println(longestCommonPrefix(new String[]{"a"}));
        System.out.println(longestCommonPrefix(new String[]{"ab", "a"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder prefix = new StringBuilder("");
        boolean isPrefixable = true;
        int endCharIndex = -1;
        Arrays.sort(strs);

        if (strs.length > 0) {
            outer:
            for (int i = 0; i < strs[0].length(); i++) {
                for (int j = 1; j < strs.length; j++) {

                    if (strs[0].charAt(i) != strs[j].charAt(i)) {
                        break outer;
                    }
                }
                endCharIndex++;
                prefix.append(strs[0].charAt(endCharIndex));
            }
        }
        return prefix.toString();
    }
}



