package JUnitTests.BinarySearchTreeTests;

import BinarySearchTree.BinarySearchTree;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestBinarySearchTree {


    @Test
    public void iterator() throws Exception {
    }

    /* Protected, not used by other classes
    @Test
    public void search() throws Exception {
    }
    */

    /* Protected, not used by other classes
    @Test
    public void removeTop() throws Exception {
    }

    */

    BinarySearchTree bst = new BinarySearchTree();
    boolean b = bst.add(1, 1);

    @Test
    public void testIfAdded() {
        assertTrue(b);
        assertTrue(bst.contains(1));
        assertFalse(bst.isEmpty());
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
        assertEquals(0, bst.size());
    }

    @Test
    public void testClear() throws Exception {
        bst.clear();
        assertEquals(0, bst.size());
    }
}
