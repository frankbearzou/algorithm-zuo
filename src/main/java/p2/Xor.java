package p2;

public class Xor {
    // all occur even times, except only one number occurs odd times. find that number occurs odd times
    public int xor(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res = res ^ arr[i];
        }
        return res;
    }

    // all occur even times, except two numbers occur odd times.
    public int[] xorTwo(int[] arr) {
        // first xor all, the result is a ^ b
        int firstXor = 0;
        for (int i = 0; i < arr.length; i++) {
            firstXor = firstXor ^ arr[i];
        }

        // find the last one of the first xor
        int one = firstXor & (~firstXor + 1);
        int res1 = 0;
        // separate to two groups, first group is the value 1 on same last one digit, second is 0 on that digit
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & one) == 1) {
                res1 = res1 ^ arr[i];
            }
        }
        int res2 = firstXor ^ res1;
        return new int[]{res1, res2};
    }
}
