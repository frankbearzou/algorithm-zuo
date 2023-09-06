package a5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadixSortTest {
    @Test
    void testOneDigit() {
        int[] arr = {5,3,9,7,6,8,4,1,2,0};
        RadixSort radixSort = new RadixSort();
        radixSort.sort(arr);
        assertArrayEquals(new int[]{0,1,2,3,4,5,6,7,8,9}, arr);
    }

    @Test
    void testHundredDigit() {
        int[] arr = {121, 432, 564, 23, 1, 45, 788};
        RadixSort radixSort = new RadixSort();
        radixSort.sort(arr);
        assertArrayEquals(new int[]{1, 23, 45, 121, 432, 564, 788}, arr);
    }
}
