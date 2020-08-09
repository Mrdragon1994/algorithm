package com.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
//给你一个整数数组 nums 和一个整数 k。
//
// 如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
//
// 请返回这个数组中「优美子数组」的数目。
//
//
//
// 示例 1：
//
// 输入：nums = [1,1,2,1,1], k = 3
//输出：2
//解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
//
//
// 示例 2：
//
// 输入：nums = [2,4,6], k = 1
//输出：0
//解释：数列中不包含任何奇数，所以不存在优美子数组。
//
//
// 示例 3：
//
// 输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
//输出：16
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 50000
// 1 <= nums[i] <= 10^5
// 1 <= k <= nums.length
//
// Related Topics 双指针
// 👍 122 👎 0
/**
 * 滑动窗口
 */
public class SubArraysTest2 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2,1,1};
        int k = 3;
        System.out.println(test(nums, k));
    }

    public static int test(int[] nums, int k) {
        int count = 0;
        //总的奇数个数
//        int oddSum = (int) Arrays.stream(nums).boxed().filter(i -> i % 2 == 1).count();
//        //存放所有奇数的下标
//        int[] b = new int[oddSum];
//        int j = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) == 1) {
                list.add(i);
            }
        }
        for (int m = 0; m < list.size(); m++) {
            int index = m + k - 1; //符合奇数个元素长度的下一个位置坐标
            if (index < list.size()) {
                //左边的偶数个数
                //m-1如果小于0,表明是原数组中的第一个奇数,那么它前面的偶数个数就是b[m]个
                //m-1如果不小于0,表明它前面的偶数个数等于
                int left = m - 1 < 0 ? list.get(m) : list.get(m) - list.get(m - 1) - 1;
                //右边的偶数个数
                //如果当前奇数区间的终点位置m+k-1大于当前数组了,
                int right = index + 1 >= list.size() ? nums.length - list.get(index) - 1 : list.get(index+1) - list.get(index) - 1;
                count += (left+1) * (right+1);
            }
        }
        return count;
    }
}
