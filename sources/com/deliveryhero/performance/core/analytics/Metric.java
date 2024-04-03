package com.deliveryhero.performance.core.analytics;

import android.os.SystemClock;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\r\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\bJ\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u0006\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u000bJ\b\u0010\r\u001a\u00020\u000eH\u0016R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0004\n\u0002\u0010\u0005R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006\u000f"}, d2 = {"Lcom/deliveryhero/performance/core/analytics/Metric;", "", "()V", "end", "", "Ljava/lang/Long;", "start", "duration", "()Ljava/lang/Long;", "isRunning", "", "", "stop", "toString", "", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Metric {
    @Nullable
    private Long end;
    @Nullable
    private Long start;

    @Nullable
    public final Long duration() {
        Long l11 = this.start;
        if (l11 == null) {
            return null;
        }
        long longValue = l11.longValue();
        Long l12 = this.end;
        if (l12 == null) {
            return null;
        }
        return Long.valueOf(l12.longValue() - longValue);
    }

    public final boolean isRunning() {
        return this.start != null && this.end == null;
    }

    public final void start() {
        this.start = Long.valueOf(SystemClock.uptimeMillis());
    }

    public final void stop() {
        this.end = Long.valueOf(SystemClock.uptimeMillis());
    }

    @NotNull
    public String toString() {
        return Metric.class.getSimpleName() + "(start=" + this.start + ", end=" + this.end + ')';
    }
}
