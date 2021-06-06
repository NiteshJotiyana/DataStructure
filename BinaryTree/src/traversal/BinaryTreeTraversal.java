package traversal;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeTraversal {

	public BinaryTreeTraversal() {
		// TODO Auto-generated constructor stub
	}

	public void preOrderRecursive(TreeNode root) {
		if (root != null) {
			System.out.println(root.getData());
			preOrderRecursive(root.getLeft());
			preOrderRecursive(root.getRight());
		}
	}

	public void inOrderRecursive(TreeNode root) {
		if (root != null) {
			inOrderRecursive(root.getLeft());
			System.out.println(root.getData());
			inOrderRecursive(root.getRight());
		}
	}

	public void postOrderRecursive(TreeNode root) {
		if (root != null) {
			postOrderRecursive(root.getLeft());
			postOrderRecursive(root.getRight());
			System.out.println(root.getData());
		}
	}

	public void preOrderIterative(TreeNode root) {
		if (root == null) {
			return;
		}
		Stack<TreeNode> S = new Stack<TreeNode>();
		S.push(root);

		while (!S.isEmpty()) {
			TreeNode n = S.pop();
			System.out.println(n.getData());

			if (n.getRight() != null)
				S.push(n.getRight());
			if (n.getLeft() != null)
				S.push(n.getLeft());

		}
	}

	public void inOrderIterative(TreeNode root) {
		if (root == null)
			return;

		Stack<TreeNode> S = new Stack<TreeNode>();

		while (true) {
			while (root != null) {
				S.push(root);
				root = root.getLeft();
			}
			if (S.isEmpty())
				break;

			root = S.pop();
			System.out.println(root.getData());
			root = root.getRight();
		}
	}

	public static void levelOrder(TreeNode root) {
		if (root == null)
			return;

		Queue<TreeNode> Q = new LinkedList<>();

		Q.add(root);

		while (!Q.isEmpty()) {

			TreeNode n = Q.remove();
			System.out.println(n.getData());
			if (n.getLeft() != null)
				Q.add(n.getLeft());

			if (n.getRight() != null)
				Q.add(n.getRight());
		}
	}

	public static void zigzagTraversal(TreeNode root) {
		if (root == null)
			return;
		Stack<TreeNode> S = new Stack<>();
		S.push(root);

		int level = 0;

		while (!S.isEmpty()) {
			level++;
			int count = S.size();
			while (count > 0) {
				TreeNode node = S.pop();
				System.out.print(node.getData()+" ");
				if (level % 2 == 0) {
					if (node.getLeft() != null)
						S.push(node.getLeft());
					if (node.getRight() != null)
						S.push(node.getRight());
				} else {
					if (node.getRight() != null)
						S.push(node.getRight());
					if (node.getLeft() != null)
						S.push(node.getLeft());

				}

				count--;
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

		TreeNode n3 = new TreeNode(4, null, null);
		TreeNode n4 = new TreeNode(5, null, null);
		TreeNode n5 = new TreeNode(6, null, null);
		TreeNode n6 = new TreeNode(7, null, null);

		TreeNode n1 = new TreeNode(2, n3, n4);
		TreeNode n2 = new TreeNode(3, n5, n6);

		TreeNode root = new TreeNode(1, n1, n2);

		levelOrder(root);
		zigzagTraversal(root);
		
	}

}
