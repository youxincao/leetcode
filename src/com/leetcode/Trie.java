package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by weilun on 2015/5/11.
 */

class TrieNode {
    // Initialize your data structure here.
    List<TrieNode> mChilds = null;

    boolean isLeaf = false ;
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

    boolean isLeaf() {
        return isLeaf;
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
                cur.mChilds.add(temp);

                cur = temp;
            }else {
                cur = node;
            }
        }

        cur.isLeaf = true ;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if( null == word || word.length() == 0 )
            return false;
        int length = word.length();
        TrieNode cur = root ;

        for (int i = 0; i < length; i++) {
            char data = word.charAt(i);

            TrieNode node = cur.childsContain(data);
            if( node == null)
                return false ;
            cur = node;
        }

        return cur.isLeaf();
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if( null == prefix || prefix.length() == 0 )
            return false;
        int length = prefix.length();
        TrieNode cur = root ;

        for (int i = 0; i < length; i++) {
            char data = prefix.charAt(i);

            TrieNode node = cur.childsContain(data);
            if( node == null)
                return false ;
            cur = node;
        }

        return true ;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("int");
        trie.insert("in");
        trie.insert("ine");
        System.out.println(trie.search("int"));
        System.out.println(trie.search("in"));

        System.out.println(trie.startsWith("int"));
        System.out.println(trie.startsWith("in"));
        System.out.println(trie.startsWith("intint"));
    }
}
