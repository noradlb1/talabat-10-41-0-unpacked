package com.talabat.feature.darkstorescarrierbag.domain.event;

import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import com.talabat.feature.pickup.data.events.ConstantsKt;
import com.talabat.observabilityNew.squads.nfv.ObservableAttributesNames;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\t\u0010\f\u001a\u00020\u0003HÂ\u0003J\t\u0010\r\u001a\u00020\u0003HÂ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÂ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\tHÖ\u0003J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0018H\u0016J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/talabat/feature/darkstorescarrierbag/domain/event/DarkstoresCarrierBagEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "eventName", "", "vendorCode", "popupButton", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "attributes", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "component1", "component2", "component3", "copy", "equals", "", "other", "featureName", "hashCode", "", "name", "platforms", "", "toString", "com_talabat_feature_darkstores-carrier-bag_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DarkstoresCarrierBagEvent extends TalabatEvent {
    @NotNull
    private final String eventName;
    @NotNull
    private final String popupButton;
    @NotNull
    private final String vendorCode;

    public DarkstoresCarrierBagEvent(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(str2, ObservableAttributesNames.VENDOR_CODE);
        Intrinsics.checkNotNullParameter(str3, ConstantsKt.POPUP_BUTTON);
        this.eventName = str;
        this.vendorCode = str2;
        this.popupButton = str3;
    }

    private final String component1() {
        return this.eventName;
    }

    private final String component2() {
        return this.vendorCode;
    }

    private final String component3() {
        return this.popupButton;
    }

    public static /* synthetic */ DarkstoresCarrierBagEvent copy$default(DarkstoresCarrierBagEvent darkstoresCarrierBagEvent, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = darkstoresCarrierBagEvent.eventName;
        }
        if ((i11 & 2) != 0) {
            str2 = darkstoresCarrierBagEvent.vendorCode;
        }
        if ((i11 & 4) != 0) {
            str3 = darkstoresCarrierBagEvent.popupButton;
        }
        return darkstoresCarrierBagEvent.copy(str, str2, str3);
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return MapsKt__MapsKt.mapOf(TuplesKt.to("bottomSheetName", "carrier_bag"), TuplesKt.to("screenType", "basket"), TuplesKt.to("screenName", "basket"), TuplesKt.to("eventOrigin", "basket"), TuplesKt.to("shopId", this.vendorCode), TuplesKt.to(ConstantsKt.POPUP_BUTTON, this.popupButton));
    }

    @NotNull
    public final DarkstoresCarrierBagEvent copy(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(str2, ObservableAttributesNames.VENDOR_CODE);
        Intrinsics.checkNotNullParameter(str3, ConstantsKt.POPUP_BUTTON);
        return new DarkstoresCarrierBagEvent(str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DarkstoresCarrierBagEvent)) {
            return false;
        }
        DarkstoresCarrierBagEvent darkstoresCarrierBagEvent = (DarkstoresCarrierBagEvent) obj;
        return Intrinsics.areEqual((Object) this.eventName, (Object) darkstoresCarrierBagEvent.eventName) && Intrinsics.areEqual((Object) this.vendorCode, (Object) darkstoresCarrierBagEvent.vendorCode) && Intrinsics.areEqual((Object) this.popupButton, (Object) darkstoresCarrierBagEvent.popupButton);
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "darkstores_carrier_bag";
    }

    public int hashCode() {
        return (((this.eventName.hashCode() * 31) + this.vendorCode.hashCode()) * 31) + this.popupButton.hashCode();
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return this.eventName;
    }

    @NotNull
    public List<PlatformName> platforms() {
        return CollectionsKt__CollectionsJVMKt.listOf(PlatformName.GOOGLE_ANALYTICS);
    }

    @NotNull
    public String toString() {
        String str = this.eventName;
        String str2 = this.vendorCode;
        String str3 = this.popupButton;
        return "DarkstoresCarrierBagEvent(eventName=" + str + ", vendorCode=" + str2 + ", popupButton=" + str3 + ")";
    }
}
