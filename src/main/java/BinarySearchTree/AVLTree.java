package BinarySearchTree;

import java.util.Comparator;
import java.util.Iterator;

public class AVLTree<V extends Comparable<V>>  extends BinarySearchTree<V>{

    public AVLTree() {
        super();
    }

    public AVLTree(Comparator<V> alternateOrder) {
        super(alternateOrder);
    }

    // returns true if (id, val) pair was added to tree.
    public boolean add(Integer id, V val) {
        Node<V> newNode = new Node<V>(id, val,EMPTY,EMPTY);

        // add value to binary search tree
        // if there's no root, create value at root
        if (root.isEmpty())
        {
            root = newNode;
        } else {
            Node<V> insertLocation = search(root,val);
            int initialSize = insertLocation.ids.size();

            if(add(id, newNode, insertLocation) &&
                    initialSize == insertLocation.ids.size()){
                // A new node has been added.
                rebalance(insertLocation);
            }
        }
        size++;
        return true;
    }

    public Integer remove(Integer id, V val) {
        if (isEmpty()) return null;

        Node<V> removeAt = search(root, val);
        Node<V> p = null;

         if (val.equals(removeAt.value())) {
             if(removeAt.ids.size() < 2) {
                 if(removeAt.parent() != null) p = removeAt.parent();
                 boolean wasLeftChild = removeAt.isLeft();

                 Node<V> replace = removeTop(removeAt);
                 size--;

                 if(p != null){
                     if(wasLeftChild) p.setLeft(replace);
                     else p.setRight(replace);
                     rebalance(p);
                 }

                 if(!replace.isEmpty()) {
                     Node<V> child = replace;
                     while (!child.right().isEmpty()) child = child.right();

                     rebalance(child);
                 }
             } else {
                removeAt.ids.remove(id);
             }
             return id;
         }

         return null;
    }

    protected void rebalance(Node<V> n) {
        if (getBalance(n) <= -2) {
            if (n.left().left().height() >= n.left().right().height())
                n = rotateRight(n);
            else
                n = rotateLeftThenright(n);

        } else if (getBalance(n) >= 2) {
            if (n.right().right().height() >= n.right().left().height())
                n = rotateLeft(n);
            else
                n = rotateRightThenleft(n);
        }

        if (n.parent() != null) {
            rebalance(n.parent());
        } else {
            root = n;
        }
    }

    protected Node<V> rotateLeft(Node<V> x) {
        Node<V> parent = x.parent();
        Node<V> newRoot = x.right();
        boolean wasChild = parent != null;
        boolean wasRightChild = x.isRight();
        x.setRight(newRoot.left());
        newRoot.setLeft(x);
        if (wasChild) {
            if (wasRightChild) {
                parent.setRight(newRoot);
            } else {
                parent.setLeft(newRoot);
            }
        }
        return newRoot;
    }

    protected Node<V> rotateRight(Node<V> y) {
        Node<V> parent = y.parent();
        Node<V> newRoot = y.left();
        boolean wasChild = parent != null;
        boolean wasLeftChild = y.isLeft();
        y.setLeft(newRoot.right());
        newRoot.setRight(y);
        if (wasChild) {
            if (wasLeftChild) {
                parent.setLeft(newRoot);
            } else {
                parent.setRight(newRoot);
            }
        }
        return newRoot;
    }

    protected Node<V> rotateLeftThenright(Node<V> n) {
        n.setLeft(rotateLeft(n.left()));
        return rotateRight(n);
    }

    protected Node<V> rotateRightThenleft(Node<V> n) {
        n.setRight(rotateRight(n.right()));
        return rotateLeft(n);
    }

    protected int getBalance(Node<V> node){
        if(node.isEmpty()) return -1;
        return node.right().height() - node.left().height();
    }
}