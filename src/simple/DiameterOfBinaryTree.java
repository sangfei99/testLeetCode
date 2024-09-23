package simple;
/*
543. 二叉树的直径
给你一棵二叉树的根节点，返回该树的直径 。
二叉树的直径是指树中任意两个节点之间最长路径的长度 。这条路径可能经过也可能不经过根节点root 。
两节点之间路径的长度由它们之间边数表示。

示例 1：
输入：root = [1,2,3,4,5]
输出：3
解释：3 ，取路径 [4,2,1,3] 或 [5,2,1,3] 的长度。

示例 2：
输入：root = [1,2]
输出：1
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
        // 构建二叉树: [1,2,3,4,5]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // 创建 Solution 实例并计算直径
        DiameterOfBinaryTree solution = new DiameterOfBinaryTree();
        int diameter = solution.diameterOfBinaryTree(root);

        // 输出结果
        System.out.println(diameter);
    }
}
