package com.deliveryhero.performance.firebase;

import com.deliveryhero.performance.core.analytics.PerformanceTracker;
import com.deliveryhero.performance.core.analytics.Trace;
import com.google.firebase.perf.FirebasePerformance;
import com.instabug.library.internal.storage.cache.UserAttributesCacheManager;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J \u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J \u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J$\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0010H\u0016J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R \u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00190\u00188\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/deliveryhero/performance/firebase/FirebasePerformanceTracker;", "Lcom/deliveryhero/performance/core/analytics/PerformanceTracker;", "", "traceName", "", "startTrace", "stopTrace", "counter", "addTraceCounter", "metricName", "", "metricValue", "putTraceMetric", "attrName", "attrValue", "addTraceAttribute", "", "attrs", "putAllTraceAttributes", "cancelTrace", "resetTraces", "Lcom/google/firebase/perf/FirebasePerformance;", "firebasePerformance", "Lcom/google/firebase/perf/FirebasePerformance;", "j$/util/concurrent/ConcurrentHashMap", "Lcom/deliveryhero/performance/core/analytics/Trace;", "traces", "Lj$/util/concurrent/ConcurrentHashMap;", "<init>", "(Lcom/google/firebase/perf/FirebasePerformance;)V", "firebase_release"}, k = 1, mv = {1, 6, 0})
public final class FirebasePerformanceTracker implements PerformanceTracker {
    @NotNull
    private final FirebasePerformance firebasePerformance;
    @NotNull
    private final ConcurrentHashMap<String, Trace> traces = new ConcurrentHashMap<>();

    public FirebasePerformanceTracker(@NotNull FirebasePerformance firebasePerformance2) {
        Intrinsics.checkNotNullParameter(firebasePerformance2, "firebasePerformance");
        this.firebasePerformance = firebasePerformance2;
    }

    public void addHostScreen(@NotNull String str, @NotNull String str2) {
        PerformanceTracker.DefaultImpls.addHostScreen(this, str, str2);
    }

    public void addTraceAttribute(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "traceName");
        Intrinsics.checkNotNullParameter(str2, "attrName");
        Intrinsics.checkNotNullParameter(str3, "attrValue");
        Trace trace = this.traces.get(str);
        if (trace != null) {
            trace.putAttribute(str2, str3);
        }
    }

    public void addTraceCounter(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "traceName");
        Intrinsics.checkNotNullParameter(str2, "counter");
        Trace trace = this.traces.get(str);
        if (trace != null) {
            trace.incrementMetric(str2, 1);
        }
    }

    public void cancelTrace(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "traceName");
        this.traces.remove(str);
    }

    public void putAllTraceAttributes(@NotNull String str, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "traceName");
        Intrinsics.checkNotNullParameter(map, UserAttributesCacheManager.USER_ATTRIBUTES_CACHE_KEY);
        for (Map.Entry next : map.entrySet()) {
            addTraceAttribute(str, (String) next.getKey(), (String) next.getValue());
        }
    }

    public void putTraceMetric(@NotNull String str, @NotNull String str2, long j11, @Nullable Map<String, ? extends Object> map) {
        PerformanceTracker.DefaultImpls.putTraceMetric(this, str, str2, j11, map);
    }

    public void resetTraces() {
        this.traces.clear();
    }

    public void startTrace(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "traceName");
        com.google.firebase.perf.metrics.Trace newTrace = this.firebasePerformance.newTrace(str);
        Intrinsics.checkNotNullExpressionValue(newTrace, "firebasePerformance.newTrace(traceName)");
        FirebaseTrace firebaseTrace = new FirebaseTrace(newTrace);
        firebaseTrace.start();
        this.traces.put(str, firebaseTrace);
    }

    public void stopTrace(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "traceName");
        Trace trace = this.traces.get(str);
        if (trace != null) {
            trace.stop();
        }
        this.traces.remove(str);
    }

    public void putTraceMetric(@NotNull String str, @NotNull String str2, long j11) {
        Intrinsics.checkNotNullParameter(str, "traceName");
        Intrinsics.checkNotNullParameter(str2, "metricName");
        Trace trace = this.traces.get(str);
        if (trace != null) {
            trace.putMetric(str2, j11);
        }
    }
}
