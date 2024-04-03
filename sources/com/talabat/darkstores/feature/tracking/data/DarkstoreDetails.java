package com.talabat.darkstores.feature.tracking.data;

import com.talabat.observabilityNew.squads.nfv.ObservableAttributesNames;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/talabat/darkstores/feature/tracking/data/DarkstoreDetails;", "", "vendorId", "", "vendorCode", "deliveryFee", "", "deliveryTime", "minimumOrderValue", "(Ljava/lang/String;Ljava/lang/String;FLjava/lang/String;F)V", "getDeliveryFee", "()F", "getDeliveryTime", "()Ljava/lang/String;", "getMinimumOrderValue", "getVendorCode", "getVendorId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DarkstoreDetails {
    private final float deliveryFee;
    @NotNull
    private final String deliveryTime;
    private final float minimumOrderValue;
    @NotNull
    private final String vendorCode;
    @NotNull
    private final String vendorId;

    public DarkstoreDetails(@NotNull String str, @NotNull String str2, float f11, @NotNull String str3, float f12) {
        Intrinsics.checkNotNullParameter(str, "vendorId");
        Intrinsics.checkNotNullParameter(str2, ObservableAttributesNames.VENDOR_CODE);
        Intrinsics.checkNotNullParameter(str3, "deliveryTime");
        this.vendorId = str;
        this.vendorCode = str2;
        this.deliveryFee = f11;
        this.deliveryTime = str3;
        this.minimumOrderValue = f12;
    }

    public static /* synthetic */ DarkstoreDetails copy$default(DarkstoreDetails darkstoreDetails, String str, String str2, float f11, String str3, float f12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = darkstoreDetails.vendorId;
        }
        if ((i11 & 2) != 0) {
            str2 = darkstoreDetails.vendorCode;
        }
        String str4 = str2;
        if ((i11 & 4) != 0) {
            f11 = darkstoreDetails.deliveryFee;
        }
        float f13 = f11;
        if ((i11 & 8) != 0) {
            str3 = darkstoreDetails.deliveryTime;
        }
        String str5 = str3;
        if ((i11 & 16) != 0) {
            f12 = darkstoreDetails.minimumOrderValue;
        }
        return darkstoreDetails.copy(str, str4, f13, str5, f12);
    }

    @NotNull
    public final String component1() {
        return this.vendorId;
    }

    @NotNull
    public final String component2() {
        return this.vendorCode;
    }

    public final float component3() {
        return this.deliveryFee;
    }

    @NotNull
    public final String component4() {
        return this.deliveryTime;
    }

    public final float component5() {
        return this.minimumOrderValue;
    }

    @NotNull
    public final DarkstoreDetails copy(@NotNull String str, @NotNull String str2, float f11, @NotNull String str3, float f12) {
        Intrinsics.checkNotNullParameter(str, "vendorId");
        Intrinsics.checkNotNullParameter(str2, ObservableAttributesNames.VENDOR_CODE);
        Intrinsics.checkNotNullParameter(str3, "deliveryTime");
        return new DarkstoreDetails(str, str2, f11, str3, f12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DarkstoreDetails)) {
            return false;
        }
        DarkstoreDetails darkstoreDetails = (DarkstoreDetails) obj;
        return Intrinsics.areEqual((Object) this.vendorId, (Object) darkstoreDetails.vendorId) && Intrinsics.areEqual((Object) this.vendorCode, (Object) darkstoreDetails.vendorCode) && Intrinsics.areEqual((Object) Float.valueOf(this.deliveryFee), (Object) Float.valueOf(darkstoreDetails.deliveryFee)) && Intrinsics.areEqual((Object) this.deliveryTime, (Object) darkstoreDetails.deliveryTime) && Intrinsics.areEqual((Object) Float.valueOf(this.minimumOrderValue), (Object) Float.valueOf(darkstoreDetails.minimumOrderValue));
    }

    public final float getDeliveryFee() {
        return this.deliveryFee;
    }

    @NotNull
    public final String getDeliveryTime() {
        return this.deliveryTime;
    }

    public final float getMinimumOrderValue() {
        return this.minimumOrderValue;
    }

    @NotNull
    public final String getVendorCode() {
        return this.vendorCode;
    }

    @NotNull
    public final String getVendorId() {
        return this.vendorId;
    }

    public int hashCode() {
        return (((((((this.vendorId.hashCode() * 31) + this.vendorCode.hashCode()) * 31) + Float.floatToIntBits(this.deliveryFee)) * 31) + this.deliveryTime.hashCode()) * 31) + Float.floatToIntBits(this.minimumOrderValue);
    }

    @NotNull
    public String toString() {
        String str = this.vendorId;
        String str2 = this.vendorCode;
        float f11 = this.deliveryFee;
        String str3 = this.deliveryTime;
        float f12 = this.minimumOrderValue;
        return "DarkstoreDetails(vendorId=" + str + ", vendorCode=" + str2 + ", deliveryFee=" + f11 + ", deliveryTime=" + str3 + ", minimumOrderValue=" + f12 + ")";
    }
}
