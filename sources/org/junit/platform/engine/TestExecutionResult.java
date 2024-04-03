package org.junit.platform.engine;

import j$.util.Optional;
import org.apiguardian.api.API;
import org.junit.platform.commons.util.Preconditions;
import org.junit.platform.commons.util.ToStringBuilder;

@API(since = "1.0", status = API.Status.STABLE)
public class TestExecutionResult {
    private static final TestExecutionResult SUCCESSFUL_RESULT = new TestExecutionResult(Status.SUCCESSFUL, (Throwable) null);
    private final Status status;
    private final Throwable throwable;

    public enum Status {
        SUCCESSFUL,
        ABORTED,
        FAILED
    }

    private TestExecutionResult(Status status2, Throwable th2) {
        this.status = (Status) Preconditions.notNull(status2, "Status must not be null");
        this.throwable = th2;
    }

    public static TestExecutionResult aborted(Throwable th2) {
        return new TestExecutionResult(Status.ABORTED, th2);
    }

    public static TestExecutionResult failed(Throwable th2) {
        return new TestExecutionResult(Status.FAILED, th2);
    }

    public static TestExecutionResult successful() {
        return SUCCESSFUL_RESULT;
    }

    public Status getStatus() {
        return this.status;
    }

    public Optional<Throwable> getThrowable() {
        return Optional.ofNullable(this.throwable);
    }

    public String toString() {
        return new ToStringBuilder((Object) this).append("status", this.status).append("throwable", this.throwable).toString();
    }
}
