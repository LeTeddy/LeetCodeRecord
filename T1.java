import java.util.HashMap;
import java.util.Map;

class Solution {
    //梦开始的地方
    //判断 target - nums[i] 是否之前遍历过
    //判断是否遍历过  ————————---》 哈希表
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] { i, map.get(target - nums[i]) };
            } else {
                map.put(nums[i], i);
            }
        }

        return null;
    }
}