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

    }

    public int height(){

    }

    public E value(){
        return val;
    }

    public Iterator<E> inorderIterator(){

    }

    public boolean isBalanced(){

    }

    public boolean isComplete(){

    }

    public boolean isEmpty(){

    }

    public boolean isFull(){

    }

    public boolean isLeft(){

    }

    public boolean isRight(){

    }

    public Iterator<E> iterator(){

    }

    public Node<E> left(){

    }

    public Iterator<E> levelOrderIterator(){

    }

    public Node<E> parent(){

    }

    public Iterator<E> postorderIterator(){

    }

    public Iterator<E> preorderIterator(){

    }

    public Node<E> right(){

    }

    public Node<E> root(){

    }

    protected void rotateLeft(){

    }

    protected void rotateRight(){

    }

    public void setLeft(Node<E> otherL){

    }

    public void setRight(Node<E> otherR){

    }

    protected void setParent(Node<E> otherP){

    }

    public void setValue(E val){

    }

    public int size(){

    }

    public String toString(){

    }

    public String treeString(){

    }
}
