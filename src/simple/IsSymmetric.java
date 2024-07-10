package simple;

import java.util.List;

/*
101. 对称二叉树
给你一个二叉树的根节点 root ， 检查它是否轴对称。

示例 1：
输入：root = [1,2,2,3,4,4,3]
输出：true

示例 2：
输入：root = [1,2,2,null,3,null,3]
输出：false
 */
public class IsSymmetric {
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

    public boolean isSymmetric(TreeNode root) {
        if (root==null){
            return true;
        }
        return isMirror(root.left,root.right);
    }

    public boolean isMirror(TreeNode left, TreeNode right) {
        if(left == null && right == null){
         return true;   
        }
        if (left == null || right == null) {
            return false;
        }
        return (left.val == right.val && isMirror(left.right,right.left) && isMirror(left.left,right.right));
    }


    public static void main(String[] args) {
        IsSymmetric solution = new IsSymmetric();

        // 示例 1
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(4);
        root1.right.left = new TreeNode(4);
        root1.right.right = new TreeNode(3);
        System.out.println(solution.isSymmetric(root1)); // 输出: true

        // 示例 2
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.right = new TreeNode(3);
        root2.right.right = new TreeNode(3);
        System.out.println(solution.isSymmetric(root2)); // 输出: false
    }
}
