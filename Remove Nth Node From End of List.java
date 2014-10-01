/* Remove Nth Node From End of List: Given a linked list, remove the nth node from the end of list and return its head.*/
//my solution:First get the length(size) of the list and then traversal from head to end to the right position and made the change
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode a = new ListNode(0);
        a = head;
        while(a != null){
            size++;
            a = a.next;
        }
        a = head;
        if (head == null || n > size)   return null;
        int target = size - n;
        if(target == 0) head = head.next;
        for(int i = 1; i < target; i++){
            a = a.next;
        }
        if(a.next == null)  return head;// n = 0
        else {
                a.next = a.next.next;
        }
        return head;
    }
}
//two pointer to avoid calculating the length of list
//dummy to access head of list
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n <= 0) {
            return null;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode preDelete = dummy;
        for (int i = 0; i < n; i++) {
            if (head == null) {
                return null;
            }
            head = head.next;
        }
        while (head != null) {
            head = head.next;
            preDelete = preDelete.next;
        }
        preDelete.next = preDelete.next.next;
        return dummy.next;
    }
}
