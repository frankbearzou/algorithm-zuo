package a10;

import java.util.PriorityQueue;

/*
use less money to split gold.
the cost to split gold is the length of current gold brick.
solution: use min heap (huffman coding), take two each time, make sum and put back.
 */
public class SplitGold {
    public int split(int[] arr) {
        int sum = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int val : arr) {
            queue.offer(val);
        }
        while (queue.size() > 1) {
            sum += queue.poll() + queue.poll();
            queue.offer(sum);
        }
        return sum;
    }

    public static void main(String[] args) {
        SplitGold splitGold = new SplitGold();
        System.out.println(splitGold.split(new int[]{10, 20, 30}));
    }
}
