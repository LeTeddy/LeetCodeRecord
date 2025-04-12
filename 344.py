from typing import List

class Solution(object):
    def reverseString(self, s: List[str]):
        """
        :type s: List[str]
        :rtype: None Do not return anything, modify s in-place instead.
        """
        left = 0
        right = s.__len__() - 1
        while(left < right):
            temp = s[left]
            s[left] = s[right]
            s[right] = temp
            left += 1
            right -= 1
  
s = ["h","e","l","l","o"]
sol = Solution()
sol.reverseString(s)
print(s)