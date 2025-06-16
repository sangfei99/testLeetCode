package medium;
/*
55. ��Ծ��Ϸ
����һ���Ǹ��������� nums �������λ������ĵ�һ���±� �������е�ÿ��Ԫ�ش������ڸ�λ�ÿ�����Ծ����󳤶ȡ�
�ж����Ƿ��ܹ��������һ���±꣬������ԣ����� true �����򣬷��� false ��

ʾ�� 1��
���룺nums = [2,3,1,1,4]
�����true
���ͣ��������� 1 �������±� 0 �����±� 1, Ȼ���ٴ��±� 1 �� 3 ���������һ���±ꡣ

ʾ�� 2��
���룺nums = [3,2,1,0,4]
�����false
���ͣ������������ܻᵽ���±�Ϊ 3 ��λ�á������±�������Ծ������ 0 �� ������Զ�����ܵ������һ���±ꡣ
 */
public class CanJump {
    public static boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                return false;
            }
            maxReach = Math.max(maxReach,i+nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        boolean res = canJump(new int[]{2,3,1,1,4});
        System.out.println(res);
    }
}
