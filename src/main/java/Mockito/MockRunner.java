package Mockito;

import Database.AppDatabase;
import Database.Record;
import Database.Database;

import static org.mockito.Mockito.*;

public class MockRunner {

    public static void main(String[] args) {
        Database mockedDB = mock(AppDatabase.class);

        Record r1 = new Record("Tyler1", true, 76);
        Record r2 = new Record("Tyler2", false, 11);
        Record r3 = new Record("Dave", true, 23);
        Record r4 = new Record("Kevin", false, 51);
        Record r5 = new Record("Kyle", false, 1);
        mockedDB.add(r1);
        mockedDB.add(r2);
        mockedDB.add(r3);
        mockedDB.add(r4);
        mockedDB.add(r5);
        mockedDB.remove(r4);
        when(mockedDB.get(r1)).thenReturn(r1);
        when(mockedDB.get(1)).thenReturn(r5);
        mockedDB.filter(r2);

        verify(mockedDB).add(r1);
        verify(mockedDB).add(r2);
        verify(mockedDB).add(r3);
        verify(mockedDB).add(r4);
        verify(mockedDB).add(r5);
        verify(mockedDB).remove(r4);
        mockedDB.get(r1);
        verify(mockedDB).get(r1);
        mockedDB.get(1);
        verify(mockedDB).get(1);
        verify(mockedDB).filter(r2);
        System.out.println(verify(mockedDB).add(r4));


    }
}
