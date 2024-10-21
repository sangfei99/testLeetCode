package simple;

/*
617. 合并二叉树
给你两棵二叉树： root1 和 root2 。
想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。
你需要将这两棵树合并成一棵新二叉树。
合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。
返回合并后的二叉树。
注意: 合并过程必须从两个树的根节点开始。

示例 1：
输入：root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
输出：[3,4,5,5,4,null,7]

示例 2：
输入：root1 = [1], root2 = [1,2]
输出：[2,2]
 */


import java.util.LinkedList;
import java.util.Queue;

    public class MergeTrees {
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

        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            if (root1 == null) return root2;
            if (root2 == null) return root1;

            // 合并当前节点的值
            TreeNode mergedNode = new TreeNode(root1.val + root2.val);

            // 递归合并左右子树
            mergedNode.left = mergeTrees(root1.left,root2.left);
            mergedNode.right = mergeTrees(root1.right,root2.right);

            return mergedNode;
        }

        //打印二叉树
    public void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("Empty Tree");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current != null) {
                System.out.print(current.val + " ");
                queue.add(current.left);
                queue.add(current.right);
            } else {
                System.out.print("null ");
            }
        }
        System.out.println();
    }


    public static void main(String[] args) {
            MergeTrees solution = new MergeTrees();

            // 创建示例树
            TreeNode root1 = new TreeNode(1, new TreeNode(3, new TreeNode(5), null), new TreeNode(2));
            TreeNode root2 = new TreeNode(2, new TreeNode(1, null, new TreeNode(4)), new TreeNode(3, null, new TreeNode(7)));

            TreeNode mergedRoot = solution.mergeTrees(root1, root2);
            solution.printTree(mergedRoot);
        }

    }

