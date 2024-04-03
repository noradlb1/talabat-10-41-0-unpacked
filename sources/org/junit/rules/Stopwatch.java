package org.junit.rules;

import java.util.concurrent.TimeUnit;
import org.junit.AssumptionViolatedException;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public abstract class Stopwatch implements TestRule {
    private final Clock clock;
    private volatile long endNanos;
    private volatile long startNanos;

    public static class Clock {
        public long nanoTime() {
            return System.nanoTime();
        }
    }

    public class InternalWatcher extends TestWatcher {
        private InternalWatcher() {
        }

        public void f(Throwable th2, Description description) {
            Stopwatch.this.stopping();
            Stopwatch stopwatch = Stopwatch.this;
            stopwatch.d(stopwatch.getNanos(), th2, description);
        }

        public void g(Description description) {
            Stopwatch stopwatch = Stopwatch.this;
            stopwatch.e(stopwatch.getNanos(), description);
        }

        public void h(AssumptionViolatedException assumptionViolatedException, Description description) {
            Stopwatch.this.stopping();
            Stopwatch stopwatch = Stopwatch.this;
            stopwatch.f(stopwatch.getNanos(), assumptionViolatedException, description);
        }

        public void j(Description description) {
            Stopwatch.this.starting();
        }

        public void k(Description description) {
            Stopwatch.this.stopping();
            Stopwatch stopwatch = Stopwatch.this;
            stopwatch.g(stopwatch.getNanos(), description);
        }
    }

    public Stopwatch() {
        this(new Clock());
    }

    /* access modifiers changed from: private */
    public long getNanos() {
        if (this.startNanos != 0) {
            long j11 = this.endNanos;
            if (j11 == 0) {
                j11 = this.clock.nanoTime();
            }
            return j11 - this.startNanos;
        }
        throw new IllegalStateException("Test has not started");
    }

    /* access modifiers changed from: private */
    public void starting() {
        this.startNanos = this.clock.nanoTime();
        this.endNanos = 0;
    }

    /* access modifiers changed from: private */
    public void stopping() {
        this.endNanos = this.clock.nanoTime();
    }

    public final Statement apply(Statement statement, Description description) {
        return new InternalWatcher().apply(statement, description);
    }

    public void d(long j11, Throwable th2, Description description) {
    }

    public void e(long j11, Description description) {
    }

    public void f(long j11, AssumptionViolatedException assumptionViolatedException, Description description) {
    }

    public void g(long j11, Description description) {
    }

    public long runtime(TimeUnit timeUnit) {
        return timeUnit.convert(getNanos(), TimeUnit.NANOSECONDS);
    }

    public Stopwatch(Clock clock2) {
        this.clock = clock2;
    }
}
