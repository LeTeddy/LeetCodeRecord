package T300;

import java.util.ArrayList;

/*给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
示例 1：
输入：nums = [10,9,2,5,3,7,101,18]
输出：4
解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
示例 2：
输入：nums = [0,1,0,3,2,3]
输出：4
示例 3：
输入：nums = [7,7,7,7,7,7,7]
输出：1 */
class Solution {
  public static void main(String[] args) {
    lengthOfLIS2(new int[] { 0, 1, 0, 3, 2, 3 });
  }

  // 动态规划法
  public static int lengthOfLIS(int[] nums) {
    int max = 0;
    int[] dp = new int[nums.length]; // dp[i]到i位置的最长递增子序列的长度
    for (int i = 0; i < nums.length; i++) {
      dp[i] = 1;
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          dp[i] = Math.max(dp[j] + 1, dp[i]);
        }
      }
      if (dp[i] > max) {
        max = dp[i];
      }
    }
    return max;
  }

  // 还有一种方法
  public static int lengthOfLIS2(int[] nums) {
    ArrayList<Integer> LIS = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      int pos = findPos(LIS, nums[i]);
      if(pos == LIS.size()){
        LIS.add(nums[i]);
      }else{
        LIS.set(pos, nums[i]);
      }
    }
    return LIS.size();
  }

  private static int findPos(ArrayList<Integer> LIS, int target) {
    //二分法找当前最长递增子序列中第一个比这个数大的数的位置
    int left = 0, right = LIS.size(); //包左不包右
    while (left < right) {
      int mid = (right + left) / 2;
      if(LIS.get(mid) > target){
        right = mid;
      }
      if(LIS.get(mid) < target){
        left = mid + 1;
      }
      if(LIS.get(mid) == target){
        return mid;
      }
    }
    return left;
  }
}
