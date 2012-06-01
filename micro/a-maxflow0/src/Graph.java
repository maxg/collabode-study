import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
 * A graph file is a sequence of lines:
 *        id_or_ids "--" capacity "->" id_or_ids
 * Where: id = [a-zA-Z_0-9]+
 *        id_or_ids = id | "{" id ( "," id )+ "}"
 *        capacity = [0-9]+
 * And tokens may be separated by whitespace.
 */
public class Graph {
    
    private final List<String> lines;
    
    public Graph(InputStream in) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        lines = new ArrayList<String>();
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        // TODO parse into data structure
    }
    
    public int maxFlow() {
        // TODO maybe https://en.wikipedia.org/wiki/Ford–Fulkerson_algorithm
        throw new Error("Unimplemented");
    }
    
    @Override public String toString() {
        return getClass().getSimpleName() + lines;
    }
}
