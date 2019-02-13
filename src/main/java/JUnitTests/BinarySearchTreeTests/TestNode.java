package JUnitTests.BinarySearchTreeTests;

import BinarySearchTree.InOrderIterator;
import BinarySearchTree.LevelOrderIterator;
import BinarySearchTree.Node;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class TestNode {
    Node<Integer> n1 = new Node<Integer>(1, 2);
    Node<Integer> n2 = new Node<Integer>(2, 1);
    Node<Integer> n3 = new Node<Integer>(3, 3);

    public void setup() {
        n2.setLeft(n1);
        n2.setRight(n3);
    }

    @Test
    public void depth() throws Exception {
        setup();
        assertEquals(1, n1.depth());
        assertEquals(0, n2.depth());
        assertEquals(1, n3.depth());
    }

    @Test
    public void height() throws Exception {
        setup();
    }

    @Test
    public void value() throws Exception {
        setup();
        assertEquals(Integer.valueOf(2), n1.value());
        assertEquals(Integer.valueOf(1), n2.value());
        assertEquals(Integer.valueOf(3), n3.value());
    }

    @Test
    public void iterator() throws Exception {
        setup();
        Iterator<Integer> it = n2.iterator();
        assertEquals(n1.value(), it.next());
        assertEquals(n2.value(), it.next());
        assertEquals(n3.value(), it.next());
        assertFalse(it.hasNext());
    }

    @Test
    public void levelOrderIterator() throws Exception {
        setup();
        Iterator<Integer> it = n2.levelOrderIterator();
        assertEquals(n2.value(), it.next());
        assertEquals(n1.value(), it.next());
        assertEquals(n3.value(), it.next());
        assertFalse(it.hasNext());
}

    @Test
    public void isBalanced() throws Exception {
        setup();
        assertTrue(n2.isBalanced());
    }

    @Test
    public void isComplete() throws Exception {
        setup();
        assertTrue(n2.isComplete());
        n2.setRight(new Node<Integer>());
        assertTrue(n2.isComplete());
        n2.setRight(n3);
        n2.setLeft(new Node<Integer>());
        assertFalse(n2.isComplete());
    }

    @Test
    public void isEmpty() throws Exception {
        setup();
        assertFalse(n2.isEmpty());
        n2 = new Node<Integer>();
        assertTrue(n2.isEmpty());
    }

    @Test
    public void isFull() throws Exception {
        setup();
        assertTrue(n2.isFull());
        assertTrue(n1.isFull());
        n2.setRight(new Node<Integer>());
        assertFalse(n2.isFull());
    }

    @Test
    public void isLeft() throws Exception {
        setup();
        assertTrue(n1.isLeft());
        assertFalse(n2.isLeft());
        assertFalse(n3.isLeft());
    }

    @Test
    public void isRight() throws Exception {
        setup();
        assertFalse(n1.isRight());
        assertFalse(n2.isRight());
        assertTrue(n3.isRight());
    }

    @Test
    public void left() throws Exception {
        setup();
        assertEquals(n1, n2.left());
        assertTrue(n1.left().isEmpty());
    }

    @Test
    public void parent() throws Exception {
        setup();
        assertEquals(n2, n1.parent());
        assertEquals(n2, n3.parent());
    }

    @Test
    public void right() throws Exception {
        setup();
        assertEquals(n3, n2.right());
        assertTrue(n3.right().isEmpty());
    }

    @Test
    public void setLeft() throws Exception {
        n2.setLeft(n1);
        assertEquals(n2.left(), n1);
    }

    @Test
    public void setRight() throws Exception {
        n2.setRight(n3);
        assertEquals(n2.right(), n3);
    }

    //Protected
    @Test
    public void setParent() throws Exception {
    }

    @Test
    public void setValue() throws Exception {
        n1.setValue(0);
        assertEquals(Integer.valueOf(0), n1.value());
    }

    @Test
    public void size() throws Exception {
        setup();
        assertEquals(3, n2.size());
    }

    @Test
    public void root() throws Exception {
        setup();
        assertEquals(n2, n2.root());
        assertEquals(n2, n1.root());
        assertEquals(n2, n3.root());
    }

}