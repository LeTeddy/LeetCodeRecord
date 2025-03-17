class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 递归吧
        // 不递归，快慢指针
        ListNode res_head = new ListNode(0, head),fast = res_head,slow = res_head;
        int count = 0;
        while (count != n && fast != null) {
            fast = fast.next;
            count++;
        }
        if(count != n){
            return head;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}