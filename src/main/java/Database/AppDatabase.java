package Database;

public class AppDatabase extends Database{

    public Record get(int id) {
        return records.get(indices.get(id));
    }

    public boolean add(Record r) {
        records.add(r); // Add record to list
        int ind = records.size() - 1; // Get record index

        boolean success = false;

        // Reject record if its id is not unique
        if (!indices.containsKey(r.getId())) {
            indices.put(r.getId(), ind); // Save record location
            success = true;
        }

        return success;
    }
}
