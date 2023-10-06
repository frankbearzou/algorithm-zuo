package a13;

/*
there are cards with numbers in a line.
two people choose cards from two ends.
the person with more value win.
return the win number.
 */
public class CardsInLine {
    public int win(int[] cards) {
        if (cards == null || cards.length == 0) {
            return 0;
        }
        int R = cards.length - 1;
        return Math.max(first(cards, 0, R), second(cards, 0, R));
    }

    private int first(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        }
        int left = arr[L] + second(arr, L + 1, R);
        int right = arr[R] + second(arr, L, R - 1);
        return Math.max(left, right);
    }

    private int second(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }
        return Math.min(first(arr, L + 1, R), first(arr, L, R - 1));
    }

    public static void main(String[] args) {
        CardsInLine cardsInLine = new CardsInLine();
        System.out.println(cardsInLine.win(new int[]{10, 1, 7}));
    }
}
