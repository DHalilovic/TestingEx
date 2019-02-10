package Database;

import java.util.Comparator;

public class RecordComparator implements Comparator<Integer> {

    private Database db;

    public RecordComparator(Database db) {
        this.db = db;
    }

    public int compare(Integer o1, Integer o2) {
        return db.getById(o1).compareTo(db.getById(o2));
    }
}
