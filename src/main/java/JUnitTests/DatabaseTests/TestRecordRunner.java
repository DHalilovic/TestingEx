package JUnitTests.DatabaseTests;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRecordRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestRecord.class);

        for (Failure failure : result.getFailures()) {
            System.out.println("Failure: " + failure.toString());
        }

        if(result.wasSuccessful()) {
            System.out.println("Test was a success");
        }
    }
}
