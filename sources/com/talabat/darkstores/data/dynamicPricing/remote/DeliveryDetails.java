package com.talabat.darkstores.data.dynamicPricing.remote;

import com.talabat.feature.darkstoresvendor.domain.model.BasketDeliveryFeeTiersInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\nHÆ\u0003J=\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/talabat/darkstores/data/dynamicPricing/remote/DeliveryDetails;", "", "deliveryFee", "", "deliveryTime", "", "minOrderValue", "basketDeliveryFeeTiersInfo", "Lcom/talabat/feature/darkstoresvendor/domain/model/BasketDeliveryFeeTiersInfo;", "isTPro", "", "(FLjava/lang/String;FLcom/talabat/feature/darkstoresvendor/domain/model/BasketDeliveryFeeTiersInfo;Z)V", "getBasketDeliveryFeeTiersInfo", "()Lcom/talabat/feature/darkstoresvendor/domain/model/BasketDeliveryFeeTiersInfo;", "getDeliveryFee", "()F", "getDeliveryTime", "()Ljava/lang/String;", "()Z", "getMinOrderValue", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DeliveryDetails {
    @Nullable
    private final BasketDeliveryFeeTiersInfo basketDeliveryFeeTiersInfo;
    private final float deliveryFee;
    @NotNull
    private final String deliveryTime;
    private final boolean isTPro;
    private final float minOrderValue;

    public DeliveryDetails(float f11, @NotNull String str, float f12, @Nullable BasketDeliveryFeeTiersInfo basketDeliveryFeeTiersInfo2, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "deliveryTime");
        this.deliveryFee = f11;
        this.deliveryTime = str;
        this.minOrderValue = f12;
        this.basketDeliveryFeeTiersInfo = basketDeliveryFeeTiersInfo2;
        this.isTPro = z11;
    }

    public static /* synthetic */ DeliveryDetails copy$default(DeliveryDetails deliveryDetails, float f11, String str, float f12, BasketDeliveryFeeTiersInfo basketDeliveryFeeTiersInfo2, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = deliveryDetails.deliveryFee;
        }
        if ((i11 & 2) != 0) {
            str = deliveryDetails.deliveryTime;
        }
        String str2 = str;
        if ((i11 & 4) != 0) {
            f12 = deliveryDetails.minOrderValue;
        }
        float f13 = f12;
        if ((i11 & 8) != 0) {
            basketDeliveryFeeTiersInfo2 = deliveryDetails.basketDeliveryFeeTiersInfo;
        }
        BasketDeliveryFeeTiersInfo basketDeliveryFeeTiersInfo3 = basketDeliveryFeeTiersInfo2;
        if ((i11 & 16) != 0) {
            z11 = deliveryDetails.isTPro;
        }
        return deliveryDetails.copy(f11, str2, f13, basketDeliveryFeeTiersInfo3, z11);
    }

    public final float component1() {
        return this.deliveryFee;
    }

    @NotNull
    public final String component2() {
        return this.deliveryTime;
    }

    public final float component3() {
        return this.minOrderValue;
    }

    @Nullable
    public final BasketDeliveryFeeTiersInfo component4() {
        return this.basketDeliveryFeeTiersInfo;
    }

    public final boolean component5() {
        return this.isTPro;
    }

    @NotNull
    public final DeliveryDetails copy(float f11, @NotNull String str, float f12, @Nullable BasketDeliveryFeeTiersInfo basketDeliveryFeeTiersInfo2, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "deliveryTime");
        return new DeliveryDetails(f11, str, f12, basketDeliveryFeeTiersInfo2, z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeliveryDetails)) {
            return false;
        }
        DeliveryDetails deliveryDetails = (DeliveryDetails) obj;
        return Intrinsics.areEqual((Object) Float.valueOf(this.deliveryFee), (Object) Float.valueOf(deliveryDetails.deliveryFee)) && Intrinsics.areEqual((Object) this.deliveryTime, (Object) deliveryDetails.deliveryTime) && Intrinsics.areEqual((Object) Float.valueOf(this.minOrderValue), (Object) Float.valueOf(deliveryDetails.minOrderValue)) && Intrinsics.areEqual((Object) this.basketDeliveryFeeTiersInfo, (Object) deliveryDetails.basketDeliveryFeeTiersInfo) && this.isTPro == deliveryDetails.isTPro;
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

    public final float getMinOrderValue() {
        return this.minOrderValue;
    }

    public int hashCode() {
        int floatToIntBits = ((((Float.floatToIntBits(this.deliveryFee) * 31) + this.deliveryTime.hashCode()) * 31) + Float.floatToIntBits(this.minOrderValue)) * 31;
        BasketDeliveryFeeTiersInfo basketDeliveryFeeTiersInfo2 = this.basketDeliveryFeeTiersInfo;
        int hashCode = (floatToIntBits + (basketDeliveryFeeTiersInfo2 == null ? 0 : basketDeliveryFeeTiersInfo2.hashCode())) * 31;
        boolean z11 = this.isTPro;
        if (z11) {
            z11 = true;
        }
        return hashCode + (z11 ? 1 : 0);
    }

    public final boolean isTPro() {
        return this.isTPro;
    }

    @NotNull
    public String toString() {
        float f11 = this.deliveryFee;
        String str = this.deliveryTime;
        float f12 = this.minOrderValue;
        BasketDeliveryFeeTiersInfo basketDeliveryFeeTiersInfo2 = this.basketDeliveryFeeTiersInfo;
        boolean z11 = this.isTPro;
        return "DeliveryDetails(deliveryFee=" + f11 + ", deliveryTime=" + str + ", minOrderValue=" + f12 + ", basketDeliveryFeeTiersInfo=" + basketDeliveryFeeTiersInfo2 + ", isTPro=" + z11 + ")";
    }
}
