package com.ds;

import java.util.HashMap;

public class TrieNode {

	HashMap<Character, TrieNode> child = new HashMap<Character, TrieNode>();
	boolean isEnd;

}
