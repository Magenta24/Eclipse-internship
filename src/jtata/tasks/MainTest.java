package jtata.tasks;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MainTest {

    Main tests = new Main();
    @Test
    void add() {
        assertEquals(23, tests.Add("11,12"));
        assertEquals(0, tests.Add(""));
        assertEquals(123, tests.Add("123"));
        assertEquals(135, tests.Add("123,12,1"));
    }
}