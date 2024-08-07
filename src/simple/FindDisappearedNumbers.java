package simple;

import java.util.ArrayList;
import java.util.List;

/*
448. 找到所有数组中消失的数字
给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
示例 1：
输入：nums = [4,3,2,7,8,2,3,1]
输出：[5,6]

示例 2：
输入：nums = [1,1]
输出：[2]
 */
public class FindDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int num:nums){
            int index = Math.abs(num)-1;
            if (nums[index]>0){
                nums[index] = - nums[index]; //用负数标记这个位置的数字出现过
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>0){
                result.add(i+1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindDisappearedNumbers solution = new FindDisappearedNumbers();

        // 示例 1
        int[] nums1 = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> result1 = solution.findDisappearedNumbers(nums1);
        System.out.println(result1);  // 输出: [5, 6]

        // 示例 2
        int[] nums2 = {1, 1};
        List<Integer> result2 = solution.findDisappearedNumbers(nums2);
        System.out.println(result2);  // 输出: [2]
    }
}
