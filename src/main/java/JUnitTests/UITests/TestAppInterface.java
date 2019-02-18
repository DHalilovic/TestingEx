package JUnitTests.UITests;

import BinarySearchTree.BinarySearchTree;
import Database.*;

import UI.AppInterface;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import javax.swing.*;

import java.awt.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import static org.mockito.Mockito.*;

//import static org.junit.Assert.*;
//import static org.mockito.Mockito.*;

public class TestAppInterface  {

    @Mock protected Database databaseMock;
    @Rule public MockitoRule mockitoRule = MockitoJUnit.rule();

    protected AppInterface ui = new AppInterface(databaseMock);

    @Test
    public void testAdd() throws Exception {
        ui.run();

        Record r = new Record("", false, 0);
        when(databaseMock.add(any(Record.class))).thenReturn(r);

        JButton addBtn = ui.getAddBtn();
        addBtn.doClick();
        verify(databaseMock).add(any(Record.class));

        assertEquals(r, new Record("", false, 0));
    }

    public class MockitoTest  {

        @Mock
        Database databaseMock;

        @Rule
        public MockitoRule mockitoRule = MockitoJUnit.rule();

        @Test
        public void testQuery()  {
//            ClassToTest t  = new ClassToTest(databaseMock);
//            boolean check = t.query("* from t");
//            assertTrue(check);
//            verify(databaseMock).query("* from t");
        }
    }

}