import junit.framework.TestCase;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * Created by Admi on 28.05.2015.
 */
public class SVectorTest extends TestCase {

    @Test
    public void testAdd()  {
        SVector<String> instance = new SVector<>();
        instance.add("qwe");
        instance.add("qwe");
        instance.add("qwe");
        instance.add("111", 1);
        instance.add("555", 5);
        instance.add("-1-1-1", -1);
        instance.add("000", 0);
    }

    @Test
    public void testRemove()  {
        SVector<String> instance = new SVector<>();
        instance.add("111");
        instance.add("222");
        instance.add("333");
        instance.add("444");
        instance.add("555");
        instance.remove(2);
        instance.remove(0);
        instance.remove(-1);
        assertEquals(instance.get(0), "222");
        assertEquals(instance.get(2), "555");


    }

    @Test
    public void testGet() {
        SVector<String> instance = new SVector<>();
        instance.add("111");
        instance.add("222");
        instance.add("333");
        instance.add("444");
        instance.add("555");

        assertEquals(instance.get(0), "111");
        assertEquals(instance.get(2), "333");
        assertNull(instance.get(-1));
        assertNull(instance.get(5));
        assertNull(instance.get(100));
    }

    @Test
    public void testIndexOf() {
        SVector<String> instance = new SVector<>();
        instance.add("111");
        instance.add("222");
        instance.add("333");
        instance.add("444");
        instance.add("555");

        assertEquals(instance.indexOf("111"), 0);
        assertEquals(instance.indexOf("333"), 2);
        assertEquals(instance.indexOf("fdfd"), -1);

    }

    @Test
    public void testIterator() {
        SVector<String> instance = new SVector<>();
        instance.add("111");
        instance.add("222");
        instance.add("333");
        instance.add("444");
        instance.add("555");

        Iterator<String> it = instance.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }
}