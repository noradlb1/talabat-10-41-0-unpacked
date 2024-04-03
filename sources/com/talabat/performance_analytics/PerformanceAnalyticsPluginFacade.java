package com.talabat.performance_analytics;

import com.deliveryhero.performance.core.analytics.PerformanceTrackingManager;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0007R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/talabat/performance_analytics/PerformanceAnalyticsPluginFacade;", "", "()V", "performanceTrackingManager", "Lcom/deliveryhero/performance/core/analytics/PerformanceTrackingManager;", "setPerformanceTrackingManager", "", "manager", "performance_analytics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PerformanceAnalyticsPluginFacade {
    @NotNull
    public static final PerformanceAnalyticsPluginFacade INSTANCE = new PerformanceAnalyticsPluginFacade();
    @Nullable
    @JvmField
    public static PerformanceTrackingManager performanceTrackingManager;

    private PerformanceAnalyticsPluginFacade() {
    }

    @JvmStatic
    public static final void setPerformanceTrackingManager(@NotNull PerformanceTrackingManager performanceTrackingManager2) {
        Intrinsics.checkNotNullParameter(performanceTrackingManager2, "manager");
        performanceTrackingManager = performanceTrackingManager2;
    }
}
