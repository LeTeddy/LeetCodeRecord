/*
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。

 

示例 1：

输入：nums = [-4,-1,0,3,10]
输出：[0,1,9,16,100]
解释：平方后，数组变为 [16,1,0,9,100]
排序后，数组变为 [0,1,9,16,100]
示例 2：

输入：nums = [-7,-3,2,3,11]
输出：[4,9,9,49,121]
 */

class Solution {
    public int[] sortedSquares(int[] nums) {
        if(nums.length == 0){
            return new int[]{};
        }

        int[] res = new int[nums.length];
        int left = 0,right = nums.length - 1,cur = right; //左闭右闭
        
        while(left != right){
            if(Math.abs(nums[left]) > Math.abs(nums[right])){
                res[cur] = nums[left] * nums[left];
                left++;
            }else{
                res[cur] = nums[right] * nums[right];
                right--;
            }
            cur--;
        }
        res[cur] = nums[left] * nums[left];
        return res;
    }
}