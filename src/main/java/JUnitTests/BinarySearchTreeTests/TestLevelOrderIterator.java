package JUnitTests.BinarySearchTreeTests;

import BinarySearchTree.LevelOrderIterator;
import BinarySearchTree.Node;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class TestLevelOrderIterator {

    Node<Integer> n1 = new Node<Integer>(1, 2);
    Node<Integer> n2 = new Node<Integer>(2, 1);
    Node<Integer> n3 = new Node<Integer>(3, 3);
    LevelOrderIterator<Integer> it;

    public void setup() {
        n1.setLeft(n2);
        n1.setRight(n3);
        it = new LevelOrderIterator<Integer>(n1);
    }

    @Test
    public void hasNext() throws Exception {
        setup();
        assertTrue(it.hasNext());
    }

    @Test
    public void get() throws Exception {
        setup();
        assertEquals(Integer.valueOf(1), it.get());
    }

    @Test
    public void next() throws Exception {
    }

    @Test
    public void remove() throws Exception {
    }

}