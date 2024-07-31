package simple;

/*
283. 移动零
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
请注意 ，必须在不复制数组的情况下原地对数组进行操作。
示例 1:
输入: nums = [0,1,0,3,12]
输出: [1,3,12,0,0]

示例 2:
输入: nums = [0]
输出: [0]
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int latsNonZeroIndex = 0;// 用来追踪非零元素的插入位置

        // 遍历数组，将所有非零元素移动到前面
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // 交换当前非零元素与 lastNonZeroIndex 指向的元素
                int temp = nums[i];
                nums[i]=nums[latsNonZeroIndex];
                nums[latsNonZeroIndex]=temp;

                // 移动 lastNonZeroIndex
                latsNonZeroIndex++;
            }
        }
    }

    public static void main(String[] args) {
        MoveZeroes solution = new MoveZeroes();

        int[] nums1 = {0, 1, 0, 3, 12};
        solution.moveZeroes(nums1);
        System.out.println(java.util.Arrays.toString(nums1)); // 输出: [1, 3, 12, 0, 0]

        int[] nums2 = {0};
        solution.moveZeroes(nums2);
        System.out.println(java.util.Arrays.toString(nums2)); // 输出: [0]
    }
}
