package BinarySearchTree;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Stack;

public class InOrderIterator<V> implements Iterator<V> {
    protected Node<V> root;
    protected Stack<Node<V>> s;

    public InOrderIterator(Node<V> node) {
        root = node;
        s = new Stack<Node<V>>();
        start();
    }

    private void start() {
        s.clear();
        if(!root.isEmpty()){
            fillStack(root);
        }
    }

    private void fillStack(Node<V> node) {
        Node<V> current = node;
        s.push(current);
        while( !current.left().isEmpty()){
            current = current.left();
            s.push(current);
        }
    }

    public V get() throws EmptyStackException {
        return s.peek().value();
    }

    public boolean hasNext() {
        return !s.isEmpty();
    }

    public V next() throws EmptyStackException {
        Node<V> current = s.pop();
        V ret = current.value();

        if( !current.right().isEmpty()){
            fillStack(current.right());
        }

        return ret;
    }

    public void remove() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Remove() is not implemented for this iterator");
    }
}
