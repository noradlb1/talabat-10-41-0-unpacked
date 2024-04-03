package com.talabat.fluid.homescreen.domain.usecase.application.impl;

import com.talabat.core.observabilityNew.domain.IScreenTracker;
import com.talabat.core.observabilityNew.domain.entity.ScreenTrackerParams;
import com.talabat.core.observabilityNew.domain.squads.home.HomeScreenPerformanceParams;
import com.talabat.fluid.homescreen.domain.usecase.application.StopHomeScreenTraceUseCase;
import com.talabat.observability.performance.PerformanceTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/talabat/fluid/homescreen/domain/usecase/application/impl/StopHomeScreenTraceUseCaseImpl;", "Lcom/talabat/fluid/homescreen/domain/usecase/application/StopHomeScreenTraceUseCase;", "screenTracker", "Lcom/talabat/core/observabilityNew/domain/IScreenTracker;", "performanceTracker", "Lcom/talabat/observability/performance/PerformanceTracker;", "(Lcom/talabat/core/observabilityNew/domain/IScreenTracker;Lcom/talabat/observability/performance/PerformanceTracker;)V", "stopHomeScreenTrace", "", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class StopHomeScreenTraceUseCaseImpl implements StopHomeScreenTraceUseCase {
    @NotNull
    private final PerformanceTracker performanceTracker;
    @NotNull
    private final IScreenTracker screenTracker;

    public StopHomeScreenTraceUseCaseImpl(@NotNull IScreenTracker iScreenTracker, @NotNull PerformanceTracker performanceTracker2) {
        Intrinsics.checkNotNullParameter(iScreenTracker, "screenTracker");
        Intrinsics.checkNotNullParameter(performanceTracker2, "performanceTracker");
        this.screenTracker = iScreenTracker;
        this.performanceTracker = performanceTracker2;
    }

    public void stopHomeScreenTrace() {
        this.performanceTracker.stopTrace("appStartToInteractive");
        this.screenTracker.stopTrace(new ScreenTrackerParams("home", HomeScreenPerformanceParams.SCREEN_NAME, "home"));
    }
}
