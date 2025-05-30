package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
15.����֮��
����һ���������� nums ���ж��Ƿ������Ԫ�� [nums[i], nums[j], nums[k]] ���� i != j��i != k �� j != k ��ͬʱ������ nums[i] + nums[j] + nums[k] == 0 ��
���㷵�����к�Ϊ 0 �Ҳ��ظ�����Ԫ�顣
ע�⣺���в����԰����ظ�����Ԫ�顣

ʾ�� 1��
���룺nums = [-1,0,1,2,-1,-4]
�����[[-1,-1,2],[-1,0,1]]
���ͣ�
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 ��
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 ��
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 ��
��ͬ����Ԫ���� [-1,0,1] �� [-1,-1,2] ��
ע�⣬�����˳�����Ԫ���˳�򲢲���Ҫ��
 */
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length-2; i++) {
            //��i���Ұ벿��
            int left = i+1;
            int right = nums.length-1;

            //�����ظ�ֵ
            if(i>0 && nums[i]==nums[i-1]) continue;

            while(left<right){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));

                    // �����ظ�ֵ
                    while (left<right && nums[left]==nums[left+1]) left++;
                    while (left<right && nums[right]==nums[right-1]) right--;

                    left++;
                    right--;
                }
                else if(sum<0){
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> res = threeSum(new int[]{-1,0,1,2,-1,-4});
        System.out.println(res);
    }
}
