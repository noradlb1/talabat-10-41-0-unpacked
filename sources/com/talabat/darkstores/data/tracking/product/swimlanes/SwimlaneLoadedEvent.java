package com.talabat.darkstores.data.tracking.product.swimlanes;

import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B3\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003¢\u0006\u0002\u0010\u0007J\u001e\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\u0017\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003HÂ\u0003J\u0017\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003HÂ\u0003J9\u0010\r\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00032\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÖ\u0003J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0016J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0016J\t\u0010\u0015\u001a\u00020\u0004HÖ\u0001R\u001c\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/talabat/darkstores/data/tracking/product/swimlanes/SwimlaneLoadedEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "storeInfoParams", "", "", "", "additionalParams", "(Ljava/util/Map;Ljava/util/Map;)V", "attributes", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "component1", "component2", "copy", "equals", "", "other", "featureName", "hashCode", "", "name", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SwimlaneLoadedEvent extends TalabatEvent {
    @NotNull
    private final Map<String, Object> additionalParams;
    @NotNull
    private final Map<String, Object> storeInfoParams;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SwimlaneLoadedEvent(Map map, Map map2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(map, (i11 & 2) != 0 ? MapsKt__MapsKt.emptyMap() : map2);
    }

    private final Map<String, Object> component1() {
        return this.storeInfoParams;
    }

    private final Map<String, Object> component2() {
        return this.additionalParams;
    }

    public static /* synthetic */ SwimlaneLoadedEvent copy$default(SwimlaneLoadedEvent swimlaneLoadedEvent, Map<String, Object> map, Map<String, Object> map2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            map = swimlaneLoadedEvent.storeInfoParams;
        }
        if ((i11 & 2) != 0) {
            map2 = swimlaneLoadedEvent.additionalParams;
        }
        return swimlaneLoadedEvent.copy(map, map2);
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return MapsKt__MapsKt.plus(this.storeInfoParams, this.additionalParams);
    }

    @NotNull
    public final SwimlaneLoadedEvent copy(@NotNull Map<String, ? extends Object> map, @NotNull Map<String, ? extends Object> map2) {
        Intrinsics.checkNotNullParameter(map, "storeInfoParams");
        Intrinsics.checkNotNullParameter(map2, "additionalParams");
        return new SwimlaneLoadedEvent(map, map2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SwimlaneLoadedEvent)) {
            return false;
        }
        SwimlaneLoadedEvent swimlaneLoadedEvent = (SwimlaneLoadedEvent) obj;
        return Intrinsics.areEqual((Object) this.storeInfoParams, (Object) swimlaneLoadedEvent.storeInfoParams) && Intrinsics.areEqual((Object) this.additionalParams, (Object) swimlaneLoadedEvent.additionalParams);
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "darkstores";
    }

    public int hashCode() {
        return (this.storeInfoParams.hashCode() * 31) + this.additionalParams.hashCode();
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return SwimlanesEventsKt.SWIMLANE_LOADED;
    }

    @NotNull
    public String toString() {
        Map<String, Object> map = this.storeInfoParams;
        Map<String, Object> map2 = this.additionalParams;
        return "SwimlaneLoadedEvent(storeInfoParams=" + map + ", additionalParams=" + map2 + ")";
    }

    public SwimlaneLoadedEvent(@NotNull Map<String, ? extends Object> map, @NotNull Map<String, ? extends Object> map2) {
        Intrinsics.checkNotNullParameter(map, "storeInfoParams");
        Intrinsics.checkNotNullParameter(map2, "additionalParams");
        this.storeInfoParams = map;
        this.additionalParams = map2;
    }
}
