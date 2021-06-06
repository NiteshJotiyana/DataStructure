package tree;

public class BinarySearchTree {

	public static TreeNode delete(TreeNode root, int data) {

		if (root == null)
			return null;
		else if (root.getData() > data)
			root.setLeft(delete(root.getLeft(), data));
		else if (root.getData() < data)
			root.setRight(delete(root.getRight(), data));
		else {
			if (root.getLeft() == null)
				return root.getRight();
			if (root.getRight() == null)
				return root.getLeft();

			TreeNode max = max(root.getLeft());
			root.setData(max.getData());
			root.setLeft(delete(root.getLeft(), max.getData()));
		}

		return root;
	}

	public static TreeNode search(TreeNode root, int data) {

		if (root == null)
			return null;

		if (root.getData() == data) {
			return root;
		}
		if (root.getData() > data) {
			return search(root.getLeft(), data);
		} else {
			return search(root.getRight(), data);
		}
	}

	/**
	* Find Min Element in Binary Search Tree
	*/
	public int min(TreeNode root) {
		if (root == null)
			return -1;

		if (root.getLeft() == null)
			return root.getData();
		else
			return min(root.getLeft());
	}

	public static TreeNode max(TreeNode root) {
		if (root == null)
			return null;

		if (root.getRight() == null)
			return root;
		else
			return max(root.getRight());
	}

	public void printSortedOrder(TreeNode root) {
		if (root == null)
			return;
		else {
			printSortedOrder(root.getLeft());
			System.out.println(root.getData());
			printSortedOrder(root.getRight());
		}
	}

	public static TreeNode insert(TreeNode root, int data) {
		if (root == null)
			return new TreeNode(data, null, null);
		if (root.getData() > data) {
			root.setLeft(insert(root.getLeft(), data));
		} else {
			root.setRight(insert(root.getRight(), data));
		}
		return root;
	}

	static TreeNode prev = null;

	public static TreeNode getHead(TreeNode root) {
		while (root.getLeft() != null) {
			root = root.getLeft();
		}
		System.out.println("root : " + root.getData());
		return root;
	}

	public static TreeNode convertToDLL(TreeNode root) {
		if (root != null) {
			convertToDLL(root.getLeft());

			if (prev != null)
				System.out.print(prev.getData() + "-" + root.getData() + " ");

			root.setLeft(prev);
			if (prev != null)
				prev.setRight(root);

			prev = root;
			convertToDLL(root.getRight());

		}

		return root;

	}

	public static void printDLL(TreeNode head) {
		while (head != null) {
			System.out.print(head.getData() + " -> ");
			head = head.getRight();
		}
	}

	public static void DLLToBST(Node head) {
		int N = size(head);
		BinarySearchTree.head = head;

		DLLToBSTRecursive(N);
	}

	static Node head;

	public static TreeNode DLLToBSTRecursive(int N) {
		if (N <= 0)
			return null;

		TreeNode left = DLLToBSTRecursive(N / 2);
		TreeNode node = new TreeNode(head.data, null, null);
		node.setLeft(left);
		head = head.next;

		node.setRight(DLLToBSTRecursive(N - N / 2 - 1));
		return node;
	}

	public static int size(Node head) {
		int size = 0;

		while (head != null) {
			size++;
			head = head.next;

		}
		return size;
	}

	public static int treeSize(TreeNode root) {

		if (root == null)
			return 0;
		else {
			int l = treeSize(root.getLeft());
			int r = treeSize(root.getRight());
			return l + r + 1;
		}

	}

	public static void main(String[] args) {

		/*
		 * TreeNode n3 = new TreeNode(1, null, null); TreeNode n4 = new
		 * TreeNode(3, null, null);
		 * 
		 * TreeNode n5 = new TreeNode(5, null, null); TreeNode n6 = new
		 * TreeNode(7, null, null);
		 * 
		 * TreeNode n1 = new TreeNode(2, n3, n4); TreeNode n2 = new TreeNode(6,
		 * n5, n6); TreeNode root = new TreeNode(4, n1, n2);
		 * 
		 * convertToDLL(root); printDLL(getHead(root));
		 */
		Node n1 = null, n2 = null, n3 = null, n4 = null, n5 = null, n6 = null, n7 = null;

		n7 = new Node(7, n6, null);
		n6 = new Node(6, n5, n7);
		n5 = new Node(5, n4, n6);
		n4 = new Node(4, n3, n5);
		n3 = new Node(3, n2, n4);
		n2 = new Node(2, n1, n3);
		n1 = new Node(1, null, n2);
		int N = size(n1);
		BinarySearchTree.head = n1;
		TreeNode root = DLLToBSTRecursive(N);

		inOrderRecursive(root);

	}

	public static void inOrderRecursive(TreeNode root) {
		if (root != null) {
			inOrderRecursive(root.getLeft());
			System.out.print(root.getData() + " -> ");
			inOrderRecursive(root.getRight());
		}

	}

}
