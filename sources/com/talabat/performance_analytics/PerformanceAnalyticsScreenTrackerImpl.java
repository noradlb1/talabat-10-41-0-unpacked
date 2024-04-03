package com.talabat.performance_analytics;

import com.deliveryhero.performance.core.analytics.PerformanceTrackingManager;
import com.deliveryhero.performance.core.screentracker.ScreenPerformanceLogger;
import com.deliveryhero.performance.core.screentracker.ScreenPerformanceTracker;
import com.facebook.internal.NativeProtocol;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J&\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/talabat/performance_analytics/PerformanceAnalyticsScreenTrackerImpl;", "Lcom/talabat/performance_analytics/PerformanceAnalyticsScreenTrackerApi;", "performanceTrackingManager", "Lcom/deliveryhero/performance/core/analytics/PerformanceTrackingManager;", "(Lcom/deliveryhero/performance/core/analytics/PerformanceTrackingManager;)V", "cancelScreenTrace", "", "traceName", "", "endScreenTrace", "attributes", "", "startScreenTrace", "params", "Lcom/talabat/performance_analytics/StartScreenTraceParams;", "performance_analytics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PerformanceAnalyticsScreenTrackerImpl implements PerformanceAnalyticsScreenTrackerApi {
    @NotNull
    private PerformanceTrackingManager performanceTrackingManager;

    public PerformanceAnalyticsScreenTrackerImpl(@NotNull PerformanceTrackingManager performanceTrackingManager2) {
        Intrinsics.checkNotNullParameter(performanceTrackingManager2, "performanceTrackingManager");
        this.performanceTrackingManager = performanceTrackingManager2;
        ScreenPerformanceTracker.init$default(performanceTrackingManager2, (ScreenPerformanceLogger) null, 2, (Object) null);
    }

    public void cancelScreenTrace(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "traceName");
        PerformanceAnalyticsPluginKt.getLogTag();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("cancelScreenTrace: ");
        sb2.append(str);
        ScreenPerformanceTracker.cancel(str);
    }

    public void endScreenTrace(@NotNull String str, @Nullable Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "traceName");
        PerformanceAnalyticsPluginKt.getLogTag();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("endScreenTrace: ");
        sb2.append(str);
        sb2.append(' ');
        sb2.append(map);
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                this.performanceTrackingManager.addTraceAttribute(PerformanceAnalyticsScreenTrackerImplKt.toScreenTraceName(str), (String) next.getKey(), (String) next.getValue());
            }
        }
        ScreenPerformanceTracker.stop(str);
    }

    public void startScreenTrace(@NotNull StartScreenTraceParams startScreenTraceParams) {
        Intrinsics.checkNotNullParameter(startScreenTraceParams, NativeProtocol.WEB_DIALOG_PARAMS);
        PerformanceAnalyticsPluginKt.getLogTag();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("startScreenTrace: ");
        sb2.append(startScreenTraceParams);
        ScreenPerformanceTracker.start(startScreenTraceParams.getTraceName(), startScreenTraceParams.getScreenName(), startScreenTraceParams.getScreenType());
    }
}
