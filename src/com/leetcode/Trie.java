package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by weilun on 2015/5/11.
 */

class TrieNode {
    // Initialize your data structure here.
    List<TrieNode> mChilds = null;
    char value = '0';

    public TrieNode() {
        mChilds = new ArrayList<TrieNode>();
    }

    TrieNode childsContain(char data) {
        for (TrieNode node : mChilds ) {
            if ( node.value == data)
                return node ;
        }
        return null;
    }

}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {

        if( word == null || word.length() == 0 )
            return;

        int length = word.length();
        TrieNode cur = root ;

        for (int i = 0; i < length; i++) {
            char data = word.charAt(i);

            TrieNode node = cur.childsContain(data);
            if( node == null  ) {
                TrieNode temp = new TrieNode();
                temp.value = data;
                node.mChilds.add(temp);

                cur = node;
            }else {
                cur = node;
            }
        }

    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return false;
    }
}
