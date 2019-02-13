package Database;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class AppDatabase extends Database {

    @Override
    public Record add(Record r) {
        // Increment if current id not available/unique
        while ( records.containsKey(idCounter) ) {
            idCounter++;
        }

        r.setId(idCounter); // Set record id
        records.put(idCounter, r); // Add record
        tree.add( idCounter, r.getLength() );

        // Increment to next id for easier future use
        idCounter++;

        return r;
    }

    @Override
    public Record remove(Record r) {
        tree.remove(r.getId(), r.getLength()); // Remove id from tree
        return records.remove(r.getId()); // Remove id from records
    }

    public ArrayList<Record> removeAll(Record r){
        ArrayList<Record> removed = new ArrayList<Record>();

        if(!records.isEmpty()) {
            // Only one attributed can be provided per action via UI
            if (r.getName() != null) {
                // Delete records whose names equal query
                Iterator<Record> it = records.values().iterator();
                while(it.hasNext()){
                    Record t = it.next();
                    if (t.getName().equals(r.getName())) {
                        Record recordToBeRemoved = records.remove(t.getId());
                        tree.remove(recordToBeRemoved.getId(), r.getLength());
                        removed.add(recordToBeRemoved);
                    }
                }
            } else if (r.getLength() != null) {
                Iterator<Record> it = records.values().iterator();
                while(it.hasNext()) {
                    Record t = it.next();
                    if (t.getId() == r.getId()) {
                        Record recordToBeRemoved = records.remove(t.getId());
                        tree.remove(recordToBeRemoved.getId(), r.getLength());
                        removed.add(recordToBeRemoved);
                    }
                }
            } else { // Otherwise 'good' attribute provided
                Iterator<Record> it = records.values().iterator();
                while(it.hasNext()) {
                    Record t = it.next();
                    if (t.isGood() == r.isGood()) {
                        Record recordToBeRemoved = records.remove(t.getId());
                        tree.remove(recordToBeRemoved.getId(), r.getLength());
                        removed.add(recordToBeRemoved);
                    }
                }
            }
        }
        return removed;
    }

    @Override
    public Record get(Record r) {
        return records.get(r.getId());
    }

    @Override
    public Record get(int id) {
        return records.get(id);
    }

    @Override
    public ArrayList<Record> filter(Record r) {
        // Initialize result
        ArrayList<Record> result = new ArrayList<Record>();

        if(!records.isEmpty()) {
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
                Set<Integer> ids = tree.get(r.getLength());
                if (ids != null && !ids.isEmpty()){
                    for (Integer id : ids) {
                        result.add(records.get(id));
                    }
                }
            } else { // Otherwise 'good' attribute provided
                // Add records with boolean values matching query
                for (Record t : records.values()) {
                    if (t.isGood() == r.isGood())
                        result.add(t);
                }
            }
        }

        return result;
    }
}
