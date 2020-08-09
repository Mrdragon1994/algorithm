package com.algorithm.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class CountNumber {
    private static int[] array = new int[]{1,2,3,4,5};
    private static int k = 2;
    private static int[] b = new int[k];
    private static int count = 0;
    private static int tempK = k;
    public static void main(String[] args) {
        System.out.println(test(array, k));
    }

    public static int test(int[] array, int k) {
        if (k > array.length) {
            return -1;
        } else if (k == array.length) {
            if (testArray(array)) {
                return 1;
            } else {
                return 0;
            }
        } else { //如果k小于array.length,那么就相当于是从array.length中随意选K个元素组成新的子数组
            return getCount(array.length, k);
        }
    }


    public static boolean testArray(int[] array) {
        if (Arrays.stream(array).boxed().filter(a -> a % 2 == 0).collect(Collectors.toList()).size() > 0) {
            return false;
        } else {
            return true;
        }
    }

    public static int getCount(int length ,int k) {
        int i, j;
        for (i = k; i <= length; i++) {
            b[k-1] = i - 1;
            if (k > 1) {
                getCount(i-1, k-1);
            } else {
                int[] c = new int[tempK];
                for (j = 0; j <= tempK - 1; j++) {
                    c[j] = array[b[j]];
                }
                if (testArray(c)) {
                    count++;
                }
            }
        }
        return count;
    }
}
