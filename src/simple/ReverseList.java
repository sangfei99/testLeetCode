package simple;

/*
206. 反转链表
给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。

示例 1：
输入：head = [1,2,3,4,5]
输出：[5,4,3,2,1]

示例 2：
输入：head = [1,2]
输出：[2,1]

示例 3：
输入：head = []
输出：[]
 */
public class ReverseList {
      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current =head;

        while (current != null){
            ListNode nextNode = current.next; // 记录当前节点的下一个节点
            current.next = prev;// 将当前节点的 next 指向前一个节点
            prev =current;// 前一个节点移动到当前节点
            current =nextNode;// 当前节点移动到下一个节点
        }
        return prev;
    }
    // 辅助函数：从数组构建链表
    public ListNode buildLinkedList(int[] values) {
        if (values.length == 0) {
            return null;
        }
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return head;
    }

    // 辅助函数：将链表转换为数组
    public int[] linkedListToArray(ListNode head) {
        java.util.List<Integer> result = new java.util.ArrayList<>();
        ListNode current = head;
        while (current != null) {
            result.add(current.val);
            current = current.next;
        }
        return result.stream().mapToInt(i -> i).toArray();
    }


    public static void main(String[] args) {
        ReverseList solution = new ReverseList();

        ListNode head = solution.buildLinkedList(new int[]{1, 2, 3, 4, 5});
        ListNode reversedHead = solution.reverseList(head);
        int[] result = solution.linkedListToArray(reversedHead);
        System.out.println(java.util.Arrays.toString(result)); // 输出: [5, 4, 3, 2, 1]

        head = solution.buildLinkedList(new int[]{1, 2});
        reversedHead = solution.reverseList(head);
        result = solution.linkedListToArray(reversedHead);
        System.out.println(java.util.Arrays.toString(result)); // 输出: [2, 1]

        head = solution.buildLinkedList(new int[]{});
        reversedHead = solution.reverseList(head);
        result = solution.linkedListToArray(reversedHead);
        System.out.println(java.util.Arrays.toString(result)); // 输出: []
    }
}
