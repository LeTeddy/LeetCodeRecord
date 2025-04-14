package T18;
/*
 * 给定一个字符串 s ，验证 s 是否是 回文串 ，只考虑字母和数字字符，可以忽略字母的大小写。
本题中，将空字符串定义为有效的 回文串 。
示例 1：
输入: s = "A man, a plan, a canal: Panama"
输出: true
解释："amanaplanacanalpanama" 是回文串
示例 2
输入: s = "race a car"
输出: false
解释："raceacar" 不是回文串
 */
class Solution {
  public boolean isPalindrome(String s) {
      int left = 0, right = s.length() - 1;
      String lowerCase = s.toLowerCase();
      while(left < right){
        if(!Character.isLetter(lowerCase.charAt(left)) && !Character.isDigit(lowerCase.charAt(left))) {left++;continue;}
        if(!Character.isLetter(lowerCase.charAt(right)) && !Character.isDigit(lowerCase.charAt(right))) {right--;continue;}
        if (lowerCase.charAt(right) != lowerCase.charAt(left)) return false;
        left++;
        right--;
      }
      return true;
  }
}
