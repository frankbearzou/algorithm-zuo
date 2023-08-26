package p3;

public class MaxArray {
    public int max(int[] arr) {
        return max(arr, 0, arr.length - 1);
    }

    private int max(int[] arr, int l, int r) {
        if (l == r) {
            return arr[l];
        }
        int mid = l + (r - l) / 2;
        int left = max(arr, l, mid);
        int right = max(arr, mid + 1, r);
        return Math.max(left, right);
    }
}
