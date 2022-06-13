package jtata.tasks;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MainTest {

    Main tests = new Main();
    @Test
    void add() {
        // Task 1
        assertEquals(23, tests.Add("11,12"));
        assertEquals(0, tests.Add(""));
        assertEquals(123, tests.Add("123"));
        assertEquals(136, tests.Add("123,12,1"));

        // Task 2
        assertEquals(142, tests.Add("123,12,1,2,4"));
        assertEquals(54, tests.Add("1,1,2,3,5,8,13,21"));
        assertEquals(13, tests.Add("2,1,3,7"));


        // Task 3
        assertEquals(13, tests.Add("2\n1,3,7"));
        assertEquals(-1, tests.Add("1,1,,"));
        assertEquals(-1, tests.Add("1\n,"));
        assertEquals(8, tests.Add("1\n3,4"));
        assertEquals(-1, tests.Add("1\n3,4,,"));
        assertEquals(-1, tests.Add(",,"));

    }
}