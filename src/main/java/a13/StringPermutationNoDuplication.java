package a13;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringPermutationNoDuplication {
    public List<String> permutation(String str) {
        List<String> ans = new ArrayList<>();
        process(str.toCharArray(), 0, ans);
        return ans;
    }

    private void process(char[] arr, int index, List<String> ans) {
        if (index == arr.length) {
            ans.add(String.valueOf(arr));
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int i = index; i < arr.length; i++) {
            if (!set.contains(arr[i])) {
                set.add(arr[i]);
                swap(arr, i, index);
                process(arr, index + 1, ans);
                swap(arr, i, index);
            }
        }
    }

    private void swap(char[] arr, int i, int j) {
        char c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }

    public static void main(String[] args) {
        StringPermutationNoDuplication app = new StringPermutationNoDuplication();
        List<String> list = app.permutation("aab");
        System.out.println(list);
    }
}
