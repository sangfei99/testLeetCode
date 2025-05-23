package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
56.�ϲ�����
������ intervals ��ʾ���ɸ�����ļ��ϣ����е�������Ϊ intervals[i] = [starti, endi] ������ϲ������ص������䣬������һ�����ص����������飬
��������ǡ�ø��������е��������䡣

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
        if (intervals == null || intervals.length<=1) {
            return intervals;
        }
        // ��������ʼλ�ý�������
        Arrays.sort(intervals, Comparator.comparingInt(a->a[0]));
        List<int[]> merged = new ArrayList<>();
        int[] current = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            // �����ǰ��������һ���������ص����ϲ�����
            if (current[1] >= intervals[i][0]) {
                current[1] = Math.max(current[1],intervals[i][1]);
            }
            else {
                // ���ص������浱ǰ���䣬����ʼ��һ��
                merged.add(current);
                current = intervals[i];
            }
        }
        // ������һ������
        merged.add(current);

        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        int[][] ret = merge(new int[][]{{2,6},{1,3},{8,10},{15,18}});
        System.out.println(Arrays.deepToString(ret));
    }
}
