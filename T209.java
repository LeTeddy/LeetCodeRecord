/*
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。

找出该数组中满足其总和大于等于 target 的长度最小的 子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。

 

示例 1：

输入：target = 7, nums = [2,3,1,2,4,3]
输出：2
解释：子数组 [4,3] 是该条件下的长度最小的子数组。
示例 2：

输入：target = 4, nums = [1,4,4]
输出：1
示例 3：

输入：target = 11, nums = [1,1,1,1,1,1,1,1]
输出：0
 */
//这子数组是个连续的
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        if(nums.length < 1){
            return 0;
        }
        int start = 0, end = 0;
        int sum = 0, res = Integer.MAX_VALUE;
        // 左闭右闭 end - start + 1
        while (end < nums.length) {
            sum += nums[end];
            //这里得用while吧start调整到最靠前的位置
            while (sum >= target) {
                // 如果满足条件了
                // 1.对比长度是不是更小
                // 2.sum减去start处的值，start前移
                // 再进行对比 看看行不行
                int size = (end - start + 1);
                res = size < res ? size : res;
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return res < Integer.MAX_VALUE ? res : 0;
    }
}