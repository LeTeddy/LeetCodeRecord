package T216;

import java.util.ArrayList;
import java.util.List;

/*
 * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
只使用数字1到9
每个数字 最多使用一次 
返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。

示例 1:
输入: k = 3, n = 7
输出: [[1,2,4]]
解释:
1 + 2 + 4 = 7
没有其他符合的组合了。
示例 2:
输入: k = 3, n = 9
输出: [[1,2,6], [1,3,5], [2,3,4]]
解释:
1 + 2 + 6 = 9
1 + 3 + 5 = 9
2 + 3 + 4 = 9
没有其他符合的组合了。
示例 3:
输入: k = 4, n = 1
输出: []
解释: 不存在有效的组合。
在[1,9]范围内使用4个不同的数字，我们可以得到的最小和是1+2+3+4 = 10，因为10 > 1，没有有效的组合。
 */
class Solution {
  public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    backTracking(k, n, 1, ans, path);
    return ans;
  }

  private void backTracking(int k, int n, int startIndex, List<List<Integer>> ans, List<Integer> path){
    //改一下终止条件 就是收集结果的条件
    int currentSum = sum(path);
    if(path.size() == k && currentSum == n){
      List<Integer> resPath = new ArrayList<>();
      resPath.addAll(path);
      ans.add(resPath);
      return;
    }
    //想办法剪一下枝
    // k - path.size() - 1 这次添加路径后，后面还能加多少路径,其中path.size()是已经有的，1是这次要添加的；
    // n - (k - path.size() - 1) ：就是再往后，后面最少要留下几个数去添加
    // 例如，k = 4,现在path.size()只有1，这次再添加一个，还剩两个(k - path.size() - 1)需要添加
    // n如果等于9，那你的i最多等于到7，后面加上 8 和 9。
    for (int i = startIndex; i <= 9 - (k - path.size()) + 1 && currentSum < n;i++){
      path.add(i);
      backTracking(k, n, i + 1, ans, path);
      path.remove(path.size() - 1);
    }
  }

  private int sum(List<Integer> path){
    int sum = 0;
    for (Integer i : path) {
      sum += i;
    }
    return sum;
  }
}
