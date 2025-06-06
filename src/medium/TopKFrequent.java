package medium;

import java.util.*;

/*
347.前 K 个高频元素
给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按任意顺序返回答案。

示例 1:
输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]

示例 2:
输入: nums = [1], k = 1
输出: [1]
 */
public class TopKFrequent {
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> minheap = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for(Map.Entry<Integer,Integer> entry :map.entrySet()) {
            minheap.offer(entry);
            if (minheap.size()>k) {
                minheap.poll();
            }
        }
        int[] ret = new int[k];
        int index =0;
        while(!minheap.isEmpty()){
            ret[index++] = minheap.poll().getKey();
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] ret = topKFrequent(new int[]{1,1,1,2,2,3},2);
        System.out.println(Arrays.toString(ret));
    }
}
