/*Convert Sorted List to Binary Search Tree :Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.*/
//solution 1: build the tree from bottom to top*/
public class Solution{
	static ListNode h;
	public TreeNode sortedListToBST(ListNode head) {
		if(head == null) {
			return null;
		}
		h = head;
		int len = getLength(head);
		return sortedListToBST(0, len - 1);
	}
//get list length
	public int getLength(ListNode head){
		int len = 0;
		ListNode p = head;
		while(p != null){
			len++;
			p = p.next;
		}
		return len;
	}
// build tree bottom-up
	public TreeNode sortedListToBST(int start, int end){
		if(start > end){
			return null;
		}
		
		int mid = (start + end) / 2;
		
		TreeNode left = sortedListToBST(start, mid - 1);
		TreeNode root = new TreeNode(h.val);
		h = h.next;
		TreeNode right = sortedListToBST(mid + 1, end);
		
		root.left = left;
		root.right = right;
		
		return root;
	}
}
// solution 2: build tree top-down
 public static TreeNode rec(ListNode start, ListNode end){  
        if(start == end){  
            return null;  
        }  
          
        // 一次遍历找到中点的方法：快慢指针  
        ListNode mid = start;           // 该指针最终会指向中点  
        ListNode probe = start;         // 探针最终会到达end  
        while(probe!=end && probe.next!=end){       // 探针完成搜索，注意停止条件是和end比较而不是和null比！  
            mid = mid.next;  
            probe = probe.next.next;  
        }  
          
        TreeNode root = new TreeNode(mid.val);  
        root.left = rec(start, mid);  
        root.right = rec(mid.next, end);  
        return root;  
    }  
	
