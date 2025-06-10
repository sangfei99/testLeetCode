package medium;

import java.util.Arrays;

/*
322.��Ǯ�һ�
����һ���������� coins ����ʾ��ͬ����Ӳ�ң��Լ�һ������ amount ����ʾ�ܽ�
���㲢���ؿ��Դճ��ܽ����������ٵ�Ӳ�Ҹ��� �����û���κ�һ��Ӳ�����������ܽ����� -1 ��
�������Ϊÿ��Ӳ�ҵ����������޵ġ�

ʾ�� 1��
���룺coins = [1, 2, 5], amount = 11
�����3
���ͣ�11 = 5 + 5 + 1

ʾ�� 2��
���룺coins = [2], amount = 3
�����-1

ʾ�� 3��
���룺coins = [1], amount = 0
�����0
 */
public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for (int coin:coins){
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i],dp[i-coin]+1);
            }
        }
        return dp[amount]<amount+1 ? dp[amount]:-1;
    }

    public static void main(String[] args) {
        int res = coinChange(new int[]{1, 2, 5},11);
        System.out.println(res);
    }
}
