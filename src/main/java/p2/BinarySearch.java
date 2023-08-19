package p2;

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
}
