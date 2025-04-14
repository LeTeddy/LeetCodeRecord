package T40;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
///////-notDoneYet-notDoneYet-notDoneYet-notDoneYet-notDoneYet-notDoneYet-notDoneYet-notDoneYet-notDoneYet//////
/*
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
candidates 中的每个数字在每个组合中只能使用 一次 。
注意：解集不能包含重复的组合。 
示例 1:
输入: candidates = [10,1,2,7,6,1,5], target = 8,
输出:
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
示例 2:
输入: candidates = [2,5,2,1,2], target = 5,
输出:
[
[1,2,2],
[5]
]
 */
public class Solution {
  public static void main(String[] args) {
    Solution so = new Solution();
    so.combinationSum(new int[]{1,2}, 4);
  }

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    //这个大概要去重了
    //先排序   1  1  {----}这一支中包含  1  {----}，因为包含不取第二个1的分支  1   1（不取）  {----}   ==  1   {----}
    Arrays.sort(candidates);
    HashSet<List<Integer>> ans = new HashSet<>();
    Integer sum = 0;
    List<Integer> path = new ArrayList<>();
    backTrace(candidates, target, 0, ans, sum, path);
    List<List<Integer>> res = new ArrayList<>(ans);
    return res;
  }

  private void backTrace(int[] candidates, int target, int startIndex, HashSet<List<Integer>> ans, Integer sum, List<Integer> path){
    if (sum > target) {
      return;
    }
    //这样去重会超时
    if (sum == target) {
      List<Integer> resPath = new ArrayList<>();
      resPath.addAll(path);
      resPath.sort(Comparator.naturalOrder());
      ans.add(resPath);
      return;
    }
    int newStartIndex = startIndex + 1;
    for (int i = startIndex;i < candidates.length && sum < target;i = newStartIndex) {
      path.add(candidates[i]);
      sum += candidates[i];
      backTrace(candidates, target, newStartIndex, ans, sum, path);
      sum -= candidates[i];
      path.remove(path.size() - 1);
      while(newStartIndex < candidates.length && candidates[i] == candidates[newStartIndex]){
        newStartIndex++;
      }
    }
  }
}
