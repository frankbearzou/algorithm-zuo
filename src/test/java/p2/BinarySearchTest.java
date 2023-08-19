package p2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    BinarySearch binarySearch;
    int[] arr;

    @BeforeEach
    public void setup() {
        binarySearch = new BinarySearch();
        arr = new int[]{1, 3, 5, 6, 8, 9};
    }

    @Test
    void testBinarySearch() {
        assertTrue(binarySearch.binarySearch(arr, 3));
    }
}
