package junit.framework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public class TestResult {

    /* renamed from: a  reason: collision with root package name */
    public List<TestFailure> f23721a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public List<TestFailure> f23722b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public List<TestListener> f23723c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public int f23724d = 0;
    private boolean fStop = false;

    private synchronized List<TestListener> cloneListeners() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        arrayList.addAll(this.f23723c);
        return arrayList;
    }

    public void a(final TestCase testCase) {
        startTest(testCase);
        runProtected(testCase, new Protectable() {
            public void protect() throws Throwable {
                testCase.runBare();
            }
        });
        endTest(testCase);
    }

    public synchronized void addError(Test test, Throwable th2) {
        this.f23722b.add(new TestFailure(test, th2));
        for (TestListener addError : cloneListeners()) {
            addError.addError(test, th2);
        }
    }

    public synchronized void addFailure(Test test, AssertionFailedError assertionFailedError) {
        this.f23721a.add(new TestFailure(test, assertionFailedError));
        for (TestListener addFailure : cloneListeners()) {
            addFailure.addFailure(test, assertionFailedError);
        }
    }

    public synchronized void addListener(TestListener testListener) {
        this.f23723c.add(testListener);
    }

    public void endTest(Test test) {
        for (TestListener endTest : cloneListeners()) {
            endTest.endTest(test);
        }
    }

    public synchronized int errorCount() {
        return this.f23722b.size();
    }

    public synchronized Enumeration<TestFailure> errors() {
        return Collections.enumeration(this.f23722b);
    }

    public synchronized int failureCount() {
        return this.f23721a.size();
    }

    public synchronized Enumeration<TestFailure> failures() {
        return Collections.enumeration(this.f23721a);
    }

    public synchronized void removeListener(TestListener testListener) {
        this.f23723c.remove(testListener);
    }

    public synchronized int runCount() {
        return this.f23724d;
    }

    public void runProtected(Test test, Protectable protectable) {
        try {
            protectable.protect();
        } catch (AssertionFailedError e11) {
            addFailure(test, e11);
        } catch (ThreadDeath e12) {
            throw e12;
        } catch (Throwable th2) {
            addError(test, th2);
        }
    }

    public synchronized boolean shouldStop() {
        return this.fStop;
    }

    public void startTest(Test test) {
        int countTestCases = test.countTestCases();
        synchronized (this) {
            this.f23724d += countTestCases;
        }
        for (TestListener startTest : cloneListeners()) {
            startTest.startTest(test);
        }
    }

    public synchronized void stop() {
        this.fStop = true;
    }

    public synchronized boolean wasSuccessful() {
        boolean z11;
        if (failureCount() == 0 && errorCount() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        return z11;
    }
}
