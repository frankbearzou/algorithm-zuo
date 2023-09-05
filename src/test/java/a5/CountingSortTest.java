package a5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountingSortTest {
    @Test
    void test() {
        int[] arr = {5,3,9,7,6,8,4,1,2,0};
        CountingSort countingSort = new CountingSort();
        countingSort.sort(arr);
        assertArrayEquals(new int[]{0,1,2,3,4,5,6,7,8,9}, arr);
    }
}