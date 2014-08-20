/*Populating Next Right Pointers in Each Node II:Follow up for problem "Populating Next Right Pointers in Each Node". What if the given tree could be any binary tree? Would your previous solution still work? Note: You may only use constant extra space. For example, Given the following binary tree, 1 / \ 2 3 / \ \ 4 5 7 After calling your function, the tree should look like: 1 -> NULL / \ 2 -> 3 -> NULL / \ \ 4-> 5 -> 7 -> NULL */
public class Solution {
	public void connect(TreeLinkNode root) {
		if(root == null) return;
		TreeLinkNode parent = root;
		TreeLinkNode pre;
		TreeLinkNode next;
		while(parent != null) {
			pre = null;
			next = null;
			while (parent != null) {
				if(next == null) {
					next = (parent.left != null) ? parent.left : parent.right;
				}
				if ( parent.left != null) {
					if(pre != null) {
						pre.next = parent.left;
						pre = pre.next;
					}
					else {
						pre = parent.left;
					}
				}
				if (parent.right != null) {
					if(pre != null) {
						pre.next = parent.right;
						pre = pre.next;
					}
					else{
						pre = parent.right;
					}
				}
				parent = parent.next;
			}
			parent = next;
		}
	}
}

// solution 2
public class Solution {
	public void connect(TreeLinkNode root) {
		if (root == null) return;
		TreeLinkNode rootNext = root.next;//找到与root同一行的next node
		TreeLinkNode next = null; //下一个被连接的对象
		//rootNext 如果是null说明已经处理完这一层的所有node
		//next不等于null说明找到了最左边下一个被连接的对象
		while (rootNext != null) {
			if (rootNext.left != null) { //优先找左边
				next = rootNext.left;
				break;
			}
			else if(rootnext.right != null) {
				next = rootNext.right;
			}
			else 
				rootNext = rootNext.next;
		}
		if (root.right != null) {
			root.right.next = next;
		}
		if (root.left != null) {
			if (root.right != null) {
				root.left.next = root.right;
			}
			else
				root.left.next = next;
		}
		connect(root.right);
		connect(root.left);
	}
}
				
