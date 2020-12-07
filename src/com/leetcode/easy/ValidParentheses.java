package com.leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    private Map<Character, Character> mappings;

    public ValidParentheses() {
        mappings = new HashMap<>();
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');
    }

    public static void main(String[] args) {

        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[]}"));
        System.out.println(isValid("((("));
        System.out.println(isValid("([]"));

        System.out.println("************ Enhanced Way *************");

        ValidParentheses obj1 = new ValidParentheses();
        System.out.println(obj1.isValidEnhanced("()"));
        System.out.println(obj1.isValidEnhanced("()[]{}"));
        System.out.println(obj1.isValidEnhanced("(]"));
        System.out.println(obj1.isValidEnhanced("([)]"));
        System.out.println(obj1.isValidEnhanced("{[]}"));
        System.out.println(obj1.isValidEnhanced("((("));
        System.out.println(obj1.isValidEnhanced("([]"));
        System.out.println(obj1.isValidEnhanced("(]"));
    }

    public boolean isValidEnhanced(String s) {
        boolean isValidParentheses = true;

        Stack<Character> parentheses = new Stack<>();

        int index = 0;
        while (index < s.length() && isValidParentheses) {
            if (mappings.containsKey(s.charAt(index))) {
                char topElement = parentheses.isEmpty() ? '#' : parentheses.pop();

                if (topElement != mappings.get(s.charAt(index))) {
                    isValidParentheses = false;
                }
            } else {
                parentheses.push(s.charAt(index));
            }
            index++;
        }

        if (!parentheses.isEmpty()) {
            isValidParentheses = false;
        }
        return isValidParentheses;
    }

    public static boolean isValid(String s) {
        boolean isValidParentheses = true;

        Stack<Character> parentheses = new Stack<>();
        int stackPointer = 0;
        int index = 0;
        while (index < s.length() && isValidParentheses) {
            switch (s.charAt(index)) {
                case '(':
                case '{':
                case '[':
                    if (index == s.length() - 1) {
                        isValidParentheses = false;
                    } else {
                        parentheses.push(s.charAt(index));
                        stackPointer++;
                        index++;
                    }
                    break;
                case ')':
                    if (parentheses.size() > 0 && parentheses.elementAt(stackPointer - 1) == '(') {
                        parentheses.pop();
                        stackPointer--;
                        index++;
                    } else {
                        isValidParentheses = false;
                    }
                    break;
                case '}':
                    if (parentheses.size() > 0 && parentheses.elementAt(stackPointer - 1) == '{') {
                        parentheses.pop();
                        stackPointer--;
                        index++;
                    } else {
                        isValidParentheses = false;
                    }
                    break;
                case ']':
                    if (parentheses.size() > 0 && parentheses.elementAt(stackPointer - 1) == '[') {
                        parentheses.pop();
                        stackPointer--;
                        index++;
                    } else {
                        isValidParentheses = false;
                    }
                    break;
            }
        }

        isValidParentheses = stackPointer == 0;

        return isValidParentheses;
    }
}
