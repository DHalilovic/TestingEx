package Database;

import java.util.ArrayList;

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
        // Initialize result
        ArrayList<Record> result = new ArrayList<Record>();

        // Filter by which attribute is provided
        // Only one attributed can be provided per action via UI
        if (r.getName() != null) {
            // Add records whose names contain query
            for (Record t : records.values()) {
                if (t.getName().contains(r.getName()))
                    result.add(t);
            }
        } else if (r.getLength() != null) {
            // Filter by tree
            // TODO filter by tree
        } else { // Otherwise 'good' attribute provided
            // Add records with boolean values matching query
            for (Record t : records.values()) {
                if (t.isGood().equals(r.isGood()))
                    result.add(t);
            }
        }

        return result;
    }
}
