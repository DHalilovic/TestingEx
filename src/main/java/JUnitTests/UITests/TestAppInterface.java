package JUnitTests.UITests;

import BinarySearchTree.BinarySearchTree;
import Database.*;

import UI.AppInterface;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import javax.swing.*;

import java.awt.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

//import static org.junit.Assert.*;
//import static org.mockito.Mockito.*;

public class TestAppInterface  {

    @Mock protected Database databaseMock = Mockito.mock(Database.class);
    @Rule public MockitoRule mockitoRule = MockitoJUnit.rule();

    protected AppInterface ui;

    @Before
    public void setUp(){
        ui = new AppInterface(databaseMock);
    }

    @Test
    public void testNotAdded() throws Exception {
        ui.run();

        JButton addBtn = ui.getAddBtn();
        addBtn.doClick();

        verify(databaseMock, never()).add(any(Record.class));
    }

    @Test
    public void testAdded() throws Exception {
        ui.run();

        ui.getAddNameTextField().setText("Name");
        ui.getAddGoodCheckBox().doClick();
        ui.getAddLengthTextField().setValue(5);

        ui.getAddBtn().doClick();

        ArgumentCaptor<Record> arg = ArgumentCaptor.forClass(Record.class);
        verify(databaseMock).add(arg.capture());

        Record r = arg.getValue();
        assertEquals("Name", r.getName());
        assertEquals(true, r.isGood());
        assertEquals(5, (int) r.getLength());
    }

    @Test
    public void testFindName() {
        ui.run();

        ui.getFindNameTextField().setText("Name");

        ui.getFindNameBtn().doClick();

        ArgumentCaptor<Record> arg = ArgumentCaptor.forClass(Record.class);
        verify(databaseMock).filter(arg.capture());

        Record r = arg.getValue();
        assertEquals("Name", r.getName());
        assertNull(r.getLength());
    }

    @Test
    public void testFindNameEmpty() {
        ui.run();
        ui.getFindNameBtn().doClick();

        verify(databaseMock, never()).filter(any(Record.class));
    }

    @Test
    public void testFindLength() {
        ui.run();

        ui.getFindLengthTextField().setValue(5);

        ui.getFindLengthBtn().doClick();

        ArgumentCaptor<Record> arg = ArgumentCaptor.forClass(Record.class);
        verify(databaseMock).filter(arg.capture());

        Record r = arg.getValue();
        assertNull(r.getName());
        assertEquals(5, (int) r.getLength());
    }

    @Test
    public void testFindLengthEmpty() {
        ui.run();
        ui.getFindLengthBtn().doClick();

        verify(databaseMock, never()).filter(any(Record.class));
    }
}