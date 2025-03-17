/*
示例 1：

输入：head = [1,2,3,4,5]
输出：[5,4,3,2,1]
示例 2：

输入：head = [1,2]
输出：[2,1]
示例 3：

输入：head = []
输出：[]
 */

// Definition for singly-linked list.

class Solution {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseList(ListNode head) {
        //保证有两个及以上的节点
        if(head == null || head.next == null){
            return head;
        }
        //双指针法
        ListNode pre = null,cur = head;
        while (cur != null) {
            //在纸上写一下伪代码梳理一下思路就很快
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            //返回pre就行
            // if(temp == null){
            //     return cur;
            // }
            cur = temp;
        }
        return pre;
    }
}