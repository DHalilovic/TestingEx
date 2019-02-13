package Database;

import BinarySearchTree.AVLTree;
import BinarySearchTree.BinarySearchTree;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public abstract class Database {

    protected int idCounter; // Tracks next valid id
    protected LinkedHashMap<Integer, Record> records; // References records by id
    protected BinarySearchTree<Integer> tree;


    public Database(){
        this(new LinkedHashMap<Integer, Record>(),
                new AVLTree<Integer>()
        );
    }

    public Database(LinkedHashMap<Integer, Record> records, BinarySearchTree<Integer> tree) {
        this.records = records;
        this.tree = tree;
    }

    public abstract Record add(Record r);

    public abstract Record remove(Record r);

    public abstract ArrayList<Record> removeAll(Record r);

    public abstract Record get(Record r);

    public abstract Record get(int id);

    public abstract ArrayList<Record> filter(Record r);
}
