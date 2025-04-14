package T90;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
/*
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的 子集（幂集）。
解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
示例 1:
输入：nums = [1,2,2]
输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
示例 2：
输入：nums = [0]
输出：[[],[0]]
 */
//这种就是输入数组有重复元素，但输出数组不要重复元素，那就是前面那个题，就是某一个子树里面已经包含其兄弟子树的结果了，所以就整一个newStartIndex赋给i，i不要自加了。
//这个newStartIndex就是下一个跟跟当前i指向的元素不同
class Solution {
  public static void main(String[] args) {
    Solution so = new Solution();
    so.subsetsWithDup(new int[]{1,2,2});
  }
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> ans = new ArrayList<>();
    Stack<Integer> path = new Stack<>();
    backTrace(nums, 0, ans, path);
    return ans;
  }

  private void backTrace(int[] nums, int startIndex, List<List<Integer>> ans, Stack<Integer> path){
    ans.add(new ArrayList<Integer>(path));
    for (int i = startIndex; i < nums.length;){
      path.push(nums[i]);
      backTrace(nums, i + 1, ans, path);
      path.pop();
      int newStartIndex = i + 1;
      while(newStartIndex < nums.length && nums[i] == nums[newStartIndex]) newStartIndex++;
      i = newStartIndex;
    }
  }
}