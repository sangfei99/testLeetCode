package simple;
/*
543. ��������ֱ��
����һ�ö������ĸ��ڵ㣬���ظ�����ֱ�� ��
��������ֱ����ָ�������������ڵ�֮���·���ĳ��� ������·�����ܾ���Ҳ���ܲ��������ڵ�root ��
���ڵ�֮��·���ĳ���������֮�������ʾ��

ʾ�� 1��
���룺root = [1,2,3,4,5]
�����3
���ͣ�3 ��ȡ·�� [4,2,1,3] �� [5,2,1,3] �ĳ��ȡ�

ʾ�� 2��
���룺root = [1,2]
�����1
 */
public class DiameterOfBinaryTree {
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
  private int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return diameter;
    }
    private int dfs(TreeNode node){
        if (node == null) {
            return 0;
        }
        int leftDepth = dfs(node.left);
        int rightDepth = dfs(node.right);

        diameter = Math.max(diameter,leftDepth+rightDepth);
        return Math.max(leftDepth,rightDepth)+1;
    }

    public static void main(String[] args) {
        // ����������: [1,2,3,4,5]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // ���� Solution ʵ��������ֱ��
        DiameterOfBinaryTree solution = new DiameterOfBinaryTree();
        int diameter = solution.diameterOfBinaryTree(root);

        // ������
        System.out.println(diameter);
    }
}
