package JUnitTests.DatabaseTests;

import Database.Record;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestRecord {

    Record r = new Record("John Wick", true, 9);

    @Test
    public void getId() throws Exception {
        r.setId(1);
        assertNotNull(r.getId());
        assertEquals(1, r.getId());
    }

    //if getId works, this should work as well
    @Test
    public void setId() throws Exception {
    }

    @Test
    public void getName() throws Exception {
        assertEquals("John Wick", r.getName());
    }

    @Test
    public void setName() throws Exception {
        r.setName("a");
        assertEquals("a", r.getName());
    }

    @Test
    public void isGood() throws Exception {
        assertTrue(r.isGood());
    }

    @Test
    public void setGood() throws Exception {
        r.setGood(false);
        assertFalse(r.isGood());
    }

    @Test
    public void getLength() throws Exception {
        assertEquals(Integer.valueOf(9), r.getLength());
    }

    @Test
    public void setLength() throws Exception {
        r.setLength(10);
        assertEquals(Integer.valueOf(10), r.getLength());
    }

    @Test
    public void compareTo() throws Exception {
        Record s = new Record("a", true, 9);
        assertEquals(0, r.compareTo(s));
        s.setLength(10);
        assertEquals(-1, r.compareTo(s));
        s.setLength(8);
        assertEquals(1, r.compareTo(s));
    }

//    @Test
//    public String toString() throws Exception {
//        return null;
//    }

}