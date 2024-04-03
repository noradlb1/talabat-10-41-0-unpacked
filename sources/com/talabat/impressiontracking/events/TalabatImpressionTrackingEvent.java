package com.talabat.impressiontracking.events;

import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0002\u0010\u0007J\u001e\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J\t\u0010\f\u001a\u00020\u0003HÂ\u0003J\t\u0010\r\u001a\u00020\u0003HÂ\u0003J\u0015\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0006HÂ\u0003J3\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\tHÖ\u0003J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/talabat/impressiontracking/events/TalabatImpressionTrackingEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "eventName", "", "featureName", "impressionPayload", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "attributes", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "name", "toString", "com_talabat_ThirdPartyLibs_ImpressionTracking_ImpressionTracking"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TalabatImpressionTrackingEvent extends TalabatEvent {
    @NotNull
    private final String eventName;
    @NotNull
    private final String featureName;
    @NotNull
    private final Map<String, String> impressionPayload;

    public TalabatImpressionTrackingEvent(@NotNull String str, @NotNull String str2, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(str2, "featureName");
        Intrinsics.checkNotNullParameter(map, "impressionPayload");
        this.eventName = str;
        this.featureName = str2;
        this.impressionPayload = map;
    }

    private final String component1() {
        return this.eventName;
    }

    private final String component2() {
        return this.featureName;
    }

    private final Map<String, String> component3() {
        return this.impressionPayload;
    }

    public static /* synthetic */ TalabatImpressionTrackingEvent copy$default(TalabatImpressionTrackingEvent talabatImpressionTrackingEvent, String str, String str2, Map<String, String> map, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = talabatImpressionTrackingEvent.eventName;
        }
        if ((i11 & 2) != 0) {
            str2 = talabatImpressionTrackingEvent.featureName;
        }
        if ((i11 & 4) != 0) {
            map = talabatImpressionTrackingEvent.impressionPayload;
        }
        return talabatImpressionTrackingEvent.copy(str, str2, map);
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return this.impressionPayload;
    }

    @NotNull
    public final TalabatImpressionTrackingEvent copy(@NotNull String str, @NotNull String str2, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(str2, "featureName");
        Intrinsics.checkNotNullParameter(map, "impressionPayload");
        return new TalabatImpressionTrackingEvent(str, str2, map);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TalabatImpressionTrackingEvent)) {
            return false;
        }
        TalabatImpressionTrackingEvent talabatImpressionTrackingEvent = (TalabatImpressionTrackingEvent) obj;
        return Intrinsics.areEqual((Object) this.eventName, (Object) talabatImpressionTrackingEvent.eventName) && Intrinsics.areEqual((Object) this.featureName, (Object) talabatImpressionTrackingEvent.featureName) && Intrinsics.areEqual((Object) this.impressionPayload, (Object) talabatImpressionTrackingEvent.impressionPayload);
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return this.featureName;
    }

    public int hashCode() {
        return (((this.eventName.hashCode() * 31) + this.featureName.hashCode()) * 31) + this.impressionPayload.hashCode();
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return this.eventName;
    }

    @NotNull
    public String toString() {
        String str = this.eventName;
        String str2 = this.featureName;
        Map<String, String> map = this.impressionPayload;
        return "TalabatImpressionTrackingEvent(eventName=" + str + ", featureName=" + str2 + ", impressionPayload=" + map + ")";
    }
}
