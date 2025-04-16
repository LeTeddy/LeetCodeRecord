package T96;

/*给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
示例 1：
输入：n = 3
输出：5
示例 2：
输入：n  */
class Solution {
  // 如果没说二叉搜索树的话，那就很难办了。
  // 但是他说了是二叉搜索树，所以结合二叉搜索树的性质，就能做了
  // 二叉搜索树就是 左子树左右节点的值都小于根节点，右子树左右结点的值都大于根节点
  public int numTrees(int n) {
    if (n < 3) {
      return n;
    }
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;
    dp[2] = 2;
    for (int i = 3; i <= n; i++) {
      int sum = 0;
      for (int j = 1; j <= i; j++) {
        // 轮着做根节点
        // 左子树 * 右子树  //得是乘呀
        sum = sum + dp[j - 1] * dp[i - j];
      }
      dp[i] = sum;
    }
    return dp[n];
  }
}
