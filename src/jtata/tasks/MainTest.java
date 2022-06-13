package jtata.tasks;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MainTest {

    Main tests = new Main();
    

    @Test
    void addTask1() throws Exception {
        // Task 1
        assertEquals(23, tests.Add("11,12"));
        assertEquals(123, tests.Add("123"));
        assertEquals(136, tests.Add("123,12,1"));
    }

    @Test
    void addEmptyInputString() throws Exception {
        assertEquals(0, tests.Add(""));
    }

    @Test
    void addTask2MultipleNumbers() throws Exception {
        // Task 2
        assertEquals(142, tests.Add("123,12,1,2,4"));
        assertEquals(54, tests.Add("1,1,2,3,5,8,13,21"));
        assertEquals(13, tests.Add("2,1,3,7"));
    }

    @Test
    void addTask3ComaAndNewLineDelimiters() throws Exception {
        // Task 3
        assertEquals(13, tests.Add("2\n1,3,7"));
        assertEquals(-1, tests.Add("1,1,,"));
        assertEquals(-1, tests.Add("1\n,"));
        assertEquals(8, tests.Add("1\n3,4"));
        assertEquals(-1, tests.Add("1\n3,4,,"));
        assertEquals(-1, tests.Add(",,"));
    }

    @Test
    void addTask4ComaAndNewLineDelimiters() throws Exception {
        // Task 4
        assertEquals(39, tests.Add("//-\n1-2-34-2"));
        assertEquals(-1, tests.Add("//-\n1-2+34-2"));
        assertEquals(-1, tests.Add("//\n1-2-34-2"));
        assertEquals(39, tests.Add("///\n1/2/34/2"));
        assertEquals(-1, tests.Add("///\n1/2\n34,2"));
        assertEquals(-1, tests.Add("///\n"));
        assertEquals(1, tests.Add("///\n1"));
        assertEquals(-1, tests.Add("/3\n13532"));
        assertEquals(-1, tests.Add("//313532"));
        assertEquals(-1, tests.Add("//-31-35-32"));
    }


    @Test
    void addTask5TestingForException() throws Exception {
        // Task 5
        Exception exception;
        String actualMessage;

        // case 1
        exception = assertThrows(Exception.class, () -> {
            tests.Add("-12,3,1,4");
        });

        actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains("negatives not allowed: -12"));

        // case 2
        exception = assertThrows(Exception.class, () -> {
            tests.Add("-12,-3,-1,-4");
        });

        actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains("negatives not allowed: -12 -3 -1 -4 "));

    }

    @Test
    void addTask6IgnoringNumbersGreaterThan1000() throws Exception {
        // Task 6
        assertEquals(2, tests.Add("//-\n1001-2-3400-2000"));
        assertEquals(0, tests.Add("1006,2675\n1234"));
        assertEquals(1, tests.Add("1006\n2675\n1234\n1"));

    }


}