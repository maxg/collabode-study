import java.io.IOException;

public class MaxFlow {
    
    public static void main(String[] args) throws IOException {
        Graph graph = new Graph(MaxFlow.class.getResourceAsStream("abcde.txt"));
        System.out.println(graph);
        System.out.println("Max-flow = " + graph.maxFlow());
    }
}
