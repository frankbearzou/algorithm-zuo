package a13;

public class Knapsack {
    public int maxValue(int[] weight, int[] value, int bag) {
        return process(weight, value, 0, bag);
    }

    private int process(int[] weight, int[] value, int index, int rest) {
        if (rest < 0) {
            return -1;
        }
        if (index == weight.length) {
            return 0;
        }
        int drop = process(weight, value, index + 1, rest);
        int take = process(weight, value, index + 1, rest - weight[index]);
        if (take != -1) {
            take += value[index];
        }
        return Math.max(drop, take);
    }

    public static void main(String[] args) {
        int[] weights = { 3, 2, 4, 7, 3, 1, 7 };
        int[] values = { 5, 6, 3, 19, 12, 4, 2 };
        int bag = 15;
        Knapsack knapsack = new Knapsack();
        System.out.println(knapsack.maxValue(weights, values, bag));
    }
}
