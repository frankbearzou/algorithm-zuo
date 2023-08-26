package p3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinStackTest {
    @Test
    void test() {
        MinStack s = new MinStack();
        s.push(5);
        s.push(6);
        s.push(7);
        assertEquals(5, s.min());
        s.push(4);
        assertEquals(4, s.min());
        s.push(7);
        assertEquals(4, s.min());
        s.push(3);
        assertEquals(3, s.min());
        s.push(4);
        assertEquals(3, s.min());
        s.pop();
    }

}