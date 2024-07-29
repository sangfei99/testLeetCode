package simple;

/*
234. ��������
����һ���������ͷ�ڵ� head �������жϸ������Ƿ�Ϊ������������ǣ����� true �����򣬷��� false ��
ʾ�� 1��
���룺head = [1,2,2,1]
�����true

ʾ�� 2��
���룺head = [1,2]
�����false
 */
public class IsPalindrome {
      public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }

   //��ת����
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode mid = findMiddle(head);
        ListNode secondHalf = reverse(mid);
        ListNode firstHalf = head;

        // �Ƚ�ǰ�벿�ֺͷ�ת��ĺ�벿��
        while (secondHalf != null){
            if(firstHalf.val != secondHalf.val){
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }

    // �ҵ�������е�
    private ListNode findMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //��ת����
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
        // ����һ���������� 1 -> 2 -> 2 -> 1
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(2);
        head1.next.next.next = new ListNode(1);

        // ����һ���ǻ������� 1 -> 2
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);

        // ���� Solution ʵ��
        IsPalindrome solution = new IsPalindrome();

        // ���Ի�������
        boolean result1 = solution.isPalindrome(head1);
        System.out.println("Is the first list a palindrome? " + result1); // ���: true

        // ���Էǻ�������
        boolean result2 = solution.isPalindrome(head2);
        System.out.println("Is the second list a palindrome? " + result2); // ���: false
    }
}
