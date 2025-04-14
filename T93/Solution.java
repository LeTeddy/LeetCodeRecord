package T93;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 示例 1：
 输入：s = "25525511135"
 输出：["255.255.11.135","255.255.111.35"]
 示例 2：
 输入：s = "0000"
 输出：["0.0.0.0"]
 示例 3：
 输入：s = "101023"
 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 */
// ""叫charsequence  ''叫char
class Solution {
  public static void main(String[] args) {
    Solution so = new Solution();
    so.restoreIpAddresses("101023");
  }
  public List<String> restoreIpAddresses(String s) {
    // 我觉得主要就是这个 0 的处理
    // 树的深度就是4啦
    Deque<String> path = new LinkedList<>();
    List<String> ans = new ArrayList<>();// string = path.join(".")
    backTrace(s, 0, path, ans);
    return ans;
  }

  private void backTrace(String s, int startIndex, Deque<String> path, List<String> ans) {
    if(path.size() > 4) {
      return;
    }
    if(path.size() == 4 && startIndex == s.length()){

      ans.add(String.join(".", path));
      return;
    }
    if(startIndex == s.length()){
      return;
    }
    StringBuffer sb = new StringBuffer();
    //在这里保证不以0开头
    if(s.charAt(startIndex) == '0') {
      path.add(sb.append('0').toString());
      backTrace(s, startIndex + 1, path, ans);
      path.removeLast();
      return;
    }
    for (int i = startIndex; i < s.length() && path.size() < 4; i++) {
      String newSection = sb.append(s.charAt(i)).toString();
      if(Integer.valueOf(newSection) > 255){
        break;
      }
      path.addLast(newSection);
      backTrace(s, i + 1, path, ans);
      path.removeLast();
    }
  }
}
