package a3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortRecursionTest {
    @Test
    void test() {
        MergeSortRecursion sort = new MergeSortRecursion();
        int[] arr = {5, 4, 6, 7, 1, 8, 2, 9, 3};
        sort.mergeSort(arr);
        assertArrayEquals(new int[]{1,2,3,4,5,6,7,8,9}, arr);
    }
}
