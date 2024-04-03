package library.talabat.mvp.checkout.tracking;

import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u001c\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0016J\t\u0010\f\u001a\u00020\u0003HÂ\u0003J\t\u0010\r\u001a\u00020\u0003HÂ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\tHÖ\u0003J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0016H\u0016J\t\u0010\u0017\u001a\u00020\bHÖ\u0001R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Llibrary/talabat/mvp/checkout/tracking/ScheduleDeliveryClosedEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "vendorId", "", "customerCode", "(II)V", "attributes", "", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "component1", "component2", "copy", "equals", "", "other", "featureName", "hashCode", "name", "platforms", "", "toString", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ScheduleDeliveryClosedEvent extends TalabatEvent {
    private final int customerCode;
    private final int vendorId;

    public ScheduleDeliveryClosedEvent(int i11, int i12) {
        this.vendorId = i11;
        this.customerCode = i12;
    }

    private final int component1() {
        return this.vendorId;
    }

    private final int component2() {
        return this.customerCode;
    }

    public static /* synthetic */ ScheduleDeliveryClosedEvent copy$default(ScheduleDeliveryClosedEvent scheduleDeliveryClosedEvent, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = scheduleDeliveryClosedEvent.vendorId;
        }
        if ((i13 & 2) != 0) {
            i12 = scheduleDeliveryClosedEvent.customerCode;
        }
        return scheduleDeliveryClosedEvent.copy(i11, i12);
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return MapsKt__MapsKt.mapOf(TuplesKt.to("shopId", Integer.valueOf(this.vendorId)), TuplesKt.to("screenName", "checkout"), TuplesKt.to("shopType", "darkstores"), TuplesKt.to("customerCode", Integer.valueOf(this.customerCode)));
    }

    @NotNull
    public final ScheduleDeliveryClosedEvent copy(int i11, int i12) {
        return new ScheduleDeliveryClosedEvent(i11, i12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ScheduleDeliveryClosedEvent)) {
            return false;
        }
        ScheduleDeliveryClosedEvent scheduleDeliveryClosedEvent = (ScheduleDeliveryClosedEvent) obj;
        return this.vendorId == scheduleDeliveryClosedEvent.vendorId && this.customerCode == scheduleDeliveryClosedEvent.customerCode;
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return ScheduledDeliveryEventConstantsKt.FEATURE_SCHEDULED_DELIVERY;
    }

    public int hashCode() {
        return (this.vendorId * 31) + this.customerCode;
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return ScheduledDeliveryEventConstantsKt.EVENT_SCHEDULED_DELIVERY_CLOSED;
    }

    @NotNull
    public List<PlatformName> platforms() {
        return CollectionsKt__CollectionsJVMKt.listOf(PlatformName.GOOGLE_ANALYTICS);
    }

    @NotNull
    public String toString() {
        int i11 = this.vendorId;
        int i12 = this.customerCode;
        return "ScheduleDeliveryClosedEvent(vendorId=" + i11 + ", customerCode=" + i12 + ")";
    }
}
