/*
给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
返回 滑动窗口中的最大值 。
示例 1：
输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
输出：[3,3,5,5,6,7]
解释：
滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
示例 2：
输入：nums = [1], k = 1
输出：[1]*/
package T239;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//单调队列  需要用双向队列实现 
class Solution {
    public static void main(String[] args) {
        int [] nums = {1,3,1,2,0,5};
        int k = 3;
        Solution so = new Solution();
        int[] res = so.maxSlidingWindow(nums, k);
        System.out.println(res);
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            //加入队列
            while (!q.isEmpty() && q.peekLast() < nums[i]) {
                q.pollLast();
            }
            q.addLast(nums[i]);
            //检查队列长度
            //只在需要pop的元素（nums[i - k])等于队列头元素(当前最大值)的时候才pop，如果不等于，说明这个元素已经被[i - k + 1 : i]之间的元素卷走了
            if (i > k - 1){
                if(q.peekFirst() == nums[i - k]){
                    q.pollFirst();
                }
            }
            if (i >= k - 1) {
                res.add(q.peek());
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
