from typing import List
import copy

class Solution:
    def __init__(self):
        self.ans: List[List[str]] = []
        self.path: List[str] = []
    def partition(self, s: str) -> List[List[str]]:
        self.backTrack(s, 0)
        return self.ans

    def backTrack(self, s: str, startIndex: int):
        if startIndex == len(s):
            resPath: List[str] = copy.deepcopy(self.path)
            self.ans.append(resPath)

        currentStr = ''
        for i in range(startIndex, len(s), 1):
            currentStr += s[i]
            if self.isPalindrome(currentStr):
                self.path.append(currentStr)
                #这里不叫回溯这里叫递归
                self.backTrack(s, i + 1)
                #别忘了回溯
                self.path.pop(len(self.path) - 1)

    
    def isPalindrome(self, s: str) -> bool:
        return s == s[::-1]

so = Solution()
so.partition("aab")
