import java.util.HashMap;
import java.util.Stack;
/*
 * 给定一个只包括 '(',')','{','}','[',']' 的字符串 s ,判断字符串是否有效。

有效字符串需满足：
左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
每个右括号都有一个对应的相同类型的左括号。
 */

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        String ss = "()";
        s.isValid(ss);
    }

    public boolean isValid(String s) {
        HashMap<Character,Character> map = new HashMap<>();
        if (s.length() % 2 == 1) return false;
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i < s.length();i++) {
            Character c = s.charAt(i);
            if(map.containsKey(c)){
                if(stack.empty() || map.get(c) != stack.peek()){
                    return false;
                }
                stack.pop();
            }else {
                stack.push(c);
            }
        }
        if(!stack.empty()) {
            return false;
        }
        return true;
    }
}