/*
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：

实现 MyQueue 类：

void push(int x) 将元素 x 推到队列的末尾
int pop() 从队列的开头移除并返回元素
int peek() 返回队列开头的元素
boolean empty() 如果队列为空，返回 true ；否则，返回 false
说明：

你 只能 使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
输入：
["MyQueue", "push", "push", "peek", "pop", "empty"]
[[], [1], [2], [], [], []]
输出：
[null, null, null, 1, 1, false]
 */
import java.util.Stack;;

class MyQueue {
  public static void main(String[] args) {
    MyQueue m = new MyQueue();
    m.push(1);
    m.push(2);
    m.push(3);
    m.push(4);
    System.out.println(m.pop());
    m.push(5);
    System.out.println(m.pop());
    System.out.println(m.pop());
    System.out.println(m.pop());
  }
  Stack<Integer> emptyStack;
  Stack<Integer> notEmptyStack;

  public MyQueue() {
      this.emptyStack = new Stack<>();
      this.notEmptyStack = new Stack<>();
  }
  
  public void push(int x) {
      while(!this.notEmptyStack.isEmpty()){
        Integer e = this.notEmptyStack.pop();
        this.emptyStack.push(e);
      }
      notEmptyStack.push(x);
      while(!this.emptyStack.isEmpty()){
        Integer e = this.emptyStack.pop();
        this.notEmptyStack.push(e);
      }
  }
  
  public int pop() {
      return notEmptyStack.pop();
  }
  
  public int peek() {
      return notEmptyStack.peek();
  }
  
  public boolean empty() {
      return notEmptyStack.isEmpty();
  }
}



/**
* Your MyQueue object will be instantiated and called as such:
* MyQueue obj = new MyQueue();
* obj.push(x);
* int param_2 = obj.pop();
* int param_3 = obj.peek();
* boolean param_4 = obj.empty();
*/