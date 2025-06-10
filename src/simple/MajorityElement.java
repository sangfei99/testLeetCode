package simple;

/*
169. 多数元素
给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ?n/2? 的元素。
你可以假设数组是非空的，并且给定的数组总是存在多数元素。

示例 1：
输入：nums = [3,2,3]
输出：3

示例 2：
输入：nums = [2,2,1,1,1,2,2]
输出：2
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count =0;
        for (int num:nums){
            if (count == 0) {
                candidate = num;
            }
            count += (num==candidate) ? 1 : -1;
        }
        return candidate;
    }

    public static void main(String[] args) {
        MajorityElement solution = new MajorityElement();
        int[] nums1 = {3, 2, 3};
        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        int[] nums3 = {1};

        System.out.println(solution.majorityElement(nums1));  // 输出：3
        System.out.println(solution.majorityElement(nums2));  // 输出：2
        System.out.println(solution.majorityElement(nums3));  // 输出：1
    }
}
