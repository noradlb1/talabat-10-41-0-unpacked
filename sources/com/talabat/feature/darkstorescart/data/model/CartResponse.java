package com.talabat.feature.darkstorescart.data.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import com.talabat.feature.darkstorescampaignmessage.data.model.NetworkCampaignProgressResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B½\u0001\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0001\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\b\u0001\u0010\n\u001a\u00020\b\u0012\b\b\u0001\u0010\u000b\u001a\u00020\b\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\b\u0012\b\b\u0001\u0010\u000e\u001a\u00020\b\u0012\b\b\u0001\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0001\u0010\u0011\u001a\u00020\b\u0012\b\b\u0001\u0010\u0012\u001a\u00020\u0010\u0012\u0010\b\u0001\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\b\u0012\n\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\u0002\u0010\u0019J\u000f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0010HÆ\u0003J\t\u00102\u001a\u00020\bHÆ\u0003J\t\u00103\u001a\u00020\u0010HÆ\u0003J\u0011\u00104\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u0010\u00106\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010(J\u000b\u00107\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\u000f\u00108\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\t\u00109\u001a\u00020\bHÆ\u0003J\t\u0010:\u001a\u00020\bHÆ\u0003J\t\u0010;\u001a\u00020\bHÆ\u0003J\t\u0010<\u001a\u00020\bHÆ\u0003J\u0010\u0010=\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010(J\u0010\u0010>\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010(J\t\u0010?\u001a\u00020\bHÆ\u0003JÌ\u0001\u0010@\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0003\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0003\u0010\n\u001a\u00020\b2\b\b\u0003\u0010\u000b\u001a\u00020\b2\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\b2\b\b\u0003\u0010\u000e\u001a\u00020\b2\b\b\u0003\u0010\u000f\u001a\u00020\u00102\b\b\u0003\u0010\u0011\u001a\u00020\b2\b\b\u0003\u0010\u0012\u001a\u00020\u00102\u0010\b\u0003\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00032\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÆ\u0001¢\u0006\u0002\u0010AJ\u0013\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010E\u001a\u00020FHÖ\u0001J\t\u0010G\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0011\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001bR\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001bR\u0011\u0010\u000e\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001bR\u0019\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001dR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001dR\u0015\u0010\u0016\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010)\u001a\u0004\b'\u0010(R\u0015\u0010\f\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010)\u001a\u0004\b*\u0010(R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001bR\u0015\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010)\u001a\u0004\b,\u0010(R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b-\u0010!R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001bR\u0011\u0010\u0012\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b/\u0010!¨\u0006H"}, d2 = {"Lcom/talabat/feature/darkstorescart/data/model/CartResponse;", "", "items", "", "Lcom/talabat/feature/darkstorescart/data/model/CartResponseProduct;", "appliedCampaigns", "Lcom/talabat/feature/darkstorescart/data/model/CampaignLabel;", "total", "", "subtotal", "absoluteDiscount", "deliveryFee", "serviceFee", "subtotalAfterDiscount", "deliveryTotal", "targetAudience", "", "deliveryAbsoluteDiscount", "vendorId", "feeDescriptions", "Lcom/talabat/feature/darkstorescart/data/model/FeeDescription;", "cartId", "minimumOrderValue", "campaignProgress", "Lcom/talabat/feature/darkstorescampaignmessage/data/model/NetworkCampaignProgressResponse;", "(Ljava/util/List;Ljava/util/List;FFFFLjava/lang/Float;Ljava/lang/Float;FLjava/lang/String;FLjava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Float;Lcom/talabat/feature/darkstorescampaignmessage/data/model/NetworkCampaignProgressResponse;)V", "getAbsoluteDiscount", "()F", "getAppliedCampaigns", "()Ljava/util/List;", "getCampaignProgress", "()Lcom/talabat/feature/darkstorescampaignmessage/data/model/NetworkCampaignProgressResponse;", "getCartId", "()Ljava/lang/String;", "getDeliveryAbsoluteDiscount", "getDeliveryFee", "getDeliveryTotal", "getFeeDescriptions", "getItems", "getMinimumOrderValue", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getServiceFee", "getSubtotal", "getSubtotalAfterDiscount", "getTargetAudience", "getTotal", "getVendorId", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/util/List;Ljava/util/List;FFFFLjava/lang/Float;Ljava/lang/Float;FLjava/lang/String;FLjava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Float;Lcom/talabat/feature/darkstorescampaignmessage/data/model/NetworkCampaignProgressResponse;)Lcom/talabat/feature/darkstorescart/data/model/CartResponse;", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_darkstores-cart_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CartResponse {
    private final float absoluteDiscount;
    @NotNull
    private final List<CampaignLabel> appliedCampaigns;
    @Nullable
    private final NetworkCampaignProgressResponse campaignProgress;
    @Nullable
    private final String cartId;
    private final float deliveryAbsoluteDiscount;
    private final float deliveryFee;
    private final float deliveryTotal;
    @Nullable
    private final List<FeeDescription> feeDescriptions;
    @NotNull
    private final List<CartResponseProduct> items;
    @Nullable
    private final transient Float minimumOrderValue;
    @Nullable
    private final Float serviceFee;
    private final float subtotal;
    @Nullable
    private final Float subtotalAfterDiscount;
    @NotNull
    private final String targetAudience;
    private final float total;
    @NotNull
    private final String vendorId;

    public CartResponse(@NotNull List<CartResponseProduct> list, @NotNull @Json(name = "applied_campaigns") List<CampaignLabel> list2, float f11, float f12, @Json(name = "absolute_discount") float f13, @Json(name = "delivery_fee") float f14, @Nullable @Json(name = "service_fee") Float f15, @Nullable @Json(name = "subtotal_after_discount") Float f16, @Json(name = "delivery_total") float f17, @NotNull @Json(name = "target_audience") String str, @Json(name = "delivery_absolute_discount") float f18, @NotNull @Json(name = "vendor_id") String str2, @Nullable @Json(name = "fees_desc") List<FeeDescription> list3, @Nullable @Json(name = "cart_id") String str3, @Nullable Float f19, @Nullable @Json(name = "campaign_progress") NetworkCampaignProgressResponse networkCampaignProgressResponse) {
        String str4 = str;
        String str5 = str2;
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        Intrinsics.checkNotNullParameter(list2, "appliedCampaigns");
        Intrinsics.checkNotNullParameter(str4, "targetAudience");
        Intrinsics.checkNotNullParameter(str5, "vendorId");
        this.items = list;
        this.appliedCampaigns = list2;
        this.total = f11;
        this.subtotal = f12;
        this.absoluteDiscount = f13;
        this.deliveryFee = f14;
        this.serviceFee = f15;
        this.subtotalAfterDiscount = f16;
        this.deliveryTotal = f17;
        this.targetAudience = str4;
        this.deliveryAbsoluteDiscount = f18;
        this.vendorId = str5;
        this.feeDescriptions = list3;
        this.cartId = str3;
        this.minimumOrderValue = f19;
        this.campaignProgress = networkCampaignProgressResponse;
    }

    public static /* synthetic */ CartResponse copy$default(CartResponse cartResponse, List list, List list2, float f11, float f12, float f13, float f14, Float f15, Float f16, float f17, String str, float f18, String str2, List list3, String str3, Float f19, NetworkCampaignProgressResponse networkCampaignProgressResponse, int i11, Object obj) {
        CartResponse cartResponse2 = cartResponse;
        int i12 = i11;
        return cartResponse.copy((i12 & 1) != 0 ? cartResponse2.items : list, (i12 & 2) != 0 ? cartResponse2.appliedCampaigns : list2, (i12 & 4) != 0 ? cartResponse2.total : f11, (i12 & 8) != 0 ? cartResponse2.subtotal : f12, (i12 & 16) != 0 ? cartResponse2.absoluteDiscount : f13, (i12 & 32) != 0 ? cartResponse2.deliveryFee : f14, (i12 & 64) != 0 ? cartResponse2.serviceFee : f15, (i12 & 128) != 0 ? cartResponse2.subtotalAfterDiscount : f16, (i12 & 256) != 0 ? cartResponse2.deliveryTotal : f17, (i12 & 512) != 0 ? cartResponse2.targetAudience : str, (i12 & 1024) != 0 ? cartResponse2.deliveryAbsoluteDiscount : f18, (i12 & 2048) != 0 ? cartResponse2.vendorId : str2, (i12 & 4096) != 0 ? cartResponse2.feeDescriptions : list3, (i12 & 8192) != 0 ? cartResponse2.cartId : str3, (i12 & 16384) != 0 ? cartResponse2.minimumOrderValue : f19, (i12 & 32768) != 0 ? cartResponse2.campaignProgress : networkCampaignProgressResponse);
    }

    @NotNull
    public final List<CartResponseProduct> component1() {
        return this.items;
    }

    @NotNull
    public final String component10() {
        return this.targetAudience;
    }

    public final float component11() {
        return this.deliveryAbsoluteDiscount;
    }

    @NotNull
    public final String component12() {
        return this.vendorId;
    }

    @Nullable
    public final List<FeeDescription> component13() {
        return this.feeDescriptions;
    }

    @Nullable
    public final String component14() {
        return this.cartId;
    }

    @Nullable
    public final Float component15() {
        return this.minimumOrderValue;
    }

    @Nullable
    public final NetworkCampaignProgressResponse component16() {
        return this.campaignProgress;
    }

    @NotNull
    public final List<CampaignLabel> component2() {
        return this.appliedCampaigns;
    }

    public final float component3() {
        return this.total;
    }

    public final float component4() {
        return this.subtotal;
    }

    public final float component5() {
        return this.absoluteDiscount;
    }

    public final float component6() {
        return this.deliveryFee;
    }

    @Nullable
    public final Float component7() {
        return this.serviceFee;
    }

    @Nullable
    public final Float component8() {
        return this.subtotalAfterDiscount;
    }

    public final float component9() {
        return this.deliveryTotal;
    }

    @NotNull
    public final CartResponse copy(@NotNull List<CartResponseProduct> list, @NotNull @Json(name = "applied_campaigns") List<CampaignLabel> list2, float f11, float f12, @Json(name = "absolute_discount") float f13, @Json(name = "delivery_fee") float f14, @Nullable @Json(name = "service_fee") Float f15, @Nullable @Json(name = "subtotal_after_discount") Float f16, @Json(name = "delivery_total") float f17, @NotNull @Json(name = "target_audience") String str, @Json(name = "delivery_absolute_discount") float f18, @NotNull @Json(name = "vendor_id") String str2, @Nullable @Json(name = "fees_desc") List<FeeDescription> list3, @Nullable @Json(name = "cart_id") String str3, @Nullable Float f19, @Nullable @Json(name = "campaign_progress") NetworkCampaignProgressResponse networkCampaignProgressResponse) {
        List<CartResponseProduct> list4 = list;
        Intrinsics.checkNotNullParameter(list4, FirebaseAnalytics.Param.ITEMS);
        Intrinsics.checkNotNullParameter(list2, "appliedCampaigns");
        Intrinsics.checkNotNullParameter(str, "targetAudience");
        Intrinsics.checkNotNullParameter(str2, "vendorId");
        return new CartResponse(list4, list2, f11, f12, f13, f14, f15, f16, f17, str, f18, str2, list3, str3, f19, networkCampaignProgressResponse);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CartResponse)) {
            return false;
        }
        CartResponse cartResponse = (CartResponse) obj;
        return Intrinsics.areEqual((Object) this.items, (Object) cartResponse.items) && Intrinsics.areEqual((Object) this.appliedCampaigns, (Object) cartResponse.appliedCampaigns) && Intrinsics.areEqual((Object) Float.valueOf(this.total), (Object) Float.valueOf(cartResponse.total)) && Intrinsics.areEqual((Object) Float.valueOf(this.subtotal), (Object) Float.valueOf(cartResponse.subtotal)) && Intrinsics.areEqual((Object) Float.valueOf(this.absoluteDiscount), (Object) Float.valueOf(cartResponse.absoluteDiscount)) && Intrinsics.areEqual((Object) Float.valueOf(this.deliveryFee), (Object) Float.valueOf(cartResponse.deliveryFee)) && Intrinsics.areEqual((Object) this.serviceFee, (Object) cartResponse.serviceFee) && Intrinsics.areEqual((Object) this.subtotalAfterDiscount, (Object) cartResponse.subtotalAfterDiscount) && Intrinsics.areEqual((Object) Float.valueOf(this.deliveryTotal), (Object) Float.valueOf(cartResponse.deliveryTotal)) && Intrinsics.areEqual((Object) this.targetAudience, (Object) cartResponse.targetAudience) && Intrinsics.areEqual((Object) Float.valueOf(this.deliveryAbsoluteDiscount), (Object) Float.valueOf(cartResponse.deliveryAbsoluteDiscount)) && Intrinsics.areEqual((Object) this.vendorId, (Object) cartResponse.vendorId) && Intrinsics.areEqual((Object) this.feeDescriptions, (Object) cartResponse.feeDescriptions) && Intrinsics.areEqual((Object) this.cartId, (Object) cartResponse.cartId) && Intrinsics.areEqual((Object) this.minimumOrderValue, (Object) cartResponse.minimumOrderValue) && Intrinsics.areEqual((Object) this.campaignProgress, (Object) cartResponse.campaignProgress);
    }

    public final float getAbsoluteDiscount() {
        return this.absoluteDiscount;
    }

    @NotNull
    public final List<CampaignLabel> getAppliedCampaigns() {
        return this.appliedCampaigns;
    }

    @Nullable
    public final NetworkCampaignProgressResponse getCampaignProgress() {
        return this.campaignProgress;
    }

    @Nullable
    public final String getCartId() {
        return this.cartId;
    }

    public final float getDeliveryAbsoluteDiscount() {
        return this.deliveryAbsoluteDiscount;
    }

    public final float getDeliveryFee() {
        return this.deliveryFee;
    }

    public final float getDeliveryTotal() {
        return this.deliveryTotal;
    }

    @Nullable
    public final List<FeeDescription> getFeeDescriptions() {
        return this.feeDescriptions;
    }

    @NotNull
    public final List<CartResponseProduct> getItems() {
        return this.items;
    }

    @Nullable
    public final Float getMinimumOrderValue() {
        return this.minimumOrderValue;
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

    @NotNull
    public final String getVendorId() {
        return this.vendorId;
    }

    public int hashCode() {
        int hashCode = ((((((((((this.items.hashCode() * 31) + this.appliedCampaigns.hashCode()) * 31) + Float.floatToIntBits(this.total)) * 31) + Float.floatToIntBits(this.subtotal)) * 31) + Float.floatToIntBits(this.absoluteDiscount)) * 31) + Float.floatToIntBits(this.deliveryFee)) * 31;
        Float f11 = this.serviceFee;
        int i11 = 0;
        int hashCode2 = (hashCode + (f11 == null ? 0 : f11.hashCode())) * 31;
        Float f12 = this.subtotalAfterDiscount;
        int hashCode3 = (((((((((hashCode2 + (f12 == null ? 0 : f12.hashCode())) * 31) + Float.floatToIntBits(this.deliveryTotal)) * 31) + this.targetAudience.hashCode()) * 31) + Float.floatToIntBits(this.deliveryAbsoluteDiscount)) * 31) + this.vendorId.hashCode()) * 31;
        List<FeeDescription> list = this.feeDescriptions;
        int hashCode4 = (hashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        String str = this.cartId;
        int hashCode5 = (hashCode4 + (str == null ? 0 : str.hashCode())) * 31;
        Float f13 = this.minimumOrderValue;
        int hashCode6 = (hashCode5 + (f13 == null ? 0 : f13.hashCode())) * 31;
        NetworkCampaignProgressResponse networkCampaignProgressResponse = this.campaignProgress;
        if (networkCampaignProgressResponse != null) {
            i11 = networkCampaignProgressResponse.hashCode();
        }
        return hashCode6 + i11;
    }

    @NotNull
    public String toString() {
        List<CartResponseProduct> list = this.items;
        List<CampaignLabel> list2 = this.appliedCampaigns;
        float f11 = this.total;
        float f12 = this.subtotal;
        float f13 = this.absoluteDiscount;
        float f14 = this.deliveryFee;
        Float f15 = this.serviceFee;
        Float f16 = this.subtotalAfterDiscount;
        float f17 = this.deliveryTotal;
        String str = this.targetAudience;
        float f18 = this.deliveryAbsoluteDiscount;
        String str2 = this.vendorId;
        List<FeeDescription> list3 = this.feeDescriptions;
        String str3 = this.cartId;
        Float f19 = this.minimumOrderValue;
        NetworkCampaignProgressResponse networkCampaignProgressResponse = this.campaignProgress;
        return "CartResponse(items=" + list + ", appliedCampaigns=" + list2 + ", total=" + f11 + ", subtotal=" + f12 + ", absoluteDiscount=" + f13 + ", deliveryFee=" + f14 + ", serviceFee=" + f15 + ", subtotalAfterDiscount=" + f16 + ", deliveryTotal=" + f17 + ", targetAudience=" + str + ", deliveryAbsoluteDiscount=" + f18 + ", vendorId=" + str2 + ", feeDescriptions=" + list3 + ", cartId=" + str3 + ", minimumOrderValue=" + f19 + ", campaignProgress=" + networkCampaignProgressResponse + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CartResponse(java.util.List r21, java.util.List r22, float r23, float r24, float r25, float r26, java.lang.Float r27, java.lang.Float r28, float r29, java.lang.String r30, float r31, java.lang.String r32, java.util.List r33, java.lang.String r34, java.lang.Float r35, com.talabat.feature.darkstorescampaignmessage.data.model.NetworkCampaignProgressResponse r36, int r37, kotlin.jvm.internal.DefaultConstructorMarker r38) {
        /*
            r20 = this;
            r0 = r37
            r1 = r0 & 8192(0x2000, float:1.14794E-41)
            r2 = 0
            if (r1 == 0) goto L_0x000a
            r17 = r2
            goto L_0x000c
        L_0x000a:
            r17 = r34
        L_0x000c:
            r1 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x0013
            r18 = r2
            goto L_0x0015
        L_0x0013:
            r18 = r35
        L_0x0015:
            r1 = 32768(0x8000, float:4.5918E-41)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x001e
            r19 = r2
            goto L_0x0020
        L_0x001e:
            r19 = r36
        L_0x0020:
            r3 = r20
            r4 = r21
            r5 = r22
            r6 = r23
            r7 = r24
            r8 = r25
            r9 = r26
            r10 = r27
            r11 = r28
            r12 = r29
            r13 = r30
            r14 = r31
            r15 = r32
            r16 = r33
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.darkstorescart.data.model.CartResponse.<init>(java.util.List, java.util.List, float, float, float, float, java.lang.Float, java.lang.Float, float, java.lang.String, float, java.lang.String, java.util.List, java.lang.String, java.lang.Float, com.talabat.feature.darkstorescampaignmessage.data.model.NetworkCampaignProgressResponse, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
