package Trie;

public class Trie {
    static class Node {
        Node[] children; // 26
        boolean isEnd;

        public Node() {
            children = new Node[26]; // a tto z
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            isEnd = false;
        }
    }

    static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.isEnd = true; // mark the end of the word
    }

    public static boolean search(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                System.out.println("Not Present");
                return false;
            }
            curr = curr.children[idx];
        }
        if (curr.isEnd == true) {
            System.out.println("Present");
            return true;
        }
        System.out.println("Not Present");
        return false;
    }

    public static boolean wordBreak(String word) {
        if (word.length() == 0) {
            return true;
        }
        for (int i = 1; i <= word.length(); i++) {
            if (search(word.substring(0, i)) && wordBreak(word.substring(i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean startsWith(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }

    public static int countNode(Node root) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                count += countNode(root.children[i]);
                
            }
        }
        return count + 1;
    }

    public static String ans = "";

    public static void longestWord(Node root, StringBuilder temp) {
        if (root == null) {
            return;
        }
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null && root.children[i].isEnd == true) {
                temp.append((char) (i + 'a'));
                
                if (temp.length() > ans.length()) {
                    ans = temp.toString();
                } 
                longestWord(root.children[i], temp);
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }

    public static void main(String[] args) {

        // String words[] = { "the", "a", "there", "their", "any" };
        // for (String word : words) {
        // insert(word);
        // }
        // search("thala");

        // String words[] = { "i", "like", "samsung", "mobile", "sam" };
        // String word = "ilikesamsung";
        // // String word = "ilikesung";

        // for (int i = 0; i < words.length; i++) {
        //     insert(words[i]);
        // }
        // System.out.println(wordBreak(word));
        // String words[] = { "apple", "app", "mango", "man", "woman" };
        // String prefix = "app";
        // String prefix2 = "moon";
        // for (int i = 0; i < words.length; i++) {
        //     insert(words[i]);
        // }
        // System.out.println(startsWith(prefix2));
        // String str = "ababa";

        // for (int i = 0; i < str.length(); i++) {
        //     String suffix = str.substring(i);
        //     insert(suffix);
        // }
        // System.out.println(countNode(root));

        String words[] = {"a", "bananan", "app", "appl", "app", "ap", "apply", "apple" };
           for (int i = 0; i < words.length; i++) {
            insert(words[i]);
           }
           longestWord(root, new StringBuilder(""));
           System.out.println(ans);
    }
}
