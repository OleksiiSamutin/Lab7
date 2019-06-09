import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.List;

import static org.junit.Assert.*;

public class MyListTest1 {

    protected MyList list;
    private MyList list1;
    private MyList list2;
    private MusicComposition m1;
    private MusicComposition m2;
    private MusicComposition m3;
    private MusicComposition m4;

    @Before
    public void setParam() {
        list = new MyList();
        list1 = new MyList();
        list2 = new MyList();
        m1 = new MusicComposition(250, "Alex",
                "Byb", 54);
        m2 = new MusicComposition(253, "alex",
                "Byb", 54);
        m3 = new MusicComposition(281, "lola",
                "Byb", 54);
        m4 = new MusicComposition(277, "alex",
                "Byb", 54);

    }


    @Test
    public void size() {
        assert(list1.size()==0);
        list1.add(m1);
        list1.add(m2);
        assertEquals(2,list1.size());
    }

    @Test
    public void isEmpty() {
        assertTrue(list1.isEmpty());
        list1.add(m1);
        assertFalse(list1.isEmpty());
    }

    @Test
    public void contains() {
        assertFalse(list1.contains(m1));
        list1.add(m1);
        assertTrue(list1.contains(m1));
    }

    @Test
    public void iterator() {
        assertFalse(list1.iterator().hasNext());
        list1.add(m1);
        assertTrue(list1.iterator().hasNext());
        assertEquals(m1,list1.iterator().next());
    }

    @Test
    public void testToArray() {
        list1.add(m1);
        list1.add(m2);
        list1.add(m3);
        Object[] arr = list1.toArray();
        assertTrue(arr[0].equals(m1));
        assertTrue(arr[1].equals(m2));
        assertTrue(arr[2].equals(m3));
    }


    @Test
    public void add() {
        assertTrue(list1.add(m1));
        assertTrue(list1.contains(m1));
    }

    @Test
    public void remove() {
        list1.add(m1);
        list1.remove(m1);
        assertFalse(list1.contains(m1));
    }

    @Test
    public void containsAll() {
        list1.add(m1);
        list1.add(m2);
        list1.add(m3);
        list2.add(m2);
        list2.add(m3);
        assertTrue(list1.containsAll(list2));
    }

    @Test
    public void addAll() {
        list1.add(m1);
        list1.add(m2);
        assertFalse(list2.containsAll(list1));
        list2.addAll(list1);
        assertEquals(2,list1.size());
        assertTrue(list2.containsAll(list1));
    }

    @Test
    public void addAll1() {
        list2.add(m1);
        list2.add(m3);
        list1.addAll(4,list2);

    }

    @Test
    public void removeAll() {
        list1.add(m1);
        list1.add(m2);
        list1.add(m3);
        list2.addAll(list1);
        assertTrue(list2.containsAll(list1));
        list2.removeAll(list1);
        assertFalse(list2.containsAll(list1));
    }

    @Test
    public void retainAll() {
        list1.add(m1);
        list1.add(m2);
        list1.add(m3);
        list2.add(m3);
        assertTrue(list1.retainAll(list2));
        assertEquals(1,list1.size());
    }

    @Test
    public void clear() {
        list.clear();
        assert(list.size()==0);
    }

    @Test
    public void get() {
        list1.add(m1);
        list1.add(m2);
        list1.add(m3);
        list1.add(m2);
        assertEquals(m2,list1.get(3));

    }

    @Test
    public void set() {
        list1.add(m1);
        list1.add(m3);
        list1.add(m1);
        list1.add(m2);
        assertFalse(list1.get(1)==m2);
        list1.set(1,m2);
        assertTrue(list1.get(1)==m2);
    }

    @Test
    public void removeByIndex() {
        list1.add(m1);
        list1.add(m2);
        list1.add(m3);
        list1.add(m1);
        assertTrue(list1.get(2)==m3);
        list1.remove(2);
        assertFalse(list1.get(2)==m3);
        assertEquals(3,list1.size());

    }

    @Test
    public void indexOf() {
        list1.add(m1);
        list1.add(m2);
        list1.add(m3);
        list1.add(m2);
        assert(list1.indexOf(m2)==1);
        assert(list1.indexOf(m1)==0);
        assertEquals(-1,list1.indexOf(m4));
    }

    @Test
    public void lastIndexOf() {
        list1.add(m1);
        list1.add(m2);
        list1.add(m3);
        list1.add(m2);
        list1.add(m1);
        assert(list1.lastIndexOf(m2)==3);
        assert(list1.lastIndexOf(m1)==4);
        assert(list1.lastIndexOf(m3)==2);
        assertEquals(-1,list1.lastIndexOf(m4));
    }


    @Test
    public void subList() {
        list1.add(m1);
        list1.add(m2);
        list1.add(m3);
        list1.add(m4);
        list1.add(m4);
        List<MusicComposition> sub;
        sub = list1.subList(1,4);
        for (int i = 1; i < 4; i++) {
            assertEquals(sub.get(i), list1.get(i));
        }


    }

    @Test
    public void replaceAll() {
    }

    @Test
    public void toArray() {
        list.add(m1);
        list.add(m2);

        Object[] actualArray = list.toArray();
        assertEquals(2, actualArray.length);

        Object[] expectedArray = new Object[]{
                m1,
                m2
        };
        for (int i = 0; i < actualArray.length; i++) {
            assertSame(expectedArray[i], actualArray[i]);
        }
    }

}