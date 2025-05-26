package medium;

import java.util.Arrays;

/*
238.��������������ĳ˻�
����һ���������� nums���������� answer ������ answer[i] ���� nums �г� nums[i] ֮�������Ԫ�صĳ˻� ��
��Ŀ���ݱ�֤���� nums֮������Ԫ�ص�ȫ��ǰ׺Ԫ�غͺ�׺�ĳ˻�����32λ������Χ�ڡ�
�벻Ҫʹ�ó��������� O(n) ʱ�临�Ӷ�����ɴ��⡣

ʾ�� 1:
����: nums = [1,2,3,4]
���: [24,12,8,6]

ʾ�� 2:
����: nums = [-1,1,0,-3,3]
���: [0,0,9,0,0]
 */
public class ProductExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int n= nums.length;
        int[] answer = new int[n];

        // �ȼ�����ߵĳ˻�
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i-1] * nums[i-1];
        }

        // �ٴ�����������ұߵĳ˻�
        int right = 1;
        for (int i = n-1; i >=0 ; i--) {
            answer[i] = answer[i]*right;
            right *= nums[i];
        }
        return answer;

    }

    public static void main(String[] args) {
        int[] ret = productExceptSelf(new int[] {1,2,3,4});
        System.out.println(Arrays.toString(ret));
    }
}
