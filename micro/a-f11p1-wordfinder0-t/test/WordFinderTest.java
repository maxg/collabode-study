import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class WordFinderTest {
    @Test
    public void basicGetSubstringsTest() {
        String haystack = "abcde";
        String[] needles = {"ab", "abc", "de", "fg"};

        Map<String, Integer> expectedOutput = new HashMap<String, Integer>();
        expectedOutput.put("ab", 0);
        expectedOutput.put("abc", 0);
        expectedOutput.put("de", 3);

        assertEquals(expectedOutput, WordFinder.getSubstrings(haystack,
                                                              needles));
        String[] needlesAgain = {"ab", "abc", "de", "fg"};
        assertArrayEquals(needlesAgain, needles);   
    }
    
    @Test
    public void noNeedlesTest() {
        String haystack = "abcde";
        String[] needles = new String[0];
        assertEquals(new HashMap<String, Integer>(),
                     WordFinder.getSubstrings(haystack, needles));
    }
    
    @Test
    public void findFirstOccurrenceTest() {
        String haystack = "abcdabcd";
        String[] needles = {"ab", "abcd", "da"};
        
        Map<String, Integer> expectedOutput = new HashMap<String, Integer>();
        expectedOutput.put("ab", 0);
        expectedOutput.put("abcd", 0);
        expectedOutput.put("da", 3);
        
        assertEquals(expectedOutput,
                     WordFinder.getSubstrings(haystack, needles));
    }
    
    @Test
    public void mixedCaseTest() {
        String haystack = "ABa*bab";
        String[] needles = {"ab"};
        
        Map<String, Integer> expectedOutput = new HashMap<String, Integer>();
        expectedOutput.put("ab", 5);
        
        assertEquals(expectedOutput,
                     WordFinder.getSubstrings(haystack, needles));
    }
}
