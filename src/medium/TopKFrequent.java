package medium;

import java.util.*;

/*
347.ǰ K ����ƵԪ��
����һ���������� nums ��һ������ k �����㷵�����г���Ƶ��ǰ k �ߵ�Ԫ�ء�����԰�����˳�򷵻ش𰸡�

ʾ�� 1:
����: nums = [1,1,1,2,2,3], k = 2
���: [1,2]

ʾ�� 2:
����: nums = [1], k = 1
���: [1]
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
