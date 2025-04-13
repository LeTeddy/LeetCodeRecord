package T77;

import java.util.ArrayList;
import java.util.List;

/*
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。

你可以按 任何顺序 返回答案。
示例 1：
输入：n = 4, k = 2
输出：
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 */
class Solution {
  public static void main(String[] args) {
    Solution so = new Solution();
    so.combine(4, 2);
  }

  public List<List<Integer>> combine(int n, int k) {
    // define global variable
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    backTracking(n, k, ans, path, 1);
    return ans;
  }

  private void backTracking(int n, int k, List<List<Integer>> ans, List<Integer> path, int startIndex) {
    //终止条件
    if (path.size() == k) {
      //收集结果
      List<Integer> resPath = new ArrayList<>();
      resPath.addAll(path);
      ans.add(resPath);
      return;
    }
    //不到终止条件的话，就继续递归，递归完别忘回溯
    //剪枝!
    for (int i = startIndex; i <= n - (k - path.size()) + 1; i ++){
      path.add(i);
      //递归
      backTracking(n, k, ans, path, i + 1);
      //回溯
      path.remove(path.size() - 1);
    }
  }
}