'''
请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、popleft 和 empty）。

实现 MyStack 类：

void push(int x) 将元素 x 压入栈顶。
int popleft() 移除并返回栈顶元素。
int top() 返回栈顶元素。
boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。

注意：
你只能使用队列的标准操作 —— 也就是 push to back、peek/popleft from front、size 和 is empty 这些操作。
你所使用的语言也许不支持队列。 你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。'''
from collections import deque

class MyStack:

    def __init__(self):
        self.q1:deque = deque()
        self.q2:deque = deque()
        
    def push(self, x: int) -> None:
        q:deque #非空队列
        if self.q1.count == 0:
            q = self.q2
        else:
            q = self.q1
        q.append(x)

    def pop(self) -> int:
        q:deque #非空队列
        eq:deque
        if len(self.q1) == 0:
            q = self.q2
            eq = self.q1
        else:
            q = self.q1
            eq = self.q2
        if len(q) == 0:
            return
        while len(q) != 1:
            eq.append(q.popleft())
        return q.popleft()

    def top(self) -> int:
        e = self.pop()
        self.push(e)
        return e

    def empty(self) -> bool:
        return len(self.q1) == 0 and len(self.q2) == 0

ms = MyStack()
ms.push(1)
ms.push(2)
ms.top()
e = ms.pop()

# Your MyStack object will be instantiated and called as such:
# obj = MyStack()
# obj.push(x)
# param_2 = obj.popleft()
# param_3 = obj.top()
# param_4 = obj.empty()