package com.talabat.talabatcommon.feature.pickupToggle.events;

import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\b\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00062\u0006\u0010\t\u001a\u00020\nH\u0016J\t\u0010\u000b\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\bHÖ\u0003J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\t\u0010\u0013\u001a\u00020\u0007HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/talabat/talabatcommon/feature/pickupToggle/events/OrderModeClickEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "pickupClicked", "", "(Z)V", "attributes", "", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "component1", "copy", "equals", "other", "featureName", "hashCode", "", "name", "toString", "Companion", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderModeClickEvent extends TalabatEvent {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String EVENT_NAME = "toggle_clicked";
    private final boolean pickupClicked;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/talabatcommon/feature/pickupToggle/events/OrderModeClickEvent$Companion;", "", "()V", "EVENT_NAME", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public OrderModeClickEvent(boolean z11) {
        this.pickupClicked = z11;
    }

    private final boolean component1() {
        return this.pickupClicked;
    }

    public static /* synthetic */ OrderModeClickEvent copy$default(OrderModeClickEvent orderModeClickEvent, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = orderModeClickEvent.pickupClicked;
        }
        return orderModeClickEvent.copy(z11);
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(platformName, "platform");
        Pair[] pairArr = new Pair[3];
        pairArr[0] = TuplesKt.to("screenType", "shop_list");
        if (this.pickupClicked) {
            str = "pickup_vendor_list";
        } else {
            str = "Restaurant List Screen";
        }
        pairArr[1] = TuplesKt.to("screenName", str);
        if (this.pickupClicked) {
            str2 = "for_pickup";
        } else {
            str2 = "for_delivery";
        }
        pairArr[2] = TuplesKt.to("toggleName", str2);
        return MapsKt__MapsKt.mutableMapOf(pairArr);
    }

    @NotNull
    public final OrderModeClickEvent copy(boolean z11) {
        return new OrderModeClickEvent(z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof OrderModeClickEvent) && this.pickupClicked == ((OrderModeClickEvent) obj).pickupClicked;
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "pickup";
    }

    public int hashCode() {
        boolean z11 = this.pickupClicked;
        if (z11) {
            return 1;
        }
        return z11 ? 1 : 0;
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return EVENT_NAME;
    }

    @NotNull
    public String toString() {
        boolean z11 = this.pickupClicked;
        return "OrderModeClickEvent(pickupClicked=" + z11 + ")";
    }
}
