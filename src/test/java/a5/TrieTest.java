package a5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrieTest {
    @Test
    void test() {
        Trie trie = new Trie();
        trie.insert("abc");
        trie.insert("abd");
        assertEquals(1, trie.search("abc"));
        assertEquals(1, trie.search("abd"));
        assertEquals(0, trie.search("ab"));
        trie.delete("abd");
        assertEquals(1, trie.search("abc"));
        assertEquals(0, trie.search("abd"));
    }
}
