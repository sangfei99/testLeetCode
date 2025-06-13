package simple;

import medium.LevelOrder;

/*
108.����������ת��Ϊ����������
����һ���������� nums ������Ԫ���Ѿ����������У����㽫��ת��Ϊһ��ƽ�������������

ʾ�� 1��
���룺nums = [-10,-3,0,5,9]
�����[0,-3,9,-10,null,5]
���ͣ�[0,-10,5,null,-3,null,9] Ҳ������Ϊ��ȷ�𰸣�

ʾ�� 2��
���룺nums = [1,3]
�����[3,1]
���ͣ�[1,null,3] �� [3,1] ���Ǹ߶�ƽ�������������
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

    // �����ӡ����֤�Ƿ��� BST��
    public static void inorderPrint(TreeNode root) {
        if (root == null) return;
        inorderPrint(root.left);
        System.out.print(root.val + " ");
        inorderPrint(root.right);
    }

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode root = sortedArrayToBST(nums);

        System.out.println("�����������֤ BST ���ʣ�:");
        inorderPrint(root);
    }
}
