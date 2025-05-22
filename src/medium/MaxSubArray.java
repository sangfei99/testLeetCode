package medium;

/*
53.����������
����һ���������� nums �������ҳ�һ���������͵����������飨���������ٰ���һ��Ԫ�أ������������͡�
�������������е�һ���������֡�
ʾ�� 1��
���룺nums = [-2,1,-3,4,-1,2,1,-5,4]
�����6
���ͣ����������� [4,-1,2,1] �ĺ����Ϊ 6 ��

ʾ�� 2��
���룺nums = [1]
�����1

ʾ�� 3��
���룺nums = [5,4,-1,7,8]
�����23
 */
public class MaxSubArray {
    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int ret = maxSubArray(new int[]{1});
        System.out.println(ret);
    }
}
