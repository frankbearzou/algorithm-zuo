package p2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class XorTest {

    Xor xor;

    @BeforeEach
    public void setup() {
        xor = new Xor();
    }

    @Test
    void testXor() {
        assertEquals(1, xor.xor(new int[]{1,1,1,2,2,3,3,3,3,4,4}));
    }

    @Test
    void testXorTwo() {
        assertArrayEquals(new int[]{5,2}, xor.xorTwo(new int[]{1,1,2,2,2,3,3,3,3,4,4,5,5,5,6,6,6,6}));
    }

    @Test
    void testCountBinaryOnes() {
        assertEquals(2, xor.countBinaryOnes(5));
        assertEquals(3, xor.countBinaryOnes(22));
    }
}
