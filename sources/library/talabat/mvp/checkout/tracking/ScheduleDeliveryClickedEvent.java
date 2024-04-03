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

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\t\u001a\u00020\nH\u0016J\t\u0010\u000b\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\bHÖ\u0003J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\u0014H\u0016J\t\u0010\u0015\u001a\u00020\u0007HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Llibrary/talabat/mvp/checkout/tracking/ScheduleDeliveryClickedEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "vendorId", "", "(I)V", "attributes", "", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "component1", "copy", "equals", "", "other", "featureName", "hashCode", "name", "platforms", "", "toString", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ScheduleDeliveryClickedEvent extends TalabatEvent {
    private final int vendorId;

    public ScheduleDeliveryClickedEvent(int i11) {
        this.vendorId = i11;
    }

    private final int component1() {
        return this.vendorId;
    }

    public static /* synthetic */ ScheduleDeliveryClickedEvent copy$default(ScheduleDeliveryClickedEvent scheduleDeliveryClickedEvent, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = scheduleDeliveryClickedEvent.vendorId;
        }
        return scheduleDeliveryClickedEvent.copy(i11);
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return MapsKt__MapsKt.mapOf(TuplesKt.to("shopId", Integer.valueOf(this.vendorId)), TuplesKt.to("screenName", "checkout"));
    }

    @NotNull
    public final ScheduleDeliveryClickedEvent copy(int i11) {
        return new ScheduleDeliveryClickedEvent(i11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ScheduleDeliveryClickedEvent) && this.vendorId == ((ScheduleDeliveryClickedEvent) obj).vendorId;
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return ScheduledDeliveryEventConstantsKt.FEATURE_SCHEDULED_DELIVERY;
    }

    public int hashCode() {
        return this.vendorId;
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return ScheduledDeliveryEventConstantsKt.EVENT_SCHEDULED_DELIVERY_CLICKED;
    }

    @NotNull
    public List<PlatformName> platforms() {
        return CollectionsKt__CollectionsJVMKt.listOf(PlatformName.GOOGLE_ANALYTICS);
    }

    @NotNull
    public String toString() {
        int i11 = this.vendorId;
        return "ScheduleDeliveryClickedEvent(vendorId=" + i11 + ")";
    }
}
