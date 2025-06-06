package simple;
/*
160.相交链表
给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
图示两个链表在节点 c1 开始相交：
题目数据保证整个链式结构中不存在环。
注意，函数返回结果后，链表必须保持其原始结构。

自定义评测：
评测系统 的输入如下（你设计的程序 不适用 此输入）：
intersectVal - 相交的起始节点的值。如果不存在相交节点，这一值为 0
listA - 第一个链表
listB - 第二个链表
skipA - 在 listA 中（从头节点开始）跳到交叉节点的节点数
skipB - 在 listB 中（从头节点开始）跳到交叉节点的节点数
评测系统将根据这些输入创建链式数据结构，并将两个头节点 headA 和 headB 传递给你的程序。如果程序能够正确返回相交节点，那么你的解决方案将被 视作正确答案 。

示例 1：
输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
输出：Intersected at '8'
解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,6,1,8,4,5]。
在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
— 请注意相交节点的值不为 1，因为在链表 A 和链表 B 之中值为 1 的节点 (A 中第二个节点和 B 中第三个节点) 是不同的节点。
换句话说，它们在内存中指向两个不同的位置，而链表 A 和链表 B 中值为 8 的节点 (A 中第三个节点，B 中第四个节点) 在内存中指向相同的位置。
 */

public class GetIntersectionNode {
    public static class ListNode {
        int val;          // 节点的值
        ListNode next;    // 指向下一个节点的指针

        ListNode() {} // 无参构造函数

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //如果两个链表均为空，则返回null
        if (headA == null || headB == null) {
            return null;
        }
        //创建2个指针
        ListNode pA = headA;
        ListNode pB = headB;

        //两个指针最终会相遇在相交点或在遍历完两个链表后同时指向 null
        while (pA!=pB){   //注：链表节点的内存地址相同才是真正的相等，值相同不代表相等
            pA = (pA == null)?headB:pA.next;
            pB = (pB == null)?headA:pB.next;
        }
        // pA 和 pB 相等时，可能是相交节点或都为 null（表示没有相交节点）
        return pA;
    }

    public static void main(String[] args) {
            // 创建示例链表
            // 链表A: 4 -> 1 -> 8 -> 4 -> 5
            ListNode headA = new ListNode(4);
            headA.next = new ListNode(1);
            ListNode intersection = new ListNode(8);
            headA.next.next = intersection;
            intersection.next = new ListNode(4);
            intersection.next.next = new ListNode(5);

            // 链表B: 5 -> 6 -> 1 -> 8 -> 4 -> 5
            ListNode headB = new ListNode(5);
            headB.next = new ListNode(6);
            headB.next.next = new ListNode(1);
            headB.next.next.next = intersection;

            // 查找相交节点
            GetIntersectionNode solution = new GetIntersectionNode();
            ListNode result = solution.getIntersectionNode(headA, headB);

            // 打印结果
            if (result != null) {
                System.out.println("Intersection at node with value: " + result.val);
            } else {
                System.out.println("No intersection");
            }
    }
}
