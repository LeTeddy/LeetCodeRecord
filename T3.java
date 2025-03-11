import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {

        //双指针
        //哈希表查存在否
        //哈希集合也可以
        //map里只能存包装类
        HashSet<Character> set = new HashSet<>();
        int res = 0;
        //
        for(int i = 0,j = -1;i < s.length();i++){
            if(set.contains(s.charAt(i))){
                res = Math.max(res, set.size());
                while (set.contains(s.charAt(i))) {
                    j++;
                    set.remove(s.charAt(j));
                }
                set.add(s.charAt(i));
            }else{
                set.add(s.charAt(i));
            }
        }
        res = Math.max(res, set.size());
        return res;
    }
}