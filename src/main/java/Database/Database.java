package Database;

import BinarySearchTree.BinarySearchTree;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public abstract class Database {

    protected int idCounter; // Tracks next valid id
    protected LinkedHashMap<Integer, Record> records; // References records by id
    protected BinarySearchTree<Integer> tree; // Sorts records for optimized(?) filtering

    public Database() {
        records = new LinkedHashMap<Integer, Record>();
        tree = new BinarySearchTree<Integer>();
    }

    abstract Record add(Record r);

    abstract Record remove(Record r);

    abstract Record get(Record r);

    abstract Record get(int id);

    abstract ArrayList<Record> filter(Record r);
}
