package org.junit.internal.runners.model;

import org.junit.internal.AssumptionViolatedException;
import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.MultipleFailureException;

public class EachTestNotifier {
    private final Description description;
    private final RunNotifier notifier;

    public EachTestNotifier(RunNotifier runNotifier, Description description2) {
        this.notifier = runNotifier;
        this.description = description2;
    }

    private void addMultipleFailureException(MultipleFailureException multipleFailureException) {
        for (Throwable addFailure : multipleFailureException.getFailures()) {
            addFailure(addFailure);
        }
    }

    public void addFailedAssumption(AssumptionViolatedException assumptionViolatedException) {
        this.notifier.fireTestAssumptionFailed(new Failure(this.description, assumptionViolatedException));
    }

    public void addFailure(Throwable th2) {
        if (th2 instanceof MultipleFailureException) {
            addMultipleFailureException((MultipleFailureException) th2);
        } else {
            this.notifier.fireTestFailure(new Failure(this.description, th2));
        }
    }

    public void fireTestFinished() {
        this.notifier.fireTestFinished(this.description);
    }

    public void fireTestIgnored() {
        this.notifier.fireTestIgnored(this.description);
    }

    public void fireTestStarted() {
        this.notifier.fireTestStarted(this.description);
    }
}
