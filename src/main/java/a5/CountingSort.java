package a5;

public class CountingSort {
    public void sort(int[] arr) {
        if (arr == null || arr.length == 1) {
            return;
        }
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int[] count = new int[max + 1];
        // put value at count index
        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];
            count[value]++;
        }
        // get cumulate sum
        for (int i = 1; i < count.length; i++) {
            count[i] = count[i] + count[i - 1];
        }
        // put value to output
        int[] output = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            output[--count[arr[i]]] = arr[i];
        }
        // put value back to arr
        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }
    }
}
