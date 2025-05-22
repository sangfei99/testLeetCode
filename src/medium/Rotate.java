package medium;

import java.util.Arrays;

/*
189.��ת����
����һ���������� nums���������е�Ԫ��������ת k ��λ�ã����� k �ǷǸ�����

ʾ�� 1:
����: nums = [1,2,3,4,5,6,7], k = 3
���: [5,6,7,1,2,3,4]
����:
������ת 1 ��: [7,1,2,3,4,5,6]
������ת 2 ��: [6,7,1,2,3,4,5]
������ת 3 ��: [5,6,7,1,2,3,4]

ʾ�� 2:
���룺nums = [-1,-100,3,99], k = 2
�����[3,99,-1,-100]
����:
������ת 1 ��: [99,-1,-100,3]
������ת 2 ��: [3,99,-1,-100]
 */
public class Rotate {
    public static void rotate(int[] nums, int k) {    //��ԭ�������޸ģ����Է��ص�Ҳ��ԭ����nums,����Ҫ����ķ���ֵ
        int n = nums.length;
        k = k % n; //��ֹk����n
        reverse(nums,0,n-1); //�ȷ�ת��������
        reverse(nums,0,k-1); //��תǰk��
        reverse(nums,k,n-1);  //��ת����n-k��
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
