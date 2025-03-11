class ListNode {
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

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode l3 = new ListNode();
        //头指针
        ListNode res = l3;

        while (l1 != null && l2 != null) {
            int v = l1.val + l2.val + carry;
            l3.next = new ListNode(v % 10);
            carry = v / 10;

            l3 = l3.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int v = l1.val + carry;
            l3.next = new ListNode(v % 10);
            carry = v / 10;

            l3 = l3.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int v = l2.val + carry;
            l3.next = new ListNode(v % 10);
            carry = v / 10;

            l3 = l3.next;
            l2 = l2.next;
        }
        if (carry != 0) {
            l3.next = new ListNode(carry);
        }

        return res.next;
    }
}