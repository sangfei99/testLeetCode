package medium;

import java.util.HashMap;
import java.util.HashSet;

/*
3.���ظ��ַ�����Ӵ�
����һ���ַ��� s �������ҳ����в������ظ��ַ��� ��Ӵ��ĳ��ȡ�

ʾ�� 1:
����: s = "abcabcbb"
���: 3
����: ��Ϊ���ظ��ַ�����Ӵ��� "abc"�������䳤��Ϊ 3��

ʾ�� 2:
����: s = "bbbbb"
���: 1
����: ��Ϊ���ظ��ַ�����Ӵ��� "b"�������䳤��Ϊ 1��

ʾ�� 3:
����: s = "pwwkew"
���: 3
����: ��Ϊ���ظ��ַ�����Ӵ��� "wke"�������䳤��Ϊ 3��
��ע�⣬��Ĵ𰸱����� �Ӵ� �ĳ��ȣ�"pwke" ��һ�������У������Ӵ���
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
