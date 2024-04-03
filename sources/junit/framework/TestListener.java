package junit.framework;

public interface TestListener {
    void addError(Test test, Throwable th2);

    void addFailure(Test test, AssertionFailedError assertionFailedError);

    void endTest(Test test);

    void startTest(Test test);
}
