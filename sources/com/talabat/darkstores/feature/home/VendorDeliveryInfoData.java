package com.talabat.darkstores.feature.home;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003JM\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0001J\u0013\u0010\u001f\u001a\u00020\t2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006$"}, d2 = {"Lcom/talabat/darkstores/feature/home/VendorDeliveryInfoData;", "", "deliveryTime", "", "deliveryFee", "", "minOrderValue", "deliveryFeeRange", "enableBasketBasedDeliveryFee", "", "onDeliveryInfoIconClicked", "Lkotlin/Function0;", "", "(Ljava/lang/String;FFLjava/lang/String;ZLkotlin/jvm/functions/Function0;)V", "getDeliveryFee", "()F", "getDeliveryFeeRange", "()Ljava/lang/String;", "getDeliveryTime", "getEnableBasketBasedDeliveryFee", "()Z", "getMinOrderValue", "getOnDeliveryInfoIconClicked", "()Lkotlin/jvm/functions/Function0;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorDeliveryInfoData {
    private final float deliveryFee;
    @Nullable
    private final String deliveryFeeRange;
    @NotNull
    private final String deliveryTime;
    private final boolean enableBasketBasedDeliveryFee;
    private final float minOrderValue;
    @NotNull
    private final Function0<Unit> onDeliveryInfoIconClicked;

    public VendorDeliveryInfoData(@NotNull String str, float f11, float f12, @Nullable String str2, boolean z11, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, "deliveryTime");
        Intrinsics.checkNotNullParameter(function0, "onDeliveryInfoIconClicked");
        this.deliveryTime = str;
        this.deliveryFee = f11;
        this.minOrderValue = f12;
        this.deliveryFeeRange = str2;
        this.enableBasketBasedDeliveryFee = z11;
        this.onDeliveryInfoIconClicked = function0;
    }

    public static /* synthetic */ VendorDeliveryInfoData copy$default(VendorDeliveryInfoData vendorDeliveryInfoData, String str, float f11, float f12, String str2, boolean z11, Function0<Unit> function0, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = vendorDeliveryInfoData.deliveryTime;
        }
        if ((i11 & 2) != 0) {
            f11 = vendorDeliveryInfoData.deliveryFee;
        }
        float f13 = f11;
        if ((i11 & 4) != 0) {
            f12 = vendorDeliveryInfoData.minOrderValue;
        }
        float f14 = f12;
        if ((i11 & 8) != 0) {
            str2 = vendorDeliveryInfoData.deliveryFeeRange;
        }
        String str3 = str2;
        if ((i11 & 16) != 0) {
            z11 = vendorDeliveryInfoData.enableBasketBasedDeliveryFee;
        }
        boolean z12 = z11;
        if ((i11 & 32) != 0) {
            function0 = vendorDeliveryInfoData.onDeliveryInfoIconClicked;
        }
        return vendorDeliveryInfoData.copy(str, f13, f14, str3, z12, function0);
    }

    @NotNull
    public final String component1() {
        return this.deliveryTime;
    }

    public final float component2() {
        return this.deliveryFee;
    }

    public final float component3() {
        return this.minOrderValue;
    }

    @Nullable
    public final String component4() {
        return this.deliveryFeeRange;
    }

    public final boolean component5() {
        return this.enableBasketBasedDeliveryFee;
    }

    @NotNull
    public final Function0<Unit> component6() {
        return this.onDeliveryInfoIconClicked;
    }

    @NotNull
    public final VendorDeliveryInfoData copy(@NotNull String str, float f11, float f12, @Nullable String str2, boolean z11, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, "deliveryTime");
        Intrinsics.checkNotNullParameter(function0, "onDeliveryInfoIconClicked");
        return new VendorDeliveryInfoData(str, f11, f12, str2, z11, function0);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VendorDeliveryInfoData)) {
            return false;
        }
        VendorDeliveryInfoData vendorDeliveryInfoData = (VendorDeliveryInfoData) obj;
        return Intrinsics.areEqual((Object) this.deliveryTime, (Object) vendorDeliveryInfoData.deliveryTime) && Intrinsics.areEqual((Object) Float.valueOf(this.deliveryFee), (Object) Float.valueOf(vendorDeliveryInfoData.deliveryFee)) && Intrinsics.areEqual((Object) Float.valueOf(this.minOrderValue), (Object) Float.valueOf(vendorDeliveryInfoData.minOrderValue)) && Intrinsics.areEqual((Object) this.deliveryFeeRange, (Object) vendorDeliveryInfoData.deliveryFeeRange) && this.enableBasketBasedDeliveryFee == vendorDeliveryInfoData.enableBasketBasedDeliveryFee && Intrinsics.areEqual((Object) this.onDeliveryInfoIconClicked, (Object) vendorDeliveryInfoData.onDeliveryInfoIconClicked);
    }

    public final float getDeliveryFee() {
        return this.deliveryFee;
    }

    @Nullable
    public final String getDeliveryFeeRange() {
        return this.deliveryFeeRange;
    }

    @NotNull
    public final String getDeliveryTime() {
        return this.deliveryTime;
    }

    public final boolean getEnableBasketBasedDeliveryFee() {
        return this.enableBasketBasedDeliveryFee;
    }

    public final float getMinOrderValue() {
        return this.minOrderValue;
    }

    @NotNull
    public final Function0<Unit> getOnDeliveryInfoIconClicked() {
        return this.onDeliveryInfoIconClicked;
    }

    public int hashCode() {
        int hashCode = ((((this.deliveryTime.hashCode() * 31) + Float.floatToIntBits(this.deliveryFee)) * 31) + Float.floatToIntBits(this.minOrderValue)) * 31;
        String str = this.deliveryFeeRange;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        boolean z11 = this.enableBasketBasedDeliveryFee;
        if (z11) {
            z11 = true;
        }
        return ((hashCode2 + (z11 ? 1 : 0)) * 31) + this.onDeliveryInfoIconClicked.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.deliveryTime;
        float f11 = this.deliveryFee;
        float f12 = this.minOrderValue;
        String str2 = this.deliveryFeeRange;
        boolean z11 = this.enableBasketBasedDeliveryFee;
        Function0<Unit> function0 = this.onDeliveryInfoIconClicked;
        return "VendorDeliveryInfoData(deliveryTime=" + str + ", deliveryFee=" + f11 + ", minOrderValue=" + f12 + ", deliveryFeeRange=" + str2 + ", enableBasketBasedDeliveryFee=" + z11 + ", onDeliveryInfoIconClicked=" + function0 + ")";
    }
}
