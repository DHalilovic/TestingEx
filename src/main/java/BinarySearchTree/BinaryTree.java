package BinarySearchTree;

import java.util.Iterator;

public class BinaryTree<E> {
    protected BinaryTree<E> left;
    protected BinaryTree<E> right;
    protected BinaryTree<E> parent;
    protected E val;

    BinaryTree( E val, BinaryTree<E> l, BinaryTree<E> r){
        left = l;
        right = r;
        parent = null;
        this.val = val;
    }

    BinaryTree(E val){
        this(val, null, null);
    }

    BinaryTree(){
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

    public BinaryTree<E> left(){

    }

    public Iterator<E> levelOrderIterator(){

    }

    public BinaryTree<E> parent(){

    }

    public Iterator<E> postorderIterator(){

    }

    public Iterator<E> preorderIterator(){

    }

    public BinaryTree<E> right(){

    }

    public BinaryTree<E> root(){

    }

    protected void rotateLeft(){

    }

    protected void rotateRight(){

    }

    public void setLeft(BinaryTree<E> otherL){

    }

    public void setRight(BinaryTree<E> otherR){

    }

    protected void setParent(BinaryTree<E> otherP){

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
