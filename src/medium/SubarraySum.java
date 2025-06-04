package medium;
/*
560.和为 K 的子数组
给你一个整数数组 nums 和一个整数k ，请你统计并返回该数组中和为 k 的子数组的个数 。
子数组是数组中元素的连续非空序列。

示例 1：
输入：nums = [1,1,1], k = 2
输出：2

示例 2：
输入：nums = [1,2,3], k = 3
输出：2
 */

import java.util.HashMap;

public class SubarraySum {
    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0,1);

        int sum = 0;
        int count = 0;
        for(int num:nums){
            sum+=num;

            if (prefixSumMap.containsKey(sum-k)) {
                count+= prefixSumMap.get(sum-k);
            }
            prefixSumMap.put(sum,prefixSumMap.getOrDefault(sum,0)+1);
        }
        return count;
    }

    public static void main(String[] args) {
        int ret = subarraySum(new int[]{1,1,1},2);
        System.out.println(ret);
    }
}
