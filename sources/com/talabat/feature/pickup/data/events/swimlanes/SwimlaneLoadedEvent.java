package com.talabat.feature.pickup.data.events.swimlanes;

import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\b\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\t\u0010\r\u001a\u00020\u0003HÂ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÂ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\nHÖ\u0003J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\t\u0010\u0016\u001a\u00020\tHÖ\u0001R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/talabat/feature/pickup/data/events/swimlanes/SwimlaneLoadedEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "tracking", "Lcom/talabat/feature/pickup/data/events/swimlanes/SwimlanesTracking;", "isSwiping", "", "(Lcom/talabat/feature/pickup/data/events/swimlanes/SwimlanesTracking;Z)V", "attributes", "", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "component1", "component2", "copy", "equals", "other", "featureName", "hashCode", "", "name", "toString", "Companion", "com_talabat_feature_pickup_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SwimlaneLoadedEvent extends TalabatEvent {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String SWIMLANE_LOADED = "swimlane_loaded";
    @NotNull
    private static final String SWIMLANE_SWIPED = "swimlane_swiped";
    private final boolean isSwiping;
    @NotNull

    /* renamed from: tracking  reason: collision with root package name */
    private final SwimlanesTracking f58636tracking;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/talabat/feature/pickup/data/events/swimlanes/SwimlaneLoadedEvent$Companion;", "", "()V", "SWIMLANE_LOADED", "", "SWIMLANE_SWIPED", "com_talabat_feature_pickup_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SwimlaneLoadedEvent(SwimlanesTracking swimlanesTracking, boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(swimlanesTracking, (i11 & 2) != 0 ? false : z11);
    }

    private final SwimlanesTracking component1() {
        return this.f58636tracking;
    }

    private final boolean component2() {
        return this.isSwiping;
    }

    public static /* synthetic */ SwimlaneLoadedEvent copy$default(SwimlaneLoadedEvent swimlaneLoadedEvent, SwimlanesTracking swimlanesTracking, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            swimlanesTracking = swimlaneLoadedEvent.f58636tracking;
        }
        if ((i11 & 2) != 0) {
            z11 = swimlaneLoadedEvent.isSwiping;
        }
        return swimlaneLoadedEvent.copy(swimlanesTracking, z11);
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return SwimlanesTracking.Companion.commonAttributes(this.f58636tracking);
    }

    @NotNull
    public final SwimlaneLoadedEvent copy(@NotNull SwimlanesTracking swimlanesTracking, boolean z11) {
        Intrinsics.checkNotNullParameter(swimlanesTracking, "tracking");
        return new SwimlaneLoadedEvent(swimlanesTracking, z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SwimlaneLoadedEvent)) {
            return false;
        }
        SwimlaneLoadedEvent swimlaneLoadedEvent = (SwimlaneLoadedEvent) obj;
        return Intrinsics.areEqual((Object) this.f58636tracking, (Object) swimlaneLoadedEvent.f58636tracking) && this.isSwiping == swimlaneLoadedEvent.isSwiping;
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "pickup";
    }

    public int hashCode() {
        int hashCode = this.f58636tracking.hashCode() * 31;
        boolean z11 = this.isSwiping;
        if (z11) {
            z11 = true;
        }
        return hashCode + (z11 ? 1 : 0);
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        if (this.isSwiping) {
            return SWIMLANE_SWIPED;
        }
        return SWIMLANE_LOADED;
    }

    @NotNull
    public String toString() {
        SwimlanesTracking swimlanesTracking = this.f58636tracking;
        boolean z11 = this.isSwiping;
        return "SwimlaneLoadedEvent(tracking=" + swimlanesTracking + ", isSwiping=" + z11 + ")";
    }

    public SwimlaneLoadedEvent(@NotNull SwimlanesTracking swimlanesTracking, boolean z11) {
        Intrinsics.checkNotNullParameter(swimlanesTracking, "tracking");
        this.f58636tracking = swimlanesTracking;
        this.isSwiping = z11;
    }
}
