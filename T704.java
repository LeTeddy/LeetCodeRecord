/*
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。


示例 1:

输入: nums = [-1,0,3,5,9,12], target = 9
输出: 4
解释: 9 出现在 nums 中并且下标为 4
示例 2:

输入: nums = [-1,0,3,5,9,12], target = 2
输出: -1
解释: 2 不存在 nums 中因此返回 -1
 */
class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0){
            return -1;
        }
        //平分数组：左边多一个 （奇偶元素个数）
        //要返回下标，那就不能写递归，不然你怎么知道下标，不方便
        //写左区间、右区间指针，注意规定循环不变量：左闭右闭  、 左闭右开
        //左闭右开版本：
        int left = 0,right = nums.length;
        while(left < right){
            //我要保证的是什么   不验证的  都是不需要的     剩下的 都验证
            int mid = (left + right) / 2;//不管我怎么算这个mid
            if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
