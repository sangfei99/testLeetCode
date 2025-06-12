package medium;

import java.util.Arrays;

/*
73.��������
����һ�� m x n �ľ������һ��Ԫ��Ϊ 0 �����������к��е�����Ԫ�ض���Ϊ0 ����ʹ��ԭ���㷨

ʾ��1��
���룺matrix = [[1,1,1],[1,0,1],[1,1,1]]
�����[[1,0,1],[0,0,0],[1,0,1]]

ʾ��2��
���룺matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
�����[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 */
public class SetZeroes {
    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean firstrowZero = false;
        boolean firstcolZero = false;

        //1���жϵ�һ���費��Ҫ��0
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstcolZero = true;
                break;
            }
        }
        //2���жϵ�һ���費��Ҫ��0
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                firstrowZero = true;
                break;
            }
        }
        
        //3���õ�һ�к͵�һ�б��0
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                if (matrix[i][j] == 0) {
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }

        //4�����ݱ�ǵ�0����������
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++){
                if(matrix[i][0]==0|| matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }
        //5��������һ��
        if (firstcolZero){
            for (int i = 0; i < m; i++) {
                matrix[0][i] =0;
            }
        }

        //5��������һ��
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
