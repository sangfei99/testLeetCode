package medium;

import java.util.HashSet;

/*
128.最长连续序列(HashSet)
给定一个未排序的整数数组nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
请你设计并实现时间复杂度为 O(n) 的算法解决此问题。

示例 1：
输入：nums = [100,4,200,1,3,2]
输出：4
解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。

示例 2：
输入：nums = [0,3,7,2,5,8,4,6,0,1]
输出：9

示例 3：
输入：nums = [1,0,1,2]
输出：3
 */
public class LongestConsecutive {
    public static int longestConsecutive(int[] nums){
        if (nums==null || nums.length==0) return 0;
        HashSet<Integer> numSet = new HashSet<>();
        for(int num:nums){
            numSet.add(num);
        }
        int longestStreak = 0;
        for (int num:numSet) {
            // 只有当 num 是序列起点时才开始向后查找
            if (!numSet.contains(num-1)){
                int currentNum = num;
                int currentStreak = 1;
                // 向后查找连续数字
                while (numSet.contains(currentNum+1)){
                    currentNum++;
                    currentStreak++;
                }
                longestStreak = Math.max(longestStreak,currentStreak);
            }
        }
        return longestStreak;
    }

    public static void main(String[] args) {
        int ret = longestConsecutive(new int[]{100, 4, 200, 1, 3, 2});
        System.out.println(ret);
    }

}
