package simple;

/*
234. 回文链表
给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
示例 1：
输入：head = [1,2,2,1]
输出：true

示例 2：
输入：head = [1,2]
输出：false
 */
public class IsPalindrome {
      public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }

   //反转链表法
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode mid = findMiddle(head);
        ListNode secondHalf = reverse(mid);
        ListNode firstHalf = head;

        // 比较前半部分和反转后的后半部分
        while (secondHalf != null){
            if(firstHalf.val != secondHalf.val){
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }

    // 找到链表的中点
    private ListNode findMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //反转链表
    private ListNode reverse(ListNode head){
          ListNode prev = null;
          ListNode curr = head;
          while (curr!=null){
              ListNode next = curr.next;
              curr.next=prev;
              prev = curr;
              curr = next;
          }
          return prev;
    }

    public static void main(String[] args) {
        // 创建一个回文链表 1 -> 2 -> 2 -> 1
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(2);
        head1.next.next.next = new ListNode(1);

        // 创建一个非回文链表 1 -> 2
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);

        // 创建 Solution 实例
        IsPalindrome solution = new IsPalindrome();

        // 测试回文链表
        boolean result1 = solution.isPalindrome(head1);
        System.out.println("Is the first list a palindrome? " + result1); // 输出: true

        // 测试非回文链表
        boolean result2 = solution.isPalindrome(head2);
        System.out.println("Is the second list a palindrome? " + result2); // 输出: false
    }
}
