package p4;

public class MergeSortRecursion {
    public void mergeSort(int[] arr) {
        split(arr, 0, arr.length - 1);
    }

    private void split(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + (r - l) / 2;
        split(arr, l, mid);
        split(arr, mid + 1, r);
        merge(arr, l, mid, r);

    }

    private void merge(int[] arr, int l, int mid, int r) {
        int[] tmp = new int[r - l + 1];
        int i = 0, p1 = l, p2 = mid + 1;
        while (p1 <= mid && p2 <= r) {
            tmp[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            tmp[i++] = arr[p1++];
        }
        while (p2 <= r) {
            tmp[i++] = arr[p2++];
        }
//        for (int j = l, k = 0; j < r; j++, k++) {
//            arr[j] = tmp[k];
//        }
        for (i = 0; i < tmp.length; i++) {
            arr[i + l] = tmp[i];
        }
    }
}
