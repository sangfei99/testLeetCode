package medium;

/*
11.ʢ���ˮ������
����һ������Ϊ n ���������� height ���� n �����ߣ��� i ���ߵ������˵��� (i, 0) �� (i, height[i]) ��
�ҳ����е������ߣ�ʹ�������� x �Ṳͬ���ɵ�����������������ˮ��
�����������Դ�������ˮ����
˵�����㲻����б������

ʾ�� 1��
���룺[1,8,6,2,5,4,8,3,7]
�����49
���ͣ�ͼ�д�ֱ�ߴ����������� [1,8,6,2,5,4,8,3,7]���ڴ�����£������ܹ�����ˮ����ʾΪ��ɫ���֣������ֵΪ 49��
*/
public class MaxArea {
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxArea = 0;

        while (left<right){
            int h = Math.min(height[left],height[right]);
            int width = right-left;
            int area = h * width;

            // �ƶ��϶̵������ߣ���Ϊ�ƶ��ϳ���һ��ֻ���������С��
            maxArea = Math.max(area,maxArea);
            if (height[left]<height[right]){
                left++;
            }
            else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int ret = maxArea(new int[]{1,8,6,2,5,4,8,3,7});
        System.out.println(ret);
    }
}
