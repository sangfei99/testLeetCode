package simple;
import java.util.ArrayList;
import java.util.List;

/*
94. 二叉树的中序遍历
给定一个二叉树的根节点 root ，返回 它的中序遍历 。
示例 1：
输入：root = [1,null,2,3]
输出：[1,3,2]

示例 2：
输入：root = []
输出：[]

示例 3：
输入：root = [1]
输出：[1]
 */
public class InorderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {
        }
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root,result);
        return result;
    }

    private void inorder (TreeNode node, List<Integer> result){
        if (node==null){
            return;
        }
        //访问左子树
        inorder(node.left,result);
        //访问根节点
        result.add(node.val);
        //访问右子树
        inorder(node.right,result);
    }
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.right = new TreeNode(2);
        root1.right.left = new TreeNode(3);
        InorderTraversal solution1 = new InorderTraversal();
        System.out.println(solution1.inorderTraversal(root1)); // 输出: [1, 3, 2]

        // 示例 2
        TreeNode root2 = null;
        InorderTraversal solution2 = new InorderTraversal();
        System.out.println(solution2.inorderTraversal(root2)); // 输出: []

        // 示例 3
        TreeNode root3 = new TreeNode(1);
        InorderTraversal solution3 = new InorderTraversal();
        System.out.println(solution3.inorderTraversal(root3)); // 输出: [1]
        }

}
