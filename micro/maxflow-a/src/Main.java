public class Main {
    
    public static void main(String[] args) throws Exception {
        Graph graph = Graph.read(Main.class.getResourceAsStream("abcde.txt"));
        System.out.println("Graph = " + graph);
        String source = "A", sink = "E";
        int maxFlow = GraphMath.maxFlow(graph, source, sink);
        System.out.println("Max-flow " + source + " to " + sink + " = " + maxFlow);
    }
}
