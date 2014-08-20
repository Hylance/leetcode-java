//Swap Nodes in Pairs:Given a linked list, swap every two adjacent nodes and return its head. For example, Given 1->2->3->4, you should return the list as 2->1->4->3. Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
public class Solution{
	public ListNode swapPairs (ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode point = new ListNode(0);//use a new node to avoid boundary check.
		point.next = head;//point points to the node ahead of the first pair
		head = point;
		while(point.next != null && point.next.next != null) {
			ListNode tmp = point.next.next.next;
			point.next.next.next = point.next;
			point.next = point.next.next;
			point.next.next.next = tmp;
			point = point.next.next;
		}
		return head.next;
	}
}


