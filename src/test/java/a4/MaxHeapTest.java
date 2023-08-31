package a4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxHeapTest {
    @Test
    void test1() {
        int[] arr = {1,2,3,4,5,6,7};
        MaxHeap heap = new MaxHeap();
        heap.heapSort(arr);
        assertArrayEquals(new int[]{1,2,3,4,5,6,7}, arr);
    }

    @Test
    void test2() {
        int[] arr = {2,4,7,5,1,6,3};
        MaxHeap heap = new MaxHeap();
        heap.heapSort(arr);
        assertArrayEquals(new int[]{1,2,3,4,5,6,7}, arr);
    }

}
