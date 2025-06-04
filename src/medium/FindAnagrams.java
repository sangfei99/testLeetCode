package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
438.�ҵ��ַ�����������ĸ��λ��
���������ַ��� s �� p���ҵ� s ������ p ����λ�ʵ��Ӵ���������Щ�Ӵ�����ʼ�����������Ǵ������˳��

ʾ�� 1:
����: s = "cbaebabacd", p = "abc"
���: [0,6]
����:
��ʼ�������� 0 ���Ӵ��� "cba", ���� "abc" ����λ�ʡ�
��ʼ�������� 6 ���Ӵ��� "bac", ���� "abc" ����λ�ʡ�

ʾ�� 2:
����: s = "abab", p = "ab"
���: [0,1,2]
����:
��ʼ�������� 0 ���Ӵ��� "ab", ���� "ab" ����λ�ʡ�
��ʼ�������� 1 ���Ӵ��� "ba", ���� "ab" ����λ�ʡ�
��ʼ�������� 2 ���Ӵ��� "ab", ���� "ab" ����λ�ʡ�
 */
public class FindAnagrams {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int sLen = s.length();
        int pLen = p.length();

        if (sLen < pLen) return result;

        int[] pCount = new int[26]; //��¼p���ַ�Ƶ��
        int[] sCount = new int[26]; //��ǰ���ڵ��ַ�Ƶ��

        for (int i = 0; i < pLen; i++) {
            pCount[p.charAt(i)-'a']++;
            sCount[s.charAt(i)-'a']++;
        }
        if (Arrays.equals(sCount,pCount)) {
            result.add(0);
        }
        //��������
        for (int i = pLen; i <sLen ; i++) {
            sCount[s.charAt(i)-'a']++;//�������ַ�
            sCount[s.charAt(i-pLen)-'a']--;//�Ƴ����ַ�
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
