package Database;

import java.util.Comparator;

public class RecordComparator implements Comparator<Integer> {

    protected Database db;

    public RecordComparator(Database db) {
        this.db = db;
    }

    public int compare(Integer o1, Integer o2) {
        return db.get(o1).compareTo(db.get(o2));
    }
}
