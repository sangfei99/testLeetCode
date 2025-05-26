package medium;

import java.util.Arrays;

/*
238.除自身以外数组的乘积
给你一个整数数组 nums，返回数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
题目数据保证数组 nums之中任意元素的全部前缀元素和后缀的乘积都在32位整数范围内。
请不要使用除法，且在 O(n) 时间复杂度内完成此题。

示例 1:
输入: nums = [1,2,3,4]
输出: [24,12,8,6]

示例 2:
输入: nums = [-1,1,0,-3,3]
输出: [0,0,9,0,0]
 */
public class ProductExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int n= nums.length;
        int[] answer = new int[n];

        // 先计算左边的乘积
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i-1] * nums[i-1];
        }

        // 再从右向左乘以右边的乘积
        int right = 1;
        for (int i = n-1; i >=0 ; i--) {
            answer[i] = answer[i]*right;
            right *= nums[i];
        }
        return answer;

    }

    public static void main(String[] args) {
        int[] ret = productExceptSelf(new int[] {1,2,3,4});
        System.out.println(Arrays.toString(ret));
    }
}
