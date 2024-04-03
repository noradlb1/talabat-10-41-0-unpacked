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

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u001e\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003JJ\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\u0010\u0010!\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\t\u0010\"\u001a\u00020#HÖ\u0001J\u0010\u0010$\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000f\u0010\u000bR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0010\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006&"}, d2 = {"Lcom/talabat/darkstores/data/tracking/fees/events/PaymentSummaryExpandedEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "vendorId", "", "deliveryFee", "", "serviceFee", "total", "screenName", "(Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;)V", "getDeliveryFee", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getScreenName", "()Ljava/lang/String;", "getServiceFee", "getTotal", "getVendorId", "attributes", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;)Lcom/talabat/darkstores/data/tracking/fees/events/PaymentSummaryExpandedEvent;", "equals", "", "other", "", "featureName", "hashCode", "", "name", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PaymentSummaryExpandedEvent extends TalabatEvent {
    @Nullable
    private final Float deliveryFee;
    @Nullable
    private final String screenName;
    @Nullable
    private final Float serviceFee;
    @Nullable
    private final Float total;
    @Nullable
    private final String vendorId;

    public PaymentSummaryExpandedEvent(@Nullable String str, @Nullable Float f11, @Nullable Float f12, @Nullable Float f13, @Nullable String str2) {
        this.vendorId = str;
        this.deliveryFee = f11;
        this.serviceFee = f12;
        this.total = f13;
        this.screenName = str2;
    }

    public static /* synthetic */ PaymentSummaryExpandedEvent copy$default(PaymentSummaryExpandedEvent paymentSummaryExpandedEvent, String str, Float f11, Float f12, Float f13, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = paymentSummaryExpandedEvent.vendorId;
        }
        if ((i11 & 2) != 0) {
            f11 = paymentSummaryExpandedEvent.deliveryFee;
        }
        Float f14 = f11;
        if ((i11 & 4) != 0) {
            f12 = paymentSummaryExpandedEvent.serviceFee;
        }
        Float f15 = f12;
        if ((i11 & 8) != 0) {
            f13 = paymentSummaryExpandedEvent.total;
        }
        Float f16 = f13;
        if ((i11 & 16) != 0) {
            str2 = paymentSummaryExpandedEvent.screenName;
        }
        return paymentSummaryExpandedEvent.copy(str, f14, f15, f16, str2);
    }

    @NotNull
    public Map<String, String> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        Map feeInfoTrackingData$default = FeeTrackingUtilsKt.getFeeInfoTrackingData$default(this.vendorId, this.screenName, (String) null, 4, (Object) null);
        feeInfoTrackingData$default.putAll(FeeTrackingUtilsKt.getCheckoutTrackingData(this.deliveryFee, this.serviceFee, this.total, this.vendorId));
        return MapsKt__MapsKt.toMap(feeInfoTrackingData$default);
    }

    @Nullable
    public final String component1() {
        return this.vendorId;
    }

    @Nullable
    public final Float component2() {
        return this.deliveryFee;
    }

    @Nullable
    public final Float component3() {
        return this.serviceFee;
    }

    @Nullable
    public final Float component4() {
        return this.total;
    }

    @Nullable
    public final String component5() {
        return this.screenName;
    }

    @NotNull
    public final PaymentSummaryExpandedEvent copy(@Nullable String str, @Nullable Float f11, @Nullable Float f12, @Nullable Float f13, @Nullable String str2) {
        return new PaymentSummaryExpandedEvent(str, f11, f12, f13, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaymentSummaryExpandedEvent)) {
            return false;
        }
        PaymentSummaryExpandedEvent paymentSummaryExpandedEvent = (PaymentSummaryExpandedEvent) obj;
        return Intrinsics.areEqual((Object) this.vendorId, (Object) paymentSummaryExpandedEvent.vendorId) && Intrinsics.areEqual((Object) this.deliveryFee, (Object) paymentSummaryExpandedEvent.deliveryFee) && Intrinsics.areEqual((Object) this.serviceFee, (Object) paymentSummaryExpandedEvent.serviceFee) && Intrinsics.areEqual((Object) this.total, (Object) paymentSummaryExpandedEvent.total) && Intrinsics.areEqual((Object) this.screenName, (Object) paymentSummaryExpandedEvent.screenName);
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
    public final String getScreenName() {
        return this.screenName;
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
        String str = this.vendorId;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Float f11 = this.deliveryFee;
        int hashCode2 = (hashCode + (f11 == null ? 0 : f11.hashCode())) * 31;
        Float f12 = this.serviceFee;
        int hashCode3 = (hashCode2 + (f12 == null ? 0 : f12.hashCode())) * 31;
        Float f13 = this.total;
        int hashCode4 = (hashCode3 + (f13 == null ? 0 : f13.hashCode())) * 31;
        String str2 = this.screenName;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return hashCode4 + i11;
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return FeeTrackingConstantsKt.EVENT_FEE_DETAILS_EXPANDED;
    }

    @NotNull
    public String toString() {
        String str = this.vendorId;
        Float f11 = this.deliveryFee;
        Float f12 = this.serviceFee;
        Float f13 = this.total;
        String str2 = this.screenName;
        return "PaymentSummaryExpandedEvent(vendorId=" + str + ", deliveryFee=" + f11 + ", serviceFee=" + f12 + ", total=" + f13 + ", screenName=" + str2 + ")";
    }
}
