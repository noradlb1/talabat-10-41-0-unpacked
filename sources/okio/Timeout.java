package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\u0000H\u0016J\b\u0010\t\u001a\u00020\u0000H\u0016J\u0016\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J-\u0010\u000e\u001a\u0002H\u000f\"\u0004\b\u0000\u0010\u000f2\u0006\u0010\u0010\u001a\u00020\u00002\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0012H\bø\u0001\u0000¢\u0006\u0002\u0010\u0013J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u000e\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\u001a"}, d2 = {"Lokio/Timeout;", "", "()V", "deadlineNanoTime", "", "hasDeadline", "", "timeoutNanos", "clearDeadline", "clearTimeout", "deadline", "duration", "unit", "Ljava/util/concurrent/TimeUnit;", "intersectWith", "T", "other", "block", "Lkotlin/Function0;", "(Lokio/Timeout;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "throwIfReached", "", "timeout", "waitUntilNotified", "monitor", "Companion", "okio"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class Timeout {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @JvmField
    public static final Timeout NONE = new Timeout$Companion$NONE$1();
    private long deadlineNanoTime;
    private boolean hasDeadline;
    private long timeoutNanos;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lokio/Timeout$Companion;", "", "()V", "NONE", "Lokio/Timeout;", "minTimeout", "", "aNanos", "bNanos", "okio"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long minTimeout(long j11, long j12) {
            return (j11 != 0 && (j12 == 0 || j11 < j12)) ? j11 : j12;
        }
    }

    @NotNull
    public Timeout clearDeadline() {
        this.hasDeadline = false;
        return this;
    }

    @NotNull
    public Timeout clearTimeout() {
        this.timeoutNanos = 0;
        return this;
    }

    @NotNull
    public final Timeout deadline(long j11, @NotNull TimeUnit timeUnit) {
        boolean z11;
        Intrinsics.checkNotNullParameter(timeUnit, "unit");
        if (j11 > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return deadlineNanoTime(System.nanoTime() + timeUnit.toNanos(j11));
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("duration <= 0: ", Long.valueOf(j11)).toString());
    }

    public long deadlineNanoTime() {
        if (this.hasDeadline) {
            return this.deadlineNanoTime;
        }
        throw new IllegalStateException("No deadline".toString());
    }

    public boolean hasDeadline() {
        return this.hasDeadline;
    }

    public final <T> T intersectWith(@NotNull Timeout timeout, @NotNull Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(timeout, "other");
        Intrinsics.checkNotNullParameter(function0, "block");
        long timeoutNanos2 = timeoutNanos();
        long minTimeout = Companion.minTimeout(timeout.timeoutNanos(), timeoutNanos());
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        timeout(minTimeout, timeUnit);
        if (hasDeadline()) {
            long deadlineNanoTime2 = deadlineNanoTime();
            if (timeout.hasDeadline()) {
                deadlineNanoTime(Math.min(deadlineNanoTime(), timeout.deadlineNanoTime()));
            }
            try {
                T invoke = function0.invoke();
                InlineMarker.finallyStart(1);
                timeout(timeoutNanos2, timeUnit);
                if (timeout.hasDeadline()) {
                    deadlineNanoTime(deadlineNanoTime2);
                }
                InlineMarker.finallyEnd(1);
                return invoke;
            } catch (Throwable th2) {
                InlineMarker.finallyStart(1);
                timeout(timeoutNanos2, TimeUnit.NANOSECONDS);
                if (timeout.hasDeadline()) {
                    deadlineNanoTime(deadlineNanoTime2);
                }
                InlineMarker.finallyEnd(1);
                throw th2;
            }
        } else {
            if (timeout.hasDeadline()) {
                deadlineNanoTime(timeout.deadlineNanoTime());
            }
            try {
                T invoke2 = function0.invoke();
                InlineMarker.finallyStart(1);
                timeout(timeoutNanos2, timeUnit);
                if (timeout.hasDeadline()) {
                    clearDeadline();
                }
                InlineMarker.finallyEnd(1);
                return invoke2;
            } catch (Throwable th3) {
                InlineMarker.finallyStart(1);
                timeout(timeoutNanos2, TimeUnit.NANOSECONDS);
                if (timeout.hasDeadline()) {
                    clearDeadline();
                }
                InlineMarker.finallyEnd(1);
                throw th3;
            }
        }
    }

    public void throwIfReached() throws IOException {
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedIOException("interrupted");
        } else if (this.hasDeadline && this.deadlineNanoTime - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    @NotNull
    public Timeout timeout(long j11, @NotNull TimeUnit timeUnit) {
        boolean z11;
        Intrinsics.checkNotNullParameter(timeUnit, "unit");
        if (j11 >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            this.timeoutNanos = timeUnit.toNanos(j11);
            return this;
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("timeout < 0: ", Long.valueOf(j11)).toString());
    }

    public long timeoutNanos() {
        return this.timeoutNanos;
    }

    public final void waitUntilNotified(@NotNull Object obj) throws InterruptedIOException {
        Intrinsics.checkNotNullParameter(obj, "monitor");
        try {
            boolean hasDeadline2 = hasDeadline();
            long timeoutNanos2 = timeoutNanos();
            long j11 = 0;
            if (hasDeadline2 || timeoutNanos2 != 0) {
                long nanoTime = System.nanoTime();
                if (hasDeadline2 && timeoutNanos2 != 0) {
                    timeoutNanos2 = Math.min(timeoutNanos2, deadlineNanoTime() - nanoTime);
                } else if (hasDeadline2) {
                    timeoutNanos2 = deadlineNanoTime() - nanoTime;
                }
                if (timeoutNanos2 > 0) {
                    long j12 = timeoutNanos2 / 1000000;
                    Long.signum(j12);
                    obj.wait(j12, (int) (timeoutNanos2 - (1000000 * j12)));
                    j11 = System.nanoTime() - nanoTime;
                }
                if (j11 >= timeoutNanos2) {
                    throw new InterruptedIOException("timeout");
                }
                return;
            }
            obj.wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }

    @NotNull
    public Timeout deadlineNanoTime(long j11) {
        this.hasDeadline = true;
        this.deadlineNanoTime = j11;
        return this;
    }
}
