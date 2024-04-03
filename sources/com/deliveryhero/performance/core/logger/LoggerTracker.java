package com.deliveryhero.performance.core.logger;

import android.content.Context;
import com.deliveryhero.performance.core.analytics.PerformanceTracker;
import com.instabug.library.internal.storage.cache.UserAttributesCacheManager;
import com.pichillilorenzo.flutter_inappwebview.credential_database.URLProtectionSpaceContract;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\tH\u0016J \u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\tH\u0016J\u0018\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\tH\u0016J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0016J$\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\t2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u0019H\u0016J \u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J6\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001d2\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u0019H\u0016J\b\u0010 \u001a\u00020\u000eH\u0016J\u0010\u0010!\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0016J\u0010\u0010\"\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006#"}, d2 = {"Lcom/deliveryhero/performance/core/logger/LoggerTracker;", "Lcom/deliveryhero/performance/core/analytics/PerformanceTracker;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "fileWriter", "Lcom/deliveryhero/performance/core/logger/LoggerFileWriter;", "traces", "", "", "Lcom/deliveryhero/performance/core/logger/TraceLog;", "getTraces", "()Ljava/util/Map;", "addHostScreen", "", "traceName", "host", "addTraceAttribute", "attrName", "attrValue", "addTraceCounter", "counter", "cancelTrace", "putAllTraceAttributes", "attrs", "", "putTraceMetric", "metricName", "metricValue", "", "metadata", "", "resetTraces", "startTrace", "stopTrace", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LoggerTracker implements PerformanceTracker {
    @NotNull
    private final Context context;
    @NotNull
    private final LoggerFileWriter fileWriter;
    @NotNull
    private final Map<String, TraceLog> traces = new LinkedHashMap();

    public LoggerTracker(@NotNull Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
        this.fileWriter = new LoggerFileWriter(context2);
    }

    public void addHostScreen(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "traceName");
        Intrinsics.checkNotNullParameter(str2, URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_HOST);
        TraceLog traceLog = this.traces.get(str);
        if (traceLog != null) {
            traceLog.setHost(str2);
        }
    }

    public void addTraceAttribute(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "traceName");
        Intrinsics.checkNotNullParameter(str2, "attrName");
        Intrinsics.checkNotNullParameter(str3, "attrValue");
    }

    public void addTraceCounter(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "traceName");
        Intrinsics.checkNotNullParameter(str2, "counter");
    }

    public void cancelTrace(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "traceName");
        this.traces.remove(str);
    }

    @NotNull
    public final Map<String, TraceLog> getTraces() {
        return this.traces;
    }

    public void putAllTraceAttributes(@NotNull String str, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "traceName");
        Intrinsics.checkNotNullParameter(map, UserAttributesCacheManager.USER_ATTRIBUTES_CACHE_KEY);
    }

    public void putTraceMetric(@NotNull String str, @NotNull String str2, long j11) {
        List<MetricLog> metrics;
        Intrinsics.checkNotNullParameter(str, "traceName");
        Intrinsics.checkNotNullParameter(str2, "metricName");
        MetricLog metricLog = new MetricLog(str2, j11, (String) null, (Long) null, (Long) null, 28, (DefaultConstructorMarker) null);
        TraceLog traceLog = this.traces.get(str);
        if (traceLog != null && (metrics = traceLog.getMetrics()) != null) {
            metrics.add(metricLog);
        }
    }

    public void resetTraces() {
        this.traces.clear();
    }

    public void startTrace(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "traceName");
        this.traces.put(str, new TraceLog(str, (String) null, System.currentTimeMillis(), (Long) null, (List) null, 26, (DefaultConstructorMarker) null));
    }

    public void stopTrace(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "traceName");
        TraceLog traceLog = this.traces.get(str);
        if (traceLog != null) {
            traceLog.setStop(Long.valueOf(System.currentTimeMillis()));
            this.fileWriter.writeLog(LoggerTrackerKt.json(traceLog));
        }
    }

    public void putTraceMetric(@NotNull String str, @NotNull String str2, long j11, @Nullable Map<String, ? extends Object> map) {
        Object obj;
        List<MetricLog> metrics;
        Intrinsics.checkNotNullParameter(str, "traceName");
        Intrinsics.checkNotNullParameter(str2, "metricName");
        String access$getMetricType = LoggerTrackerKt.getMetricType(str2);
        Object obj2 = null;
        if (map == null) {
            obj = null;
        } else {
            obj = map.get("start");
        }
        Long l11 = (Long) obj;
        if (map != null) {
            obj2 = map.get(TraceLogKt.STOP_PROPERTY_NAME);
        }
        MetricLog metricLog = new MetricLog(str2, j11, access$getMetricType, l11, (Long) obj2);
        TraceLog traceLog = this.traces.get(str);
        if (traceLog != null && (metrics = traceLog.getMetrics()) != null) {
            metrics.add(metricLog);
        }
    }
}
