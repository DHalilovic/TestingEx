package JUnitTests.BinarySearchTreeTests;

import BinarySearchTree.InOrderIterator;
import BinarySearchTree.Node;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestInOrderIterator {

    Node<Integer> n1 = new Node<Integer>(1, 2);
    Node<Integer> n2 = new Node<Integer>(2, 1);
    Node<Integer> n3 = new Node<Integer>(3, 3);
    InOrderIterator<Integer> it;

    public void setup() {
        n1.setLeft(n2);
        n1.setRight(n3);
        it = new InOrderIterator<Integer>(n1);
    }

    @Test
    public void get() throws Exception {
        assertEquals(Integer.valueOf(1), it.get());
    }

    @Test
    public void hasNext() throws Exception {
        assertTrue(it.hasNext());
    }

    @Test
    public void next() throws Exception {
        assertEquals(Integer.valueOf(1), it.next());
    }
}