package medium;

import simple.FindDisappearedNumbers;
import simple.HasCycle;
import simple.ReverseList;

/*
142.��������II
����һ�������ͷ�ڵ�head ����������ʼ�뻷�ĵ�һ���ڵ㡣 ��������޻����򷵻� null��
�����������ĳ���ڵ㣬����ͨ���������� next ָ���ٴε���������д��ڻ��� Ϊ�˱�ʾ���������еĻ�������ϵͳ�ڲ�ʹ������ pos ����ʾ����β���ӵ������е�λ�ã������� 0 ��ʼ����
��� pos �� -1�����ڸ�������û�л���ע�⣺pos ����Ϊ�������д��ݣ�������Ϊ�˱�ʶ�����ʵ�������
�������޸�����

ʾ�� 1��
���룺head = [3,2,0,-4], pos = 1
�������������Ϊ 1 ������ڵ�
���ͣ���������һ��������β�����ӵ��ڶ����ڵ㡣
 */
public class DetectCycle {

    static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){
            this.val=val;
        }
        ListNode(int val,ListNode next){
            this.val= val;
            this.next= next;
        }
    }
    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next==null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;

        // ��һ�����ж��Ƿ��л�
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                ListNode index1 = head;
                ListNode index2 = slow;

                // �ڶ�������ͷ��ʼ��һ��ָ�룬Ѱ���뻷��
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;// �뻷��
            }

        }
        return null;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node0 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        head.next = node2;
        node2.next = node0;
        node0.next = node4;
        node4.next = node2; // ���ɻ������Ϊnode2

        ListNode cycleStart = detectCycle(head);

        if (cycleStart != null) {
            System.out.println("Cycle starts at node with value: " + cycleStart.val);
        } else {
            System.out.println("No cycle in the list.");
        }
    }
}
