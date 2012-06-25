import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Graph {
    
    public Graph() {
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
        String line;
        while ((line = reader.readLine()) != null) {
            // TODO parse line into graph data structure
        }
        return graph;
    }
    
}
