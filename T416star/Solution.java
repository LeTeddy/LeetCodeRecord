package T416star;

/*给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
示例 1：
输入：nums = [1,5,11,5]
输出：true
解释：数组可以分割成 [1, 5, 5] 和 [11] 。
示例 2：
输入：nums = [1,2,3,5]
输出：false
解释：数组不能分割成两个元素和相等的子集。 */
class Solution {
  public static void main(String[] args) {
    Solution so = new Solution();
    so.canPartition(new int[] { 1, 5, 11, 5 });
  }

  public boolean canPartition(int[] nums) {
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }
    //首先一个思想就是，先加起来，除二，如果能从所给元素中凑出除二之后的数
    if (sum % 2 != 0) {
      // 都不是偶数
      return false;
    }
    //转换成背包问题就是，物品的重量和价值相等
    //因为背包问题是求最大价值，如果不让重量和价值一样，那就装超了
    //这里让重量和价值相等的另一个解释就是，尽量装满，因为价值和重量一样，他就会追求价值最高，也就是重量最重。但最终也不会超过背包容量。
    //所以就是在尽量装满
    int target = sum / 2;
    int[] dp = new int[target + 1];
    // 默认数组初始化是0
    for (int i = 0; i < nums.length; i++) {
      // 这里i是物品
      // 因为压缩为一维
      // 这里j是背包大小
      for (int j = target; j >= nums[i]; j--) {
        //不装就是原来的数dp[j]              得大于等于0，等于0的时候就是恰好只能装下i
        dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
      }
    }
    if (dp[target] == target) {
      return true;
    } else {
      return false;
    }
  }
}
