package a1;

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

    @Test
    void testNearestIndex() {
        assertEquals(1, binarySearch.nearestIndex(new int[]{1,2,2,2,3,3,4,5}, 2));
    }

    @Test
    void testRegionMin() {
        assertEquals(1, binarySearch.regionMin(new int[]{5,1,8,6,7,9}));
    }
}
