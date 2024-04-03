package org.junit.internal.runners;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.InitializationError;

public class ErrorReportingRunner extends Runner {
    private final List<Throwable> causes;
    private final Class<?> testClass;

    public ErrorReportingRunner(Class<?> cls, Throwable th2) {
        if (cls != null) {
            this.testClass = cls;
            this.causes = getCauses(th2);
            return;
        }
        throw new NullPointerException("Test class cannot be null");
    }

    private Description describeCause(Throwable th2) {
        return Description.createTestDescription(this.testClass, "initializationError");
    }

    private List<Throwable> getCauses(Throwable th2) {
        if (th2 instanceof InvocationTargetException) {
            return getCauses(th2.getCause());
        }
        if (th2 instanceof InitializationError) {
            return ((InitializationError) th2).getCauses();
        }
        if (th2 instanceof InitializationError) {
            return ((InitializationError) th2).getCauses();
        }
        return Arrays.asList(new Throwable[]{th2});
    }

    private void runCause(Throwable th2, RunNotifier runNotifier) {
        Description describeCause = describeCause(th2);
        runNotifier.fireTestStarted(describeCause);
        runNotifier.fireTestFailure(new Failure(describeCause, th2));
        runNotifier.fireTestFinished(describeCause);
    }

    public Description getDescription() {
        Description createSuiteDescription = Description.createSuiteDescription(this.testClass);
        for (Throwable describeCause : this.causes) {
            createSuiteDescription.addChild(describeCause(describeCause));
        }
        return createSuiteDescription;
    }

    public void run(RunNotifier runNotifier) {
        for (Throwable runCause : this.causes) {
            runCause(runCause, runNotifier);
        }
    }
}
