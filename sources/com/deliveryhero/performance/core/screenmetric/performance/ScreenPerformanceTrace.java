package com.deliveryhero.performance.core.screenmetric.performance;

import com.deliveryhero.performance.core.analytics.PerformanceTrackingManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0006J\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/deliveryhero/performance/core/screenmetric/performance/ScreenPerformanceTrace;", "", "performanceTrackingManager", "Lcom/deliveryhero/performance/core/analytics/PerformanceTrackingManager;", "(Lcom/deliveryhero/performance/core/analytics/PerformanceTrackingManager;)V", "getScreenAggTraceName", "", "screenName", "start", "", "stop", "screenHost", "performanceMetaData", "Lcom/deliveryhero/performance/core/screenmetric/performance/PerformanceMetaData;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ScreenPerformanceTrace {
    @NotNull
    private final PerformanceTrackingManager performanceTrackingManager;

    public ScreenPerformanceTrace(@NotNull PerformanceTrackingManager performanceTrackingManager2) {
        Intrinsics.checkNotNullParameter(performanceTrackingManager2, "performanceTrackingManager");
        this.performanceTrackingManager = performanceTrackingManager2;
    }

    private final String getScreenAggTraceName(String str) {
        return Intrinsics.stringPlus("sm_", str);
    }

    public final void start(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        String screenAggTraceName = getScreenAggTraceName(str);
        ScreenPerfMetricContainer.INSTANCE.addActiveScreen$core_release(str);
        this.performanceTrackingManager.startTrace(screenAggTraceName);
    }

    public final void stop(@NotNull String str, @NotNull String str2, @NotNull PerformanceMetaData performanceMetaData) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        Intrinsics.checkNotNullParameter(str2, "screenHost");
        Intrinsics.checkNotNullParameter(performanceMetaData, "performanceMetaData");
        String screenAggTraceName = getScreenAggTraceName(str);
        for (Map.Entry next : performanceMetaData.getMetrics().entrySet()) {
            PerformanceTrackingManager performanceTrackingManager2 = this.performanceTrackingManager;
            long value = ((MetricMetaData) next.getValue()).getValue();
            Map<String, Long> metaData = ((MetricMetaData) next.getValue()).getMetaData();
            performanceTrackingManager2.putTraceMetric(screenAggTraceName, (String) next.getKey(), value, metaData);
        }
        for (Map.Entry next2 : performanceMetaData.getAttributes().entrySet()) {
            this.performanceTrackingManager.addTraceAttribute(screenAggTraceName, new SimpleTraceAttribute((String) next2.getKey()).getName(), (String) next2.getValue());
        }
        this.performanceTrackingManager.addHostScreen(screenAggTraceName, str2);
        this.performanceTrackingManager.stopTrace(screenAggTraceName);
    }
}
