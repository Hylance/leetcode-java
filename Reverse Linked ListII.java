/*Reverse Linked List II :Reverse a linked list from position m to n. Do it in-place and in one-pass.*/
public class Solution {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prevm = dummy;
		ListNode prev = new ListNode(0);
		ListNode curr = new ListNode(0);
		for (int i = 1; i <= n, i++){
			if (i < m){
				prevm = prevm.next;
			}
			else if ( i == m ) {
				prev = prevm.next;
				curr = prev.next;
			}
			else {
				prev.next = curr.next;
				curr.next = prevm.next;
				prevm.next = curr;
				curr = prev.next;
			}
		}
		return dummy.next;
	}
}

