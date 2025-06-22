package medium;

import java.util.ArrayList;
import java.util.List;

/*
46.全排列
给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。

示例 1：
输入：nums = [1,2,3]
输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

示例 2：
输入：nums = [0,1]
输出：[[0,1],[1,0]]

示例 3：
输入：nums = [1]
输出：[[1]]
 */
public class Permute {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path  = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums,used,path,result);
        return result;

    }
    public static void backtrack (int[] nums,boolean[] used, List<Integer> path,List<List<Integer>> result){
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;//如果已经被使用则跳过

            path.add(nums[i]);
            used[i] = true;

            backtrack(nums,used,path,result);//继续选择下一个数字

            //回溯
            path.remove(path.size()-1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> res = permute(new int[]{1,2,3});
        System.out.println(res);
    }
}
