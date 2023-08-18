package p2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortTest {
    private Sort sort;
    int[] arr;
    int[] sorted;

    @BeforeEach
    public void setup() {
        sort = new Sort();
        arr = new int[]{5, 4, 6, 3, 8, 2, 9, 1, 7};
        sorted = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    }

    @Test
    void testSelectionSort() {
        sort.selectionSort(arr);

        assertArrayEquals(sorted, arr);
    }

    @Test
    public void testBubbleSort() {
        sort.bubbleSort(arr);

        assertArrayEquals(sorted, arr);
    }
}
