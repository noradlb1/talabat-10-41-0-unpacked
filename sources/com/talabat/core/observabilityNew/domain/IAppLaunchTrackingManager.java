package com.talabat.core.observabilityNew.domain;

import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH&¨\u0006\u000e"}, d2 = {"Lcom/talabat/core/observabilityNew/domain/IAppLaunchTrackingManager;", "", "getAppTrackingMap", "", "", "sendAppLaunchEvent", "", "setPerformanceABTest", "abTest", "", "trackEvent", "eventName", "eventTime", "", "com_talabat_core_observability_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IAppLaunchTrackingManager {
    @NotNull
    Map<String, String> getAppTrackingMap();

    void sendAppLaunchEvent();

    void setPerformanceABTest(boolean z11);

    void trackEvent(@NotNull String str, long j11);
}
