import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class T142 {
    public ListNode detectCycle(ListNode head) {
        //我用哈希集合 
        // //不行  很慢
        // Set<ListNode> set = new HashSet<>();
        // while (head != null) {
        //     if(set.contains(head)){
        //         return head;
        //     }else{
        //         set.add(head);
        //     }
        //     head = head.next;
        // }
        // return null;
        //我不用哈希集合了
        //题目想要O(1)空间复杂度
        //
    }
}
