import java.awt.Dimension;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

public class Sizer {
    
    public static Dimension size(InputStream image) throws IOException {
        ImageInputStream in = ImageIO.createImageInputStream(image);
        ImageReader reader = ImageIO.getImageReaders(in).next();
        reader.setInput(in);
        return new Dimension(reader.getWidth(0), reader.getHeight(0));
    }
}
