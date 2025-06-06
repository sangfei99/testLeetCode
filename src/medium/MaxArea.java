package medium;

/*
11.盛最多水的容器
给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
返回容器可以储存的最大水量。
说明：你不能倾斜容器。

示例 1：
输入：[1,8,6,2,5,4,8,3,7]
输出：49
解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
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

            // 移动较短的那条线（因为移动较长的一端只会让面积更小）
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
