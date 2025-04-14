package T78;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
示例 1：
输入：nums = [1,2,3]
输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
示例 2：
输入：nums = [0]
输出：[[],[0]]
 */
class Solution {
  public static void main(String[] args) {
    Solution so = new Solution();
    so.subsets(new int[]{1,2,3});

  }
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    Stack<Integer> path = new Stack<>();
    // 先加上空集 空集是任何集合的子集
    backTrace(nums, 0, ans, path);
    return ans;
  }

  private void backTrace(int[] nums, int startIndex, List<List<Integer>> ans, Stack<Integer> path) {
    ans.add(new ArrayList<Integer>(path));
    for(int i = startIndex;i < nums.length;i++){
      path.push(nums[i]);
      backTrace(nums, i + 1, ans, path);
      path.pop();
    }
  }
}
