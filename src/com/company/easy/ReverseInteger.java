package com.company.easy;

public class ReverseInteger {
    public static void main(String[] args) {

//        int result = reverse(9646324351L);
//        System.out.println(result);
        int result = enhancedReverse(123);
        System.out.println(result);
    }

    public static int reverse(long x) {
        String numString = String.valueOf(x);
        StringBuilder reverseString = new StringBuilder();
        int result = 0;

        for (int i = numString.length() - 1; i >= 0; i--) {
            if (numString.charAt(i) == '-') {
                reverseString.insert(0, '-');
            } else {
                reverseString.append(numString.charAt(i));
            }
        }

        try {
            result = Integer.parseInt(reverseString.toString());
        } catch (NumberFormatException ignored) {
        }
        return result;
    }

    public static int enhancedReverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;

            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }

            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
