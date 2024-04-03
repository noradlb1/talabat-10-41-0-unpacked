package com.talabat.integration;

import com.huawei.hms.flutter.map.constants.Param;
import com.instabug.library.internal.storage.cache.UserAttributesCacheManager;
import com.talabat.core.fwf.domain.FunWithFlagsObservabilityPort;
import com.talabat.fluttercore.channels.AnalyticsMethodChannel;
import com.talabat.observability.ObservabilityManager;
import com.talabat.observability.common.BackgroundAction;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J8\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\bH\u0016J\u001c\u0010\u000b\u001a\u00020\u00042\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\bH\u0016J\u001c\u0010\r\u001a\u00020\u00042\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\bH\u0016J$\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00062\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\bH\u0016¨\u0006\u0010"}, d2 = {"Lcom/talabat/integration/FunWithFlagsObservability;", "Lcom/talabat/core/fwf/domain/FunWithFlagsObservabilityPort;", "()V", "observerFwfCount", "", "eventName", "", "map", "", "", "attrs", "trackCacheFill", "attributes", "trackFWFExpEvents", "trackUnExpectedScenario", "explanation", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FunWithFlagsObservability implements FunWithFlagsObservabilityPort {
    public void observerFwfCount(@NotNull String str, @NotNull Map<String, Integer> map, @NotNull Map<String, String> map2) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(map, Param.MAP);
        Intrinsics.checkNotNullParameter(map2, UserAttributesCacheManager.USER_ATTRIBUTES_CACHE_KEY);
        ObservabilityManager.trackFwfCount(str, map, map2);
    }

    public void trackCacheFill(@NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        ObservabilityManager.trackEvent(BackgroundAction.TRACK_FWF_CACHE_FILL, map);
    }

    public void trackFWFExpEvents(@NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        ObservabilityManager.trackEvent(BackgroundAction.TRACK_FWF_TRACKING_EVENTS, map);
    }

    public void trackUnExpectedScenario(@NotNull String str, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "explanation");
        Intrinsics.checkNotNullParameter(map, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        ObservabilityManager.trackUnExpectedScenario(str, map);
    }
}
