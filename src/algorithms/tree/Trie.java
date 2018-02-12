package algorithmsAndDataStructures.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lujianyu on 8/3/17.
 */
public class Trie {
    TrieNode root = new TrieNode('-', "", false);
    public Trie(String[] words) {
        for (String word : words) {
            TrieNode curr = root;
            for (int i = 0; i < word.length(); i++) {
                Character c = word.charAt(i);
                if (!curr.chirldren.containsKey(c)) {
                    curr.chirldren.put(c, new TrieNode(c, word.substring(0, i + 1),i == word.length() - 1 ? true : false));
                }
                curr = curr.chirldren.get(c);
            }
        }
    }

    public void add(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if (!curr.chirldren.containsKey(c)) {
                curr.chirldren.put(c, new TrieNode(c, word.substring(0, i + 1), i == word.length() - 1 ? true : false));
            }
            curr = curr.chirldren.get(c);
        }
    }

    public TrieNode find(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if (!curr.chirldren.containsKey(c)) {
                return null;
            }
            curr = curr.chirldren.get(c);
        }
        return curr;
    }

    public List<String> findStartWith(String s) {
        TrieNode curr = find(s);
        List<String> res = new ArrayList<>();
        search(res, curr);
        return res;
    }

    private void search(List<String> res, TrieNode node) {
        if (node == null) { return;}
        if (node.chirldren.size() == 0 && node.isWord) {
            res.add(node.word);
            return;
        }
        for (Map.Entry<Character, TrieNode> entry : node.chirldren.entrySet()) {
            search(res, entry.getValue());
        }
    }


    private class TrieNode {
        Character c;
        String word;
        Map<Character, TrieNode> chirldren;
        boolean isWord;
        public TrieNode(Character c, String word, boolean isWord) {
            this.c = c;
            this.word = word;
            this.isWord = isWord;
            this.chirldren = new HashMap<>();
        }
    }

    public static void main(String[] args) {
        String[] words = new String[]{"hello", "hell", "hela", "word"};
        Trie trie = new Trie(words);
        System.out.println(trie.find("hello").word);
        System.out.println(trie.find("he").isWord);
        System.out.println(trie.findStartWith("he"));
        System.out.println(trie.findStartWith("hel"));
        trie.add("hea");
        System.out.println(trie.findStartWith("he"));
    }
}
