package simple;

/*
206. ��ת����
���㵥�����ͷ�ڵ� head �����㷴ת���������ط�ת�������

ʾ�� 1��
���룺head = [1,2,3,4,5]
�����[5,4,3,2,1]

ʾ�� 2��
���룺head = [1,2]
�����[2,1]

ʾ�� 3��
���룺head = []
�����[]
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
            ListNode nextNode = current.next; // ��¼��ǰ�ڵ����һ���ڵ�
            current.next = prev;// ����ǰ�ڵ�� next ָ��ǰһ���ڵ�
            prev =current;// ǰһ���ڵ��ƶ�����ǰ�ڵ�
            current =nextNode;// ��ǰ�ڵ��ƶ�����һ���ڵ�
        }
        return prev;
    }
    // ���������������鹹������
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

    // ����������������ת��Ϊ����
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
        System.out.println(java.util.Arrays.toString(result)); // ���: [5, 4, 3, 2, 1]

        head = solution.buildLinkedList(new int[]{1, 2});
        reversedHead = solution.reverseList(head);
        result = solution.linkedListToArray(reversedHead);
        System.out.println(java.util.Arrays.toString(result)); // ���: [2, 1]

        head = solution.buildLinkedList(new int[]{});
        reversedHead = solution.reverseList(head);
        result = solution.linkedListToArray(reversedHead);
        System.out.println(java.util.Arrays.toString(result)); // ���: []
    }
}
