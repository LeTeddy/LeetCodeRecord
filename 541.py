class Solution(object):
    def reverseString(self, s):
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
        return s

    def reverseStr(self, s: str, k: int):
        """
        :type s: str
        :type k: int
        :rtype: str
        """
        s = list(s)
        subLeft = 0
        subRight = k if len(s) > k else len(s)
        while subLeft < len(s):
            s[subLeft:subRight] = self.reverseString(s[subLeft:subRight])
            subLeft += 2 * k
            subRight = subLeft + k if len(s) > subLeft + k else len(s)
        return ''.join(s)
    
    def reverseStr2(self, s: str, k: int):
        s = list(s)
        for i in range(0,len(s),2 * k):
            s[i:i + k] = s[i:i + k][::-1]
        return ''.join(s)

s = ["h","e","l","l","o"]
sol = Solution()
print(sol.reverseStr2(s=s,k=2))
