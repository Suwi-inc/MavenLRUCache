import java.util.Iterator;
import java.util.LinkedHashMap;

public class LRUCache<R,L> implements  ILRUCache<R,L>
{
    private final int capacity;
    private LinkedHashMap<R,L> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new LinkedHashMap<>(16, 0.75f, true);
    }

    public L get(R key) {
        L value = this.map.get(key);
        if (value == null) {
            value = null;
        }
        return value;
    }

    public void put(R key, L value) {
        if (
                !this.map.containsKey(key) &&
                        this.map.size() == this.capacity
        ) {
            Iterator<R> it = this.map.keySet().iterator();
            it.next();
            it.remove();
        }
        this.map.put(key, value);
    }
}
