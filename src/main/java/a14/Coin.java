package a14;

public class Coin {
    public int ways1(int[] coins, int total) {
        return process1(coins, 0, total);
    }

    private int process1(int[] coins, int index, int rest) {
        if (index == coins.length) {
            return rest == 0 ? 1 : 0;
        }
        int ways = 0;
        for (int count = 0; count * coins[index] <= rest; count++) {
            ways += process1(coins, index + 1, rest - coins[index] * count);
        }
        return ways;
    }

    public int ways2(int[] coins, int total) {
        int[][] dp = new int[coins.length + 1][total + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        return process2(coins, 0, total, dp);
    }

    private int process2(int[] coins, int index, int rest, int[][] dp) {
        if (dp[index][rest] != -1) {
            return dp[index][rest];
        }
        if (index == coins.length) {
            dp[index][rest] = rest == 0 ? 1 : 0;
            return dp[index][rest];
        }
        int ways = 0;
        for (int count = 0; count * coins[index] <= rest; count++) {
            ways += process2(coins, index + 1, rest - coins[index] * count, dp);
        }
        dp[index][rest] = ways;
        return ways;
    }

    public static void main(String[] args) {
        int[] c = {5, 10};
        Coin coin = new Coin();
        System.out.println(coin.ways1(c, 20));
        System.out.println(coin.ways2(c, 20));
    }
}
