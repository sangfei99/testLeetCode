package medium;

import java.util.HashSet;

/*
128.���������(HashSet)
����һ��δ�������������nums ���ҳ���������������У���Ҫ������Ԫ����ԭ�������������ĳ��ȡ�
������Ʋ�ʵ��ʱ�临�Ӷ�Ϊ O(n) ���㷨��������⡣

ʾ�� 1��
���룺nums = [100,4,200,1,3,2]
�����4
���ͣ���������������� [1, 2, 3, 4]�����ĳ���Ϊ 4��

ʾ�� 2��
���룺nums = [0,3,7,2,5,8,4,6,0,1]
�����9

ʾ�� 3��
���룺nums = [1,0,1,2]
�����3
 */
public class LongestConsecutive {
    public static int longestConsecutive(int[] nums){
        if (nums==null || nums.length==0) return 0;
        HashSet<Integer> numSet = new HashSet<>();
        for(int num:nums){
            numSet.add(num);
        }
        int longestStreak = 0;
        for (int num:numSet) {
            // ֻ�е� num ���������ʱ�ſ�ʼ������
            if (!numSet.contains(num-1)){
                int currentNum = num;
                int currentStreak = 1;
                // ��������������
                while (numSet.contains(currentNum+1)){
                    currentNum++;
                    currentStreak++;
                }
                longestStreak = Math.max(longestStreak,currentStreak);
            }
        }
        return longestStreak;
    }

    public static void main(String[] args) {
        int ret = longestConsecutive(new int[]{100, 4, 200, 1, 3, 2});
        System.out.println(ret);
    }

}
