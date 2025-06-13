package medium;

import simple.HasCycle;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
102.�������Ĳ������
����������ĸ��ڵ� root ��������ڵ�ֵ�� ������� �� �������أ������ҷ������нڵ㣩��

ʾ�� 1��
���룺root = [3,9,20,null,null,15,7]
�����[[3],[9,20],[15,7]]

ʾ�� 2��
���룺root = [1]
�����[[1]]

ʾ�� 3��
���룺root = []
�����[]
 */

public class LevelOrder {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(){}
        TreeNode(int val){
            this.val=val;
        }
        TreeNode(int val,TreeNode left,TreeNode right){
            this.val=val;
            this.left=left;
            this.right=right;
        }
    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root==null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i <size ; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add(level);
        }
        return result;
    }

    public static TreeNode buildTree(Integer[] values) {
        if (values == null || values.length == 0 || values[0] == null) return null;

        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;

        while (i < values.length) {
            TreeNode current = queue.poll();
            if (values[i] != null) {
                current.left = new TreeNode(values[i]);
                queue.offer(current.left);
            }
            i++;

            if (i < values.length && values[i] != null) {
                current.right = new TreeNode(values[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }
    public static void main(String[] args) {
        Integer[] input = {3, 9, 20, null, null, 15, 7};
        TreeNode root = buildTree(input);
        List<List<Integer>> result = levelOrder(root);

        // ��ӡ������
        for (List<Integer> level : result) {
            System.out.println(level);
        }
    }

}
