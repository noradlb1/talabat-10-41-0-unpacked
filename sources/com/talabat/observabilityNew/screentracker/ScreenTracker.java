package com.talabat.observabilityNew.screentracker;

import com.deliveryhero.performance.core.analytics.PerformanceTrackingManager;
import com.deliveryhero.performance.core.screentracker.ScreenPerformanceLogger;
import com.deliveryhero.performance.core.screentracker.ScreenPerformanceParams;
import com.deliveryhero.performance.core.screentracker.ScreenPerformanceTracker;
import com.facebook.internal.NativeProtocol;
import com.talabat.core.observabilityNew.domain.IScreenTracker;
import com.talabat.core.observabilityNew.domain.entity.ScreenTrackerParams;
import com.talabat.observabilityNew.performance.PerformanceTrackingInitializer;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/talabat/observabilityNew/screentracker/ScreenTracker;", "Lcom/talabat/core/observabilityNew/domain/IScreenTracker;", "performanceTrackingManager", "Lcom/deliveryhero/performance/core/analytics/PerformanceTrackingManager;", "performanceTrackingInitializer", "Lcom/talabat/observabilityNew/performance/PerformanceTrackingInitializer;", "(Lcom/deliveryhero/performance/core/analytics/PerformanceTrackingManager;Lcom/talabat/observabilityNew/performance/PerformanceTrackingInitializer;)V", "createScreenPerformanceParams", "Lcom/deliveryhero/performance/core/screentracker/ScreenPerformanceParams;", "params", "Lcom/talabat/core/observabilityNew/domain/entity/ScreenTrackerParams;", "initialize", "", "startTrace", "stopTrace", "com_talabat_core_observability_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ScreenTracker implements IScreenTracker {
    @NotNull
    private final PerformanceTrackingInitializer performanceTrackingInitializer;
    @NotNull
    private final PerformanceTrackingManager performanceTrackingManager;

    @Inject
    public ScreenTracker(@NotNull PerformanceTrackingManager performanceTrackingManager2, @NotNull PerformanceTrackingInitializer performanceTrackingInitializer2) {
        Intrinsics.checkNotNullParameter(performanceTrackingManager2, "performanceTrackingManager");
        Intrinsics.checkNotNullParameter(performanceTrackingInitializer2, "performanceTrackingInitializer");
        this.performanceTrackingManager = performanceTrackingManager2;
        this.performanceTrackingInitializer = performanceTrackingInitializer2;
    }

    private final ScreenPerformanceParams createScreenPerformanceParams(ScreenTrackerParams screenTrackerParams) {
        return new ScreenTracker$createScreenPerformanceParams$1(screenTrackerParams);
    }

    public void initialize() {
        this.performanceTrackingInitializer.initialize();
        ScreenPerformanceTracker.init$default(this.performanceTrackingManager, (ScreenPerformanceLogger) null, 2, (Object) null);
    }

    public void startTrace(@NotNull ScreenTrackerParams screenTrackerParams) {
        Intrinsics.checkNotNullParameter(screenTrackerParams, NativeProtocol.WEB_DIALOG_PARAMS);
        ScreenPerformanceTracker.start(createScreenPerformanceParams(screenTrackerParams));
    }

    public void stopTrace(@NotNull ScreenTrackerParams screenTrackerParams) {
        Intrinsics.checkNotNullParameter(screenTrackerParams, NativeProtocol.WEB_DIALOG_PARAMS);
        ScreenPerformanceTracker.stop(createScreenPerformanceParams(screenTrackerParams));
    }
}
