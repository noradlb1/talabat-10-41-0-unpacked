package com.deliveryhero.performance.core.analytics;

import androidx.tracing.Trace;
import com.adjust.sdk.Constants;
import com.deliveryhero.performance.core.analytics.PerformanceTrackingManager;
import com.facebook.internal.NativeProtocol;
import com.pichillilorenzo.flutter_inappwebview.credential_database.URLProtectionSpaceContract;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\u0012\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\r08\u0012\u0006\u0010(\u001a\u00020'\u0012\u0006\u0010+\u001a\u00020*¢\u0006\u0004\b9\u0010:J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0002H\u0016J \u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J \u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002H\u0016J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\u001d\u001a\u00020\u0004H\u0016J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\b\u0010!\u001a\u00020\u0004H\u0016J\u0018\u0010#\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u0002H\u0016J6\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0014\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020%\u0018\u00010$H\u0016R\u0014\u0010(\u001a\u00020'8\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010+\u001a\u00020*8\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020\r0-8\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u001a\u00101\u001a\b\u0012\u0004\u0012\u00020\u0002008\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R \u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u000204038\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u00107¨\u0006;"}, d2 = {"Lcom/deliveryhero/performance/core/analytics/PerformanceTrackingManagerImpl;", "Lcom/deliveryhero/performance/core/analytics/PerformanceTrackingManager;", "", "name", "", "reportTraceMetricStart", "reportTraceMetricStop", "traceName", "metricName", "getMetricKey", "metricKey", "parseMetricName", "parseTraceName", "Lcom/deliveryhero/performance/core/analytics/PerformanceTracker;", "performanceTracker", "addTracker", "startTrace", "stopTrace", "startMetric", "stopMetric", "counter", "addTraceCounter", "", "metricValue", "putTraceMetric", "attrName", "attrValue", "addTraceAttribute", "cancelTrace", "resetTraces", "Lcom/deliveryhero/performance/core/analytics/TraceListener;", "traceListener", "registerTraceListener", "unregisterTraceListener", "host", "addHostScreen", "", "", "metadata", "Lcom/deliveryhero/performance/core/analytics/PerformanceTrackingAttributesProvider;", "attributesProvider", "Lcom/deliveryhero/performance/core/analytics/PerformanceTrackingAttributesProvider;", "Lcom/deliveryhero/performance/core/analytics/PerformanceTrackingManager$Params;", "params", "Lcom/deliveryhero/performance/core/analytics/PerformanceTrackingManager$Params;", "", "trackers", "Ljava/util/List;", "", "traces", "Ljava/util/Set;", "j$/util/concurrent/ConcurrentHashMap", "Lcom/deliveryhero/performance/core/analytics/Metric;", "metrics", "Lj$/util/concurrent/ConcurrentHashMap;", "Lcom/deliveryhero/performance/core/analytics/TraceListener;", "", "<init>", "(Ljava/util/List;Lcom/deliveryhero/performance/core/analytics/PerformanceTrackingAttributesProvider;Lcom/deliveryhero/performance/core/analytics/PerformanceTrackingManager$Params;)V", "core_release"}, k = 1, mv = {1, 6, 0})
public final class PerformanceTrackingManagerImpl implements PerformanceTrackingManager {
    @NotNull
    private final PerformanceTrackingAttributesProvider attributesProvider;
    @NotNull
    private final ConcurrentHashMap<String, Metric> metrics = new ConcurrentHashMap<>();
    @NotNull
    private final PerformanceTrackingManager.Params params;
    @Nullable
    private TraceListener traceListener;
    @NotNull
    private final Set<String> traces;
    @NotNull
    private final List<PerformanceTracker> trackers;

    public PerformanceTrackingManagerImpl(@NotNull List<? extends PerformanceTracker> list, @NotNull PerformanceTrackingAttributesProvider performanceTrackingAttributesProvider, @NotNull PerformanceTrackingManager.Params params2) {
        Intrinsics.checkNotNullParameter(list, Constants.ADJUST_PREINSTALL_CONTENT_URI_PATH);
        Intrinsics.checkNotNullParameter(performanceTrackingAttributesProvider, "attributesProvider");
        Intrinsics.checkNotNullParameter(params2, NativeProtocol.WEB_DIALOG_PARAMS);
        this.attributesProvider = performanceTrackingAttributesProvider;
        this.params = params2;
        this.trackers = CollectionsKt___CollectionsKt.toMutableList(list);
        Set<String> synchronizedSet = Collections.synchronizedSet(new HashSet());
        Intrinsics.checkNotNullExpressionValue(synchronizedSet, "synchronizedSet(HashSet())");
        this.traces = synchronizedSet;
    }

    private final String getMetricKey(String str, String str2) {
        return str + '#' + str2;
    }

    private final String parseMetricName(String str) {
        return (String) StringsKt__StringsKt.split$default((CharSequence) str, new String[]{"#"}, false, 0, 6, (Object) null).get(1);
    }

    private final String parseTraceName(String str) {
        return (String) StringsKt__StringsKt.split$default((CharSequence) str, new String[]{"#"}, false, 0, 6, (Object) null).get(0);
    }

    private final void reportTraceMetricStart(String str) {
        if (this.params.getEnableTraceMessaging()) {
            Trace.beginAsyncSection(str, 0);
        }
    }

    private final void reportTraceMetricStop(String str) {
        if (this.params.getEnableTraceMessaging()) {
            Trace.endAsyncSection(str, 0);
        }
    }

    public void addHostScreen(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "traceName");
        Intrinsics.checkNotNullParameter(str2, URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_HOST);
        for (PerformanceTracker addHostScreen : this.trackers) {
            addHostScreen.addHostScreen(str, str2);
        }
    }

    public void addTraceAttribute(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "traceName");
        Intrinsics.checkNotNullParameter(str2, "attrName");
        Intrinsics.checkNotNullParameter(str3, "attrValue");
        for (PerformanceTracker addTraceAttribute : this.trackers) {
            addTraceAttribute.addTraceAttribute(str, str2, str3);
        }
    }

    public void addTraceCounter(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "traceName");
        Intrinsics.checkNotNullParameter(str2, "counter");
        for (PerformanceTracker addTraceCounter : this.trackers) {
            addTraceCounter.addTraceCounter(str, str2);
        }
    }

    public void addTracker(@NotNull PerformanceTracker performanceTracker) {
        Intrinsics.checkNotNullParameter(performanceTracker, "performanceTracker");
        this.trackers.add(performanceTracker);
    }

    public void cancelTrace(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "traceName");
        this.traces.remove(str);
        for (PerformanceTracker cancelTrace : this.trackers) {
            cancelTrace.cancelTrace(str);
        }
    }

    public void putTraceMetric(@NotNull String str, @NotNull String str2, long j11) {
        Intrinsics.checkNotNullParameter(str, "traceName");
        Intrinsics.checkNotNullParameter(str2, "metricName");
        for (PerformanceTracker putTraceMetric : this.trackers) {
            putTraceMetric.putTraceMetric(str, str2, j11);
        }
    }

    public void registerTraceListener(@NotNull TraceListener traceListener2) {
        Intrinsics.checkNotNullParameter(traceListener2, "traceListener");
        this.traceListener = traceListener2;
    }

    public void resetTraces() {
        this.traces.clear();
        for (PerformanceTracker resetTraces : this.trackers) {
            resetTraces.resetTraces();
        }
    }

    public void startMetric(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "traceName");
        Intrinsics.checkNotNullParameter(str2, "metricName");
        String metricKey = getMetricKey(str, str2);
        ConcurrentHashMap<String, Metric> concurrentHashMap = this.metrics;
        Metric metric = new Metric();
        metric.start();
        concurrentHashMap.put(metricKey, metric);
        reportTraceMetricStart(metricKey);
    }

    public void startTrace(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "traceName");
        if (this.traces.contains(str)) {
            cancelTrace(str);
        }
        for (PerformanceTracker startTrace : this.trackers) {
            startTrace.startTrace(str);
        }
        TraceListener traceListener2 = this.traceListener;
        if (traceListener2 != null) {
            traceListener2.traceStarted(str);
        }
        this.traces.add(str);
        reportTraceMetricStart(str);
    }

    public void stopMetric(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "traceName");
        Intrinsics.checkNotNullParameter(str2, "metricName");
        String metricKey = getMetricKey(str, str2);
        Metric metric = this.metrics.get(metricKey);
        if (metric != null) {
            metric.stop();
        }
        reportTraceMetricStop(metricKey);
    }

    public void stopTrace(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "traceName");
        if (this.traces.contains(str)) {
            Map<String, String> attributes = this.attributesProvider.getAttributes();
            for (PerformanceTracker putAllTraceAttributes : this.trackers) {
                putAllTraceAttributes.putAllTraceAttributes(str, attributes);
            }
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            ConcurrentHashMap<String, Metric> concurrentHashMap = this.metrics;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry next : concurrentHashMap.entrySet()) {
                if (Intrinsics.areEqual((Object) parseTraceName((String) next.getKey()), (Object) str)) {
                    linkedHashMap.put(next.getKey(), next.getValue());
                }
            }
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                String str2 = (String) entry.getKey();
                linkedHashSet.add(str2);
                Long duration = ((Metric) entry.getValue()).duration();
                if (duration != null) {
                    putTraceMetric(str, parseMetricName(str2), duration.longValue());
                }
            }
            this.metrics.keySet().removeAll(linkedHashSet);
            for (PerformanceTracker stopTrace : this.trackers) {
                stopTrace.stopTrace(str);
            }
            TraceListener traceListener2 = this.traceListener;
            if (traceListener2 != null) {
                traceListener2.traceStopped(str);
            }
            this.traces.remove(str);
            reportTraceMetricStop(str);
        }
    }

    public void unregisterTraceListener() {
        this.traceListener = null;
    }

    public void putTraceMetric(@NotNull String str, @NotNull String str2, long j11, @Nullable Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, "traceName");
        Intrinsics.checkNotNullParameter(str2, "metricName");
        for (PerformanceTracker putTraceMetric : this.trackers) {
            putTraceMetric.putTraceMetric(str, str2, j11, map);
        }
    }
}
