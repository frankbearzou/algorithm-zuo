package a12;

public class Hanoi {
    public void hanoi(int n) {
        move(n, "left" ,"right", "mid");
    }

    private void move(int n, String from, String to, String other) {
        if (n == 1) {
            System.out.println("move " + n + " from " + from + " to " + to);
            return;
        }
        move(n - 1, from, other, to);
        System.out.println("move " + n + " from " + from + " to " + to);
        move(n - 1, other, to, from);
    }

    public static void main(String[] args) {
        Hanoi hanoi = new Hanoi();
        hanoi.hanoi(3);
    }
}
