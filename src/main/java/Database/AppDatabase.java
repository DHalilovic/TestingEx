package Database;

import java.util.ArrayList;
import java.util.List;

public class AppDatabase extends Database {

    public Record add(Record r) {
        // Increment if current id not available/unique
        while (records.containsKey(idCounter)) {
            idCounter++;
        }

        records.put(idCounter, r); // Add record

        // Increment to next id for easier future use
        idCounter++;

        return r;
    }

    public Record remove(Record r) {
        tree.remove(r.getId(), r.getLength()); // Remove id from tree
        return records.remove(r.getId()); // Remove id from records
    }

    public Record get(Record r) {
        return records.get(r.getId());
    }

    public Record get(int id) {
        return records.get(id);
    }

    public ArrayList<Record> filter(Record r) {
        return null;
    }
}
