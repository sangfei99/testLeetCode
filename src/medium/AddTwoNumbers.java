package medium;

import simple.MergeTwoLists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*
2.�������
���������ǿյ�������ʾ�����Ǹ�������������ÿλ���ֶ��ǰ�������ķ�ʽ�洢�ģ�����ÿ���ڵ�ֻ�ܴ洢һλ���֡�
���㽫��������ӣ�������ͬ��ʽ����һ����ʾ�͵�����
����Լ���������� 0 ֮�⣬���������������� 0 ��ͷ��

ʾ�� 1��
���룺l1 = [2,4,3], l2 = [5,6,4]
�����[7,0,8]
���ͣ�342 + 465 = 807.

ʾ�� 2��
���룺l1 = [0], l2 = [0]
�����[0]

ʾ�� 3��
���룺l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
�����[8,9,9,9,0,0,0,1]
 */
public class AddTwoNumbers {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode (){}
        ListNode (int val){
            this.val = val;
        }
        ListNode (int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int carry = 0;

        while (l1 !=null || l2 !=null || carry!=0){
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            curr.next = new ListNode(sum % 10);
            carry = sum/10;

            curr = curr.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode res = addTwoNumbers(l1,l2);
        printList(res);
    }

    //��ӡ����ķ���
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}
