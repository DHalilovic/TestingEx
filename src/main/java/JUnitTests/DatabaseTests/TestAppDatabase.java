package JUnitTests.DatabaseTests;

import Database.AppDatabase;
import Database.Record;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestAppDatabase extends TestDatabase {

    AppDatabase db = new AppDatabase();
    Record r = new Record("John Wick", true, 32);

    public void setup() {
        db.add(r);
    }

    @Test
    public void testAdd(){
        assertEquals(r, db.add(r));
    }

    @Test
    public void testRemove() {
        setup();
        assertEquals(r, db.remove(r));
    }

    @Test
    public void get() throws Exception {
        setup();
        assertEquals(r, db.get(r));
    }

    @Test
    public void getById() throws Exception {
        setup();
        assertEquals(r, db.get(r.getId()));
    }

    @Test
    public void filter() throws Exception {
        setup();
        ArrayList<Record> arr = db.filter(new Record(null, true, null));
        assertTrue(arr.contains(r));

    }

}
