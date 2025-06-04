package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
438.找到字符串中所有字母异位词
给定两个字符串 s 和 p，找到 s 中所有 p 的异位词的子串，返回这些子串的起始索引。不考虑答案输出的顺序。

示例 1:
输入: s = "cbaebabacd", p = "abc"
输出: [0,6]
解释:
起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。

示例 2:
输入: s = "abab", p = "ab"
输出: [0,1,2]
解释:
起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 */
public class FindAnagrams {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int sLen = s.length();
        int pLen = p.length();

        if (sLen < pLen) return result;

        int[] pCount = new int[26]; //记录p的字符频率
        int[] sCount = new int[26]; //当前窗口的字符频率

        for (int i = 0; i < pLen; i++) {
            pCount[p.charAt(i)-'a']++;
            sCount[s.charAt(i)-'a']++;
        }
        if (Arrays.equals(sCount,pCount)) {
            result.add(0);
        }
        //滑动窗口
        for (int i = pLen; i <sLen ; i++) {
            sCount[s.charAt(i)-'a']++;//加入新字符
            sCount[s.charAt(i-pLen)-'a']--;//移除旧字符
            if (Arrays.equals(sCount,pCount)) {
                result.add(i-pLen+1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> res = findAnagrams("cbaebabacd","abc");
        System.out.println(res);
    }
}
