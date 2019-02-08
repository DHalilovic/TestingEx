package Database;

import BinarySearchTree.BinarySearchTree;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public abstract class Database {

    protected ArrayList<Record> records;
    protected LinkedHashMap<Integer, Integer> indices; // Store record locations (id, index)
    protected BinarySearchTree<Integer> tree; // Sorts records for optimized(?) filtering

    public Database() {
        records = new ArrayList<Record>();
        indices = new LinkedHashMap<Integer, Integer>();
    }

    abstract boolean add(Record r);

    abstract Record get(int id);
}
