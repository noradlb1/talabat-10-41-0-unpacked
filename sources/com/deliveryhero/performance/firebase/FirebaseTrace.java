package com.deliveryhero.performance.firebase;

import com.deliveryhero.performance.core.analytics.Trace;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bH\u0016J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/deliveryhero/performance/firebase/FirebaseTrace;", "Lcom/deliveryhero/performance/core/analytics/Trace;", "trace", "Lcom/google/firebase/perf/metrics/Trace;", "(Lcom/google/firebase/perf/metrics/Trace;)V", "incrementMetric", "", "metricName", "", "incrementBy", "", "putAttribute", "attribute", "value", "putMetric", "start", "stop", "firebase_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FirebaseTrace implements Trace {
    @NotNull
    private final com.google.firebase.perf.metrics.Trace trace;

    public FirebaseTrace(@NotNull com.google.firebase.perf.metrics.Trace trace2) {
        Intrinsics.checkNotNullParameter(trace2, "trace");
        this.trace = trace2;
    }

    public void incrementMetric(@NotNull String str, long j11) {
        Intrinsics.checkNotNullParameter(str, "metricName");
        this.trace.incrementMetric(str, j11);
    }

    public void putAttribute(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "attribute");
        Intrinsics.checkNotNullParameter(str2, "value");
        this.trace.putAttribute(str, str2);
    }

    public void putMetric(@NotNull String str, long j11) {
        Intrinsics.checkNotNullParameter(str, "metricName");
        this.trace.putMetric(str, j11);
    }

    public void start() {
        this.trace.start();
    }

    public void stop() {
        this.trace.stop();
    }
}
