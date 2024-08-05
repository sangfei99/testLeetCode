package simple;

import java.util.ArrayList;
import java.util.List;

/*
448. �ҵ�������������ʧ������
����һ���� n ������������ nums ������ nums[i] ������ [1, n] �ڡ������ҳ������� [1, n] ��Χ�ڵ�û�г����� nums �е����֣������������ʽ���ؽ����
ʾ�� 1��
���룺nums = [4,3,2,7,8,2,3,1]
�����[5,6]

ʾ�� 2��
���룺nums = [1,1]
�����[2]
 */
public class FindDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int num:nums){
            int index = Math.abs(num)-1;
            if (nums[index]>0){
                nums[index] = - nums[index]; //�ø���������λ�õ����ֳ��ֹ�
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

        // ʾ�� 1
        int[] nums1 = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> result1 = solution.findDisappearedNumbers(nums1);
        System.out.println(result1);  // ���: [5, 6]

        // ʾ�� 2
        int[] nums2 = {1, 1};
        List<Integer> result2 = solution.findDisappearedNumbers(nums2);
        System.out.println(result2);  // ���: [2]
    }
}
