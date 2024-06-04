package simple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
1. 两数之和
给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出和为目标值target的那两个整数，并返回它们的数组下标。
你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
你可以按任意顺序返回答案。
示例 1：
输入：nums = [2,7,11,15], target = 9
输出：[0,1]
解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
示例 2：
输入：nums = [3,2,4], target = 6
输出：[1,2]
示例 3：
输入：nums = [3,3], target = 6
输出：[0,1]
 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        // 创建一个哈希表来存储数值及其下标
        Map<Integer,Integer> numToIndex = new HashMap<>();
        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            // 检查是否存在 complement
            int complement=target-nums[i];
            if (numToIndex.containsKey(complement)){
                return new int[]{numToIndex.get(complement),i};
            }
            // 将当前数值和下标存入哈希表
            numToIndex.put(nums[i], i);
        }
        // 如果没有找到符合条件的两个数，返回 null
        return null;
    }
    public static void main(String[] args) {
        int[] ret = twoSum(new int[]{2, 7, 11, 15},9);
        System.out.println(Arrays.toString(ret));
    }

}



