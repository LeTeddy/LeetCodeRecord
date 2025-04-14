package T46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collector;

/*
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
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
class Solution {
  public static void main(String[] args) {
    Solution so = new Solution();
    so.permute(new int[]{1,2,3});
  }
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    Stack<Integer> path = new Stack<>();
    HashSet<Integer> notUsed = new HashSet<>();
    notUsed.addAll(Arrays.stream(nums).boxed().toList());
    backTrace(nums, 0, ans, path, notUsed);
    return ans;
  }

  private void backTrace(int[] nums, int startIndex, List<List<Integer>> ans, Stack<Integer> path, HashSet<Integer> notUsed){
    //used哈希set作为参数往下传
    if(path.size() == nums.length && notUsed.size() == 0){
      ans.add(new ArrayList<>(path));
      return;
    }
    HashSet<Integer> notUsedCopy = new HashSet<>(notUsed);
    for(Integer num : notUsedCopy){
      path.push(num);
      notUsed.remove(num);
      backTrace(nums, startIndex, ans, path, notUsed);
      path.pop();
      notUsed.add(num);
    }
  }
}
