package com.talabat.darkstores.feature.cart;

import com.talabat.feature.darkstorescart.data.model.CampaignLabel;
import com.talabat.feature.darkstorescart.data.model.FeeDescription;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0010¢\u0006\u0002\u0010\u0014J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003J\u000f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010HÆ\u0003J\u000f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00130\u0010HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\u0010\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001eJ\t\u00100\u001a\u00020\u0005HÆ\u0003J\u0010\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001eJ\t\u00103\u001a\u00020\u0005HÆ\u0003J\t\u00104\u001a\u00020\u0005HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J¢\u0001\u00106\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0010HÆ\u0001¢\u0006\u0002\u00107J\u0013\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010;\u001a\u00020<HÖ\u0001J\t\u0010=\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0010¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0016R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b$\u0010\u001eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0016R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b&\u0010\u001eR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\"R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0016¨\u0006>"}, d2 = {"Lcom/talabat/darkstores/feature/cart/CartSummary;", "", "id", "", "subtotal", "", "subtotalAfterDiscount", "deliveryFee", "deliveryFeeBeforeDiscount", "serviceFee", "offerDiscount", "total", "targetAudience", "deliveryAbsoluteDiscount", "absoluteDiscount", "appliedCampaigns", "", "Lcom/talabat/feature/darkstorescart/data/model/CampaignLabel;", "feeDescriptions", "Lcom/talabat/feature/darkstorescart/data/model/FeeDescription;", "(Ljava/lang/String;FLjava/lang/Float;FLjava/lang/Float;Ljava/lang/Float;FFLjava/lang/String;FFLjava/util/List;Ljava/util/List;)V", "getAbsoluteDiscount", "()F", "getAppliedCampaigns", "()Ljava/util/List;", "cartSummaryPrice", "getCartSummaryPrice", "getDeliveryAbsoluteDiscount", "getDeliveryFee", "getDeliveryFeeBeforeDiscount", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getFeeDescriptions", "getId", "()Ljava/lang/String;", "getOfferDiscount", "getServiceFee", "getSubtotal", "getSubtotalAfterDiscount", "getTargetAudience", "getTotal", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;FLjava/lang/Float;FLjava/lang/Float;Ljava/lang/Float;FFLjava/lang/String;FFLjava/util/List;Ljava/util/List;)Lcom/talabat/darkstores/feature/cart/CartSummary;", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CartSummary {
    private final float absoluteDiscount;
    @NotNull
    private final List<CampaignLabel> appliedCampaigns;
    private final float cartSummaryPrice;
    private final float deliveryAbsoluteDiscount;
    private final float deliveryFee;
    @Nullable
    private final Float deliveryFeeBeforeDiscount;
    @NotNull
    private final List<FeeDescription> feeDescriptions;
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private final String f56285id;
    private final float offerDiscount;
    @Nullable
    private final Float serviceFee;
    private final float subtotal;
    @Nullable
    private final Float subtotalAfterDiscount;
    @NotNull
    private final String targetAudience;
    private final float total;

    public CartSummary(@NotNull String str, float f11, @Nullable Float f12, float f13, @Nullable Float f14, @Nullable Float f15, float f16, float f17, @NotNull String str2, float f18, float f19, @NotNull List<CampaignLabel> list, @NotNull List<FeeDescription> list2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "targetAudience");
        Intrinsics.checkNotNullParameter(list, "appliedCampaigns");
        Intrinsics.checkNotNullParameter(list2, "feeDescriptions");
        this.f56285id = str;
        this.subtotal = f11;
        this.subtotalAfterDiscount = f12;
        this.deliveryFee = f13;
        this.deliveryFeeBeforeDiscount = f14;
        this.serviceFee = f15;
        this.offerDiscount = f16;
        this.total = f17;
        this.targetAudience = str2;
        this.deliveryAbsoluteDiscount = f18;
        this.absoluteDiscount = f19;
        this.appliedCampaigns = list;
        this.feeDescriptions = list2;
        this.cartSummaryPrice = f12 != null ? f12.floatValue() : f11;
    }

    public static /* synthetic */ CartSummary copy$default(CartSummary cartSummary, String str, float f11, Float f12, float f13, Float f14, Float f15, float f16, float f17, String str2, float f18, float f19, List list, List list2, int i11, Object obj) {
        CartSummary cartSummary2 = cartSummary;
        int i12 = i11;
        return cartSummary.copy((i12 & 1) != 0 ? cartSummary2.f56285id : str, (i12 & 2) != 0 ? cartSummary2.subtotal : f11, (i12 & 4) != 0 ? cartSummary2.subtotalAfterDiscount : f12, (i12 & 8) != 0 ? cartSummary2.deliveryFee : f13, (i12 & 16) != 0 ? cartSummary2.deliveryFeeBeforeDiscount : f14, (i12 & 32) != 0 ? cartSummary2.serviceFee : f15, (i12 & 64) != 0 ? cartSummary2.offerDiscount : f16, (i12 & 128) != 0 ? cartSummary2.total : f17, (i12 & 256) != 0 ? cartSummary2.targetAudience : str2, (i12 & 512) != 0 ? cartSummary2.deliveryAbsoluteDiscount : f18, (i12 & 1024) != 0 ? cartSummary2.absoluteDiscount : f19, (i12 & 2048) != 0 ? cartSummary2.appliedCampaigns : list, (i12 & 4096) != 0 ? cartSummary2.feeDescriptions : list2);
    }

    @NotNull
    public final String component1() {
        return this.f56285id;
    }

    public final float component10() {
        return this.deliveryAbsoluteDiscount;
    }

    public final float component11() {
        return this.absoluteDiscount;
    }

    @NotNull
    public final List<CampaignLabel> component12() {
        return this.appliedCampaigns;
    }

    @NotNull
    public final List<FeeDescription> component13() {
        return this.feeDescriptions;
    }

    public final float component2() {
        return this.subtotal;
    }

    @Nullable
    public final Float component3() {
        return this.subtotalAfterDiscount;
    }

    public final float component4() {
        return this.deliveryFee;
    }

    @Nullable
    public final Float component5() {
        return this.deliveryFeeBeforeDiscount;
    }

    @Nullable
    public final Float component6() {
        return this.serviceFee;
    }

    public final float component7() {
        return this.offerDiscount;
    }

    public final float component8() {
        return this.total;
    }

    @NotNull
    public final String component9() {
        return this.targetAudience;
    }

    @NotNull
    public final CartSummary copy(@NotNull String str, float f11, @Nullable Float f12, float f13, @Nullable Float f14, @Nullable Float f15, float f16, float f17, @NotNull String str2, float f18, float f19, @NotNull List<CampaignLabel> list, @NotNull List<FeeDescription> list2) {
        String str3 = str;
        Intrinsics.checkNotNullParameter(str3, "id");
        String str4 = str2;
        Intrinsics.checkNotNullParameter(str4, "targetAudience");
        List<CampaignLabel> list3 = list;
        Intrinsics.checkNotNullParameter(list3, "appliedCampaigns");
        List<FeeDescription> list4 = list2;
        Intrinsics.checkNotNullParameter(list4, "feeDescriptions");
        return new CartSummary(str3, f11, f12, f13, f14, f15, f16, f17, str4, f18, f19, list3, list4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CartSummary)) {
            return false;
        }
        CartSummary cartSummary = (CartSummary) obj;
        return Intrinsics.areEqual((Object) this.f56285id, (Object) cartSummary.f56285id) && Intrinsics.areEqual((Object) Float.valueOf(this.subtotal), (Object) Float.valueOf(cartSummary.subtotal)) && Intrinsics.areEqual((Object) this.subtotalAfterDiscount, (Object) cartSummary.subtotalAfterDiscount) && Intrinsics.areEqual((Object) Float.valueOf(this.deliveryFee), (Object) Float.valueOf(cartSummary.deliveryFee)) && Intrinsics.areEqual((Object) this.deliveryFeeBeforeDiscount, (Object) cartSummary.deliveryFeeBeforeDiscount) && Intrinsics.areEqual((Object) this.serviceFee, (Object) cartSummary.serviceFee) && Intrinsics.areEqual((Object) Float.valueOf(this.offerDiscount), (Object) Float.valueOf(cartSummary.offerDiscount)) && Intrinsics.areEqual((Object) Float.valueOf(this.total), (Object) Float.valueOf(cartSummary.total)) && Intrinsics.areEqual((Object) this.targetAudience, (Object) cartSummary.targetAudience) && Intrinsics.areEqual((Object) Float.valueOf(this.deliveryAbsoluteDiscount), (Object) Float.valueOf(cartSummary.deliveryAbsoluteDiscount)) && Intrinsics.areEqual((Object) Float.valueOf(this.absoluteDiscount), (Object) Float.valueOf(cartSummary.absoluteDiscount)) && Intrinsics.areEqual((Object) this.appliedCampaigns, (Object) cartSummary.appliedCampaigns) && Intrinsics.areEqual((Object) this.feeDescriptions, (Object) cartSummary.feeDescriptions);
    }

    public final float getAbsoluteDiscount() {
        return this.absoluteDiscount;
    }

    @NotNull
    public final List<CampaignLabel> getAppliedCampaigns() {
        return this.appliedCampaigns;
    }

    public final float getCartSummaryPrice() {
        return this.cartSummaryPrice;
    }

    public final float getDeliveryAbsoluteDiscount() {
        return this.deliveryAbsoluteDiscount;
    }

    public final float getDeliveryFee() {
        return this.deliveryFee;
    }

    @Nullable
    public final Float getDeliveryFeeBeforeDiscount() {
        return this.deliveryFeeBeforeDiscount;
    }

    @NotNull
    public final List<FeeDescription> getFeeDescriptions() {
        return this.feeDescriptions;
    }

    @NotNull
    public final String getId() {
        return this.f56285id;
    }

    public final float getOfferDiscount() {
        return this.offerDiscount;
    }

    @Nullable
    public final Float getServiceFee() {
        return this.serviceFee;
    }

    public final float getSubtotal() {
        return this.subtotal;
    }

    @Nullable
    public final Float getSubtotalAfterDiscount() {
        return this.subtotalAfterDiscount;
    }

    @NotNull
    public final String getTargetAudience() {
        return this.targetAudience;
    }

    public final float getTotal() {
        return this.total;
    }

    public int hashCode() {
        int hashCode = ((this.f56285id.hashCode() * 31) + Float.floatToIntBits(this.subtotal)) * 31;
        Float f11 = this.subtotalAfterDiscount;
        int i11 = 0;
        int hashCode2 = (((hashCode + (f11 == null ? 0 : f11.hashCode())) * 31) + Float.floatToIntBits(this.deliveryFee)) * 31;
        Float f12 = this.deliveryFeeBeforeDiscount;
        int hashCode3 = (hashCode2 + (f12 == null ? 0 : f12.hashCode())) * 31;
        Float f13 = this.serviceFee;
        if (f13 != null) {
            i11 = f13.hashCode();
        }
        return ((((((((((((((hashCode3 + i11) * 31) + Float.floatToIntBits(this.offerDiscount)) * 31) + Float.floatToIntBits(this.total)) * 31) + this.targetAudience.hashCode()) * 31) + Float.floatToIntBits(this.deliveryAbsoluteDiscount)) * 31) + Float.floatToIntBits(this.absoluteDiscount)) * 31) + this.appliedCampaigns.hashCode()) * 31) + this.feeDescriptions.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.f56285id;
        float f11 = this.subtotal;
        Float f12 = this.subtotalAfterDiscount;
        float f13 = this.deliveryFee;
        Float f14 = this.deliveryFeeBeforeDiscount;
        Float f15 = this.serviceFee;
        float f16 = this.offerDiscount;
        float f17 = this.total;
        String str2 = this.targetAudience;
        float f18 = this.deliveryAbsoluteDiscount;
        float f19 = this.absoluteDiscount;
        List<CampaignLabel> list = this.appliedCampaigns;
        List<FeeDescription> list2 = this.feeDescriptions;
        return "CartSummary(id=" + str + ", subtotal=" + f11 + ", subtotalAfterDiscount=" + f12 + ", deliveryFee=" + f13 + ", deliveryFeeBeforeDiscount=" + f14 + ", serviceFee=" + f15 + ", offerDiscount=" + f16 + ", total=" + f17 + ", targetAudience=" + str2 + ", deliveryAbsoluteDiscount=" + f18 + ", absoluteDiscount=" + f19 + ", appliedCampaigns=" + list + ", feeDescriptions=" + list2 + ")";
    }
}
