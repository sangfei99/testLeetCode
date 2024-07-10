package simple;

import java.util.List;

/*
101. �Գƶ�����
����һ���������ĸ��ڵ� root �� ������Ƿ���Գơ�

ʾ�� 1��
���룺root = [1,2,2,3,4,4,3]
�����true

ʾ�� 2��
���룺root = [1,2,2,null,3,null,3]
�����false
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

//    isSymmetric�������ж����Ƿ�Ϊ�գ����Ϊ���򷵻�true���������isMirror�����ж����������������Ƿ���Գơ�
    public boolean isSymmetric(TreeNode root) {
        if (root==null){
            return true;
        }
        return isMirror(root.left,root.right);
    }

    //    isMirror�������ݹ�ؼ�����������Ƿ���Գơ��������������Ϊ�գ�����true���������һ��Ϊ�գ�����false�����򣬱Ƚϵ�ǰ�ڵ��ֵ���ݹ����ӽڵ㡣
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

        // ʾ�� 1
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(4);
        root1.right.left = new TreeNode(4);
        root1.right.right = new TreeNode(3);
        System.out.println(solution.isSymmetric(root1)); // ���: true

        // ʾ�� 2
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.right = new TreeNode(3);
        root2.right.right = new TreeNode(3);
        System.out.println(solution.isSymmetric(root2)); // ���: false
    }
}
