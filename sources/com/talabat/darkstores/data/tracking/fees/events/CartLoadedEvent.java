package com.talabat.darkstores.data.tracking.fees.events;

import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import com.talabat.darkstores.data.tracking.fees.FeeTrackingConstantsKt;
import com.talabat.darkstores.data.tracking.fees.FeeTrackingUtilsKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u001e\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J>\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\u0010\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\u0010\u0010!\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\t\u0010\"\u001a\u00020\u0007HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\nR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006#"}, d2 = {"Lcom/talabat/darkstores/data/tracking/fees/events/CartLoadedEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "deliveryFee", "", "serviceFee", "total", "vendorId", "", "(Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;)V", "getDeliveryFee", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getServiceFee", "getTotal", "getVendorId", "()Ljava/lang/String;", "attributes", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;)Lcom/talabat/darkstores/data/tracking/fees/events/CartLoadedEvent;", "equals", "", "other", "", "featureName", "hashCode", "", "name", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CartLoadedEvent extends TalabatEvent {
    @Nullable
    private final Float deliveryFee;
    @Nullable
    private final Float serviceFee;
    @Nullable
    private final Float total;
    @Nullable
    private final String vendorId;

    public CartLoadedEvent(@Nullable Float f11, @Nullable Float f12, @Nullable Float f13, @Nullable String str) {
        this.deliveryFee = f11;
        this.serviceFee = f12;
        this.total = f13;
        this.vendorId = str;
    }

    public static /* synthetic */ CartLoadedEvent copy$default(CartLoadedEvent cartLoadedEvent, Float f11, Float f12, Float f13, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = cartLoadedEvent.deliveryFee;
        }
        if ((i11 & 2) != 0) {
            f12 = cartLoadedEvent.serviceFee;
        }
        if ((i11 & 4) != 0) {
            f13 = cartLoadedEvent.total;
        }
        if ((i11 & 8) != 0) {
            str = cartLoadedEvent.vendorId;
        }
        return cartLoadedEvent.copy(f11, f12, f13, str);
    }

    @NotNull
    public Map<String, String> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return FeeTrackingUtilsKt.getCheckoutTrackingData(this.deliveryFee, this.serviceFee, this.total, this.vendorId);
    }

    @Nullable
    public final Float component1() {
        return this.deliveryFee;
    }

    @Nullable
    public final Float component2() {
        return this.serviceFee;
    }

    @Nullable
    public final Float component3() {
        return this.total;
    }

    @Nullable
    public final String component4() {
        return this.vendorId;
    }

    @NotNull
    public final CartLoadedEvent copy(@Nullable Float f11, @Nullable Float f12, @Nullable Float f13, @Nullable String str) {
        return new CartLoadedEvent(f11, f12, f13, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CartLoadedEvent)) {
            return false;
        }
        CartLoadedEvent cartLoadedEvent = (CartLoadedEvent) obj;
        return Intrinsics.areEqual((Object) this.deliveryFee, (Object) cartLoadedEvent.deliveryFee) && Intrinsics.areEqual((Object) this.serviceFee, (Object) cartLoadedEvent.serviceFee) && Intrinsics.areEqual((Object) this.total, (Object) cartLoadedEvent.total) && Intrinsics.areEqual((Object) this.vendorId, (Object) cartLoadedEvent.vendorId);
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "darkstores";
    }

    @Nullable
    public final Float getDeliveryFee() {
        return this.deliveryFee;
    }

    @Nullable
    public final Float getServiceFee() {
        return this.serviceFee;
    }

    @Nullable
    public final Float getTotal() {
        return this.total;
    }

    @Nullable
    public final String getVendorId() {
        return this.vendorId;
    }

    public int hashCode() {
        Float f11 = this.deliveryFee;
        int i11 = 0;
        int hashCode = (f11 == null ? 0 : f11.hashCode()) * 31;
        Float f12 = this.serviceFee;
        int hashCode2 = (hashCode + (f12 == null ? 0 : f12.hashCode())) * 31;
        Float f13 = this.total;
        int hashCode3 = (hashCode2 + (f13 == null ? 0 : f13.hashCode())) * 31;
        String str = this.vendorId;
        if (str != null) {
            i11 = str.hashCode();
        }
        return hashCode3 + i11;
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return FeeTrackingConstantsKt.EVENT_CART_LOADED;
    }

    @NotNull
    public String toString() {
        Float f11 = this.deliveryFee;
        Float f12 = this.serviceFee;
        Float f13 = this.total;
        String str = this.vendorId;
        return "CartLoadedEvent(deliveryFee=" + f11 + ", serviceFee=" + f12 + ", total=" + f13 + ", vendorId=" + str + ")";
    }
}
