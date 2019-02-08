package BinarySearchTree;

import java.util.Comparator;
import java.util.Iterator;

public class BinarySearchTree<E extends Comparable<E>> {
    protected int size;
    protected Comparator<E> ordering;
    protected BinaryTree<E> root;
    protected final BinaryTree<E> EMPTY = new BinaryTree<E>();

    public BinarySearchTree(){
        this(new ClassicOrdering<E>());
    }

    public BinarySearchTree(Comparator<E> alternateOrder)
    {
        root = EMPTY;
        size = 0;
        ordering = alternateOrder;
    }

    public boolean add(E val){
        BinaryTree<E> newNode = new BinaryTree<E>(val,EMPTY,EMPTY);

        // add value to binary search tree
        // if there's no root, create value at root
        if (root.isEmpty())
        {
            root = newNode;
        } else {
            BinaryTree<E> insertLocation = search(root,val);
            E nodeValue = insertLocation.value();
            // The location returned is the successor or predecessor
            // of the to-be-inserted value
            int compare = ordering.compare(nodeValue, val);
            if(compare == 0){ // if value == nodeValue
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
        root = new BinaryTree<E>();
        size = 0;
    }

    public boolean contains(E val){
        if (root.isEmpty()) return false;

        BinaryTree<E> possibleLocation = search(root,val);
        return val.equals(possibleLocation.value());
    }

    public E get(E val){
        if (root.isEmpty()) return null;

        BinaryTree<E> possibleLocation = search(root,val);
        if (val.equals(possibleLocation.value()))
            return possibleLocation.value();
        else
            return null;
    }

    public boolean isEmpty(){
        return root == EMPTY;
    }

    public Iterator<E> iterator(){
        return root.inorderIterator();
    }

    protected BinaryTree<E> search(BinaryTree<E> root, E val){
        if(!isEmpty()) {
            E rootValue = root.value();
            BinaryTree<E> child;

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

    public E remove( E val ){
        if (isEmpty()) return null;

        if (val.equals(root.value())) // delete root value
        {
            BinaryTree<E> newroot = removeTop(root);
            size--;
            E result = root.value();
            root = newroot;
            return result;
        }
        else
        {
            BinaryTree<E> location = search(root,val);

            if (val.equals(location.value())) {
                size--;
                BinaryTree<E> parent = location.parent();
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

    protected BinaryTree<E> removeTop(BinaryTree<E> top){
        // remove topmost BinaryTree from a binary search tree
        BinaryTree<E> left  = top.left();
        BinaryTree<E> right = top.right();
        // disconnect top node
        top.setLeft(EMPTY);
        top.setRight(EMPTY);
        // Case a, no left BinaryTree
        //   easy: right subtree is new tree
        if (left.isEmpty()) { return right; }
        // Case b, no right BinaryTree
        //   easy: left subtree is new tree
        if (right.isEmpty()) { return left; }
        // Case c, left node has no right subtree
        //   easy: make right subtree of left
        BinaryTree<E> pred = left.right();
        if (pred.isEmpty())
        {
            left.setRight(right);
            return left;
        }
        // General case, slide down left tree
        //   harder: successor of root becomes new root
        //           parent always points to parent of predecessor
        BinaryTree<E> parent = left;
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

//    protected BinaryTree<E> predecessor(BinaryTree<E> node){
//
//    }
//
//    protected BinaryTree<E> successor(BinaryTree<E> node){
//
//    }
}

class ClassicOrdering<E extends Comparable<E>> implements Comparator<E>{
    public int compare(E o1, E o2) {
        return o1.compareTo(o2);
    }
}
