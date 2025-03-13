/*
 * 你可以选择使用单链表或者双链表，设计并实现自己的链表。

单链表中的节点应该具备两个属性：val 和 next 。val 是当前节点的值，next 是指向下一个节点的指针/引用。

如果是双向链表，则还需要属性 prev 以指示链表中的上一个节点。假设链表中的所有节点下标从 0 开始。

实现 MyLinkedList 类：

MyLinkedList() 初始化 MyLinkedList 对象。
int get(int index) 获取链表中下标为 index 的节点的值。如果下标无效，则返回 -1 。
void addAtHead(int val) 将一个值为 val 的节点插入到链表中第一个元素之前。在插入完成后，新节点会成为链表的第一个节点。
void addAtTail(int val) 将一个值为 val 的节点追加到链表中作为链表的最后一个元素。
void addAtIndex(int index, int val) 将一个值为 val 的节点插入到链表中下标为 index 的节点之前。如果 index 等于链表的长度，那么该节点会被追加到链表的末尾。如果 index 比长度更大，该节点将 不会插入 到链表中。
void deleteAtIndex(int index) 如果下标有效，则删除链表中下标为 index 的节点。
 

示例：

输入
["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex", "get"]
[[], [1], [3], [1, 2], [1], [1], [1]]
输出
[null, null, null, null, 2, null, 3]

解释
MyLinkedList myLinkedList = new MyLinkedList();
myLinkedList.addAtHead(1);
myLinkedList.addAtTail(3);
myLinkedList.addAtIndex(1, 2);    // 链表变为 1->2->3
myLinkedList.get(1);              // 返回 2
myLinkedList.deleteAtIndex(1);    // 现在，链表变为 1->3
myLinkedList.get(1);              // 返回 3
 */

 
class MyLinkedList {
    int val = 0;
    MyLinkedList pre = null, next = null;

    public MyLinkedList() {

    }

    public int get(int index) {
        if (this.val > index && index >= 0) {
            int i = 0;
            MyLinkedList res = this.next;
            while (i != index) {
                res = res.next;
                i++;
            }
            return res.val;
        } else {
            // 没有
            return -1;
        }
    }

    public void addAtHead(int val) {
        this.val++;
        MyLinkedList node = new MyLinkedList();
        node.val = val;
        node.next = this.next;
        this.next = node;
        node.pre = this;
        if (node.next != null) {
            node.next.pre = node;
        }
    }

    public void addAtTail(int val) {
        this.val++;
        MyLinkedList node = new MyLinkedList();
        node.val = val;
        MyLinkedList tail = this;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
        node.pre = tail;
    }

    public void addAtIndex(int index, int val) {
        // 插入到索引为index的节点之前
        if (index == 0) {
            //在下面这个函数里 this.val会++
            addAtHead(val);
        } else if (index == this.val) {
            //在下面这个函数里，this.val会++
            addAtTail(val);
        } else if (this.val > index && index > 0) {
            this.val++;
            MyLinkedList node = new MyLinkedList();
            node.val = val;
            int i = 0;
            MyLinkedList res = this.next;
            while (i != index) {
                res = res.next;
                i++;
            }
            node.next = res;
            node.pre = res.pre;
            node.pre.next = node;
            res.pre = node;
        }
    }

    public void deleteAtIndex(int index) {
        if (this.val > index && index >= 0) {
            this.val--;
            int i = 0;
            MyLinkedList res = this.next;
            while (i != index) {
                res = res.next;
                i++;
            }
            res.pre.next = res.next;
            if (res.next != null) {
                res.next.pre = res.pre;
            }
        }
    }

}

public class T707{
    public static void main(String[] args) {
        MyLinkedList llm = new  MyLinkedList();
        llm.addAtHead(0);
        llm.addAtIndex(1, 4);
        llm.addAtTail(8);
        llm.addAtHead(5);
        llm.addAtIndex(4, 3);
        llm.addAtTail(0);
        llm.addAtTail(5);
        llm.addAtIndex(6, 3);
        llm.deleteAtIndex(7);
        llm.deleteAtIndex(5);
        llm.addAtTail(4);
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */