package T39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;
/*
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。

candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 

对于给定的输入，保证和为 target 的不同组合数少于 150 个。
示例 1：
输入：candidates = [2,3,6,7], target = 7
输出：[[2,2,3],[7]]
解释：
2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
7 也是一个候选， 7 = 7 。
仅有这两种组合。
示例 2：
输入: candidates = [2,3,5], target = 8
输出: [[2,2,2,2],[2,3,3],[3,5]]
示例 3：
输入: candidates = [2], target = 1
输出: []
 */
public class Solution {
  public static void main(String[] args) {
    Solution so = new Solution();
    so.combinationSum(new int[]{2,3,6,7}, 7);
  }

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    //需要去重的话，忘set里放就行，放之前先排好序
    //但这不是最好的方案
    //反正凡是不重复的组合，就得组合C，如果能重复用已选的，那大不了不从i+1开始而是还从i开始。就是得需要一个startIndex。
    //还能优化的地方是，先把candidates排序，后续可以剪枝
    HashSet<List<Integer>> ans = new HashSet<>();
    Integer sum = 0;
    List<Integer> path = new ArrayList<>();
    backTrace(candidates, target, ans, sum, path);
    List<List<Integer>> res = new ArrayList<>(ans);
    
    return res;
  }

  private void backTrace(int[] candidates, int target, HashSet<List<Integer>> ans, Integer sum, List<Integer> path){
    if (sum == target) {
      List<Integer> resPath = new ArrayList<>();
      resPath.addAll(path);
      resPath.sort(Comparator.naturalOrder());
      ans.add(resPath);
      return;
    }
    if (sum > target) {
      return;
    }
    for (int candidate : candidates) {
      path.add(candidate);
      sum += candidate;
      backTrace(candidates, target, ans, sum, path);
      sum -= candidate;
      path.remove(path.size() - 1);
    }
  }
}
