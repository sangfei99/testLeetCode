package simple;
/*
21. 合并两个有序链表
将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

示例1：
1->2->4
1->3->4
合并为：1->1->2->3->4->4
输入：l1 = [1,2,4], l2 = [1,3,4]
输出：[1,1,2,3,4,4]

示例 2：
输入：l1 = [], l2 = []
输出：[]

示例 3：
输入：l1 = [], l2 = [0]
输出：[0]
 */
public class MergeTwoLists {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
      //创建一个虚拟节点，便于处理边界情况
      ListNode dummy = new ListNode(0);
      ListNode current =dummy;

      //遍历2个链表，直到有一个链表为空
      while (list1 !=null && list2 != null){
        if (list1.val<= list2.val){
          current.next = list1;
          list1=list1.next;
        }else{
          current.next=list2;
          list2 = list2.next;
        }
         current = current.next;
      }

      //连接剩余的节点
      if(list1 != null){
        current.next=list1;
      }else{
        current.next=list2;
      }

      //返回合并后的链表，去掉虚拟头节点
      return dummy.next;
    }

    public static void main(String[] args) {
      // 创建第一个链表：1->2->4
      ListNode l1 = new ListNode(1);
      l1.next = new ListNode(2);
      l1.next.next = new ListNode(4);

      // 创建第二个链表：1->3->4
      ListNode l2 = new ListNode(1);
      l2.next = new ListNode(3);
      l2.next.next = new ListNode(4);

      // 合并两个链表
      ListNode mergedList = mergeTwoLists(l1, l2);

      // 打印合并后的链表
      printList(mergedList);
    }

    //打印链表的方法
  public static void printList(ListNode head) {
    ListNode current = head;
    while (current != null) {
      System.out.print(current.val + " ");
      current = current.next;
    }
    System.out.println();
  }
}
