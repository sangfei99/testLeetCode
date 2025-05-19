package medium;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
49.��ĸ��λ�ʷ��飨��ϣ��
����һ���ַ������飬���㽫��ĸ��λ�������һ�𡣿��԰�����˳�򷵻ؽ���б�
��ĸ��λ��������������Դ���ʵ�������ĸ�õ���һ���µ��ʡ�

ʾ�� 1:
����: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
���: [["bat"],["nat","tan"],["ate","eat","tea"]]

ʾ�� 2:
����: strs = [""]
���: [[""]]

ʾ�� 3:
����: strs = ["a"]
���: [["a"]]
 */
public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        // ����һ����ϣ�����ڷ���
        HashMap<String,List<String>> map = new HashMap<>();
        for(String str:strs){
            // ���ַ���ת�����ַ����鲢����
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            // �������ַ�����Ϊ key
            String key = new String(chars);
            if (!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            // ��ԭʼ�ַ�����ӵ���Ӧ����
            map.get(key).add(str);
        }
        // ���ع�ϣ�������е�ֵ����ÿ�����飩
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> ret = groupAnagrams(strs);
        System.out.println(ret);
    }
}
