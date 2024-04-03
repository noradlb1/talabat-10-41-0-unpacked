package org.junit.platform.engine.support.hierarchical;

import j$.util.function.Predicate;
import org.apiguardian.api.API;
import org.junit.platform.commons.util.ExceptionUtils;
import org.junit.platform.commons.util.Preconditions;
import org.junit.platform.commons.util.UnrecoverableExceptions;
import org.junit.platform.engine.TestExecutionResult;

@API(since = "1.3", status = API.Status.MAINTAINED)
public class ThrowableCollector {
    private final Predicate<? super Throwable> abortedExecutionPredicate;
    private Throwable throwable;

    @FunctionalInterface
    public interface Executable {
        void execute() throws Throwable;
    }

    public interface Factory {
        ThrowableCollector create();
    }

    public ThrowableCollector(Predicate<? super Throwable> predicate) {
        this.abortedExecutionPredicate = (Predicate) Preconditions.notNull(predicate, "abortedExecutionPredicate must not be null");
    }

    private void add(Throwable th2) {
        Preconditions.notNull(th2, "Throwable must not be null");
        Throwable th3 = this.throwable;
        if (th3 == null) {
            this.throwable = th2;
        } else if (!hasAbortedExecution(th3) || hasAbortedExecution(th2)) {
            Throwable th4 = this.throwable;
            if (th4 != th2) {
                th4.addSuppressed(th2);
            }
        } else {
            th2.addSuppressed(this.throwable);
            this.throwable = th2;
        }
    }

    private boolean hasAbortedExecution(Throwable th2) {
        return this.abortedExecutionPredicate.test(th2);
    }

    public void assertEmpty() {
        if (!isEmpty()) {
            ExceptionUtils.throwAsUncheckedException(this.throwable);
        }
    }

    public void execute(Executable executable) {
        try {
            executable.execute();
        } catch (Throwable th2) {
            UnrecoverableExceptions.rethrowIfUnrecoverable(th2);
            add(th2);
        }
    }

    public Throwable getThrowable() {
        return this.throwable;
    }

    public boolean isEmpty() {
        return this.throwable == null;
    }

    public boolean isNotEmpty() {
        return this.throwable != null;
    }

    @API(since = "1.6", status = API.Status.MAINTAINED)
    public TestExecutionResult toTestExecutionResult() {
        if (isEmpty()) {
            return TestExecutionResult.successful();
        }
        if (hasAbortedExecution(this.throwable)) {
            return TestExecutionResult.aborted(this.throwable);
        }
        return TestExecutionResult.failed(this.throwable);
    }
}
