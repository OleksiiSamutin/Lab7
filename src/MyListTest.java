import junit.framework.TestCase;

import org.junit.*;


public class MyListTest extends TestCase {
    protected MyList list;
    private MyList list1;
    private MyList list2;
    private MusicComposition m1;
    private MusicComposition m2;
    private MusicComposition m3;

    @Before
    public void setParam(){
        list = new MyList();
        list1 = new MyList();
        list2 = new MyList();
        m1 = new MusicComposition(250, "Alex",
                "Byb", 54);
        m2 = new MusicComposition(253, "alex",
                "Byb", 54);
        m3 = new MusicComposition(281, "lola",
                "Byb", 54);

    }

    @Test
    public void add(){
        assertTrue(list1.add(m1));
        assertFalse(list1.add(m1));
    }
    @Test
    public void testToArray(){
        list1.add(m1);
        list1.add(m2);
        list1.add(m3);
        Object [] arr = list1.toArray();
        assertTrue(arr[0].equals(m1));
        assertTrue(arr[1].equals(m2));
        assertTrue(arr[2].equals(m3));
    }
}
