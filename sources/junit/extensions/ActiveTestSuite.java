package junit.extensions;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestResult;
import junit.framework.TestSuite;

public class ActiveTestSuite extends TestSuite {
    private volatile int fActiveTestDeathCount;

    public ActiveTestSuite() {
    }

    public synchronized void a() {
        while (this.fActiveTestDeathCount < testCount()) {
            try {
                wait();
            } catch (InterruptedException unused) {
                return;
            }
        }
    }

    public void run(TestResult testResult) {
        this.fActiveTestDeathCount = 0;
        super.run(testResult);
        a();
    }

    public synchronized void runFinished() {
        this.fActiveTestDeathCount++;
        notifyAll();
    }

    public void runTest(final Test test, final TestResult testResult) {
        new Thread() {
            public void run() {
                try {
                    test.run(testResult);
                } finally {
                    ActiveTestSuite.this.runFinished();
                }
            }
        }.start();
    }

    public ActiveTestSuite(Class<? extends TestCase> cls) {
        super((Class<?>) cls);
    }

    public ActiveTestSuite(String str) {
        super(str);
    }

    public ActiveTestSuite(Class<? extends TestCase> cls, String str) {
        super(cls, str);
    }
}
