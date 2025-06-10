package simple;

import java.util.HashMap;

/*
136. ֻ����һ�ε�����
����һ���ǿ��������� nums ������ĳ��Ԫ��ֻ����һ�����⣬����ÿ��Ԫ�ؾ��������Ρ��ҳ��Ǹ�ֻ������һ�ε�Ԫ�ء�
�������Ʋ�ʵ������ʱ�临�Ӷȵ��㷨����������⣬�Ҹ��㷨ֻʹ�ó�������ռ䡣

ʾ�� 1 ��
���룺nums = [2,2,1]
�����1

ʾ�� 2 ��
���룺nums = [4,1,2,1,2]
�����4

ʾ�� 3 ��
���룺nums = [1]
�����1
 */
public class SingleNumber {

    //����1
    public static int singleNumber(int[] nums) {
        int result =0;
        for (int num : nums) {
            result ^= num; //�������
        }
        return result;
    }

    //����2
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

        System.out.println(singleNumber.getSingleNumber(nums1));  // �����1
        System.out.println(singleNumber.getSingleNumber(nums2));  // �����4
        System.out.println(singleNumber.getSingleNumber(nums3));  // �����1
    }

}
