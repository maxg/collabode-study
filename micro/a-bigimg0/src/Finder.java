import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Finder {
    
    private static final Pattern IMG = Pattern.compile("<img[^>]+src=\"([^\"]+)\"");
    
    public static List<URL> images(URL page) throws IOException {
        List<URL> urls = new ArrayList<URL>();
        Scanner scan = new Scanner(page.openStream());
        String match;
        while ((match = scan.findWithinHorizon(IMG, 0)) != null) {
            Matcher m = IMG.matcher(match);
            m.find();
            urls.add(new URL(page, m.group(1)));
        }
        return urls;
    }
    
    public static SortedSet<WebImage> sizedImages(URL page) throws IOException {
        // Use images(..) to get images on page
        // For each image
        //  - Use Sizer.size(..) and construct a WebImage
        //  - Add WebImage to a SortedSet
        // Return the SortedSet
        return null;
    }
}
