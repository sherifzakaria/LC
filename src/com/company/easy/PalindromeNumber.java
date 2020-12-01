package com.company.easy;

public class PalindromeNumber {

    public static void main(String[] args) {

        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
        System.out.println(isPalindrome(-101));
    }

    public static boolean isPalindrome(int x) {
        boolean isPalindrome = false;
        if (x >= 0) {
            int reversedInteger = reverseInteger(x);
            if (x == reversedInteger) {
                isPalindrome = true;
            }
        }
        return isPalindrome;
    }

    private static int reverseInteger(int number) {
        int reversed = 0;
        while (number != 0) {
            reversed = (number % 10) + (10 * reversed);
            number /= 10;
        }
        return reversed;
    }
}
