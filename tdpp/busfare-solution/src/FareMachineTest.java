import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

import org.junit.Assert;
import org.junit.Test;

import collabode.Accepted;
import collabode.NeedsImpl;
import collabode.NeedsReview;

/**
 * JUnit: {@link Test}, {@link Assert}
 * Annotations: none -> {@link NeedsImpl} -> {@link NeedsReview} -> {@link Accepted}
 */
public class FareMachineTest {
    
    @Accepted @Test public void testConstructor() {
        new FareMachine(new InputStreamReader(System.in), new OutputStreamWriter(System.out));
    }
    
    @Accepted @Test public void testCashOK() throws IOException {
        Reader in = new StringReader("cash 1\ncash 1.00\n");
        Writer out = new StringWriter();
        new FareMachine(in, out).process();
        Assert.assertEquals("paid\npaid\n", out.toString());
    }
    
    @Accepted @Test public void testCashNotEnough() throws IOException {
        Reader in = new StringReader("cash 0\ncash 0.50\n");
        Writer out = new StringWriter();
        new FareMachine(in, out).process();
        Assert.assertEquals("insufficient\ninsufficient\n", out.toString());
    }
    
    @Accepted @Test public void testCardOK() throws IOException {
        Reader in = new StringReader("balance bob 5\ncard bob\n");
        Writer out = new StringWriter();
        new FareMachine(in, out).process();
        Assert.assertEquals("balance bob 4.25\npaid\n", out.toString());
    }
    
    @Accepted @Test public void testCardReload() throws IOException {
        Reader in = new StringReader("balance bob 0\ncard bob\nadd\ncard bob\ncash 1\ncard bob\ncard bob\n");
        Writer out = new StringWriter();
        new FareMachine(in, out).process();
        Assert.assertEquals("balance bob 0.00\ninsufficient\nbalance bob 0.00\nbalance bob 1.00\nbalance bob 0.25\npaid\n", out.toString());
    }
    
    private String expected(String filename) throws IOException {
        InputStream in = this.getClass().getResourceAsStream(filename);
        BufferedReader buff = new BufferedReader(new InputStreamReader(in));
        StringBuilder expect = new StringBuilder();
        String line;
        while ((line = buff.readLine()) != null) {
            if (line.startsWith("# => ")) {
                expect.append(line.substring(5) + "\n");
            }
        }
        return expect.toString();
    }
    
    @Accepted @Test public void testExample() throws IOException {
        String expect = expected("example.txt");
        
        InputStream in = FareMachine.class.getResourceAsStream("example.txt");
        Writer out = new StringWriter();
        new FareMachine(new InputStreamReader(in), out).process();
        
        Assert.assertEquals(expect, out.toString());
    }
    
    public static void main(String[] args) throws Exception {
        new FareMachineTest().testExample();
    }
}
