package xdwang.aequilibrium;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(SuiteTest.class);
		for (Failure fail: result.getFailures()){
			System.out.println(fail.toString());
		}
		if (result.wasSuccessful()){
			System.out.println("All tests are successfull.");
		}
	}
}
