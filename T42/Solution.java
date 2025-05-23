package T42;

import java.util.Stack;

/*给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
示例 1：
输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
输出：6
解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
示例 2：
输入：height = [4,2,0,3,2,5]
输出：9 */
class Solution {
  public int trap(int[] height) {
    Stack<Integer> stack = new Stack<>();
    int ans = 0;
    // 先计算右边第一个更高的柱子吧
    // 单调栈的特性 他是按照数组顺序遍历的 然后是栈嘛 他找到元素是倒序出的
    // 就正好对应最近的水坑
    // 有了水后就相当于填满了
    for (int i = 0; i < height.length; i++) {
      while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
        //说明找到了
        
      }
    }
  }
}
