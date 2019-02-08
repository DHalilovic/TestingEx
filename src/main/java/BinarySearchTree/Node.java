package BinarySearchTree;

import java.util.Iterator;

public class Node<E> {
    protected Node<E> left;
    protected Node<E> right;
    protected Node<E> parent;
    protected E val;

    Node(E val, Node<E> l, Node<E> r){
        left = l;
        right = r;
        parent = null;
        this.val = val;
    }

    Node(E val){
        this(val, null, null);
    }

    Node(){
        this(null);
    }

    public int depth(){
        int count = 0;
        Node<E> currentP = parent;
        while( currentP != null ){
            count++;
            currentP = currentP.parent;
        }

        return count;
    }

    public int height(){
        int leftHeight = left.height();
        int rightHeight = right.height();

        if( leftHeight >= rightHeight ){
            return leftHeight + 1;
        }else{
            return rightHeight + 1;
        }
    }

    public E value(){
        return val;
    }

    public Iterator<E> inorderIterator(){

    }

    public boolean isBalanced(){
        return Math.abs( left.height() - right.height() ) <= 1;
    }

    public boolean isComplete(){

    }

    public boolean isEmpty(){
        return val == null;
    }

    public boolean isFull(){

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

    public Iterator<E> iterator(){
        return this.inorderIterator();
    }

    public Node<E> left(){
        return left;
    }

    public Iterator<E> levelOrderIterator(){

    }

    public Node<E> parent(){
        return parent;
    }

    public Iterator<E> postorderIterator(){

    }

    public Iterator<E> preorderIterator(){

    }

    public Node<E> right(){
        return right;
    }

    protected void rotateLeft(){

    }

    protected void rotateRight(){

    }

    public void setLeft(Node<E> otherL){
        left = otherL;
    }

    public void setRight(Node<E> otherR){
        right = otherR;
    }

    protected void setParent(Node<E> otherP){
        parent = otherP;
    }

    public void setValue(E val){
        this.val = val;
    }

//    public Node<E> root(){}

//    public int size(){
//        return size;
//    }

//    public String toString(){
//
//    }
//
//    public String treeString(){
//
//    }
}
