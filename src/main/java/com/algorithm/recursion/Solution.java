package com.algorithm.recursion;

/**
 * 题目描述：
 * //一只青蛙想要过河。 假定河流被等分为 x 个单元格，并且在每一个单元格内都有可能放有一石子（也有可能没有）。 青蛙可以跳上石头，但是不可以跳入水中。
 * //
 * // 给定石子的位置列表（用单元格序号升序表示）， 请判定青蛙能否成功过河（即能否在最后一步跳至最后一个石子上）。 开始时， 青蛙默认已站在第一个石子上，并可以
 * //假定它第一步只能跳跃一个单位（即只能从单元格1跳至单元格2）。
 * //
 * // 如果青蛙上一步跳跃了 k 个单位，那么它接下来的跳跃距离只能选择为 k - 1、k 或 k + 1个单位。 另请注意，青蛙只能向前方（终点的方向）跳跃。
 * //
 * //
 * // 请注意：
 * //
 * //
 * // 石子的数量 ≥ 2 且 < 1100；
 * // 每一个石子的位置序号都是一个非负整数，且其 < 231；
 * // 第一个石子的位置永远是0。
 * //
 * //
 * // 示例 1:
 * //
 * //
 * //[0,1,3,5,6,8,12,17]
 * //
 * //总共有8个石子。
 * //第一个石子处于序号为0的单元格的位置, 第二个石子处于序号为1的单元格的位置,
 * //第三个石子在序号为3的单元格的位置， 以此定义整个数组...
 * //最后一个石子处于序号为17的单元格的位置。
 * //
 * //返回 true。即青蛙可以成功过河，按照如下方案跳跃：
 * //跳1个单位到第2块石子, 然后跳2个单位到第3块石子, 接着
 * //跳2个单位到第4块石子, 然后跳3个单位到第6块石子,
 * //跳4个单位到第7块石子, 最后，跳5个单位到第8个石子（即最后一块石子）。
 * //
 * //
 * // 示例 2:
 * //
 * //
 * //[0,1,2,3,4,8,9,11]
 * //
 * //返回 false。青蛙没有办法过河。
 * //这是因为第5和第6个石子之间的间距太大，没有可选的方案供青蛙跳跃过去。
 * //
 * // Related Topics 动态规划
 * //  86  0
 *
 *
 * //leetcode submit region begin(Prohibit modification and deletion)
 * class Solution {
 *     public boolean canCross(int[] stones) {
 *
 *     }
 * }
 * //leetcode submit region end(Prohibit modification and deletion)
 */

public class Solution {
    public static void main(String[] args) {
        int[] stones = new int[]{0,1,2,3,4,8,9,11};
        new Solution().canCross(stones);
    }

    public boolean canCross(int[] stones) {
        if(stones[1]!=1){
            return false;
        }
        for (int i = 1; i < stones.length - 1; i++) {
            int cha = stones[i+1]-stones[i];
            if (cha > i+1) {
                return false;
            }
        }
        return A(0, 1, stones);
    }

    //根据两个索引查询第三个索引的
    public boolean A(int a, int b, int[] arr) {
        if (b == arr.length - 1) {
            return true;
        }
        int k = arr[b] - arr[a];
        int index = -1;
        for (int i = b + 1; i < arr.length; i++) {
            int a1 = arr[i] - arr[b];
            if (a1 >= k - 1) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return false;
        }
        int a1 = arr[index] - arr[b];
        int a2 = -1;
        int a3 = -1;
        if (index + 1 < arr.length) {
            a2 = arr[index + 1] - arr[b];
        }
        if (index + 2 < arr.length) {
            a3 = arr[index + 2] - arr[b];
        }
        boolean x1 = false, x2 = false, x3 = false;
        if (a3 >= k - 1 && a3 <= k + 1) {
            x3 = A(b, index + 2, arr);
            if (x3){
                return true;
            }
        }
        if (a2 >= k - 1 && a2 <= k + 1) {
            x2 = A(b, index + 1, arr);
            if (x2){
                return true;
            }
        }
        if (a1 >= k - 1 && a1 <= k + 1) {
            x1 = A(b, index, arr);
            if (x1){
                return true;
            }
        }
        return false;
    }
}


