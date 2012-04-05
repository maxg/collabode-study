import java.util.*;

/**
 * A {@link Map} that records the number of times each key is assigned a
 * value.
 */
public class CountingMap<K, V> implements Map<K, V> {
    
    /**
     * Returns the number of times the specified key has been assigned
     * a value over the lifetime of this map. Removing a key from the
     * map does not reset the count.
     * 
     * @param key key whose assignment count is to be returned
     * @return the number of times the specified key has been assigned a value
     */
    public int countPuts(Object key) {
        // REQ: please implement
    }
    
    public void clear() {
        // REQ: please implement
    }
    
    public boolean containsKey(Object key) {
        // REQ: please implement
    }
    
    public boolean containsValue(Object value) {
        // REQ: please implement
    }
    
    public Set<Map.Entry<K, V>> entrySet() {
        // REQ: please implement
    }
    
    public V get(Object key) {
        // REQ: please implement
    }
    
    public boolean isEmpty() {
        // REQ: please implement
    }
    
    public Set<K> keySet() {
        // REQ: please implement
    }
    
    public V put(K key, V value) {
        // REQ: please implement
    }
    
    public void putAll(Map<? extends K, ? extends V> m) {
        // REQ: please implement
    }
    
    public V remove(Object key) {
        // REQ: please implement
    }
    
    public int size() {
        // REQ: please implement
    }
    
    public Collection<V> values() {
        // REQ: please implement
    }
    
}
