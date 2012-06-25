import java.io.IOException;
import java.net.URL;
import java.util.SortedSet;

public class BigImg {
    
    public static void main(String[] args) throws IOException {
        SortedSet<WebImage> images = Finder.sizedImages(new URL("http://www.csail.mit.edu"));
        System.out.println(images);
    }
}
