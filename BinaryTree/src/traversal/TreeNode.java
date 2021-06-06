package traversal;

public class TreeNode {

	private int data;
	private TreeNode left;
	private TreeNode right;
	private TreeNode sibling;

	public TreeNode(int data, TreeNode left, TreeNode right) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public int getData() {
		return data;
	}

	public TreeNode getSibling() {
		return sibling;
	}

	public void setSibling(TreeNode sibling) {
		this.sibling = sibling;
	}

	public void setData(int data) {
		this.data = data;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

}
