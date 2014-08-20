/*Given a linked list, judge whether it has a cycle*/
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow, fast;
        slow = fast = head;
        while(true) {
            slow = slow.next;
            if(fast.next != null)
                fast = fast.next.next;
            else(fast.next == null)
                fast = fast.next;
            if (slow == null || fast == null)
                return false;
            if (slow == fast)
                return true;
        }
        
    }
}

