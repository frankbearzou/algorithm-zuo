package a13;

import java.util.ArrayList;
import java.util.List;

public class StringPermutation {
    public List<String> permutation(String str) {
        List<String> ans = new ArrayList<>();
        permutation(str.toCharArray(), 0, ans);
        return ans;
    }

    private void permutation(char[] arr, int index, List<String> ans) {
        if (index == arr.length) {
            ans.add(String.valueOf(arr));
            return;
        }
        for (int i = index; i < arr.length; i++) {
            swap(arr, i, index);
            permutation(arr, index + 1, ans);
            swap(arr, i, index);
        }
    }

    private void swap(char[] arr, int i, int j) {
        char c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }

    public static void main(String[] args) {
        StringPermutation permutation = new StringPermutation();
        List<String> list = permutation.permutation("abc");
        System.out.println(list);
    }
}
