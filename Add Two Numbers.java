/* Add two numbers: You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list. Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8*/
public class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if ( l1 == null && l2 == null) {
			return null;
		}
		ListNode dummy = new ListNode(0);
		ListNode head = dummy;
		int carry = 0;
		while (l1 != null && l2 != null) {
			int sum = l1.val + l2.val + carry;
			head.next = new ListNode(sum % 10);
			carry /= 10;
			l1 = l1.next;
			l2 = l2.next;
			head = head.next;
		}
		while (l1 != null) {
			int sum = l1.val + carry;
			head.next = new ListNode(sum % 10);
			carrry = sum / 10;
			l1 = l1.next;
			head = head.next;
		}
		while (l2 != null ) {
			int sum = l2.val + carry;
			head.next = new ListNode(sum % 10);
			carry = sum / 10;
			l2 = l2.next;
			head = head.next;
		}
		if (carry != 0) {
			head.next = new ListNode(carry);
		}
		return dummy.next;
	}
}

