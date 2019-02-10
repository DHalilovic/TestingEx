package Database;

import java.util.List;

public class AppDatabase extends Database {

    public Record getById(int id) {
        return records.get(id);
    }

    public List<Record> getList(Record r) {
        return null;
    }

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

    public Record removeById(int id) {
        tree.remove(id);
        return records.remove(id);
    }

    public List<Record> filter(Record record) {
        return null;
    }
}
