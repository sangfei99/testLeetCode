package simple;

import medium.LevelOrder;

/*
108.将有序数组转换为二叉搜索树
给你一个整数数组 nums ，其中元素已经按升序排列，请你将其转换为一棵平衡二叉搜索树。

示例 1：
输入：nums = [-10,-3,0,5,9]
输出：[0,-3,9,-10,null,5]
解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：

示例 2：
输入：nums = [1,3]
输出：[3,1]
解释：[1,null,3] 和 [3,1] 都是高度平衡二叉搜索树。
 */
public class SortedArrayToBST {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(){}
        TreeNode(int val){
            this.val=val;
        }
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val=val;
            this.left=left;
            this.right=right;
        }
    }
    public static TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null || nums.length==0) return null;
        return buildBST(nums,0,nums.length-1);
    }
    private  static TreeNode buildBST (int[] nums,int left,int right){
        if(left>right) return null;

        int mid = left+(right-left)/2;

        TreeNode node  = new TreeNode(nums[mid]);
        node.left = buildBST(nums,left,mid-1);
        node.right = buildBST(nums,mid+1,right);

        return node;
    }

    // 中序打印（验证是否是 BST）
    public static void inorderPrint(TreeNode root) {
        if (root == null) return;
        inorderPrint(root.left);
        System.out.print(root.val + " ");
        inorderPrint(root.right);
    }

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode root = sortedArrayToBST(nums);

        System.out.println("中序遍历（验证 BST 性质）:");
        inorderPrint(root);
    }
}
