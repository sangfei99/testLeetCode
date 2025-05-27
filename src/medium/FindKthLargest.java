package medium;

import java.util.PriorityQueue;

/*
215. �����еĵ�K�����Ԫ��
������������ nums ������ k���뷵�������е� k ������Ԫ�ء�
��ע�⣬����Ҫ�ҵ������������ĵ� k ������Ԫ�أ������ǵ� k ����ͬ��Ԫ�ء�
�������Ʋ�ʵ��ʱ�临�Ӷ�Ϊ O(n) ���㷨��������⡣

ʾ�� 1:
����: [3,2,1,5,6,4], k = 2
���: 5

ʾ�� 2:
����: [3,2,3,1,2,4,5,5,6], k = 4
���: 4
 */
public class FindKthLargest {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int num:nums){
            heap.offer(num);
            if (heap.size() >k) {
                heap.poll();// ���ֶѴ�СΪ k
            }
        }
        // �Ѷ�Ԫ�ؼ�Ϊ�� k ���Ԫ��
        return heap.peek();
    }

    public static void main(String[] args) {
        int ret = findKthLargest(new int[]{3,2,1,5,6,4},2);
        System.out.println(ret);
    }
}
