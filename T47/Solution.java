package T47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/*
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
示例 1：
输入：nums = [1,1,2]
输出：
[[1,1,2],
 [1,2,1],
 [2,1,1]]
示例 2：
输入：nums = [1,2,3]
输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
class Solution {
  public static void main(String[] args) {
    Solution so = new Solution();
    so.permuteUnique(new int[]{1,1,2});
  }

  public List<List<Integer>> permuteUnique(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> ans = new ArrayList<>();
    Stack<Integer> path = new Stack<>();
    int[] used = new int[nums.length];
    backTrace(nums, used, ans, path);
    return ans;
  }

  private void backTrace(int[] nums, int[] used, List<List<Integer>> ans, Stack<Integer> path) {
    if(path.size() == nums.length){
      ans.add(new ArrayList<>(path));
    }
    for (int i = 0; i < nums.length;i++) {
      //i > 0防止后面i - 1为负
      //user[i - 1] == 0 && nums[i] == nums[i - 1]说明前一个与当前元素相同的元素没有用，那就是回溯回来的，前一个肯定是先用的，并且已经包含了不用这个的情况，然后用这个不用前一个的话就跟前一个用了不用这一个一样，所以跳过
      if(i > 0 && used[i - 1] == 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      if(used[i] != 1) {
        path.push(nums[i]);
        used[i] = 1;
        backTrace(nums, used, ans, path);
        path.pop();
        used[i] = 0;
      }
      //简单一点就用i++，每次进入循环都判断就完事儿了
      // int newStartIndex = 0;
      // while (newStartIndex < nums.length && nums[newStartIndex] == nums[i] && used[newStartIndex] == 1) {
      //   newStartIndex++;
      // }
      // i = newStartIndex;
    }
  }
}
