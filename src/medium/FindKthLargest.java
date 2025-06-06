package medium;

import java.util.PriorityQueue;

/*
215. 数组中的第K个最大元素
给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。

示例 1:
输入: [3,2,1,5,6,4], k = 2
输出: 5

示例 2:
输入: [3,2,3,1,2,4,5,5,6], k = 4
输出: 4
 */
public class FindKthLargest {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int num:nums){
            heap.offer(num);
            if (heap.size() >k) {
                heap.poll();// 保持堆大小为 k
            }
        }
        // 堆顶元素即为第 k 大的元素
        return heap.peek();
    }

    public static void main(String[] args) {
        int ret = findKthLargest(new int[]{3,2,1,5,6,4},2);
        System.out.println(ret);
    }
}
