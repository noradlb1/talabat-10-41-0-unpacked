package com.talabat.core.observabilityNew.domain;

import com.talabat.core.di.Api;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/talabat/core/observabilityNew/domain/ObservabilityCoreLibApi;", "Lcom/talabat/core/di/Api;", "appLaunchTrackingManager", "Lcom/talabat/core/observabilityNew/domain/IAppLaunchTrackingManager;", "getAppLaunchTrackingManager", "()Lcom/talabat/core/observabilityNew/domain/IAppLaunchTrackingManager;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "getObservabilityManager", "()Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "performanceTracker", "Lcom/talabat/core/observabilityNew/domain/IPerformanceTracker;", "getPerformanceTracker", "()Lcom/talabat/core/observabilityNew/domain/IPerformanceTracker;", "screenTracker", "Lcom/talabat/core/observabilityNew/domain/IScreenTracker;", "getScreenTracker", "()Lcom/talabat/core/observabilityNew/domain/IScreenTracker;", "timeTracker", "Lcom/talabat/core/observabilityNew/domain/ITimeTracker;", "getTimeTracker", "()Lcom/talabat/core/observabilityNew/domain/ITimeTracker;", "com_talabat_core_observability_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ObservabilityCoreLibApi extends Api {
    @NotNull
    IAppLaunchTrackingManager getAppLaunchTrackingManager();

    @NotNull
    IObservabilityManager getObservabilityManager();

    @NotNull
    IPerformanceTracker getPerformanceTracker();

    @NotNull
    IScreenTracker getScreenTracker();

    @NotNull
    ITimeTracker getTimeTracker();
}
