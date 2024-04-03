package com.talabat.observability.squads.discovery;

import com.talabat.observability.ObservabilityManager;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\nJ\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\rJ\u0016\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/talabat/observability/squads/discovery/AppLaunchTrackingManger;", "", "()V", "appStartTime", "", "getAppStartTime", "()J", "setAppStartTime", "(J)V", "appTrackingMap", "", "", "canSendEvent", "", "getCanSendEvent", "()Z", "setCanSendEvent", "(Z)V", "isFirstRun", "setFirstRun", "getAppTrackingMap", "sendAppLaunchEvent", "", "setPerfomanceABTest", "abTest", "trackEvent", "eventName", "eventTime", "com_talabat_NewArchi_Observability_Observability"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AppLaunchTrackingManger {
    @NotNull
    public static final AppLaunchTrackingManger INSTANCE = new AppLaunchTrackingManger();
    private static long appStartTime;
    @NotNull
    private static final Map<String, String> appTrackingMap = new LinkedHashMap();
    private static boolean canSendEvent;
    private static boolean isFirstRun;

    private AppLaunchTrackingManger() {
    }

    public final long getAppStartTime() {
        return appStartTime;
    }

    @NotNull
    public final Map<String, String> getAppTrackingMap() {
        return appTrackingMap;
    }

    public final boolean getCanSendEvent() {
        return canSendEvent;
    }

    public final boolean isFirstRun() {
        return isFirstRun;
    }

    public final void sendAppLaunchEvent() {
        if (canSendEvent && !isFirstRun) {
            canSendEvent = false;
            ObservabilityManager.trackEvent("app_launch_time", DiscoveryEventType.DiscoveryEvents.name(), appTrackingMap);
        }
    }

    public final void setAppStartTime(long j11) {
        appStartTime = j11;
    }

    public final void setCanSendEvent(boolean z11) {
        canSendEvent = z11;
    }

    public final void setFirstRun(boolean z11) {
        isFirstRun = z11;
    }

    public final void setPerfomanceABTest(boolean z11) {
        appTrackingMap.put("perfomance_ab_test", String.valueOf(z11));
    }

    public final void trackEvent(@NotNull String str, long j11) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Date date = new Date(appStartTime);
        appTrackingMap.put(str, String.valueOf(new Date(j11).getTime() - date.getTime()));
    }
}
