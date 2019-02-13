package JUnitTests.DatabaseTests;

import Database.AppDatabase;
import Database.Record;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestAppDatabase {

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

}
