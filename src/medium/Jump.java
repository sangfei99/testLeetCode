package medium;

/*
45. ��Ծ��Ϸ II
����һ������Ϊ n �� 0 ������������ nums����ʼλ��Ϊ nums[0]��
ÿ��Ԫ�� nums[i] ��ʾ������ i �����ת����󳤶ȡ����仰˵��������� nums[i] �����������ת������ nums[i + j] ��:
0 <= j <= nums[i]
i + j < n
���ص��� nums[n - 1] ����С��Ծ���������ɵĲ����������Ե��� nums[n - 1]��

ʾ�� 1:
����: nums = [2,3,1,1,4]
���: 2
����: �������һ��λ�õ���С��Ծ���� 2��
     ���±�Ϊ 0 �����±�Ϊ 1 ��λ�ã��� 1 ����Ȼ���� 3 ��������������һ��λ�á�

ʾ�� 2:
����: nums = [2,3,0,1,4]
���: 2
 */
public class Jump {
    public static int jump(int[] nums) {
        int jumps = 0;
        int end = 0;
        int farthest = 0;
        for (int i = 0; i < nums.length-1; i++) {
            farthest = Math.max(farthest,i+nums[i]);
            if (i == end) {
                jumps++;
                end=farthest;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        int res = jump(new int[]{2,3,1,1,4});
        System.out.println(res);
    }
}
