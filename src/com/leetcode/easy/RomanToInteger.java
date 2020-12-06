package com.leetcode.easy;

import java.util.Map;

public class RomanToInteger {

    private static Map<Character, Integer> romans = Map.of('I', 1, 'V', 5, 'X', 10,
            'L', 50, 'C', 100, 'D', 500, 'M', 1000);

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("IX"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        int total = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            int num1 = romans.get(s.charAt(i));
            int num2 = romans.get(s.charAt(i + 1));

            if (num1 < num2) {
                total -= num1;
            } else {
                total += num1;
            }
        }
        total += romans.get(s.charAt(s.length() - 1));

        return total;
    }
}
