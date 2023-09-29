package a10;

import java.util.PriorityQueue;

public class IPO {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> cost = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> profit = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        for (int i = 0; i < profits.length; i++) {
            cost.offer(new int[]{capital[i], profits[i]});
        }

        while (k-- > 0) {
            while (!cost.isEmpty() && cost.peek()[0] <= w) {
                profit.offer(cost.poll());
            }
            w += profit.poll()[1];
        }

        return w;
    }

    public static void main(String[] args) {
        IPO ipo = new IPO();
        System.out.println(ipo.findMaximizedCapital(2, 1, new int[]{3, 1, 3, 2}, new int[]{1, 1, 4, 5}));
    }
}
