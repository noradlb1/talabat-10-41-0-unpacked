package com.talabat.observabilityNew.squads.discovery;

import com.talabat.core.observabilityNew.domain.IAppLaunchTrackingManager;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fH\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000fH\u0016J\u0018\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u0006H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/talabat/observabilityNew/squads/discovery/AppLaunchTrackingManager;", "Lcom/talabat/core/observabilityNew/domain/IAppLaunchTrackingManager;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "(Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "appStartTime", "", "getAppStartTime", "()J", "setAppStartTime", "(J)V", "appTrackingMap", "", "", "canSendEvent", "", "getCanSendEvent", "()Z", "setCanSendEvent", "(Z)V", "isFirstRun", "setFirstRun", "getAppTrackingMap", "sendAppLaunchEvent", "", "setPerformanceABTest", "abTest", "trackEvent", "eventName", "eventTime", "com_talabat_core_observability_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AppLaunchTrackingManager implements IAppLaunchTrackingManager {
    private long appStartTime;
    @NotNull
    private final Map<String, String> appTrackingMap = new LinkedHashMap();
    private boolean canSendEvent;
    private boolean isFirstRun;
    @NotNull
    private final IObservabilityManager observabilityManager;

    @Inject
    public AppLaunchTrackingManager(@NotNull IObservabilityManager iObservabilityManager) {
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        this.observabilityManager = iObservabilityManager;
    }

    public final long getAppStartTime() {
        return this.appStartTime;
    }

    @NotNull
    public Map<String, String> getAppTrackingMap() {
        return this.appTrackingMap;
    }

    public final boolean getCanSendEvent() {
        return this.canSendEvent;
    }

    public final boolean isFirstRun() {
        return this.isFirstRun;
    }

    public void sendAppLaunchEvent() {
        if (this.canSendEvent && !this.isFirstRun) {
            this.canSendEvent = false;
            this.observabilityManager.trackEvent("app_launch_time", DiscoveryEventType.DiscoveryEvents.name(), this.appTrackingMap);
        }
    }

    public final void setAppStartTime(long j11) {
        this.appStartTime = j11;
    }

    public final void setCanSendEvent(boolean z11) {
        this.canSendEvent = z11;
    }

    public final void setFirstRun(boolean z11) {
        this.isFirstRun = z11;
    }

    public void setPerformanceABTest(boolean z11) {
        this.appTrackingMap.put("perfomance_ab_test", String.valueOf(z11));
    }

    public void trackEvent(@NotNull String str, long j11) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Date date = new Date(this.appStartTime);
        this.appTrackingMap.put(str, String.valueOf(new Date(j11).getTime() - date.getTime()));
    }
}
