package a1;

public class BinarySearch {
    public boolean binarySearch(int[] sortedArr, int target) {
        if (sortedArr == null || sortedArr.length == 0) {
            return false;
        }

        int l = 0, r = sortedArr.length - 1, m;
        while (l < r) {
            m = l + (r - l) / 2;
            if (sortedArr[m] == target) {
                return true;
            } else if (sortedArr[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return sortedArr[l] == target;
    }

    // find the most left index that satisfies >= target
    public int nearestIndex(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int index = -1;
        int l = 0, r = arr.length - 1, mid;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (arr[mid] >= target) {
                r = mid - 1;
                index = mid;
            } else {
                l = mid + 1;
            }
        }

        return index;
    }

    public int regionMin(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (arr.length == 1 || arr[0] < arr[1]) {
            return arr[0];
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr[arr.length - 1];
        }
        int l = 1, r = arr.length - 2, mid;
        while (l < r) {
            mid = l + (r - l) / 2;
            if (arr[mid] > arr[mid - 1]) {
                r = mid - 1;
            } else if (arr[mid] > arr[mid + 1]) {
                l = mid + 1;
            } else {
                // no same value in arr
                return mid;
            }
        }
        return l;
    }
}
