package T17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.PrimitiveIterator.OfLong;

/*
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
示例 1：
输入：digits = "23"
输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
示例 2：
输入：digits = ""
输出：[]
示例 3：
输入：digits = "2"
输出：["a","b","c"]
 */
class Solution {
  public static void main(String[] args) {
    Solution so = new Solution();
    so.letterCombinations("7");
  }
  public List<String> letterCombinations(String digits) {
    int len = digits.length();
    List<String> ans = new ArrayList<>();
    if (len < 1) {
      return ans;
    }

    HashMap<Character,List<Character>> map = new HashMap<>();
    map.put('2', new ArrayList<>(Arrays.asList('a','b','c')));
    map.put('3', new ArrayList<>(Arrays.asList('d','e','f')));
    map.put('4', new ArrayList<>(Arrays.asList('g','h','i')));
    map.put('5', new ArrayList<>(Arrays.asList('j','k','l')));
    map.put('6', new ArrayList<>(Arrays.asList('m','n','o')));
    map.put('7', new ArrayList<>(Arrays.asList('p','q','r','s')));
    map.put('8', new ArrayList<>(Arrays.asList('t','u','v')));
    map.put('9', new ArrayList<>(Arrays.asList('w','x','y','z')));

    StringBuffer sb = new StringBuffer();

    backTrace(0, len, digits, map, ans, sb);

    return ans;
  }

  private void backTrace(int currentPos, int len, String digits, HashMap<Character,List<Character>> map, List<String> ans, StringBuffer sb){
    if (sb.length() == len) {
      ans.add(sb.toString());
      return;
    }

    List<Character> childs = map.get(digits.charAt(currentPos));
    for (Character ch : childs) {
      sb.append(ch);
      backTrace(currentPos + 1, len, digits, map, ans, sb);
      sb.deleteCharAt(sb.length() - 1);
    }
  }
}