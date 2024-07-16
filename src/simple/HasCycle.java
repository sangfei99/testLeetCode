package simple;

import java.util.List;

/*
141. 环形链表
给你一个链表的头节点 head ，判断链表中是否有环。
如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，
评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
如果链表中存在环 ，则返回 true 。 否则，返回 false 。

示例 1：
输入：head = [3,2,0,-4], pos = 1
输出：true
解释：链表中有一个环，其尾部连接到第二个节点。

示例 2：
输入：head = [1,2], pos = 0
输出：true
解释：链表中有一个环，其尾部连接到第一个节点。

示例 3：
输入：head = [1], pos = -1
输出：false
解释：链表中没有环。
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
            return false;// 链表为空或只有一个节点，不可能有环
        }
        ListNode slow = head; //定义一个慢指针，每次移动1步
        ListNode fast = head.next; //定义一个快指针，每次移动2步

        while (slow != fast){
            if (fast == null || fast.next ==null) {
                return false;// 快指针到达链表末尾，没有环
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;// 快慢指针相遇，有环
    }

    public static void main(String[] args) {
        // 创建测试用例
        ListNode head = new ListNode(3);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(0);
        ListNode fourth = new ListNode(-4);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = second;  // 创建一个环

        HasCycle solution = new HasCycle();
        System.out.println(solution.hasCycle(head));  // 输出：true

        ListNode head2 = new ListNode(1);
        ListNode second2 = new ListNode(2);

        head2.next = second2;
        second2.next = head2;  // 创建一个环

        System.out.println(solution.hasCycle(head2));  // 输出：true

        ListNode head3 = new ListNode(1);

        System.out.println(solution.hasCycle(head3));  // 输出：false
    }
}
