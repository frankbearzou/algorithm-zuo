package a13;

import java.util.ArrayList;
import java.util.List;

public class StringAllSubSequence {
    public List<String> allSubSequence(String str) {
        List<String> ans = new ArrayList<>();
        process(str.toCharArray(), 0, ans, "");
        return ans;
    }

    private void process(char[] arr, int index, List<String> ans, String path) {
        if (index == arr.length) {
            if (!path.isEmpty()) {
                ans.add(path);
            }
            return;
        }
        process(arr, index + 1, ans, path);
        process(arr, index + 1, ans, path + arr[index]);
    }

    public static void main(String[] args) {
        StringAllSubSequence sequence = new StringAllSubSequence();
        List<String> list = sequence.allSubSequence("abc");
        System.out.println(list.stream().sorted().toList());
    }
}
