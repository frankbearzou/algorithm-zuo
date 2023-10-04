package a13;

/*
abc:
a, ab, abc
b, bc
c
 */
public class SubString {
    public void subString(String str) {
        char[] arr = str.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k]);
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        SubString subString = new SubString();
        subString.subString("abc");
    }
}
