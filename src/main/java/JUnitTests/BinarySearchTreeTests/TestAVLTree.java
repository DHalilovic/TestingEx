package JUnitTests.BinarySearchTreeTests;

import BinarySearchTree.*;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestAVLTree extends TestBinarySearchTree {

    /* These can't be tested.
    A. There is no form of output for the tree with these methods
    B. They're protected
    C. No other class will interact with these

    @Test
    public void rebalance() throws Exception {
    }

    @Test
    public void rotateLeft() throws Exception {
    }

    @Test
    public void rotateRight() throws Exception {
    }

    @Test
    public void rotateLeftThenright() throws Exception {
    }

    @Test
    public void rotateRightThenleft() throws Exception {
    }

    @Test
    public void getBalance() throws Exception {

    }
    */

    BinarySearchTree bst = new AVLTree();
    boolean b = bst.add(1, 1);

    @Test
    public void testIfAdded() {
        assertTrue(b);
        assertTrue(bst.contains(1));
        assertFalse(bst.isEmpty());
    }

    @Test
    public void testSize() {
        assertEquals(1, bst.size());
    }

    @Test
    public void testGet() {
        Set<Integer> set = new HashSet<Integer>();
        set.add(1);
        assertEquals(set, bst.get(1));
    }

    @Test
    public void testIsEmpty() {
        assertFalse(bst.isEmpty());
    }

    @Test
    public void testRemove() {
        assertEquals(Integer.valueOf(1), bst.remove(1,1));
        assertFalse(bst.contains(1));
        assertTrue(bst.isEmpty());
    }
}
