package BinarySearchTree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderIterator<V> implements Iterator<V> {
    protected Node<V> root;
    protected Queue<Node<V>> q;

    public LevelOrderIterator(Node<V> node) {
        q = new LinkedList<Node<V>>();
        this.root = node;
        start();
    }

    private void start() {
        q.clear();
        if(!root.isEmpty()) q.add(root);
    }

    public boolean hasNext() {
        return !q.isEmpty();
    }

    public V get() throws NullPointerException
    {
        return q.poll().value();
    }

    public V next() throws NullPointerException {
        Node<V> current = q.poll();
        V ret = current.value();
        if(!current.left().isEmpty()){
            q.add(current.left());
        }
        if(!current.right().isEmpty()){
            q.add(current.right());
        }

        return ret;
    }

    public void remove() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Remove() is not implemented for this iterator");
    }
}
