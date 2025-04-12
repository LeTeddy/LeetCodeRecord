'''
给你一个字符串数组 tokens ，表示一个根据 逆波兰表示法 表示的算术表达式。

请你计算该表达式。返回一个表示表达式值的整数。

注意：

有效的算符为 '+'、'-'、'*' 和 '/' 。
每个操作数（运算对象）都可以是一个整数或者另一个表达式。
两个整数之间的除法总是 向零截断 。
表达式中不含除零运算。
输入是一个根据逆波兰表示法表示的算术表达式。
答案及所有中间计算结果可以用 32 位 整数表示。
 

示例 1：

输入：tokens = ["2","1","+","3","*"]
输出：9
解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
示例 2：

输入：tokens = ["4","13","5","/","+"]
输出：6
解释：该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6'''
from typing import List

class Solution:
    def isOprator(self, c: str):
        return c == '*' or c == '/' or c == '+' or c == '-'
    
    def cal(self, op1:str, op2:str, op:str):
        op1 = int(op1)
        op2 = int(op2)
        if op == '*':
            return op1 * op2
        elif op == '+':
            return op1 + op2
        elif op == '/':
            return op1 / op2
        elif op == '-':
            return op1 - op2

    def evalRPN(self, tokens: List[str]) -> int:
        stack = []
        for i in range(0, len(tokens), 1):
            ch = tokens[i]
            if (self.isOprator(ch)):
                op1 = stack.pop()
                op2 = stack.pop()
                res = self.cal(op2,op1,ch)
                stack.append(int(res))
            else:
                stack.append(ch)
        return int(stack.pop())
    
    from operator import add,sub,mul

    def div(x,y):
        return int(x/y) if x*y>0 else -(abs(x)//abs(y))
    
    op_map={'+':add,'-':sub,'*':mul,'/':div} ##python可以map里面存函数，可以整出来做运算
    
    def evalPRN2(self, tokens: List[str]) -> int:
        stack=[]
        for token in tokens:
            if token not in {'+','-','*','/'}:
                stack.append(int(token))

            else:
                op2=stack.pop()
                op1=stack.pop()
                stack.append(self.op_map[token](op1,op2))
        return stack.pop()
  
so = Solution()
so.evalRPN(["4","13","5","/","+"])
