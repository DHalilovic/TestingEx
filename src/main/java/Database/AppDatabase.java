package Database;

public class AppDatabase extends Database {

    public Record get(int id) {
        return records.get(records.get(id));
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

    public Record remove(int id) {
        return records.remove(id);
    }
}
