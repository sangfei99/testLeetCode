package medium;

import java.util.Arrays;

/*
73.矩阵置零
给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为0 。请使用原地算法

示例1：
输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
输出：[[1,0,1],[0,0,0],[1,0,1]]

示例2：
输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 */
public class SetZeroes {
    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean firstrowZero = false;
        boolean firstcolZero = false;

        //1、判断第一列需不需要置0
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstcolZero = true;
                break;
            }
        }
        //2、判断第一行需不需要置0
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                firstrowZero = true;
                break;
            }
        }
        
        //3、用第一行和第一列标记0
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                if (matrix[i][j] == 0) {
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }

        //4、根据标记的0对行列置零
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++){
                if(matrix[i][0]==0|| matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }
        //5、最后处理第一列
        if (firstcolZero){
            for (int i = 0; i < m; i++) {
                matrix[0][i] =0;
            }
        }

        //5、最后处理第一行
        if (firstrowZero){
            for (int i = 0; i < m; i++) {
                matrix[i][0] =0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] res = new int[][]{{1,1,1},{1,0,1},{1,1,1}};
        setZeroes(res);
        System.out.println(Arrays.deepToString(res));
    }
}
