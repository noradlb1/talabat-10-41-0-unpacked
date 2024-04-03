package com.talabat.feature.pickup.data.events.swimlanes;

import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00062\u0006\u0010\t\u001a\u00020\nH\u0016J\t\u0010\u000b\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\bHÖ\u0003J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\t\u0010\u0014\u001a\u00020\u0007HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/talabat/feature/pickup/data/events/swimlanes/SwimlaneClickedEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "tracking", "Lcom/talabat/feature/pickup/data/events/swimlanes/SwimlanesTracking;", "(Lcom/talabat/feature/pickup/data/events/swimlanes/SwimlanesTracking;)V", "attributes", "", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "component1", "copy", "equals", "", "other", "featureName", "hashCode", "", "name", "toString", "Companion", "com_talabat_feature_pickup_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SwimlaneClickedEvent extends TalabatEvent {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String EVENT_NAME = "shop_clicked";
    @NotNull

    /* renamed from: tracking  reason: collision with root package name */
    private final SwimlanesTracking f58635tracking;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/feature/pickup/data/events/swimlanes/SwimlaneClickedEvent$Companion;", "", "()V", "EVENT_NAME", "", "com_talabat_feature_pickup_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SwimlaneClickedEvent(@NotNull SwimlanesTracking swimlanesTracking) {
        Intrinsics.checkNotNullParameter(swimlanesTracking, "tracking");
        this.f58635tracking = swimlanesTracking;
    }

    private final SwimlanesTracking component1() {
        return this.f58635tracking;
    }

    public static /* synthetic */ SwimlaneClickedEvent copy$default(SwimlaneClickedEvent swimlaneClickedEvent, SwimlanesTracking swimlanesTracking, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            swimlanesTracking = swimlaneClickedEvent.f58635tracking;
        }
        return swimlaneClickedEvent.copy(swimlanesTracking);
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return MapsKt__MapsKt.plus(MapsKt__MapsKt.mutableMapOf(TuplesKt.to("chainId", this.f58635tracking.getVendorId()), TuplesKt.to("shopId", this.f58635tracking.getBranchId()), TuplesKt.to("shopClickOrigin", "swimlane"), TuplesKt.to("vendorSponsoringPlacement", "shop_list:swimlane")), (Map) SwimlanesTracking.Companion.commonAttributes(this.f58635tracking));
    }

    @NotNull
    public final SwimlaneClickedEvent copy(@NotNull SwimlanesTracking swimlanesTracking) {
        Intrinsics.checkNotNullParameter(swimlanesTracking, "tracking");
        return new SwimlaneClickedEvent(swimlanesTracking);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SwimlaneClickedEvent) && Intrinsics.areEqual((Object) this.f58635tracking, (Object) ((SwimlaneClickedEvent) obj).f58635tracking);
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "pickup";
    }

    public int hashCode() {
        return this.f58635tracking.hashCode();
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "shop_clicked";
    }

    @NotNull
    public String toString() {
        SwimlanesTracking swimlanesTracking = this.f58635tracking;
        return "SwimlaneClickedEvent(tracking=" + swimlanesTracking + ")";
    }
}
