package a13;

/*
given an string "111", 1: a, 26: z. how many way to convert to string
For example: 111. 3 ways.
111: aaa
1 11: ak
11 1: ka
 */
public class ConvertNumberToLetter {
    public int number(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        return process(str.toCharArray(), 0);
    }

    private int process(char[] arr, int index) {
        if (index == arr.length) {
            return 1;
        }
        if (arr[index] == '0') {
            return 0;
        }
        int ans = process(arr, index + 1);
        if (index + 1 < arr.length && ((arr[index] - '0') * 10 + arr[index + 1] - '0' <= 26)) {
            ans += process(arr, index + 2);
        }
        return ans;
    }

    public static void main(String[] args) {
        ConvertNumberToLetter app = new ConvertNumberToLetter();
        System.out.println(app.number("111"));
    }
}
