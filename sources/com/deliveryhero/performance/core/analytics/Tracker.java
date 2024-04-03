package com.deliveryhero.performance.core.analytics;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0003H&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0012"}, d2 = {"Lcom/deliveryhero/performance/core/analytics/Tracker;", "", "addTraceAttribute", "", "traceName", "", "attrName", "attrValue", "addTraceCounter", "counter", "cancelTrace", "putTraceMetric", "metricName", "metricValue", "", "resetTraces", "startTrace", "stopTrace", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface Tracker {
    void addTraceAttribute(@NotNull String str, @NotNull String str2, @NotNull String str3);

    void addTraceCounter(@NotNull String str, @NotNull String str2);

    void cancelTrace(@NotNull String str);

    void putTraceMetric(@NotNull String str, @NotNull String str2, long j11);

    void resetTraces();

    void startTrace(@NotNull String str);

    void stopTrace(@NotNull String str);
}
