package JUnitTests.DatabaseTests;

import Database.AppDatabase;
import Database.Record;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestAppDatabase extends TestDatabase {

    AppDatabase db = new AppDatabase();
    Record r = new Record("John Wick", true, 32);

    @Test
    public void testAdd(){
        assertEquals(r, db.add(r));
    }

    @Test
    public void testRemove() {
        assertEquals(r, db.remove(r));
    }

    @Test
    public void add() throws Exception {
    }

    @Test
    public void remove() throws Exception {
    }

    @Test
    public void get() throws Exception {
    }

    @Test
    public void get1() throws Exception {
    }

    @Test
    public void filter() throws Exception {
    }

}
