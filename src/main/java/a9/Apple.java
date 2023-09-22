package a9;

/**
 * apple can fit to 6 or 8 bags
 */
public class Apple {
    public static int minBags(int apple) {
        for (int i = apple / 8; i >= 0; i--) {
            if ((apple - 8 * i) % 6 == 0) {
                return i + (apple - 8 * i) / 6;
            }
        }
        return -1;
    }

    public int minBagsAwesome(int apple) {
        if ((apple & 1) == 1) {
            return -1;
        }
        if (apple < 18) {
            return apple == 0 ? 0 : (apple == 6 || apple == 8) ? 1 : (apple == 12 || apple == 14 || apple == 16) ? 2 : -1;
        }
        return (apple - 18) / 8 + 3;
    }

    public static void main(String[] args) {
        Apple apple = new Apple();
        for (int i = 0; i <= 100; i++) {
            System.out.println(i + ": " + apple.minBagsAwesome(i));
        }
    }
}
