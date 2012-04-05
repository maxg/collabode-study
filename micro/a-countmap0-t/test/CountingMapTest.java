import static org.junit.Assert.*;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;

public class CountingMapTest {
    
    CountingMap<String, String> map = new CountingMap<String, String>();
    
    @Test
    public void testInitial() {
        assertEquals(0, map.countPuts("key"));
        assertEquals(0, map.countPuts(null));
        assertEquals(0, map.countPuts(1));
    }
    
    @Test
    public void testPuts() {
        map.put("key", "value1");
        assertEquals(1, map.countPuts("key"));
        assertEquals("value1", map.get("key"));
        map.put("key", "value2");
        map.put("key", "value2");
        assertEquals(3, map.countPuts("key"));
        assertEquals("value2", map.get("key"));
    }
    
    @Test
    public void testMultipleKeys() {
        map.put("key1", "value0");
        map.put("key2", "value1");
        map.put("key2", "value2");
        assertEquals(1, map.countPuts("key1"));
        assertEquals(2, map.countPuts("key2"));
        assertEquals("value0", map.get("key1"));
        assertEquals("value2", map.get("key2"));
    }
    
    @Test
    public void testPutAll() {
        Map<String, String> other = new LinkedHashMap<String, String>();
        other.put("a", "android");
        other.put("b", "busybox");
        map.put("b", "bee");
        map.put("c", "cow");
        map.putAll(other);
        assertEquals(1, map.countPuts("a"));
        assertEquals(2, map.countPuts("b"));
        assertEquals(1, map.countPuts("c"));
    }
    
    @Test
    public void testRemoves() {
        map.put("key", "value1");
        map.remove("key");
        assertEquals(1, map.countPuts("key"));
        assertEquals(null, map.get("key"));
        assertFalse(map.containsKey("key"));
        map.put("key", "value2");
        map.put("key", "value2");
        map.remove("key");
        assertEquals(3, map.countPuts("key"));
        assertEquals(null, map.get("key"));
        assertFalse(map.containsKey("key"));
    }
    
    @Test
    public void testSets() {
        map.put("a", "apple");
        map.put("b", "bendy");
        map.put("b", "berry");
        map.put("b", "bunny");
        map.put("c", "cycle");
        map.put("d", "dance");
        assertEquals(4, map.size());
        assertFalse(map.isEmpty());
        assertTrue(map.containsKey("a"));
        assertEquals(4, map.keySet().size());
        assertEquals(4, map.values().size());
        assertEquals(4, map.entrySet().size());
        map.keySet().clear();
        assertEquals(0, map.size());
        assertTrue(map.isEmpty());
        assertFalse(map.containsKey("a"));
        assertEquals(0, map.keySet().size());
        assertEquals(0, map.values().size());
        assertEquals(0, map.entrySet().size());
        assertEquals(1, map.countPuts("a"));
        assertEquals(3, map.countPuts("b"));
    }
    
    @Test
    public void testClear() {
        map.put("a", "apple");
        map.put("b", "bendy");
        map.put("b", "berry");
        map.put("b", "bunny");
        map.put("c", "cycle");
        map.put("d", "dance");
        map.clear();
        assertEquals(0, map.size());
        assertTrue(map.isEmpty());
        assertEquals(1, map.countPuts("a"));
        assertEquals(3, map.countPuts("b"));
        assertEquals(0, map.countPuts("e"));
    }
}
