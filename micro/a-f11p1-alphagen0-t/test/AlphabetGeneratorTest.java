import static org.junit.Assert.*;

import org.junit.Test;

public class AlphabetGeneratorTest {
    @Test
    public void generateFrequencyAlphabetTest() {
        String[] trainingData = {"aa", "bbc"};
        char[] expectedOutput = {'a', 'a', 'a', 'a',
                                 'b', 'b', 'b', 'b',
                                 'c', 'c'};
        assertArrayEquals(expectedOutput,
                AlphabetGenerator.generateFrequencyAlphabet(
                        10, trainingData));
    }

    @Test
    public void oneOccurrenceOfEachAZTest() {
        String[] trainingData = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        char[] expectedOutput = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        assertArrayEquals(expectedOutput,
                AlphabetGenerator.generateFrequencyAlphabet(
                        26, trainingData));
    }
    
    @Test
    public void oneOccurrenceOfEachAZBase13Test() {
        String[] trainingData = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        char[] expectedOutput = {'a', 'c', 'e', 'g', 'i', 'k', 'm', 'o', 'q', 's', 'u', 'w', 'y'};
        assertArrayEquals(expectedOutput,
                AlphabetGenerator.generateFrequencyAlphabet(
                        13, trainingData));
    }
    
    @Test
    public void oneOccurrenceOfEachABCDEFBase4Test() {
        String[] trainingData = {"a", "b", "c", "d", "e", "f"};
        char[] expectedOutput = {'a', 'b', 'd', 'e'};
        assertArrayEquals(expectedOutput,
                AlphabetGenerator.generateFrequencyAlphabet(
                        4, trainingData));
    }
}
