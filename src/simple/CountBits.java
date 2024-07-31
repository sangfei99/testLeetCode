package simple;
/*
338. ����λ����
����һ������ n ������ 0 <= i <= n �е�ÿ�� i ������������Ʊ�ʾ�� 1 �ĸ��� ������һ������Ϊ n + 1 ������ ans ��Ϊ�𰸡�
ʾ�� 1��
���룺n = 2
�����[0,1,1]
���ͣ�
0 --> 0
1 --> 1
2 --> 10
ʾ�� 2��

���룺n = 5
�����[0,1,1,2,1,2]
���ͣ�
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101
 */

/*
�����Ǽ��� ans[i] ʱ�����ǿ������� ans[i >> 1]��������Ϊ i >> 1 �� i �Ķ����Ʊ�ʾ����һλ���ֵ������ζ����ȥ���� i �����λ�����磺
��� i = 2 (������ 10)����ô i >> 1 = 1 (������ 1)��
��� i = 3 (������ 11)����ô i >> 1 = 1 (������ 1)��

i & 1 ��Ϊ�˼�� i �����λ�� 0 ���� 1��
��� i ��ż�������� 2������ô i & 1 = 0��
��� i ������������ 3������ô i & 1 = 1��
 */
public class CountBits {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        for (int i = 1; i <= n ; i++) {
            ans[i] = ans[i>>1] + (i & 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        CountBits solution = new CountBits();

        // ʾ�� 1
        int n1 = 2;
        int[] result1 = solution.countBits(n1);
        System.out.println(java.util.Arrays.toString(result1));  // ���: [0, 1, 1]

        // ʾ�� 2
        int n2 = 5;
        int[] result2 = solution.countBits(n2);
        System.out.println(java.util.Arrays.toString(result2));  // ���: [0, 1, 1, 2, 1, 2]
    }
}
