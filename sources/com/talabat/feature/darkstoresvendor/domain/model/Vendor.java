package com.talabat.feature.darkstoresvendor.domain.model;

import com.talabat.observabilityNew.squads.nfv.ObservableAttributesNames;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u000fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0006HÆ\u0003J\t\u0010\"\u001a\u00020\nHÆ\u0003J\t\u0010#\u001a\u00020\nHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\rHÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0019Jl\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020\n2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020+HÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0016R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015¨\u0006-"}, d2 = {"Lcom/talabat/feature/darkstoresvendor/domain/model/Vendor;", "", "vendorId", "", "vendorCode", "deliveryFee", "", "deliveryTime", "minimumOrderValue", "isTPro", "", "isVendorPro", "basketDeliveryFeeTiersInfo", "Lcom/talabat/feature/darkstoresvendor/domain/model/BasketDeliveryFeeTiersInfo;", "scheduleDeliveryDiscount", "(Ljava/lang/String;Ljava/lang/String;FLjava/lang/String;FZZLcom/talabat/feature/darkstoresvendor/domain/model/BasketDeliveryFeeTiersInfo;Ljava/lang/Float;)V", "getBasketDeliveryFeeTiersInfo", "()Lcom/talabat/feature/darkstoresvendor/domain/model/BasketDeliveryFeeTiersInfo;", "getDeliveryFee", "()F", "getDeliveryTime", "()Ljava/lang/String;", "()Z", "getMinimumOrderValue", "getScheduleDeliveryDiscount", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getVendorCode", "getVendorId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;FLjava/lang/String;FZZLcom/talabat/feature/darkstoresvendor/domain/model/BasketDeliveryFeeTiersInfo;Ljava/lang/Float;)Lcom/talabat/feature/darkstoresvendor/domain/model/Vendor;", "equals", "other", "hashCode", "", "toString", "com_talabat_feature_darkstores-vendor_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Vendor {
    @Nullable
    private final BasketDeliveryFeeTiersInfo basketDeliveryFeeTiersInfo;
    private final float deliveryFee;
    @NotNull
    private final String deliveryTime;
    private final boolean isTPro;
    private final boolean isVendorPro;
    private final float minimumOrderValue;
    @Nullable
    private final Float scheduleDeliveryDiscount;
    @NotNull
    private final String vendorCode;
    @NotNull
    private final String vendorId;

    public Vendor(@NotNull String str, @NotNull String str2, float f11, @NotNull String str3, float f12, boolean z11, boolean z12, @Nullable BasketDeliveryFeeTiersInfo basketDeliveryFeeTiersInfo2, @Nullable Float f13) {
        Intrinsics.checkNotNullParameter(str, "vendorId");
        Intrinsics.checkNotNullParameter(str2, ObservableAttributesNames.VENDOR_CODE);
        Intrinsics.checkNotNullParameter(str3, "deliveryTime");
        this.vendorId = str;
        this.vendorCode = str2;
        this.deliveryFee = f11;
        this.deliveryTime = str3;
        this.minimumOrderValue = f12;
        this.isTPro = z11;
        this.isVendorPro = z12;
        this.basketDeliveryFeeTiersInfo = basketDeliveryFeeTiersInfo2;
        this.scheduleDeliveryDiscount = f13;
    }

    public static /* synthetic */ Vendor copy$default(Vendor vendor, String str, String str2, float f11, String str3, float f12, boolean z11, boolean z12, BasketDeliveryFeeTiersInfo basketDeliveryFeeTiersInfo2, Float f13, int i11, Object obj) {
        Vendor vendor2 = vendor;
        int i12 = i11;
        return vendor.copy((i12 & 1) != 0 ? vendor2.vendorId : str, (i12 & 2) != 0 ? vendor2.vendorCode : str2, (i12 & 4) != 0 ? vendor2.deliveryFee : f11, (i12 & 8) != 0 ? vendor2.deliveryTime : str3, (i12 & 16) != 0 ? vendor2.minimumOrderValue : f12, (i12 & 32) != 0 ? vendor2.isTPro : z11, (i12 & 64) != 0 ? vendor2.isVendorPro : z12, (i12 & 128) != 0 ? vendor2.basketDeliveryFeeTiersInfo : basketDeliveryFeeTiersInfo2, (i12 & 256) != 0 ? vendor2.scheduleDeliveryDiscount : f13);
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

    public final boolean component6() {
        return this.isTPro;
    }

    public final boolean component7() {
        return this.isVendorPro;
    }

    @Nullable
    public final BasketDeliveryFeeTiersInfo component8() {
        return this.basketDeliveryFeeTiersInfo;
    }

    @Nullable
    public final Float component9() {
        return this.scheduleDeliveryDiscount;
    }

    @NotNull
    public final Vendor copy(@NotNull String str, @NotNull String str2, float f11, @NotNull String str3, float f12, boolean z11, boolean z12, @Nullable BasketDeliveryFeeTiersInfo basketDeliveryFeeTiersInfo2, @Nullable Float f13) {
        Intrinsics.checkNotNullParameter(str, "vendorId");
        Intrinsics.checkNotNullParameter(str2, ObservableAttributesNames.VENDOR_CODE);
        Intrinsics.checkNotNullParameter(str3, "deliveryTime");
        return new Vendor(str, str2, f11, str3, f12, z11, z12, basketDeliveryFeeTiersInfo2, f13);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Vendor)) {
            return false;
        }
        Vendor vendor = (Vendor) obj;
        return Intrinsics.areEqual((Object) this.vendorId, (Object) vendor.vendorId) && Intrinsics.areEqual((Object) this.vendorCode, (Object) vendor.vendorCode) && Intrinsics.areEqual((Object) Float.valueOf(this.deliveryFee), (Object) Float.valueOf(vendor.deliveryFee)) && Intrinsics.areEqual((Object) this.deliveryTime, (Object) vendor.deliveryTime) && Intrinsics.areEqual((Object) Float.valueOf(this.minimumOrderValue), (Object) Float.valueOf(vendor.minimumOrderValue)) && this.isTPro == vendor.isTPro && this.isVendorPro == vendor.isVendorPro && Intrinsics.areEqual((Object) this.basketDeliveryFeeTiersInfo, (Object) vendor.basketDeliveryFeeTiersInfo) && Intrinsics.areEqual((Object) this.scheduleDeliveryDiscount, (Object) vendor.scheduleDeliveryDiscount);
    }

    @Nullable
    public final BasketDeliveryFeeTiersInfo getBasketDeliveryFeeTiersInfo() {
        return this.basketDeliveryFeeTiersInfo;
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

    @Nullable
    public final Float getScheduleDeliveryDiscount() {
        return this.scheduleDeliveryDiscount;
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
        int hashCode = ((((((((this.vendorId.hashCode() * 31) + this.vendorCode.hashCode()) * 31) + Float.floatToIntBits(this.deliveryFee)) * 31) + this.deliveryTime.hashCode()) * 31) + Float.floatToIntBits(this.minimumOrderValue)) * 31;
        boolean z11 = this.isTPro;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int i11 = (hashCode + (z11 ? 1 : 0)) * 31;
        boolean z13 = this.isVendorPro;
        if (!z13) {
            z12 = z13;
        }
        int i12 = (i11 + (z12 ? 1 : 0)) * 31;
        BasketDeliveryFeeTiersInfo basketDeliveryFeeTiersInfo2 = this.basketDeliveryFeeTiersInfo;
        int i13 = 0;
        int hashCode2 = (i12 + (basketDeliveryFeeTiersInfo2 == null ? 0 : basketDeliveryFeeTiersInfo2.hashCode())) * 31;
        Float f11 = this.scheduleDeliveryDiscount;
        if (f11 != null) {
            i13 = f11.hashCode();
        }
        return hashCode2 + i13;
    }

    public final boolean isTPro() {
        return this.isTPro;
    }

    public final boolean isVendorPro() {
        return this.isVendorPro;
    }

    @NotNull
    public String toString() {
        String str = this.vendorId;
        String str2 = this.vendorCode;
        float f11 = this.deliveryFee;
        String str3 = this.deliveryTime;
        float f12 = this.minimumOrderValue;
        boolean z11 = this.isTPro;
        boolean z12 = this.isVendorPro;
        BasketDeliveryFeeTiersInfo basketDeliveryFeeTiersInfo2 = this.basketDeliveryFeeTiersInfo;
        Float f13 = this.scheduleDeliveryDiscount;
        return "Vendor(vendorId=" + str + ", vendorCode=" + str2 + ", deliveryFee=" + f11 + ", deliveryTime=" + str3 + ", minimumOrderValue=" + f12 + ", isTPro=" + z11 + ", isVendorPro=" + z12 + ", basketDeliveryFeeTiersInfo=" + basketDeliveryFeeTiersInfo2 + ", scheduleDeliveryDiscount=" + f13 + ")";
    }
}
