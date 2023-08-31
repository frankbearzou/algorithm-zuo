package a4;

public class MaxHeap {
    private int size = 0;
    int[] arr;

    public void heapSort(int[] arr) {
        // copy array
        this.arr = arr;
        this.size = arr.length;

        for (int i = 0; i < size; i++) {
            heapInsert(i);
        }
        int n = size;
        while (n > 1) {
            swap(0, --n);
            heapify(0, n);
        }
    }

    // index i go up
    public void heapInsert(int i) {
        // i greater than its parent
        while (arr[i] > arr[(i - 1) / 2]) {
            swap(i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    // index i go down
    public void heapify(int i, int n) {
        int l = i * 2 + 1;
        while (l < n) {
            int maxIndex = l + 1 < n && arr[l + 1] > arr[l] ? l + 1 : l;
            maxIndex = arr[i] > arr[maxIndex] ? i : maxIndex;
            if (i == maxIndex) {
                break;
            }
            swap(i, maxIndex);
            i = maxIndex;
            l = i * 2 + 1;
        }
    }

    private void swap(int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
