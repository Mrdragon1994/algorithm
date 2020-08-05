package com.algorithm.stack;

import java.util.Stack;

/**
 * 问题描述:
 * 在给定的一个字符串中,只包含()[]四种,请判定给定的字符串是否能够匹配出多个成对的组合,是返回true,不是返回false
 */
public class SimlpleBracketMatch {
    public static void main(String[] args) {
        String str1 = "[(])";
        String str2 = "(])";
        String str3 = "([[]()])";
        String str4 = "(((([[]]))))";
        System.out.println(test(str4));
    }

    public static String test(String string) {
        char[] param = string.toCharArray();
        //存放元素的集合
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < param.length; i++) {
            if (stack.isEmpty()) { //栈空则入
                stack.push(param[i]);
            } else { //栈不空则进行匹配
                if (!get(stack, param[i])) {
                    stack.push(param[i]);
                }

            }
        }
        if (stack.isEmpty()) {
            return "Yes";
        } else {
            return "No";
        }
    }

    public static boolean get(Stack stack, Character character) {
        if (character.equals('[') || character.equals('(')) {
            return false;
        } else {
            if (character.equals(')') && stack.peek().equals('(')) {
                stack.pop();
                return true;
            } else if (character.equals(']') && stack.peek().equals('[')) {
                stack.pop();
                return true;
            } else {
                return false;
            }
        }
    }
}
