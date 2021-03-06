/* Partition List: Given a linked list and a value x, partition it such that all nodes less than x come before the nodes greater than or equal to x. You should preserve the original relative order of the nodes in each of the two partitions.FOr example, given 1->4->3->2->5->2 and x = 3, return 1->2->2->4->3->5.*/
public class Solution {
	public ListNode partition (ListNode heead, int x) {
		if (head == null) {
			return null;
		}
		ListNode leftDummy = new ListNode(0);
		ListNode rightDummy = new ListNode(0);
		ListNode left = leftDummy;
		ListNode right = rightDummy;
		while (head != null) {
			if (head.val < x) {
				left.next = head;
				left = head;
			}
			else {
				right.next = head;
				right = head;
			}
			head = head.next;
		}
		right.next = null;
		left.next = rightdummy.next;
		return leftdummy.next;
	}
}
