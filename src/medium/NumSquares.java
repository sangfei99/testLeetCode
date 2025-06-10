package medium;

import java.util.Arrays;

/*
279.��ȫƽ����
����һ������ n ������ ��Ϊ n ����ȫƽ�������������� ��
��ȫƽ���� ��һ����������ֵ������һ��������ƽ�������仰˵����ֵ����һ�������Գ˵Ļ������磬1��4��9 �� 16 ������ȫƽ�������� 3 �� 11 ���ǡ�

ʾ�� 1��
���룺n = 12
�����3
���ͣ�12 = 4 + 4 + 4

ʾ�� 2��
���룺n = 13
�����2
���ͣ�13 = 4 + 9
 */
public class NumSquares {
    public static int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j*j<=i ; j++) {
                dp[i] = Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int res = numSquares(12);
        System.out.println(res);
    }
}
