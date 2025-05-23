package T70;
/*假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
示例 1：
输入：n = 2
输出：2
解释：有两种方法可以爬到楼顶。
1. 1 阶 + 1 阶
2. 2 阶
示例 2：
输入：n = 3
输出：3
解释：有三种方法可以爬到楼顶。
1. 1 阶 + 1 阶 + 1 阶
2. 1 阶 + 2 阶
3. 2 阶 + 1 阶 */
//靠 原来就是个斐波那契数列
class Solution {
  public int climbStairs(int n) {
      int[] dp = new int[n + 1];
      if(n == 1){
        return 1;
      }else if(n == 2){
        return 2;
      }
      dp[1] = 1;
      dp[2] = 2;
      for(int i = 3;i <= n;i++){
        dp[i] = dp[i - 1] + dp[i - 2];//dp[i - 1]种方法多迈一步到达i；dp[i - 2]种方法多迈两步到达i；
      }
      return dp[n];
  }
}
