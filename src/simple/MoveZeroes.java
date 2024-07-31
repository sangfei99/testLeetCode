package simple;

/*
283. �ƶ���
����һ������ nums����дһ������������ 0 �ƶ��������ĩβ��ͬʱ���ַ���Ԫ�ص����˳��
��ע�� �������ڲ���������������ԭ�ض�������в�����
ʾ�� 1:
����: nums = [0,1,0,3,12]
���: [1,3,12,0,0]

ʾ�� 2:
����: nums = [0]
���: [0]
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int latsNonZeroIndex = 0;// ����׷�ٷ���Ԫ�صĲ���λ��

        // �������飬�����з���Ԫ���ƶ���ǰ��
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // ������ǰ����Ԫ���� lastNonZeroIndex ָ���Ԫ��
                int temp = nums[i];
                nums[i]=nums[latsNonZeroIndex];
                nums[latsNonZeroIndex]=temp;

                // �ƶ� lastNonZeroIndex
                latsNonZeroIndex++;
            }
        }
    }

    public static void main(String[] args) {
        MoveZeroes solution = new MoveZeroes();

        int[] nums1 = {0, 1, 0, 3, 12};
        solution.moveZeroes(nums1);
        System.out.println(java.util.Arrays.toString(nums1)); // ���: [1, 3, 12, 0, 0]

        int[] nums2 = {0};
        solution.moveZeroes(nums2);
        System.out.println(java.util.Arrays.toString(nums2)); // ���: [0]
    }
}
