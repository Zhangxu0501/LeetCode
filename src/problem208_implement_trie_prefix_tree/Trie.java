package problem208_implement_trie_prefix_tree;

/**
 * @author zhangxu create on 2019/1/15
 * version 1.0
 */
import java.util.*;
class Trie {
    private TrieNode root;
    public class TrieNode{
        public char c;
        public TrieNode []  childern =new TrieNode [26];
        public List words=new ArrayList();
        public boolean isEnd;
    }
    /** Initialize your data structure here. */
    public Trie() {
        root=new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode current=root;
        for(int x=0;x<word.length();x++){
            int index=word.charAt(x)-'a';
            TrieNode [] childern=current.childern;
            if(childern[index]==null){
                TrieNode node = new TrieNode();
                node.c=word.charAt(x);
                childern[index]=node;
                node.words.add(word);
                current=node;
            }
            else{
                TrieNode node=childern[index];
                node.words.add(word);
                current=node;
            }
        }
        current.isEnd=true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode current=root;
        for(int x=0;x<word.length();x++){
            int index=word.charAt(x)-'a';
            TrieNode [] childern=current.childern;
            if(childern[index]==null){
                return false;
            }
            else{
                current=childern[index];
            }
        }
        return current.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode current=root;
        for(int x=0;x<prefix.length();x++){
            int index=prefix.charAt(x)-'a';
            TrieNode [] childern=current.childern;
            if(childern[index]==null){
                return false;
            }
            else{
                current=childern[index];
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */