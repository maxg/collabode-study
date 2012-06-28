import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Graph {
    
    public Graph() {
    }
    
    public void addEdge(String from, String to, int capacity) {
        // TODO add edge to graph data structure
        System.out.println("Add edge from " + from + " to " + to + " with " + capacity);
    }
    
    /**
     * Read a graph from a file.
     *
     * A graph file is a sequence of lines:
     *        nodes "--" capacity "->" nodes    
     * Where: node = [a-zA-Z_0-9]+
     *        nodes = node | "{" node ( "," node )+ "}"
     *        capacity = [0-9]+
     * And tokens may be separated by whitespace.
     */
    public static Graph read(InputStream in) throws IOException {
        Graph graph = new Graph();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String nodesRegex = "\\s*(\\w+|\\{[^\\}]+})\\s*";
        String edgeRegex = "--\\s*(\\d+)\\s*->";
        Pattern regex = Pattern.compile(nodesRegex + edgeRegex + nodesRegex);
        String nodesDelims = "{,} \t";
        String line;
        while ((line = reader.readLine()) != null) {
            Matcher m = regex.matcher(line);
            if ( ! m.matches()) {
                throw new IOException("Error parsing graph: " + line);
            }
            int capacity = Integer.parseInt(m.group(2));
            StringTokenizer fromTok = new StringTokenizer(m.group(1), nodesDelims);
            while (fromTok.hasMoreElements()) {
                String from = fromTok.nextToken();
                StringTokenizer toTok = new StringTokenizer(m.group(3), nodesDelims);
                while (toTok.hasMoreElements()) {
                    graph.addEdge(from, toTok.nextToken(), capacity);
                }
            }
        }
        return graph;
    }
    
}
