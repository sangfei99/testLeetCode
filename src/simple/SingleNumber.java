package simple;

import java.util.HashMap;

/*
136. 只出现一次的数字
给你一个非空整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。

示例 1 ：
输入：nums = [2,2,1]
输出：1

示例 2 ：
输入：nums = [4,1,2,1,2]
输出：4

示例 3 ：
输入：nums = [1]
输出：1
 */
public class SingleNumber {

    //方法1
    public static int singleNumber(int[] nums) {
        int result =0;
        for (int num : nums) {
            result ^= num; //异或运算
        }
        return result;
    }

    //方法2
    public  int getSingleNumber(int[] nums){
        HashMap<Integer,Integer>map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for (int num : nums) {
            if (map.get(num)==1) {
                return num;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();
        int[] nums1 = {2, 2, 1};
        int[] nums2 = {4, 1, 2, 1, 2};
        int[] nums3 = {1};

        System.out.println(singleNumber.getSingleNumber(nums1));  // 输出：1
        System.out.println(singleNumber.getSingleNumber(nums2));  // 输出：4
        System.out.println(singleNumber.getSingleNumber(nums3));  // 输出：1
    }

}
