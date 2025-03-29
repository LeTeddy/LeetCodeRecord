/*
 *  给定两个数组 nums1 和 nums2 ，返回 它们的 交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。

    示例 1：

    输入：nums1 = [1,2,2,1], nums2 = [2,2]
    输出：[2]
    示例 2：

    输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
    输出：[9,4]
    解释：[4,9] 也是可通过的
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // set will do
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> set1 = new HashSet<>();
        for (int nums12 : nums1) {
            set1.add(nums12);
        }
        for (int nums22 : nums2) {
            if(set1.contains(nums22)){
                set2.add(nums22);
            }
        }
        int[] res = set2.stream().mapToInt(Integer::intValue).toArray();
        return res;
    }
    //哈希 ： 给一个元素  判断这个元素有没有出现过  这哈希就是最快的
    //如果数值不大，比如26个字母，1000以内的数， 并且分布不分散   那可以用数组来解决，省去哈希运算
}