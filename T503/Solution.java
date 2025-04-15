package T503;

import java.util.Stack;

/*给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素 。
数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 。
示例 1:
输入: nums = [1,2,1]
输出: [2,-1,2]
解释: 第一个 1 的下一个更大的数是 2；
数字 2 找不到下一个更大的数； 
第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
示例 2:
输入: nums = [1,2,3,4,3]
输出: [2,3,4,-1,4]*/
class Solution {
  public static void main(String[] args) {
    Solution so = new Solution();
    so.nextGreaterElements(new int[]{1,2,3,4,3});
  }
  public int[] nextGreaterElements(int[] nums) {
    Stack<Integer> stack = new Stack<>();
    int[] res = new int[nums.length];
    for (int i = 0; i < res.length; i++) {
      res[i] = -1;
    }
    // 循环遍历的话，其实转两圈就行了，转两圈还找不到，那就是没有
    for (int i = 0; i < nums.length * 2; i++) {
      while (!stack.isEmpty() && nums[stack.peek()] < nums[i % nums.length]) {
        res[stack.pop()] = nums[i % nums.length];
      }
      stack.push(i % nums.length);
    }
    return res;
  }
}
