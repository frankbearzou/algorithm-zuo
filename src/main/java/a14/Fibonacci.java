package a14;

public class Fibonacci {
    public int recur(int N) {
        if (N == 1 || N == 2) {
            return 1;
        }
        return recur(N - 1) + recur(N - 2);
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.recur(10));
    }
}
