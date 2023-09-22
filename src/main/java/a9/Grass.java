package a9;

/**
 * cow and sheep eat grass.
 * cow eat first, and then sheep eat.
 * they can eat 1, 4 ,16, 64... each time.
 * assume the cow and sheep are small.
 * one win when it eats the last one.
 */
/*
base case:
first row: grass left
second row:
1: cow win
2: sheep win
0, 1, 2, 3, 4, 5
2, 1, 2, 1, 1, 2
 */
public class Grass {

    public int eat(int n) {
        if (n <= 5) {
            if (n == 0 || n == 2 || n == 5) {
                return 2;
            } else {
                return 1;
            }
        }
        int base = 1;
        while (n - base > 0) {
            if (eat(n - base) == 2) {
                return 1;
            }
            base *= 4;
        }
        return 2;
    }

    public static void main(String[] args) {
        Grass grass = new Grass();
        for (int i = 0; i < 100; i++) {
            System.out.println(i + ": " + grass.eat(i));
        }
    }
}
