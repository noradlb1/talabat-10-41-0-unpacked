package org.junit.rules;

import java.util.concurrent.TimeUnit;
import org.junit.internal.runners.statements.FailOnTimeout;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class Timeout implements TestRule {
    private final boolean lookForStuckThread;
    private final TimeUnit timeUnit;
    private final long timeout;

    public static class Builder {
        private boolean lookForStuckThread = false;
        private TimeUnit timeUnit = TimeUnit.SECONDS;
        private long timeout = 0;

        public boolean a() {
            return this.lookForStuckThread;
        }

        public TimeUnit b() {
            return this.timeUnit;
        }

        public Timeout build() {
            return new Timeout(this);
        }

        public long c() {
            return this.timeout;
        }

        public Builder withLookingForStuckThread(boolean z11) {
            this.lookForStuckThread = z11;
            return this;
        }

        public Builder withTimeout(long j11, TimeUnit timeUnit2) {
            this.timeout = j11;
            this.timeUnit = timeUnit2;
            return this;
        }
    }

    @Deprecated
    public Timeout(int i11) {
        this((long) i11, TimeUnit.MILLISECONDS);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Timeout millis(long j11) {
        return new Timeout(j11, TimeUnit.MILLISECONDS);
    }

    public static Timeout seconds(long j11) {
        return new Timeout(j11, TimeUnit.SECONDS);
    }

    public Statement a(Statement statement) throws Exception {
        return FailOnTimeout.builder().withTimeout(this.timeout, this.timeUnit).withLookingForStuckThread(this.lookForStuckThread).build(statement);
    }

    public Statement apply(Statement statement, Description description) {
        try {
            return a(statement);
        } catch (Exception e11) {
            return new Statement() {
                public void evaluate() throws Throwable {
                    throw new RuntimeException("Invalid parameters for Timeout", e11);
                }
            };
        }
    }

    public Timeout(long j11, TimeUnit timeUnit2) {
        this.timeout = j11;
        this.timeUnit = timeUnit2;
        this.lookForStuckThread = false;
    }

    public Timeout(Builder builder) {
        this.timeout = builder.c();
        this.timeUnit = builder.b();
        this.lookForStuckThread = builder.a();
    }
}
