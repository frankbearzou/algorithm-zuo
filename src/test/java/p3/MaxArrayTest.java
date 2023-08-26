package p3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxArrayTest {
    @Test
    void test() {
        MaxArray max = new MaxArray();
        assertEquals(7, max.max(new int[]{4,6,3,7}));
        assertEquals(7, max.max(new int[]{4,6,3,7,5}));
        assertEquals(7, max.max(new int[]{4,1,6,3,7,2,5}));
    }

}