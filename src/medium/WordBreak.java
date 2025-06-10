package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
139.���ʲ��
����һ���ַ��� s ��һ���ַ����б� wordDict ��Ϊ�ֵ䡣������������ֵ��г��ֵ�һ����������ƴ�ӳ� s �򷵻� true��
ע�⣺��Ҫ���ֵ��г��ֵĵ���ȫ����ʹ�ã������ֵ��еĵ��ʿ����ظ�ʹ�á�

ʾ�� 1��
����: s = "leetcode", wordDict = ["leet", "code"]
���: true
����: ���� true ��Ϊ "leetcode" ������ "leet" �� "code" ƴ�ӳɡ�

ʾ�� 2��
����: s = "applepenapple", wordDict = ["apple", "pen"]
���: true
����: ���� true ��Ϊ "applepenapple" ������ "apple" "pen" "apple" ƴ�ӳɡ�
     ע�⣬������ظ�ʹ���ֵ��еĵ��ʡ�

ʾ�� 3��
����: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
���: false
 */
public class WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> WordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 1; i <=s.length() ; i++) {
            for (int j = 0; j < i; j++) {
                if(dp[j] && WordSet.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("leet", "code");
        boolean res = wordBreak("leetcode",list);
        System.out.println(res);
    }
}
