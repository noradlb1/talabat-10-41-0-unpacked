package org.junit.platform.engine;

import j$.util.Optional;
import org.apiguardian.api.API;
import org.junit.platform.commons.util.ToStringBuilder;

@API(since = "1.6", status = API.Status.EXPERIMENTAL)
public class SelectorResolutionResult {
    private static final SelectorResolutionResult RESOLVED_RESULT = new SelectorResolutionResult(Status.RESOLVED, (Throwable) null);
    private static final SelectorResolutionResult UNRESOLVED_RESULT = new SelectorResolutionResult(Status.UNRESOLVED, (Throwable) null);
    private final Status status;
    private final Throwable throwable;

    public enum Status {
        RESOLVED,
        UNRESOLVED,
        FAILED
    }

    private SelectorResolutionResult(Status status2, Throwable th2) {
        this.status = status2;
        this.throwable = th2;
    }

    public static SelectorResolutionResult failed(Throwable th2) {
        return new SelectorResolutionResult(Status.FAILED, th2);
    }

    public static SelectorResolutionResult resolved() {
        return RESOLVED_RESULT;
    }

    public static SelectorResolutionResult unresolved() {
        return UNRESOLVED_RESULT;
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
