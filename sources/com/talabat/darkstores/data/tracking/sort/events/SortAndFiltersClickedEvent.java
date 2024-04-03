package com.talabat.darkstores.data.tracking.sort.events;

import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import com.talabat.fluttercore.channels.AnalyticsMethodChannel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0017\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003HÂ\u0003J!\u0010\n\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0005HÖ\u0003J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016J\t\u0010\u0012\u001a\u00020\u0004HÖ\u0001R\u001c\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/talabat/darkstores/data/tracking/sort/events/SortAndFiltersClickedEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "attributes", "", "", "", "(Ljava/util/Map;)V", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "component1", "copy", "equals", "", "other", "featureName", "hashCode", "", "name", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SortAndFiltersClickedEvent extends TalabatEvent {
    @NotNull
    private final Map<String, Object> attributes;

    public SortAndFiltersClickedEvent() {
        this((Map) null, 1, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SortAndFiltersClickedEvent(Map map, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? MapsKt__MapsKt.emptyMap() : map);
    }

    private final Map<String, Object> component1() {
        return this.attributes;
    }

    public static /* synthetic */ SortAndFiltersClickedEvent copy$default(SortAndFiltersClickedEvent sortAndFiltersClickedEvent, Map<String, Object> map, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            map = sortAndFiltersClickedEvent.attributes;
        }
        return sortAndFiltersClickedEvent.copy(map);
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return this.attributes;
    }

    @NotNull
    public final SortAndFiltersClickedEvent copy(@NotNull Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        return new SortAndFiltersClickedEvent(map);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SortAndFiltersClickedEvent) && Intrinsics.areEqual((Object) this.attributes, (Object) ((SortAndFiltersClickedEvent) obj).attributes);
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "darkstores";
    }

    public int hashCode() {
        return this.attributes.hashCode();
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "filters_clicked";
    }

    @NotNull
    public String toString() {
        Map<String, Object> map = this.attributes;
        return "SortAndFiltersClickedEvent(attributes=" + map + ")";
    }

    public SortAndFiltersClickedEvent(@NotNull Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        this.attributes = map;
    }
}
