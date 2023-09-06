package a5;

public class RadixSort {
    public void sort(int[] arr) {
        if (arr == null || arr.length == 1) {
            return;
        }
        int max = getMax(arr);

        // place: one's, ten's, hundreds
        for (int place = 1; max / place > 0; place *= 10) {
            int[] count = new int[10];
            // calculate count
            for (int i = 0; i < arr.length; i++) {
                count[(arr[i] / place) % 10]++;
            }
            // calculate accumulate sum
            for (int i = 1; i < count.length; i++) {
                count[i] = count[i] + count[i - 1];
            }
            // output array
            int[] output = new int[arr.length];
            for (int i = arr.length - 1; i >= 0; i--) {
                output[--count[(arr[i] / place) % 10]] = arr[i];
            }
            // output back to arr
            for (int i  = 0; i < arr.length; i++) {
                arr[i] = output[i];
            }
        }
    }

    private int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}
