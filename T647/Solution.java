package T647;

/*给定一个字符串 s ，请计算这个字符串中有多少个回文子字符串。
具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
示例 1：
输入：s = "abc"
输出：3
解释：三个回文子串: "a", "b", "c"
示例 2：
输入：s = "aaa"
输出：6
解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa" */
class Solution {
  public static void main(String[] args) {
    countSubstrings2("aaa");
  }

  // toooooooo slow!!
  public static int countSubstrings(String s) {
    int[] dp = new int[s.length() + 1];// dp[i]表示以s[i]结尾的字符串有多少回文子串
    for (int i = 1; i <= s.length(); i++) {
      dp[i] = 1;
      for (int j = i - 2; j >= 0; j--) {
        if (isSubstr(s, j, i - 1)) {
          dp[i]++;
        }
      }
      dp[i] += dp[i - 1];
    }
    return dp[s.length()];
  }

  public static Boolean isSubstr(String s, int start, int end) {
    String sub = s.substring(start, end);
    for (int i = start, j = end; i < end; i++, j--) {
      if (s.charAt(i) != s.charAt(j)) {
        return false;
      }
    }
    return true;
  }

  public static int countSubstrings2(String s) {
    int count = 0;
    int[][] dp = new int[s.length()][s.length()];
    for (int j = 0; j < s.length(); j++) {
      for (int i = j; i >= 0; i--) {
        if(s.charAt(i) == s.charAt(j)){
          if(i == j || j - i == 1){
            dp[j][i] += 1;
          }else{
            dp[j][i] += dp[j - 1][i + 1];
          }
          count += dp[j][i];
        }
      }
    }
    return count;
  }
}
