import org.junit.Test;
import static org.junit.Assert.*;

public class CacheTest
{
    @Test
    public void RunTest()
    {
        //test empty lru cache
        LRUCache<Integer, Object> cache = new LRUCache<>(2);
        assertNull(cache.get(1));



    }
    @Test
    public void TestTwo()
    {
        //test lru cache below capacity.
        LRUCache<Integer, Object> cache = new LRUCache<>(2);


        cache.put(1, 1);
        assertEquals(cache.get(1) ,1);
        assertNull(cache.get(2));

        cache.put(2, 4);
        assertEquals(cache.get(1) ,1) ;
        assertEquals(cache.get(2) ,4) ;

    }
    @Test
    public void TestThree()
    {
        // test lru cache above capacity, oldest is removed.
        LRUCache<Integer, Object> cache = new LRUCache<>(2);

        cache.put(1, 1);
        cache.put(2, 4);
        cache.put(3, 9);
        assertNull(cache.get(1)) ;
        assertEquals(cache.get(2) ,4) ;
        assertEquals(cache.get(3) ,9) ;

    }
    @Test
    public void TestFour()
    {
        // get renews entry
        LRUCache<Integer, Object> cache = new LRUCache<>(2);

        cache.put(1, 1);
        cache.put(2, 4);
        assertEquals(cache.get(1) ,1) ;

        cache.put(3, 9);
        assertEquals(cache.get(1) ,1) ;
        assertNull(cache.get(2) );
        assertEquals(cache.get(3) ,9) ;

    }
    @Test
    public  void TestFive()
    {
        // Double put does not remove due to capacity.
        LRUCache<Integer, Object> cache = new LRUCache<>(2);

        assertNull(cache.get(2));

        cache.put(2, 6);

        assertNull(cache.get(1));

        cache.put(1, 5);
        cache.put(1, 2);

        assertEquals(cache.get(1) ,2);
        assertEquals(cache.get(2) ,6) ;

    }


}
