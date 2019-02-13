
/**
 *   from https://www.tutorialspoint.com/junit/junit_environment_setup.htm
 *   used to test if Junit works
 */

package JUnitTest;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestJunit {
    @Test

    public void testAdd() {
        String str = "Junit is working fine";
        assertEquals("Junit is working fine", str);
    }
}
