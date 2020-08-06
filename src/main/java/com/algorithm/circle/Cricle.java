package com.algorithm.circle;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 题目描述：
 * 给定1，2，3...n这么N个数,从1开始,每隔一个则划掉3个,问最后剩下哪个元素
 */
public class Cricle {
    public static void main(String[] args) {
       List<Integer> list =  IntStream.rangeClosed(1, 5).boxed().collect(Collectors.toList());
       System.out.println(test(list));
    }

    public static Integer test(List<Integer> list) {
            while (list.size() >= 4) {
                list.add(list.remove(0));
                list.remove(0);
                list.remove(0);
                list.remove(0);
            }
            return list.get(0);
    }
}
