package com.talabat.core.tracking.data;

import com.talabat.core.tracking.data.logger.LogManager;
import com.talabat.core.tracking.data.platform.TrackingPlatform;
import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import com.talabat.core.tracking.domain.TalabatTracker;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J&\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0002J&\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00032\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\bH\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/talabat/core/tracking/data/TalabatTrackerImpl;", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "trackingPlatformsRegistry", "", "Lcom/talabat/core/tracking/domain/PlatformName;", "Lcom/talabat/core/tracking/data/platform/TrackingPlatform;", "(Ljava/util/Map;)V", "getFullAttributes", "", "", "event", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "platformName", "getPlatformAttributes", "eventName", "track", "", "com_talabat_core_tracking_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TalabatTrackerImpl implements TalabatTracker {
    @NotNull
    private final Map<PlatformName, TrackingPlatform> trackingPlatformsRegistry;

    public TalabatTrackerImpl(@NotNull Map<PlatformName, ? extends TrackingPlatform> map) {
        Intrinsics.checkNotNullParameter(map, "trackingPlatformsRegistry");
        this.trackingPlatformsRegistry = map;
    }

    private final Map<String, Object> getFullAttributes(TalabatEvent talabatEvent, PlatformName platformName) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("featureName", talabatEvent.featureName(platformName));
        linkedHashMap.putAll(getPlatformAttributes(platformName, talabatEvent.name(platformName)));
        linkedHashMap.putAll(talabatEvent.attributes(platformName));
        return linkedHashMap;
    }

    private final Map<String, Object> getPlatformAttributes(PlatformName platformName, String str) {
        Map<String, Object> commonAttributes;
        TrackingPlatform trackingPlatform = this.trackingPlatformsRegistry.get(platformName);
        if (trackingPlatform == null || (commonAttributes = trackingPlatform.getCommonAttributes(str)) == null) {
            return MapsKt__MapsKt.emptyMap();
        }
        return commonAttributes;
    }

    public void track(@NotNull TalabatEvent talabatEvent) {
        TrackingPlatform trackingPlatform;
        Intrinsics.checkNotNullParameter(talabatEvent, "event");
        for (PlatformName platformName : talabatEvent.platforms()) {
            String name2 = talabatEvent.name(platformName);
            Map<String, Object> fullAttributes = getFullAttributes(talabatEvent, platformName);
            TrackingPlatform trackingPlatform2 = this.trackingPlatformsRegistry.get(platformName);
            String name3 = talabatEvent.name(platformName);
            LogManager.debug("Sending, eventName: " + name3 + " with params " + fullAttributes + " to " + platformName);
            if (platformName == PlatformName.GOOGLE_ANALYTICS && (trackingPlatform = this.trackingPlatformsRegistry.get(PlatformName.PERSEUS)) != null) {
                trackingPlatform.track(name2, fullAttributes);
            }
            if (trackingPlatform2 != null) {
                trackingPlatform2.track(name2, fullAttributes);
            }
        }
    }
}
