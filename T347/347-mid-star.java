package T347;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
示例 1:
输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]
示例 2:
输入: nums = [1], k = 1
输出: [1]
 
提示：
1 <= nums.length <= 105
k 的取值范围是 [1, 数组中不相同的元素的个数]
题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的

进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。
 */
//解决方案就是小顶堆，插入和删除元素的时间复杂度是O(logk)，k是堆中的元素个数，整体堆排序的时间复杂度是O(klogk)，k是堆中的元素个数
//这个题目复杂度优于O(nlogn)，是O(nlogk)，因为堆的大小我们控制在k，所以每次插入删除时间复杂度是O(logk)，最坏是每个元素都不一样，要插入删除n次，即O(nlogk)
class Solution {
  public int[] topKFrequent(int[] nums, int k) {
    HashMap<Integer,Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      // if(map.containsKey(nums[i]))
      // map.put(nums[i], map.get(nums[i]) + 1);
      // else
      // map.put(nums[i], 1);
      map.put(nums[i],map.getOrDefault(nums[i], 1) + 1);
    }
    PriorityQueue<Map.Entry<Integer,Integer>> q = new PriorityQueue<>((o1,o2)->o1.getValue() - o2.getValue());
    map.entrySet().forEach(e->{
      q.offer(e);
      while(q.size() > k){
        q.poll();
      }
    });
    return q.stream().mapToInt(Map.Entry<Integer,Integer>::getKey).toArray();
  }
}