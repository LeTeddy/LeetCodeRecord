import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class T15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //不用ArrayList也能排序呀
        // ArrayList<Integer> numList = new ArrayList<>();
        // for (int nums2 : nums) {
        //     numList.add(nums2);
        // }
        Arrays.sort(nums);
        int len = nums.length;
        if(len < 3){
            return res;
        }
        if(nums[0] > 0){
            return res;
        }
        for(int i = 0;i < len;i++){
            if(i > 0 && nums[i - 1] == nums[i]){
                continue;
            }
            int left = i + 1,right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum > 0){
                    right--;
                    continue;
                }else if(sum < 0){
                    left++;
                    continue;
                }else{
                    ArrayList<Integer> r = new ArrayList<>();
                    r.add(nums[i]);
                    r.add(nums[left]);
                    r.add(nums[right]);
                    res.add(r);
                    while (nums[right] == nums[right - 1] && right > left) {
                        right--;
                    }
                    while (nums[left] == nums[left + 1] && left < right) {
                        left++;
                    }
                    right--;
                    left++;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        T15 t15 = new T15();
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> lists = t15.threeSum(nums);
        System.out.println(lists);
    }
}
