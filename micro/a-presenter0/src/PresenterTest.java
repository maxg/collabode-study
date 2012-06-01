import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PresenterTest {
    
    @Test public void testTitleize() {
        assertEquals("Hello", Presenter.titleize("hello"));
    }
    
    @Test public void testPluralize() {
        assertEquals("spies", Presenter.pluralize("spy"));
    }
}
