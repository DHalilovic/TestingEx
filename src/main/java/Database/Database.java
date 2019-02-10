package Database;

import BinarySearchTree.BinarySearchTree;

import java.util.LinkedHashMap;

public abstract class Database {

    protected int idCounter; // Tracks next valid id
    protected LinkedHashMap<Integer, Record> records; // References records by id
    protected BinarySearchTree<Integer> tree; // Sorts records for optimized(?) filtering

    public Database() {
        records = new LinkedHashMap<Integer, Record>();
        tree = new BinarySearchTree<Integer>();
    }

    abstract Record add(Record r);

    abstract Record remove(int id);

    abstract Record get(int id);
}
