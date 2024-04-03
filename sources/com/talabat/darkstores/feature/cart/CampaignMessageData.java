package com.talabat.darkstores.feature.cart;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJB\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\n¨\u0006\u001f"}, d2 = {"Lcom/talabat/darkstores/feature/cart/CampaignMessageData;", "", "total", "", "cartDiscount", "deliveryDiscount", "subTotal", "subTotalAfterDiscount", "(FFFFLjava/lang/Float;)V", "getCartDiscount", "()F", "getDeliveryDiscount", "getSubTotal", "getSubTotalAfterDiscount", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getTotal", "component1", "component2", "component3", "component4", "component5", "copy", "(FFFFLjava/lang/Float;)Lcom/talabat/darkstores/feature/cart/CampaignMessageData;", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CampaignMessageData {
    private final float cartDiscount;
    private final float deliveryDiscount;
    private final float subTotal;
    @Nullable
    private final Float subTotalAfterDiscount;
    private final float total;

    public CampaignMessageData(float f11, float f12, float f13, float f14, @Nullable Float f15) {
        this.total = f11;
        this.cartDiscount = f12;
        this.deliveryDiscount = f13;
        this.subTotal = f14;
        this.subTotalAfterDiscount = f15;
    }

    public static /* synthetic */ CampaignMessageData copy$default(CampaignMessageData campaignMessageData, float f11, float f12, float f13, float f14, Float f15, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = campaignMessageData.total;
        }
        if ((i11 & 2) != 0) {
            f12 = campaignMessageData.cartDiscount;
        }
        float f16 = f12;
        if ((i11 & 4) != 0) {
            f13 = campaignMessageData.deliveryDiscount;
        }
        float f17 = f13;
        if ((i11 & 8) != 0) {
            f14 = campaignMessageData.subTotal;
        }
        float f18 = f14;
        if ((i11 & 16) != 0) {
            f15 = campaignMessageData.subTotalAfterDiscount;
        }
        return campaignMessageData.copy(f11, f16, f17, f18, f15);
    }

    public final float component1() {
        return this.total;
    }

    public final float component2() {
        return this.cartDiscount;
    }

    public final float component3() {
        return this.deliveryDiscount;
    }

    public final float component4() {
        return this.subTotal;
    }

    @Nullable
    public final Float component5() {
        return this.subTotalAfterDiscount;
    }

    @NotNull
    public final CampaignMessageData copy(float f11, float f12, float f13, float f14, @Nullable Float f15) {
        return new CampaignMessageData(f11, f12, f13, f14, f15);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CampaignMessageData)) {
            return false;
        }
        CampaignMessageData campaignMessageData = (CampaignMessageData) obj;
        return Intrinsics.areEqual((Object) Float.valueOf(this.total), (Object) Float.valueOf(campaignMessageData.total)) && Intrinsics.areEqual((Object) Float.valueOf(this.cartDiscount), (Object) Float.valueOf(campaignMessageData.cartDiscount)) && Intrinsics.areEqual((Object) Float.valueOf(this.deliveryDiscount), (Object) Float.valueOf(campaignMessageData.deliveryDiscount)) && Intrinsics.areEqual((Object) Float.valueOf(this.subTotal), (Object) Float.valueOf(campaignMessageData.subTotal)) && Intrinsics.areEqual((Object) this.subTotalAfterDiscount, (Object) campaignMessageData.subTotalAfterDiscount);
    }

    public final float getCartDiscount() {
        return this.cartDiscount;
    }

    public final float getDeliveryDiscount() {
        return this.deliveryDiscount;
    }

    public final float getSubTotal() {
        return this.subTotal;
    }

    @Nullable
    public final Float getSubTotalAfterDiscount() {
        return this.subTotalAfterDiscount;
    }

    public final float getTotal() {
        return this.total;
    }

    public int hashCode() {
        int floatToIntBits = ((((((Float.floatToIntBits(this.total) * 31) + Float.floatToIntBits(this.cartDiscount)) * 31) + Float.floatToIntBits(this.deliveryDiscount)) * 31) + Float.floatToIntBits(this.subTotal)) * 31;
        Float f11 = this.subTotalAfterDiscount;
        return floatToIntBits + (f11 == null ? 0 : f11.hashCode());
    }

    @NotNull
    public String toString() {
        float f11 = this.total;
        float f12 = this.cartDiscount;
        float f13 = this.deliveryDiscount;
        float f14 = this.subTotal;
        Float f15 = this.subTotalAfterDiscount;
        return "CampaignMessageData(total=" + f11 + ", cartDiscount=" + f12 + ", deliveryDiscount=" + f13 + ", subTotal=" + f14 + ", subTotalAfterDiscount=" + f15 + ")";
    }
}
