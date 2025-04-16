package T63;
/*给定一个 m x n 的整数数组 grid。一个机器人初始位于 左上角（即 grid[0][0]）。机器人尝试移动到 右下角（即 grid[m - 1][n - 1]）。机器人每次只能向下或者向右移动一步。
网格中的障碍物和空位置分别用 1 和 0 来表示。机器人的移动路径中不能包含 任何 有障碍物的方格。
返回机器人能够到达右下角的不同路径数量。
测试用例保证答案小于等于 2 * 109。
示例 1：
输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
输出：2
解释：3x3 网格的正中间有一个障碍物。
从左上角到右下角一共有 2 条不同的路径：
1. 向右 -> 向右 -> 向下 -> 向下
2. 向下 -> 向下 -> 向右 -> 向右
示例 2：
输入：obstacleGrid = [[0,1],[0,0]]
输出：1 */
public class Solution {
  //这个简单，如果这一格是石头，就赋值0
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    if(obstacleGrid[0][0] == 1){
      return 0;
    }
    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;
    int[][] dp = new int[m][n];
    dp[0][0] = 1;
    //哇哦 初始化的时候也是动态规划。其实真正的初始化就是dp[0][0] = 1。而且还是在obstacleGrid[0][0] == 0的情况下，不然直接返回0
    for (int i = 1; i < n; i++) {
      //初始化的时候当然也得看obstacleGrid的脸色
      dp[0][i] = obstacleGrid[0][i] == 0?dp[0][i - 1]:0;
    }
    for (int i = 1; i < m; i++) {
      dp[i][0] = obstacleGrid[i][0] == 0?dp[i - 1][0]:0;
    }
    for(int i = 1; i < m;i++){
      for(int j = 1;j < n;j++){
        if(obstacleGrid[i][j] == 1){
          dp[i][j] = 0;
        }else{
          dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        }
      }
    }
    return dp[m - 1][n - 1];
  }
}
