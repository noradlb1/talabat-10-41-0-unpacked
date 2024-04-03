package junit.framework;

import java.io.PrintWriter;
import java.io.StringWriter;

public class TestFailure {

    /* renamed from: a  reason: collision with root package name */
    public Test f23719a;

    /* renamed from: b  reason: collision with root package name */
    public Throwable f23720b;

    public TestFailure(Test test, Throwable th2) {
        this.f23719a = test;
        this.f23720b = th2;
    }

    public String exceptionMessage() {
        return thrownException().getMessage();
    }

    public Test failedTest() {
        return this.f23719a;
    }

    public boolean isFailure() {
        return thrownException() instanceof AssertionFailedError;
    }

    public Throwable thrownException() {
        return this.f23720b;
    }

    public String toString() {
        return this.f23719a + ": " + this.f23720b.getMessage();
    }

    public String trace() {
        StringWriter stringWriter = new StringWriter();
        thrownException().printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }
}
