package T53;

/*给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
子数组是数组中的一个连续部分。
示例 1：
输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
输出：6
解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
示例 2：
输入：nums = [1]
输出：1
示例 3：
输入：nums = [5,4,-1,7,8]
输出：23 */
class Solution {
  public static void main(String[] args) {
    maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 });
  }

  public static int maxSubArray(int[] nums) {
    int[] dp = new int[nums.length + 1];// dp[i][j]表示从nums[i]开始到nums[j]
    int max = Integer.MIN_VALUE;
    for (int i = 1; i <= nums.length; i++) {
      dp[i] = Math.max(nums[i - 1], nums[i - 1] + dp[i - 1]);
      max = Math.max(max, dp[i]);
    }
    return max;
  }
}