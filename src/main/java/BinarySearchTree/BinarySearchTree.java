package BinarySearchTree;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;

public class BinarySearchTree<V extends Comparable<V>> {
    protected int size;
    protected Comparator<V> ordering;
    protected Node<V> root;
    protected final Node<V> EMPTY = new Node<V>();

    public BinarySearchTree(){
        this(new ClassicOrdering<V>());
    }

    public BinarySearchTree(Comparator<V> alternateOrder)
    {
        root = EMPTY;
        size = 0;
        ordering = alternateOrder;
    }

    // returns true if (id, val) pair was added to tree.
    public boolean add(Integer id, V val){
        Node<V> newNode = new Node<V>(id, val,EMPTY,EMPTY);

        // add value to binary search tree
        // if there's no root, create value at root
        if (root.isEmpty())
        {
            root = newNode;
        } else {
            Node<V> insertLocation = search(root,val);
            return add(id, newNode, insertLocation);
        }
        size++;
        return true;
    }

    // returns true if (id, val) pair was added to tree.
    protected boolean add( Integer id, Node<V> newNode, Node<V> insertLocation ){
        V nodeValue = insertLocation.value();
        V val = newNode.val;
        // The location returned is the successor or predecessor
        // of the to-be-inserted value
        int compare = ordering.compare(nodeValue, val);
        if(compare == 0){ // if val == nodeValue
            return insertLocation.ids.add(id);
        }
        else if (compare < 0) { // if value > nodeValue
            insertLocation.setRight(newNode);
        } else { // if value < nodeValue
            insertLocation.setLeft(newNode);
        }

        return true;
    }

    public void clear(){
        root = new Node<V>();
        size = 0;
    }

    public boolean contains(V val){
        if (root.isEmpty()) return false;

        Node<V> possibleLocation = search(root,val);
        return val.equals(possibleLocation.value());
    }

    // if val exists in tree, return the list of the ids for the records that store val.
    public Set<Integer> get(V val){
        if (root.isEmpty()) return null;

        Node<V> possibleLocation = search(root,val);
        if (val.equals(possibleLocation.value()))
            return possibleLocation.ids;
        else
            return null;
    }

    public boolean isEmpty(){
        return root == EMPTY;
    }

    public Iterator<V> iterator(){
        return root.inorderIterator();
    }

    protected Node<V> search(Node<V> root, V val){
        if(!isEmpty()) {
            V rootValue = root.value();
            Node<V> child;

            // found at root: done
            if (rootValue.equals(val)) return root;
            // look left if less-than, right if greater-than
            if (ordering.compare(rootValue, val) < 0) {
                child = root.right();
            } else {
                child = root.left();
            }
            // no child there: not in tree, return this node,
            // else keep searching
            if (child.isEmpty()) {
                return root;
            } else {
                return search(child, val);
            }
        }
        return root;
    }

    public Integer remove( Integer id, V val ){
        if (isEmpty()) return null;

        Node<V> location = search(root,val);

        if (val.equals(location.value())) {
            if(location.ids.size() < 2) {
                size--;
                Node<V> parent = location.parent();
                if (parent.right() == location) {
                    parent.setRight(removeTop(location));
                } else {
                    parent.setLeft(removeTop(location));
                }
            } else {
                location.ids.remove(id);
            }
            return id;
        }

        return null;
    }

    protected Node<V> removeTop(Node<V> top){
        // remove topmost Node from a binary search tree
        Node<V> left  = top.left();
        Node<V> right = top.right();
        // disconnect top node
        top.setLeft(EMPTY);
        top.setRight(EMPTY);
        // Case a, no left Node
        //   easy: right subtree is new tree
        if (left.isEmpty()) { return right; }
        // Case b, no right Node
        //   easy: left subtree is new tree
        if (right.isEmpty()) { return left; }
        // Case c, left node has no right subtree
        //   easy: make right subtree of left
        Node<V> pred = left.right();
        if (pred.isEmpty())
        {
            left.setRight(right);
            return left;
        }
        // General case, slide down left tree
        //   harder: successor of root becomes new root
        //           parent always points to parent of predecessor
        Node<V> parent = left;
        while (!pred.right().isEmpty())
        {
            parent = pred;
            pred = pred.right();
        }
        // Assert: predecessor is predecessor of root
        parent.setRight(pred.left());
        pred.setLeft(left);
        pred.setRight(right);
        return pred;
    }

    public int size(){
        return this.size;
    }

//    public int hashCode(){
//
//    }
//
//    public String toString(){
//
//    }
//
//    public String treeString(){
//
//    }

//    protected Node<V> predecessor(Node<V> node){
//
//    }
//
//    protected Node<V> successor(Node<V> node){
//
//    }
}

class ClassicOrdering<E extends Comparable<E>> implements Comparator<E>{
    public int compare(E o1, E o2) {
        return o1.compareTo(o2);
    }
}
