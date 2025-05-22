package medium;
/*
34.�����������в���Ԫ�صĵ�һ�������һ��λ��
����һ�����շǵݼ�˳�����е��������� nums����һ��Ŀ��ֵ target�������ҳ�����Ŀ��ֵ�������еĿ�ʼλ�úͽ���λ�á�
��������в�����Ŀ��ֵ target������ [-1, -1]��
�������Ʋ�ʵ��ʱ�临�Ӷ�Ϊ O(log n) ���㷨��������⡣

ʾ�� 1��
���룺nums = [5,7,7,8,8,10], target = 8
�����[3,4]

ʾ�� 2��
���룺nums = [5,7,7,8,8,10], target = 6
�����[-1,-1]

ʾ�� 3��
���룺nums = [], target = 0
�����[-1,-1]
 */

import java.util.Arrays;

public class SearchRange {
    public static int[] searchRange(int[] nums, int target) {
        int left = findleft(nums,target);
        int right = findright(nums,target);
        if (left <= right) {
            return new int[]{left,right};
        }
        else {
            return new int[]{-1,-1};
        }

    }
    public static int findleft(int nums[],int target){
        int left = 0;
        int right = nums.length-1;
        int result = nums.length;
        while (left<=right){
            int mid = left +(right-left)/2;
            if (nums[mid] >= target) {
                right = mid -1;
                result = mid;
            }
            else {
                left = mid+1;
            }
        }
        return result;
    }
    public static int findright(int nums[],int target) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
                result = mid;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ret = searchRange(new int[]{},0);
        System.out.println(Arrays.toString(ret));
    }
}
