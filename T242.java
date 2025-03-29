import java.util.Arrays;
import java.util.HashMap;

class Solution {
    //这个太慢了
    // public boolean isAnagram(String s, String t) {
    //     // 首先长度得一样吧
    //     if (s.length() != t.length()) {
    //         return false;
    //     }
    //     //既然是哈希表的题目，那我就把一个字符串存进哈希表，另一个去查
    //     HashMap<Character, Integer> map = new HashMap<>();
    //     //不行  这个AI辅助不能开着
    //     for(int i = 0;i < s.length();i++){
    //         char c = s.charAt(i);
    //         map.put(c, map.getOrDefault(c, 0) + 1);
    //     }
    //     for(int i = 0;i < t.length();i++){
    //         char c = t.charAt(i);
    //         if(!map.containsKey(c)){
    //             return false;
    //         }
    //         map.put(c, map.get(c) - 1);
    //         if(map.get(c) < 0){
    //             return false;
    //         }
    //     }
    //     return true;
    // }
    //别用java的哈希算法，像这种字母的，就26个，也不多，直接h(x) = x就行
    //就是用数组
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        int[] freq = new int[26];
        for(int i = 0;i < s.length();i++){
            int pos = s.charAt(i) - 'a';
            freq[pos] += 1;
        }
        for(int i = 0;i < t.length();i++){
            int pos = t.charAt(i) - 'a';
            freq[pos] -= 1;
            if(freq[pos] < 0){
                return false;
            }
        }
        for(int i = 0; i < 26;i++){
            if(freq[i] > 0){
                return false;
            }
        }
        return true;
    }
    //还有更快的  Array.equal()
}