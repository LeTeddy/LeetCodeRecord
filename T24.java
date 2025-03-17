/*
 * 你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
示例 1：
输入：head = [1,2,3,4]
输出：[2,1,4,3]
示例 2：
输入：head = []
输出：[]
示例 3：
输入：head = [1]
输出：[1]
 */

import java.util.List;

/**
 * Definition for singly-linked list.
 */


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

    public ListNode swapPairs(ListNode head) {
        ListNode res_head = new ListNode(0,head);
        ListNode cur = res_head;

        while (cur.next != null && cur.next.next != null) {
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = temp.next.next;
            cur.next.next = temp;
            cur = temp;
        }

        return res_head.next;
    }
}