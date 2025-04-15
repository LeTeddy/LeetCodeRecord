package T739;

import java.util.Stack;

/*
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
示例 1:
输入: temperatures = [73,74,75,71,69,72,76,73]
输出: [1,1,4,2,1,1,0,0]
示例 2:
输入: temperatures = [30,40,50,60]
输出: [1,1,1,0]
示例 3:
输入: temperatures = [30,60,90]
输出: [1,1,0]
 */
//单调栈 新手村
class Solution {
  public static void main(String[] args) {
    Solution so = new Solution();
    so.dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});
  }
  public int[] dailyTemperatures(int[] temperatures) {
    Stack<Integer> stack = new Stack<>();
    int[] res = new int[temperatures.length];
    if (temperatures.length < 1) {
      return res;
    }
    // 开始遍历
    for (int i = 0; i < temperatures.length; i++) {
      while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
        Integer index = stack.pop();
        res[index] = i - index;
      }
      stack.push(i);
    }
    return res;
  }
}
