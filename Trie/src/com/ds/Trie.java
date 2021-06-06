package com.ds;

public class Trie {

	TrieNode root = new TrieNode();

	public void insert(String s) {

		char c[] = s.toCharArray();
		TrieNode cur = root;

		for (int i = 0; i < c.length; i++) {
			if (cur != null && !cur.child.containsKey(c[i])) {
				TrieNode t = new TrieNode();
				cur.child.put(c[i], t);
			}
			cur = cur.child.get(c[i]);

		}
		cur.isEnd = true;
	}

	public Trie() {
		insert("dog");
		insert("duck");
		insert("apple");
		insert("boy");
		insert("boyle");
		insert("dove");
		insert("zebra");

		System.out.println(prefix(root, "zebra"));
	}

	private String prefix(TrieNode root, String s) {
		TrieNode cur = root;

		String minPrefix = "";
		String curPrefix = "";

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (cur != null && cur.child.containsKey(c)) {
				curPrefix += c;
				if (cur.child.size() > 1) {
					minPrefix = curPrefix;
				}
				cur = cur.child.get(c);
				if (cur.isEnd == true)
					break;
			}
		}
		return minPrefix;
	}

	public void exist() {

	}

	public static void main(String[] args) {
		new Trie();
	}
}
