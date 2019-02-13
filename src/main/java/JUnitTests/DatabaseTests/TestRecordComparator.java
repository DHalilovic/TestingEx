package JUnitTests.DatabaseTests;

import Database.AppDatabase;
import Database.Database;
import Database.Record;
import Database.RecordComparator;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestRecordComparator {

    Database db = new AppDatabase();
    RecordComparator rc = new RecordComparator(db);

    public void setup() {
        Record r = new Record("a", true, 1);
        Record s = new Record("b", true, 1);
        Record t = new Record("b", true, 2);
        Record u = new Record("b", true, 0);
        db.add(r);
        db.add(s);
        db.add(t);
        db.add(u);
    }

    @Test
    public void compare() throws Exception {
        assertEquals(0, rc.compare(0, 1));
        assertEquals(-1, rc.compare(0, 2));
        assertEquals(1, rc.compare(0, 3));
    }

}