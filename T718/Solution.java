package T718;

import java.util.Arrays;

/*给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
示例 1:
输入：nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
输出：3
解释：长度最长的公共子数组是 [3,2,1] 。
示例 2：
输入：nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
输出：5 */
class Solution {
  public static void main(String[] args) {
    findLength(new int[] { 1, 2, 3, 2, 1 }, new int[] { 3, 2, 1, 4, 7 });
  }

  public static int findLength(int[] nums1, int[] nums2) {
    int[][] dp = new int[nums1.length][nums2.length];
    int max = 0;
    for (int i = 0; i < nums1.length; i++) {
      dp[i][0] = nums1[i] == nums2[0] ? 1 : 0;
      max = Math.max(dp[i][0],max);
    }
    for (int i = 0; i < nums2.length; i++) {
      dp[0][i] = nums2[i] == nums1[0] ? 1 : 0;
      max = Math.max(dp[0][i],max);
    }
    for(int i = 1; i < nums1.length;i++){
      for(int j = 1;j<nums2.length;j++){
        if(nums1[i] == nums2[j]){
          dp[i][j] = 1;
          dp[i][j] += dp[i - 1][j - 1];
        }
        max = Math.max(dp[i][j],max);
      }
    }
    return max;
  }
}
