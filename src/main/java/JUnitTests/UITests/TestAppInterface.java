package JUnitTests.UITests;

import Database.*;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.assertTrue;

//import static org.junit.Assert.*;
//import static org.mockito.Mockito.*;

public class TestAppInterface extends TestInterface {

    public class MockitoTest  {

        @Mock
        Database databaseMock;

        @Rule
        public MockitoRule mockitoRule = MockitoJUnit.rule();

        @Test
        public void testQuery()  {
            ClassToTest t  = new ClassToTest(databaseMock);
            boolean check = t.query("* from t");
            assertTrue(check);
            verify(databaseMock).query("* from t");
        }
    }

}