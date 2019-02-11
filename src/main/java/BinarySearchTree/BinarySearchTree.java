package BinarySearchTree;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;

public class BinarySearchTree<E extends Comparable<E>> {
    protected int size;
    protected Comparator<E> ordering;
    protected Node<E> root;
    protected final Node<E> EMPTY = new Node<E>();

    public BinarySearchTree(){
        this(new ClassicOrdering<E>());
    }

    public BinarySearchTree(Comparator<E> alternateOrder)
    {
        root = EMPTY;
        size = 0;
        ordering = alternateOrder;
    }

    // returns true if val already exists in BinarySearchTree
    public boolean add(Integer id, E val){
        Node<E> newNode = new Node<E>(id, val,EMPTY,EMPTY);

        // add value to binary search tree
        // if there's no root, create value at root
        if (root.isEmpty())
        {
            root = newNode;
        } else {
            Node<E> insertLocation = search(root,val);
            E nodeValue = insertLocation.value();
            // The location returned is the successor or predecessor
            // of the to-be-inserted value
            int compare = ordering.compare(nodeValue, val);
            if(compare == 0){ // if val == nodeValue
                insertLocation.ids.add(id);
                return true;
            }
            else if (compare < 0) { // if value > nodeValue
                insertLocation.setRight(newNode);
            } else { // if value < nodeValue
                insertLocation.setLeft(newNode);
            }
        }
        size++;
        return false;
    }

    public void clear(){
        root = new Node<E>();
        size = 0;
    }

    public boolean contains(E val){
        if (root.isEmpty()) return false;

        Node<E> possibleLocation = search(root,val);
        return val.equals(possibleLocation.value());
    }

    // if val exists in tree, return the list of the ids for the records that store val.
    public Set<Integer> get(E val){
        if (root.isEmpty()) return null;

        Node<E> possibleLocation = search(root,val);
        if (val.equals(possibleLocation.value()))
            return possibleLocation.ids;
        else
            return null;
    }

    public boolean isEmpty(){
        return root == EMPTY;
    }

    public Iterator<E> iterator(){
        return root.inorderIterator();
    }

    protected Node<E> search(Node<E> root, E val){
        if(!isEmpty()) {
            E rootValue = root.value();
            Node<E> child;

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

    public E remove( Integer id, E val ){
        if (isEmpty()) return null;

        if (val.equals(root.value())) // delete root value
        {
            Node<E> newroot = removeTop(root);
            size--;
            E result = root.value();
            root = newroot;
            return result;
        }
        else
        {
            Node<E> location = search(root,val);

            if (val.equals(location.value())) {
                size--;
                Node<E> parent = location.parent();
                if (parent.right() == location) {
                    parent.setRight(removeTop(location));
                } else {
                    parent.setLeft(removeTop(location));
                }
                return location.value();
            }
        }
        return null;
    }

    protected Node<E> removeTop(Node<E> top){
        // remove topmost Node from a binary search tree
        Node<E> left  = top.left();
        Node<E> right = top.right();
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
        Node<E> pred = left.right();
        if (pred.isEmpty())
        {
            left.setRight(right);
            return left;
        }
        // General case, slide down left tree
        //   harder: successor of root becomes new root
        //           parent always points to parent of predecessor
        Node<E> parent = left;
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

    protected int size(){
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

//    protected Node<E> predecessor(Node<E> node){
//
//    }
//
//    protected Node<E> successor(Node<E> node){
//
//    }
}

class ClassicOrdering<E extends Comparable<E>> implements Comparator<E>{
    public int compare(E o1, E o2) {
        return o1.compareTo(o2);
    }
}
