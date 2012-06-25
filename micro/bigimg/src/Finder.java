import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.SortedSet;

public class Finder {
    
    public static List<URL> images(URL page) throws IOException {
        List<URL> urls = new ArrayList<URL>();
        Scanner scanner = new Scanner(page.openStream());
        // TODO maybe Scanner.findWithinHorizon(.., 0) with a java.util.regex.Pattern
        // TODO use new URL(context, spec) where context is page
        return urls;
    }
    
    public static SortedSet<WebImage> sizedImages(URL page) throws IOException {
        // TODO use Finder.images(..) and Sizer.size(..)
        return null;
    }
    
}
