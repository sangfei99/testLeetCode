package simple;
/*
461. ��������
��������֮��� �������� ָ�������������ֶ�Ӧ������λ��ͬ��λ�õ���Ŀ��
������������ x �� y�����㲢��������֮��ĺ������롣

ʾ�� 1��
���룺x = 1, y = 4
�����2
���ͣ�
1   (0 0 0 1)
4   (0 1 0 0)
       ��   ��
����ļ�ͷָ���˶�Ӧ������λ��ͬ��λ�á�

ʾ�� 2��
���룺x = 3, y = 1
�����1
 */
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int distance =0;
        while (xor !=0){
            distance += xor & 1;
            xor =xor>>1;
        }
        return distance;
    }
    public static void main(String[] args) {
        HammingDistance solution = new HammingDistance();

        // ʾ�� 1
        int x1 = 1;
        int y1 = 4;
        int result1 = solution.hammingDistance(x1, y1);
        System.out.println(result1);  // ���: 2

        // ʾ�� 2
        int x2 = 3;
        int y2 = 1;
        int result2 = solution.hammingDistance(x2, y2);
        System.out.println(result2);  // ���: 1
    }
}
