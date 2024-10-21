package simple;

/*
617. �ϲ�������
�������ö������� root1 �� root2 ��
����һ�£����㽫����һ�ø��ǵ���һ��֮��ʱ���������ϵ�һЩ�ڵ㽫���ص�������һЩ���ᣩ��
����Ҫ�����������ϲ���һ���¶�������
�ϲ��Ĺ����ǣ���������ڵ��ص�����ô���������ڵ��ֵ�����Ϊ�ϲ���ڵ����ֵ�����򣬲�Ϊ null �Ľڵ㽫ֱ����Ϊ�¶������Ľڵ㡣
���غϲ���Ķ�������
ע��: �ϲ����̱�����������ĸ��ڵ㿪ʼ��

ʾ�� 1��
���룺root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
�����[3,4,5,5,4,null,7]

ʾ�� 2��
���룺root1 = [1], root2 = [1,2]
�����[2,2]
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

            // �ϲ���ǰ�ڵ��ֵ
            TreeNode mergedNode = new TreeNode(root1.val + root2.val);

            // �ݹ�ϲ���������
            mergedNode.left = mergeTrees(root1.left,root2.left);
            mergedNode.right = mergeTrees(root1.right,root2.right);

            return mergedNode;
        }

        //��ӡ������
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

            // ����ʾ����
            TreeNode root1 = new TreeNode(1, new TreeNode(3, new TreeNode(5), null), new TreeNode(2));
            TreeNode root2 = new TreeNode(2, new TreeNode(1, null, new TreeNode(4)), new TreeNode(3, null, new TreeNode(7)));

            TreeNode mergedRoot = solution.mergeTrees(root1, root2);
            solution.printTree(mergedRoot);
        }

    }

