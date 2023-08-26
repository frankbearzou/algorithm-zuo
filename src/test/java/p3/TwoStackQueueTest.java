package p3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoStackQueueTest {
    @Test
    void test() {
        TwoStackQueue queue = new TwoStackQueue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        assertEquals(1, queue.peek());
        assertEquals(1, queue.poll());
        queue.add(4);
        assertEquals(2, queue.poll());
        assertEquals(3, queue.poll());
        assertEquals(4, queue.poll());
    }
}