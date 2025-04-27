package T215;

/*给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
示例 1:
输入: [3,2,1,5,6,4], k = 2
输出: 5
示例 2:
输入: [3,2,3,1,2,4,5,5,6], k = 4
输出: 4 */
class Solution {
  static int[] nums = new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 };

  public static void main(String[] args) {
    findKthLargest(nums, 4);
  }

  public static int findKthLargest(int[] nums, int k) {
    // 阿里爸爸面试手撕代码考得这题，没写出来
    // 快排
    int pos = partition(nums, 0, nums.length - 1);
    while (pos != nums.length - k) {
      if (pos < nums.length - k) {
        pos = partition(nums, pos + 1, nums.length - 1);
      } else {
        pos = partition(nums, 0, pos);
      }
    }
    return nums[pos];
  }

  private static void swap(int[] nums, int a, int b) {
    int temp = nums[a];
    nums[a] = nums[b];
    nums[b] = temp;
  }

  public static int partition(int[] nums, int start, int end) {
    int piviteIndex = start;
    int pivite = nums[piviteIndex];
    swap(nums, piviteIndex, end);
    int storeIndex = start;
    for (int i = start; i < end; i++) {
      if (nums[i] <= pivite) {
        swap(nums, storeIndex, i);
        storeIndex++;
      }
    }
    swap(nums, end, storeIndex);
    return storeIndex;
  }
}
