package BinarySearchTree;

import java.util.Iterator;

public class Node<V> {
    protected Node<V> left;
    protected Node<V> right;
    protected Node<V> parent;
    protected V val;

    public Node(V val, Node<V> l, Node<V> r){
        this.val = val;
        parent = null;

        if( val == null ) {
            // empty constructor call
            left = this;
            right = this;
            return;
        }

        if ( l == null && r == null ){
            left = new Node<V>();
            right = left;
            setLeft(left);
            setRight(right);
        }

        if (left == null) { left = new Node<V>(); }
        setLeft(left);
        if (right == null) { right = new Node<V>(); }
        setRight(right);
    }

    public Node(V val){
        this(val, null, null);
    }

    public Node(){
        this(null, null, null);
    }

    public int depth(){
        int count = 0;
        Node<V> currentP = parent;

        while( currentP != null ){
            count++;
            currentP = currentP.parent;
        }

        return count;
    }

    public int height(){
        if(isEmpty()) return -1;

        int leftHeight = left.height();
        int rightHeight = right.height();

        if( leftHeight >= rightHeight ){
            return leftHeight + 1;
        }else{
            return rightHeight + 1;
        }
    }

    public V value(){
        return val;
    }

    public Iterator<V> iterator(){
        return this.inorderIterator();
    }

    public Iterator<V> inorderIterator(){
        return new InOrderIterator<V>(this);
    }

    public Iterator<V> levelOrderIterator(){
        return new LevelOrderIterator<V>(this);
    }

    public boolean isBalanced(){
        if(isEmpty()) return true;
        return Math.abs( left.height() - right.height() ) <= 1
                && left.isBalanced() && right.isBalanced();
    }

    public boolean isComplete(){
        // Complete = Any holes in tree appear only on the last level to the right.
        if (isEmpty()) return true;

        // Define and assign left's variables:
        int leftHeight = left.height();
        boolean leftIsFull = left.isFull();
        boolean leftIsComplete = left.isComplete();

        // Define and assign right's variables:
        int rightHeight = right.height();
        boolean rightIsFull = right.isFull();
        boolean rightIsComplete = right.isComplete();

        // case 1: left is full, right is complete, heights same
        if (leftIsFull && rightIsComplete &&
                (leftHeight == rightHeight)){
            return true;
        }

        // case 2: left is complete, right is full, heights differ
        if (leftIsComplete && rightIsFull &&
                (leftHeight == (rightHeight + 1))){
            return true;
        }

        return false;
    }

    public boolean isEmpty(){
        return val == null;
    }

    public boolean isFull(){
        // Full = every node besides the leaves has two children.
        if(isEmpty()) return true;

        if(left.height() != right.height() ) return false;

        return left().isFull() && right().isFull();
    }

    public boolean isLeft(){
        if( parent != null && parent.left == this ){
            return true;
        }
        return false;
    }

    public boolean isRight(){
        if( parent != null && parent.right == this ){
            return true;
        }
        return false;
    }

    public Node<V> left(){
        return left;
    }

    public Node<V> parent(){
        return parent; // may return null
    }

    public Node<V> right(){
        return right;
    }

    protected void rotateLeft(){
        Node<V> parent = parent();
        Node<V> newRoot = right();
        // is the this node a child; if so, a left child?
        boolean wasChild = parent != null;
        boolean wasRightChild = isRight();

        // hook in new root (sets newRoot's parent, as well)
        setRight(newRoot.left());

        // put pivot below it (sets this's parent, as well)
        newRoot.setLeft(this);

        if (wasChild) {
            if (wasRightChild) parent.setRight(newRoot);
            else               parent.setLeft(newRoot);
        }
    }

    protected void rotateRight(){
        Node<V> parent = parent();
        Node<V> newRoot = left();
        boolean wasChild = parent != null;
        boolean wasLeftChild = isLeft();

        // hook in new root (sets newRoot's parent, as well)
        setLeft(newRoot.right());

        // puts pivot below it (sets this's parent, as well)
        newRoot.setRight(this);

        if (wasChild) {
            if (wasLeftChild) parent.setLeft(newRoot);
            else              parent.setRight(newRoot);
        }
    }

    public void setLeft(Node<V> otherL){
        if (isEmpty()) return; // do nothing if val == null
        if (left != null && left.parent() == this) left.setParent(null);
        left = otherL;
        left.setParent(this);
    }

    public void setRight(Node<V> otherR){
        if (isEmpty()) return; // do nothing if val == null
        if (right != null && right.parent() == this) right.setParent(null);
        right = otherR;
        right.setParent(this);
    }

    protected void setParent(Node<V> otherP){
        if(!isEmpty()){
            parent = otherP;
        }
    }

    public void setValue(V val){
        this.val = val;
    }

    public int size(){
        if(isEmpty()) return 0; // base case
        return left().size() + right.size() + 1;
    }

    public Node<V> root(){
        if(parent == null){
            return this;
        } else{
            return parent.root();
        }
    }



//    public String toString(){
//
//    }
//
//    public String treeString(){
//
//    }
}
