package simple;
/*
104. ��������������
����һ�������� root �������������ȡ�
�������� ������ ��ָ�Ӹ��ڵ㵽��ԶҶ�ӽڵ���·���ϵĽڵ�����

ʾ�� 1��
���룺root = [3,9,20,null,null,15,7]
�����3

ʾ�� 2��
���룺root = [1,null,2]
�����2
 */
public  class MaxDepth {
      public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth,rightDepth)+1;
    }

    public static void main(String[] args) {
        MaxDepth solution = new MaxDepth();
        // ʾ�� 1
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        System.out.println(solution.maxDepth(root1)); // ���: 3

        // ʾ�� 2
        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(2);
        System.out.println(solution.maxDepth(root2)); // ���: 2
    }
}
