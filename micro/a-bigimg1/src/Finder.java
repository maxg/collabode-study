import java.awt.Dimension;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Finder {
    
    private static final Pattern IMG = Pattern.compile("<img[^>]+src=\"([^\"]+)\"");
    private static final Pattern CSS = Pattern.compile("<link[^>]+rel=\"stylesheet\"[^>]+href=\"([^\"]+)\"");
    
    public static List<URL> stylesheets(URL page) throws IOException {
        List<URL> urls = new ArrayList<URL>();
        Scanner scan = new Scanner(page.openStream());
        String match;
        while ((match = scan.findWithinHorizon(CSS, 0)) != null) {
            Matcher m = CSS.matcher(match);
            m.find();
            urls.add(new URL(page, m.group(1)));
        }
        return urls;
    }
    
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
        SortedSet<WebImage> images = new TreeSet<WebImage>();
        for (URL image : images(page)) {
            Dimension size = Sizer.size(image.openStream());
            images.add(new WebImage(image, size));
        }
        return images;
    }
}
