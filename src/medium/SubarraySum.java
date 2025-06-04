package medium;
/*
560.��Ϊ K ��������
����һ���������� nums ��һ������k ������ͳ�Ʋ����ظ������к�Ϊ k ��������ĸ��� ��
��������������Ԫ�ص������ǿ����С�

ʾ�� 1��
���룺nums = [1,1,1], k = 2
�����2

ʾ�� 2��
���룺nums = [1,2,3], k = 3
�����2
 */

import java.util.HashMap;

public class SubarraySum {
    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0,1);

        int sum = 0;
        int count = 0;
        for(int num:nums){
            sum+=num;

            if (prefixSumMap.containsKey(sum-k)) {
                count+= prefixSumMap.get(sum-k);
            }
            prefixSumMap.put(sum,prefixSumMap.getOrDefault(sum,0)+1);
        }
        return count;
    }

    public static void main(String[] args) {
        int ret = subarraySum(new int[]{1,1,1},2);
        System.out.println(ret);
    }
}
