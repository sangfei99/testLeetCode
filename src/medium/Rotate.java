package medium;

import java.util.Arrays;

/*
189.轮转数组
给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。

示例 1:
输入: nums = [1,2,3,4,5,6,7], k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右轮转 1 步: [7,1,2,3,4,5,6]
向右轮转 2 步: [6,7,1,2,3,4,5]
向右轮转 3 步: [5,6,7,1,2,3,4]

示例 2:
输入：nums = [-1,-100,3,99], k = 2
输出：[3,99,-1,-100]
解释:
向右轮转 1 步: [99,-1,-100,3]
向右轮转 2 步: [3,99,-1,-100]
 */
public class Rotate {
    public static void rotate(int[] nums, int k) {    //在原数组上修改，所以返回的也是原数组nums,不需要额外的返回值
        int n = nums.length;
        k = k % n; //防止k大于n
        reverse(nums,0,n-1); //先反转整个数组
        reverse(nums,0,k-1); //反转前k个
        reverse(nums,k,n-1);  //反转后面n-k个
    }
    public static void reverse(int[] nums,int start,int end) {
        while (start<end){
            int temp = nums[start];
            nums[start]= nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotate(nums,k);
        System.out.println(Arrays.toString(nums));
    }
}
