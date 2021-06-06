package traversal;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeUtil {

	public int height(TreeNode root) {
		if (root == null)
			return 0;

		int l = height(root.getLeft());
		int r = height(root.getLeft());

		return 1 + Math.max(l, r);
	}

	public static void pritnLevelOrder(TreeNode root) {

		if (root == null)
			return;

		Queue<TreeNode> Q = new LinkedList<TreeNode>();
		Q.add(root);

		int level = 1;
		while (!Q.isEmpty()) {
			int count = Q.size();

			System.out.print(level + "      ");
			while (count > 0) {

				TreeNode node = Q.remove();
				System.out.print(node.getData() + " ");

				if (node.getLeft() != null)
					Q.add(node.getLeft());

				if (node.getRight() != null)
					Q.add(node.getRight());

				count--;
			}
			System.out.println();
			level++;
		}

	}

	public static int maxSumLevel(TreeNode root) {
		if (root == null)
			return 0;

		Queue<TreeNode> Q = new LinkedList<TreeNode>();
		Q.add(root);

		int level = 0;
		int maxSum = 0;
		int maxLevel = 0;

		while (!Q.isEmpty()) {
			int sum = 0;
			int count = Q.size();
			level++;
			while (count > 0) {

				TreeNode node = Q.remove();
				sum += node.getData();
				if (node.getLeft() != null)
					Q.add(node.getLeft());

				if (node.getRight() != null)
					Q.add(node.getRight());

				count--;
			}
			if (sum > maxSum) {
				maxSum = sum;
				maxLevel = level;
			}
		}
		System.out.println("MaxSum : " + maxSum);
		return maxLevel;
	}

	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	public static int countVerticalLines(TreeNode root) {
		countVerticalLinesRecur(root, 0);
		return max + Math.abs(min) + 1;
	}

	public static void countVerticalLinesRecur(TreeNode root, int v) {
		if (root == null)
			return;

		if (v > max)
			max = v;
		if (v < min)
			min = v;

		countVerticalLinesRecur(root.getLeft(), v + 1);
		countVerticalLinesRecur(root.getRight(), v - 1);

	}

	public static int size(TreeNode root) {
		if (root == null)
			return 0;

		int l = size(root.getLeft());
		int r = size(root.getLeft());

		return l + r + 1;
	}

	public static void printAllPath(TreeNode root) {
		int size = size(root);
		int paths[] = new int[size];
		printPath(root, paths, 0);
	}

	public static void printPath(TreeNode root, int paths[], int size) {

		if (root == null)
			return;
		paths[size] = root.getData();
		size++;
		if (root.getLeft() == null && root.getRight() == null) {
			printArray(paths, size);
		}

		printPath(root.getLeft(), paths, size);
		printPath(root.getRight(), paths, size);
	}

	public static void printArray(int path[], int size) {
		for (int i = 0; i < size; i++) {

			if (i == size - 1)
				System.out.print(path[i]);
			else
				System.out.print(path[i] + " -> ");
		}
		System.out.println();
	}

	public void setNextSibling(TreeNode root) {
		if (root == null)
			return;

		if (root.getLeft() != null) {
			root.getLeft().setSibling(root.getRight());
		}
		if (root.getRight() != null) {
			if (root.getSibling() != null)
				root.getRight().setSibling(root.getSibling().getLeft());
		}

		setNextSibling(root.getLeft());
		setNextSibling(root.getRight());
	}

	public static void main(String[] args) {

		TreeNode n4 = new TreeNode(4, null, null);
		TreeNode n5 = new TreeNode(5, null, null);
		TreeNode n6 = new TreeNode(6, null, null);
		TreeNode n7 = new TreeNode(7, null, null);

		TreeNode n2 = new TreeNode(2, n4, n5);
		TreeNode n3 = new TreeNode(3, n6, n7);

		TreeNode root = new TreeNode(1, n2, n3);

		// pritnLevelOrder(root);
		printAllPath(root);
	}
}
