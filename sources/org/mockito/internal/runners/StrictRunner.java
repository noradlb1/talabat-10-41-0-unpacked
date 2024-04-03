package org.mockito.internal.runners;

import org.junit.runner.Description;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.manipulation.NoTestsRemainException;
import org.junit.runner.notification.RunNotifier;
import org.mockito.Mockito;
import org.mockito.internal.junit.UnnecessaryStubbingsReporter;
import org.mockito.internal.runners.util.FailureDetector;

public class StrictRunner implements InternalRunner {
    private boolean filterRequested;
    private final InternalRunner runner;
    private final Class<?> testClass;

    public StrictRunner(InternalRunner internalRunner, Class<?> cls) {
        this.runner = internalRunner;
        this.testClass = cls;
    }

    public void filter(Filter filter) throws NoTestsRemainException {
        this.filterRequested = true;
        this.runner.filter(filter);
    }

    public Description getDescription() {
        return this.runner.getDescription();
    }

    /* JADX INFO: finally extract failed */
    public void run(RunNotifier runNotifier) {
        UnnecessaryStubbingsReporter unnecessaryStubbingsReporter = new UnnecessaryStubbingsReporter();
        FailureDetector failureDetector = new FailureDetector();
        Mockito.framework().addListener(unnecessaryStubbingsReporter);
        try {
            runNotifier.addListener(failureDetector);
            this.runner.run(runNotifier);
            Mockito.framework().removeListener(unnecessaryStubbingsReporter);
            if (!this.filterRequested && failureDetector.isSuccessful()) {
                unnecessaryStubbingsReporter.validateUnusedStubs(this.testClass, runNotifier);
            }
        } catch (Throwable th2) {
            Mockito.framework().removeListener(unnecessaryStubbingsReporter);
            throw th2;
        }
    }
}
