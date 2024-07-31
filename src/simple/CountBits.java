package simple;
/*
338. 比特位计数
给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
示例 1：
输入：n = 2
输出：[0,1,1]
解释：
0 --> 0
1 --> 1
2 --> 10
示例 2：

输入：n = 5
输出：[0,1,1,2,1,2]
解释：
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101
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

        // 示例 1
        int n1 = 2;
        int[] result1 = solution.countBits(n1);
        System.out.println(java.util.Arrays.toString(result1));  // 输出: [0, 1, 1]

        // 示例 2
        int n2 = 5;
        int[] result2 = solution.countBits(n2);
        System.out.println(java.util.Arrays.toString(result2));  // 输出: [0, 1, 1, 2, 1, 2]
    }
}
