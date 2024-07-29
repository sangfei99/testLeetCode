package simple;


/*
226. ��ת������
����һ�ö������ĸ��ڵ� root ����ת��ö�����������������ڵ㡣
ʾ�� 1��
���룺root = [4,2,7,1,3,6,9]
�����[4,7,2,9,6,3,1]

ʾ�� 2��
���룺root = [2,1,3]
�����[2,3,1]

ʾ�� 3��
���룺root = []
�����[]
 */
public class InvertTree {
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

    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        //������������
        TreeNode temp = root.left;
        root.left=root.right;
        root.right = temp;

        //�ݹ鷭ת��������
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public static void printPreOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        // ��ת������
        InvertTree solution = new InvertTree();
        TreeNode invertedRoot = solution.invertTree(root);
        printPreOrder(invertedRoot); // ���ӦΪ��4 7 9 6 2 3 1
    }
}
