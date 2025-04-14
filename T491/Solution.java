package T491;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

/*
 * 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
示例 1：
输入：nums = [4,6,7,7]
输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
示例 2：
输入：nums = [4,4,3,2,1]
输出：[[4,4]]
 */
class Solution {
  public static void main(String[] args) {
    Solution so = new Solution();
    so.findSubsequences(new int[]{4,7,6,7});
  }
  public List<List<Integer>> findSubsequences(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    Stack<Integer> path = new Stack<>();
    backTrace(nums, 0, ans, path);
    return ans;
  }

  private void backTrace(int[] nums, int startIndex, List<List<Integer>> ans, Stack<Integer> path){
    if(path.size() > 1){
      ans.add(new ArrayList<>(path));
    }
    HashSet<Integer> set = new HashSet<>();
    for (int i = startIndex;i < nums.length;i++){
      if(set.contains(nums[i])) continue;
      if(path.isEmpty() || path.peek() <= nums[i]) {path.add(nums[i]);set.add(nums[i]);}
      else continue;
      backTrace(nums, i + 1, ans, path);
      path.pop();
      //不能这样写，输入集合是无序的而且也不能排序
      // //像这样的就每一层里加一个set来记录取过那些元素
      // int newStartIndex = i + 1;
      // while (newStartIndex < nums.length && nums[i] == nums[newStartIndex]) {
      //   newStartIndex++;
      // }
      // i = newStartIndex;
    }
  }
}