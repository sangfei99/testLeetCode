package medium;

import java.util.Arrays;

/*
56.�ϲ�����
������ intervals ��ʾ���ɸ�����ļ��ϣ����е�������Ϊ intervals[i] = [starti, endi] ������ϲ������ص������䣬������һ�����ص����������飬��������ǡ�ø��������е��������䡣

ʾ�� 1��
���룺intervals = [[1,3],[2,6],[8,10],[15,18]]
�����[[1,6],[8,10],[15,18]]
���ͣ����� [1,3] �� [2,6] �ص�, �����Ǻϲ�Ϊ [1,6].

ʾ�� 2��
���룺intervals = [[1,4],[4,5]]
�����[[1,5]]
���ͣ����� [1,4] �� [4,5] �ɱ���Ϊ�ص����䡣
 */
public class Merge {
    public static int[][] merge(int[][] intervals) {

        return new int[][]{{-1},{-1}};
    }

    public static void main(String[] args) {
        int[][] ret = merge(new int[][]{{1,3},{2,6},{8,10},{15,18}});
        System.out.println(Arrays.deepToString(ret));
    }
}
