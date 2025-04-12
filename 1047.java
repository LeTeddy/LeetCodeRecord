/*
 * 给出由小写字母组成的字符串 s，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
在 s 上反复执行重复项删除操作，直到无法继续删除。
在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。

示例：
输入："abbaca"
输出："ca"
解释：
例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 */

// import java.util.Stack; nonono 没必要要用标准的栈实现

class Solution {
  public String removeDuplicates(String s) {
      StringBuffer sb = new StringBuffer();
      int top = -1; //栈顶指针
      for (int i = 0;i < s.length();i++) {
        if(top != -1 && s.charAt(i) == sb.charAt(top)) {
          sb.setLength(sb.length() - 1);
          top--;
        }else {
          sb.append(s.charAt(i));
          top++;
        }
      }
      return sb.toString();
  }
}
