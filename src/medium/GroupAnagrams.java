package medium;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
49.字母异位词分组（哈希表）
给你一个字符串数组，请你将字母异位词组合在一起。可以按任意顺序返回结果列表。
字母异位词是由重新排列源单词的所有字母得到的一个新单词。

示例 1:
输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
输出: [["bat"],["nat","tan"],["ate","eat","tea"]]

示例 2:
输入: strs = [""]
输出: [[""]]

示例 3:
输入: strs = ["a"]
输出: [["a"]]
 */
public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        // 创建一个哈希表，用于分组
        HashMap<String,List<String>> map = new HashMap<>();
        for(String str:strs){
            // 将字符串转换成字符数组并排序
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            // 排序后的字符串作为 key
            String key = new String(chars);
            if (!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            // 将原始字符串添加到相应的组
            map.get(key).add(str);
        }
        // 返回哈希表中所有的值（即每个分组）
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> ret = groupAnagrams(strs);
        System.out.println(ret);
    }
}
