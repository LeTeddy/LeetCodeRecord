/*
 * 你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
示例 1：

输入：head = [1,2,6,3,4,5,6], val = 6
输出：[1,2,3,4,5]
示例 2：

输入：head = [], val = 1
输出：[]
示例 3：

输入：head = [7,7,7,7], val = 7
输出：[]
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
    //Warning : 没有头节点

    public ListNode removeElements(ListNode head, int val) {
        ListNode head_node = new ListNode();
        head_node.next = head;
        ListNode pre = head_node, cur = head;
        while (cur != null) {
            if(cur.val == val){
                pre.next = cur.next;
                //更新next
                cur = cur.next;
            }else{
                //更新next
                cur = cur.next;
                //更新pre
                pre = pre.next;
            }
        }
        return head_node.next;
    }
}