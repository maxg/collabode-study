import static org.junit.Assert.*;

import org.junit.Test;

public class DigitsToStringConverterTest {
    @Test
    public void smallTest() {
        int[] input = {0, 1, 2, 3};
        char[] alphabet = {'d', 'c', 'b', 'a'};

        String expectedOutput = "dcba";
        assertEquals(expectedOutput,
                     DigitsToStringConverter.convertDigitsToString(
                             input, 4, alphabet));
    }
    
    @Test
    public void largeTest() {
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        char[] alphabet = {'a', 'b', 'c', 'd', 'e',
                           'f', 'g', 'h', 'i', 'j', 'k'};

        String expectedOutput = "bcdefghijk";
        assertEquals(expectedOutput,
                     DigitsToStringConverter.convertDigitsToString(
                             input, 11, alphabet));
    }
}
