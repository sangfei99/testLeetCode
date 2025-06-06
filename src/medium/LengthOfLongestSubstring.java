package medium;

import java.util.HashMap;
import java.util.HashSet;

/*
3.无重复字符的最长子串
给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。

示例 1:
输入: s = "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

示例 2:
输入: s = "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。

示例 3:
输入: s = "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> window = new HashSet<>();
        int left =0;
        int right = 0;
        int maxLength = 0;

        while(right<s.length()){
            char c = s.charAt(right);
            while (window.contains(c)){
                window.remove(s.charAt(left));
                left++;
            }
            window.add(c);
            maxLength = Math.max(maxLength,right-left+1);
            right++;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int ret = lengthOfLongestSubstring("abcabcbb");
        System.out.println(ret);
    }
}
