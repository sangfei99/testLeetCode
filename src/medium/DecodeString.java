package medium;

import java.util.Stack;

/*
394.�ַ�������
����һ������������ַ������������������ַ�����
�������Ϊ: k[encoded_string]����ʾ���з������ڲ��� encoded_string �����ظ� k �Ρ�ע�� k ��֤Ϊ��������
�������Ϊ�����ַ���������Ч�ģ������ַ�����û�ж���Ŀո�������ķ��������Ƿ��ϸ�ʽҪ��ġ�
���⣬�������Ϊԭʼ���ݲ��������֣����е�����ֻ��ʾ�ظ��Ĵ��� k �����粻������� 3a �� 2[4] �����롣

ʾ�� 1��
���룺s = "3[a]2[bc]"
�����"aaabcbc"

ʾ�� 2��
���룺s = "3[a2[c]]"
�����"accaccacc"

ʾ�� 3��
���룺s = "2[abc]3[cd]ef"
�����"abcabccdcdcdef"

ʾ�� 4��
���룺s = "abc3[cd]xyz"
�����"abccdcdcdxyz"
 */
public class DecodeString {
    public static String decodeString(String s) {
        Stack<Integer> countstack = new Stack<>();
        Stack<StringBuilder> stringstack = new Stack<>();
        StringBuilder current = new StringBuilder();
        int k = 0;

        for (char ch:s.toCharArray()){
            if (Character.isDigit(ch)){
                k = k*10+(ch-'0');
            } else if (ch=='[') {
                //���浱ǰ�ظ������͵�ǰ�ַ���
                countstack.push(k);
                stringstack.push(current);
                //����
                current = new StringBuilder();
                k=0;
            } else if (ch==']') {
                //���һ�����봮��ƴ�ӻ��ϲ�
                int repeatTimes = countstack.pop();
                StringBuilder decode = stringstack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    decode.append(current);
                }
                current = decode;
            }
            else {
                current.append(ch);
            }
        }
        return current.toString();
    }

    public static void main(String[] args) {
        String ret = decodeString("3[a]2[bc]");
        System.out.println(ret);
    }

}
