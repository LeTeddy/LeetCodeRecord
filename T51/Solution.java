package T51;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
示例 1：
输入：n = 4
输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
解释：如上图所示，4 皇后问题存在两个不同的解法。
示例 2：
输入：n = 1
输出：[["Q"]] */
class Solution {
  public static void main(String[] args) {
    Solution so = new Solution();
    so.solveNQueens(4);
  }
  public List<List<String>> solveNQueens(int n) {
      List<Integer> cols = new ArrayList<>();
      List<List<String>> ans = new ArrayList<>();
      //这树的深度就是n，每次递归是处理某一行，每个递归里的for是处理每一列
      //路径大小为n时判断是否收集
      backTrace(n, cols, ans);
      return ans;
  }

  private void backTrace(int n, List<Integer> cols, List<List<String>> ans){
    if(cols.size() == n){
      //判断斜对角能不能攻击到
      Stack<String> res = new Stack<>();
      ArrayList<Integer> colsCopy = new ArrayList<>(cols);
      while (!colsCopy.isEmpty()) {
        StringBuffer sb = new StringBuffer();
        //一个一个判断，判断完了就打出去
        //这个打不到其他的，那其他的也打不到这个
        int rowNum = colsCopy.size() - 1;
        int colNum = colsCopy.remove(rowNum);
        for (int i = 0; i < colNum; i++) {
          sb.append(".");
        }
        sb.append("Q");
        for (int i = colNum + 1; i < n; i++) {
          sb.append(".");
        }
        res.add(sb.toString());
      }
      ans.add(res);
    }
    //每行只放一个，保证不存在同一行
    for (int i = 0; i < n; i++) {
      if(cols.contains(i)){
        //保证不存在同一列
        continue;
      }
      //保证打不到其他皇后
      //这个打不到其他的，那其他的也打不到这个
      int rowNum = cols.size();
      int colNum = i;
      int j = 0;
      for (; j < cols.size(); j++) {
        if(j - rowNum == cols.get(j) - colNum || rowNum - j == cols.get(j) - colNum){
          break;
        }
      }
      if(j != cols.size()){
        continue;
      }
      cols.add(i);
      backTrace(n, cols, ans);
      cols.remove(cols.size() - 1);
    }
  }
}
