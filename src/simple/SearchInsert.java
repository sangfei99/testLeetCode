package simple;

/*
35.��������λ�ã����ֲ��ң�
����һ�����������һ��Ŀ��ֵ�����������ҵ�Ŀ��ֵ�������������������Ŀ��ֵ�������������У����������ᱻ��˳������λ�á�
�����ʹ��ʱ�临�Ӷ�Ϊ O(log n) ���㷨��

ʾ�� 1:
����: nums = [1,3,5,6], target = 5
���: 2

ʾ�� 2:
����: nums = [1,3,5,6], target = 2
���: 1

ʾ�� 3:
����: nums = [1,3,5,6], target = 7
���: 4
 */

public class SearchInsert {
    public static int searchInsert(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;

        while (left<=right){
            int mid = left+(right-left)/2;
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] < target) {
                left=mid+1;
            } else {
                right=mid-1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int ret = searchInsert(new int[]{1,3,5,6},5);
        System.out.println(ret);
    }

}
