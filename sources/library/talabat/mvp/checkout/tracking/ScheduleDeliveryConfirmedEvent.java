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

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001c\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\t\u0010\r\u001a\u00020\u0003HÂ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÂ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÂ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\nHÖ\u0003J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0016J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u0018H\u0016J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Llibrary/talabat/mvp/checkout/tracking/ScheduleDeliveryConfirmedEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "vendorId", "", "customerCode", "selectedSlot", "", "(IILjava/lang/String;)V", "attributes", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "component1", "component2", "component3", "copy", "equals", "", "other", "featureName", "hashCode", "name", "platforms", "", "toString", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ScheduleDeliveryConfirmedEvent extends TalabatEvent {
    private final int customerCode;
    @NotNull
    private final String selectedSlot;
    private final int vendorId;

    public ScheduleDeliveryConfirmedEvent(int i11, int i12, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "selectedSlot");
        this.vendorId = i11;
        this.customerCode = i12;
        this.selectedSlot = str;
    }

    private final int component1() {
        return this.vendorId;
    }

    private final int component2() {
        return this.customerCode;
    }

    private final String component3() {
        return this.selectedSlot;
    }

    public static /* synthetic */ ScheduleDeliveryConfirmedEvent copy$default(ScheduleDeliveryConfirmedEvent scheduleDeliveryConfirmedEvent, int i11, int i12, String str, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = scheduleDeliveryConfirmedEvent.vendorId;
        }
        if ((i13 & 2) != 0) {
            i12 = scheduleDeliveryConfirmedEvent.customerCode;
        }
        if ((i13 & 4) != 0) {
            str = scheduleDeliveryConfirmedEvent.selectedSlot;
        }
        return scheduleDeliveryConfirmedEvent.copy(i11, i12, str);
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return MapsKt__MapsKt.mapOf(TuplesKt.to("shopId", Integer.valueOf(this.vendorId)), TuplesKt.to("screenName", "checkout"), TuplesKt.to("shopType", "darkstores"), TuplesKt.to("customerCode", Integer.valueOf(this.customerCode)), TuplesKt.to(ScheduledDeliveryEventConstantsKt.ATTRIBUTE_EVENT_LABEL, this.selectedSlot));
    }

    @NotNull
    public final ScheduleDeliveryConfirmedEvent copy(int i11, int i12, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "selectedSlot");
        return new ScheduleDeliveryConfirmedEvent(i11, i12, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ScheduleDeliveryConfirmedEvent)) {
            return false;
        }
        ScheduleDeliveryConfirmedEvent scheduleDeliveryConfirmedEvent = (ScheduleDeliveryConfirmedEvent) obj;
        return this.vendorId == scheduleDeliveryConfirmedEvent.vendorId && this.customerCode == scheduleDeliveryConfirmedEvent.customerCode && Intrinsics.areEqual((Object) this.selectedSlot, (Object) scheduleDeliveryConfirmedEvent.selectedSlot);
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return ScheduledDeliveryEventConstantsKt.FEATURE_SCHEDULED_DELIVERY;
    }

    public int hashCode() {
        return (((this.vendorId * 31) + this.customerCode) * 31) + this.selectedSlot.hashCode();
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return ScheduledDeliveryEventConstantsKt.EVENT_SCHEDULED_DELIVERY_CONFIRMED;
    }

    @NotNull
    public List<PlatformName> platforms() {
        return CollectionsKt__CollectionsJVMKt.listOf(PlatformName.GOOGLE_ANALYTICS);
    }

    @NotNull
    public String toString() {
        int i11 = this.vendorId;
        int i12 = this.customerCode;
        String str = this.selectedSlot;
        return "ScheduleDeliveryConfirmedEvent(vendorId=" + i11 + ", customerCode=" + i12 + ", selectedSlot=" + str + ")";
    }
}
