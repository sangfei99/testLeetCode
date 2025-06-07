package simple;

import java.util.ArrayList;
import java.util.List;

/*
118.杨辉三角
给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
在「杨辉三角」中，每个数是它左上方和右上方的数的和。

示例 1:
输入: numRows = 5
输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

示例 2:
输入: numRows = 1
输出: [[1]]
 */
public class Generate {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                // 每一行的开头和结尾都是 1
                if (j == 0 || j==i) {
                    row.add(1);
                }
                else {
                    // 中间的值等于上一行的两个值之和
                    int val = triangle.get(i-1).get(j-1) + triangle.get(i-1).get(j);
                    row.add(val);
                }
            }
            triangle.add(row);
        }
        return triangle;
    }

    public static void main(String[] args) {
        List<List<Integer>> ret = generate(5);
        System.out.println(ret);
    }
}
