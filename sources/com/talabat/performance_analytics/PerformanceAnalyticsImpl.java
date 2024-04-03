package com.talabat.performance_analytics;

import com.deliveryhero.performance.core.analytics.PerformanceTrackingManager;
import com.facebook.internal.NativeProtocol;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0016J&\u0010\u000e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/talabat/performance_analytics/PerformanceAnalyticsImpl;", "Lcom/talabat/performance_analytics/PerformanceAnalyticsApi;", "performanceTrackingManager", "Lcom/deliveryhero/performance/core/analytics/PerformanceTrackingManager;", "(Lcom/deliveryhero/performance/core/analytics/PerformanceTrackingManager;)V", "addTraceAttribute", "", "params", "Lcom/talabat/performance_analytics/TraceAttributeParams;", "addTraceCounter", "Lcom/talabat/performance_analytics/TraceCounterParams;", "cancelTrace", "traceName", "", "endTrace", "attributes", "", "putTraceMetric", "Lcom/talabat/performance_analytics/TraceMetricParams;", "resetTraces", "startTrace", "performance_analytics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PerformanceAnalyticsImpl implements PerformanceAnalyticsApi {
    @NotNull
    private PerformanceTrackingManager performanceTrackingManager;

    public PerformanceAnalyticsImpl(@NotNull PerformanceTrackingManager performanceTrackingManager2) {
        Intrinsics.checkNotNullParameter(performanceTrackingManager2, "performanceTrackingManager");
        this.performanceTrackingManager = performanceTrackingManager2;
    }

    public void addTraceAttribute(@NotNull TraceAttributeParams traceAttributeParams) {
        Intrinsics.checkNotNullParameter(traceAttributeParams, NativeProtocol.WEB_DIALOG_PARAMS);
        PerformanceAnalyticsPluginKt.getLogTag();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("addTraceAttribute: ");
        sb2.append(traceAttributeParams);
        this.performanceTrackingManager.addTraceAttribute(traceAttributeParams.getTraceName(), traceAttributeParams.getAttributeName(), traceAttributeParams.getAttributeValue());
    }

    public void addTraceCounter(@NotNull TraceCounterParams traceCounterParams) {
        Intrinsics.checkNotNullParameter(traceCounterParams, NativeProtocol.WEB_DIALOG_PARAMS);
        PerformanceAnalyticsPluginKt.getLogTag();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("addTraceCounter: ");
        sb2.append(traceCounterParams);
        this.performanceTrackingManager.addTraceCounter(traceCounterParams.getTraceName(), traceCounterParams.getCounter());
    }

    public void cancelTrace(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "traceName");
        PerformanceAnalyticsPluginKt.getLogTag();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("cancelTrace: ");
        sb2.append(str);
        this.performanceTrackingManager.cancelTrace(str);
    }

    public void endTrace(@NotNull String str, @Nullable Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "traceName");
        PerformanceAnalyticsPluginKt.getLogTag();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("endTrace: ");
        sb2.append(str);
        sb2.append(", attributes: ");
        sb2.append(map);
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                this.performanceTrackingManager.addTraceAttribute(str, (String) next.getKey(), (String) next.getValue());
            }
        }
        this.performanceTrackingManager.stopTrace(str);
    }

    public void putTraceMetric(@NotNull TraceMetricParams traceMetricParams) {
        Intrinsics.checkNotNullParameter(traceMetricParams, NativeProtocol.WEB_DIALOG_PARAMS);
        PerformanceAnalyticsPluginKt.getLogTag();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("putTraceMetric: ");
        sb2.append(traceMetricParams);
        this.performanceTrackingManager.putTraceMetric(traceMetricParams.getTraceName(), traceMetricParams.getMetricName(), traceMetricParams.getMetricValue());
    }

    public void resetTraces() {
        PerformanceAnalyticsPluginKt.getLogTag();
        this.performanceTrackingManager.resetTraces();
    }

    public void startTrace(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "traceName");
        PerformanceAnalyticsPluginKt.getLogTag();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("startTrace: ");
        sb2.append(str);
        this.performanceTrackingManager.startTrace(str);
    }
}
