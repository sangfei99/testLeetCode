package simple;

import java.util.List;

/*
141. ��������
����һ�������ͷ�ڵ� head ���ж��������Ƿ��л���
�����������ĳ���ڵ㣬����ͨ���������� next ָ���ٴε���������д��ڻ��� Ϊ�˱�ʾ���������еĻ���
����ϵͳ�ڲ�ʹ������ pos ����ʾ����β���ӵ������е�λ�ã������� 0 ��ʼ����ע�⣺pos ����Ϊ�������д��� ��������Ϊ�˱�ʶ�����ʵ�������
��������д��ڻ� ���򷵻� true �� ���򣬷��� false ��

ʾ�� 1��
���룺head = [3,2,0,-4], pos = 1
�����true
���ͣ���������һ��������β�����ӵ��ڶ����ڵ㡣

ʾ�� 2��
���룺head = [1,2], pos = 0
�����true
���ͣ���������һ��������β�����ӵ���һ���ڵ㡣

ʾ�� 3��
���룺head = [1], pos = -1
�����false
���ͣ�������û�л���
 */
public class HasCycle {
     static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next ==null) {
            return false;// ����Ϊ�ջ�ֻ��һ���ڵ㣬�������л�
        }
        ListNode slow = head; //����һ����ָ�룬ÿ���ƶ�1��
        ListNode fast = head.next; //����һ����ָ�룬ÿ���ƶ�2��

        while (slow != fast){
            if (fast == null || fast.next ==null) {
                return false;// ��ָ�뵽������ĩβ��û�л�
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;// ����ָ���������л�
    }

    public static void main(String[] args) {
        // ������������
        ListNode head = new ListNode(3);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(0);
        ListNode fourth = new ListNode(-4);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = second;  // ����һ����

        HasCycle solution = new HasCycle();
        System.out.println(solution.hasCycle(head));  // �����true

        ListNode head2 = new ListNode(1);
        ListNode second2 = new ListNode(2);

        head2.next = second2;
        second2.next = head2;  // ����һ����

        System.out.println(solution.hasCycle(head2));  // �����true

        ListNode head3 = new ListNode(1);

        System.out.println(solution.hasCycle(head3));  // �����false
    }
}
