import java.awt.Dimension;
import java.net.URL;

public class WebImage implements Comparable<WebImage> {
    
    public final URL url;
    public final Dimension size;
    
    public WebImage(URL url, Dimension size) {
        this.url = url;
        this.size = size;
    }
    
    @Override public int compareTo(WebImage other) {
        int diff = (size.width * size.height) - (other.size.width * other.size.height);
        if (diff == 0) {
            return url.toString().compareTo(other.url.toString());
        } else {
            return diff;
        }
    }
    
    @Override public String toString() {
        return url + "[" + size.width + "x" + size.height + "]";
    }
}
