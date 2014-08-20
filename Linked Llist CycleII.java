/* Given a linked list, return the node where the cycle begins. If there is no cycle, return null. Solve it without using extra space*/
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode slow, fast;
        slow = fast = head;
        while(true) {
            slow = slow.next;
            if(fast.next != null)
                fast = fast.next.next;
            else
                fast = fast.next;
            if (slow == null || fast == null)
                return null;
            if (slow == fast) {
                break;
            }
        }
        while (head != slow) {
            slow = slow.next;
            head = head.next;
        }
        return head;

    }
}
