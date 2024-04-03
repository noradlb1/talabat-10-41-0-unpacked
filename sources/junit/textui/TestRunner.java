package junit.textui;

import java.io.PrintStream;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestResult;
import junit.framework.TestSuite;
import junit.runner.BaseTestRunner;
import junit.runner.Version;

public class TestRunner extends BaseTestRunner {
    public static final int EXCEPTION_EXIT = 2;
    public static final int FAILURE_EXIT = 1;
    public static final int SUCCESS_EXIT = 0;
    private ResultPrinter fPrinter;

    public TestRunner() {
        this(System.out);
    }

    public static void main(String[] strArr) {
        try {
            if (!new TestRunner().start(strArr).wasSuccessful()) {
                System.exit(1);
            }
            System.exit(0);
        } catch (Exception e11) {
            System.err.println(e11.getMessage());
            System.exit(2);
        }
    }

    public static void run(Class<? extends TestCase> cls) {
        run((Test) new TestSuite((Class<?>) cls));
    }

    public static void runAndWait(Test test) {
        new TestRunner().doRun(test, true);
    }

    public TestResult doRun(Test test) {
        return doRun(test, false);
    }

    public void e(String str) {
        System.err.println(str);
        System.exit(1);
    }

    public TestResult h() {
        return new TestResult();
    }

    public void i(boolean z11) {
        if (z11) {
            this.fPrinter.j();
            try {
                System.in.read();
            } catch (Exception unused) {
            }
        }
    }

    public TestResult j(String str, String str2, boolean z11) throws Exception {
        return doRun(TestSuite.createTest(d(str).asSubclass(TestCase.class), str2), z11);
    }

    public void setPrinter(ResultPrinter resultPrinter) {
        this.fPrinter = resultPrinter;
    }

    public TestResult start(String[] strArr) throws Exception {
        String str = "";
        String str2 = str;
        int i11 = 0;
        boolean z11 = false;
        while (i11 < strArr.length) {
            if (strArr[i11].equals("-wait")) {
                z11 = true;
            } else if (strArr[i11].equals("-c")) {
                i11++;
                str = extractClassName(strArr[i11]);
            } else if (strArr[i11].equals("-m")) {
                i11++;
                String str3 = strArr[i11];
                int lastIndexOf = str3.lastIndexOf(46);
                String substring = str3.substring(0, lastIndexOf);
                str2 = str3.substring(lastIndexOf + 1);
                str = substring;
            } else if (strArr[i11].equals("-v")) {
                System.err.println("JUnit " + Version.id() + " by Kent Beck and Erich Gamma");
            } else {
                str = strArr[i11];
            }
            i11++;
        }
        if (!str.equals("")) {
            try {
                if (!str2.equals("")) {
                    return j(str, str2, z11);
                }
                return doRun(getTest(str), z11);
            } catch (Exception e11) {
                throw new Exception("Could not create and run test suite: " + e11);
            }
        } else {
            throw new Exception("Usage: TestRunner [-wait] testCaseName, where name is the name of the TestCase class");
        }
    }

    public void testEnded(String str) {
    }

    public void testFailed(int i11, Test test, Throwable th2) {
    }

    public void testStarted(String str) {
    }

    public TestRunner(PrintStream printStream) {
        this(new ResultPrinter(printStream));
    }

    public static TestResult run(Test test) {
        return new TestRunner().doRun(test);
    }

    public TestResult doRun(Test test, boolean z11) {
        TestResult h11 = h();
        h11.addListener(this.fPrinter);
        long currentTimeMillis = System.currentTimeMillis();
        test.run(h11);
        this.fPrinter.b(h11, System.currentTimeMillis() - currentTimeMillis);
        i(z11);
        return h11;
    }

    public TestRunner(ResultPrinter resultPrinter) {
        this.fPrinter = resultPrinter;
    }
}
