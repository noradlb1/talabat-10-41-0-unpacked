package junit.extensions;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestResult;

public class TestDecorator extends Assert implements Test {

    /* renamed from: a  reason: collision with root package name */
    public Test f23713a;

    public TestDecorator(Test test) {
        this.f23713a = test;
    }

    public void basicRun(TestResult testResult) {
        this.f23713a.run(testResult);
    }

    public int countTestCases() {
        return this.f23713a.countTestCases();
    }

    public Test getTest() {
        return this.f23713a;
    }

    public void run(TestResult testResult) {
        basicRun(testResult);
    }

    public String toString() {
        return this.f23713a.toString();
    }
}
