package a3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {
    @Test
    void test() {
        int[] arr = {5,2,8,6,9,3,1,4,7};
        QuickSort sort = new QuickSort();
        sort.quickSort(arr);
        assertArrayEquals(new int[]{1,2,3,4,5,6,7,8,9}, arr);
    }

}
