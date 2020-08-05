package com.algorithm.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目描述:
 * 在所给的字符串中,只包含()[]{}6种括号,但其顺序杂乱随意,需要判定给定的字符串是否可以找到几对能够匹配完整的子字符串,成功返回true,失败返回false
 * 如：
 */
public class MatchBracketSubstring {
    public static void main(String[] args) {
        String str = "(){}[]"; //Yes
        String str1 = "{}({)}([)"; //Yes
        String str2 = "{(}]"; //No
        String str3 = "({)[}))[]"; //Yes
        String str4 = "([(])(][)}[]"; //Yes
        String str5 = "([(]){(][)}]()"; //Yes
        String str6 = "([)[)]"; //Yes
        String str7 = "([)[)"; //Yes
        String str8 = "([)]{){}";
        System.out.println(test(str2));
    }

    public static String test(String string) {
        char[] chars = string.toCharArray();
        List<Character> list = new ArrayList<>();
        for (Character character : chars) {
            list.add(character);
        }
        //如果给定的序列首尾直接能够匹配了,那么直接返回true
        if ((list.get(0).equals('(') && list.get(list.size() - 1).equals(')')) ||
                (list.get(0).equals('[') && list.get(list.size() - 1).equals(']')) ||
                (list.get(0).equals('{') && list.get(list.size() - 1).equals('}'))) {
            return "Yes";
        } else { //对于首尾不能直接匹配,那么就需要额外进行判定
            //对于剩余子字符串还有多组而言,需要进一步判定
            if (recursion(list)) {
                return "Yes";
            } else {
                return "No";
            }
        }

    }


    /**
     *
     * @param list 当前需判定的集合
     * @return 是否能匹配成功
     */
    public static boolean recursion(List list) {
        List list1 = null;
        if (list.size() == 0) { //如果在递归过程中,list是被截取后的集合,其长度为0,说明前面的序列都匹配成功了
            return true;
        } else {
            List<Integer> temp = new ArrayList<>(); //用来记录可能匹配到的下标的位置
            for (int t = list.size() - 1; t >= 1; t--) {
                if (list.get(0).equals('(') && list.get(t).equals(')') || list.get(0).equals('[') && list.get(t).equals(']') || list.get(0).equals('{') && list.get(t).equals('}')) {
                    temp.add(t);
                }
            }
            if (temp.size() == 0) { //如果下标数组为空,那么说明就没有与当前能够匹配的,则返回false
                return false;
            } else {
                for (int i = 0; i < temp.size(); i++) {
                    list1 = list.subList(temp.get(i) + 1, list.size());
                    if (recursion(list1)) { //如果递归返回true,则终止循环,否则取下一个可能匹配的位置
                        return true;
                    }
                }
                return false;
            }
        }

    }

}
