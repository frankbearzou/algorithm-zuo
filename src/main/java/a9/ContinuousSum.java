package a9;

/*
is continuous sum
1: no
2=1+1, no
3=1+2, yes
4=1+2+1, no
5=2+3, yes
 */
public class ContinuousSum {
    public boolean sum(int n) {
        for (int i = 1; i < n; i++) {
            if (sum(n, i)) {
                return true;
            }
        }
        return false;
    }

    private boolean sum(int n, int start) {
        if (n == 0) {
            return true;
        }
        if (n < 0) {
            return false;
        }
        return sum(n - start, start + 1);
    }

    public static void main(String[] args) {
        ContinuousSum sum = new ContinuousSum();
        for (int i = 2; i < 1000; i++) {
            System.out.println(i + ": " + sum.sum(i));
        }
    }
}
