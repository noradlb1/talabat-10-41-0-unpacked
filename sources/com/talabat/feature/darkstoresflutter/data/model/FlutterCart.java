package com.talabat.feature.darkstoresflutter.data.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import com.talabat.feature.foodcart2.data.datasources.FoodCartFlutterDataSourceImpl;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001Bu\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\u000e\b\u0003\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\b\b\u0001\u0010\n\u001a\u00020\u000b\u0012\u000e\b\u0001\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\b\u0012\u0010\b\u0001\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\b\u0012\b\b\u0001\u0010\u0010\u001a\u00020\u0011\u0012\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0006HÆ\u0003J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\t\u0010'\u001a\u00020\u000bHÆ\u0003J\u000f\u0010(\u001a\b\u0012\u0004\u0012\u00020\r0\bHÆ\u0003J\u0011\u0010)\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\bHÆ\u0003J\t\u0010*\u001a\u00020\u0011HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0013HÆ\u0003Jy\u0010,\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\u000e\b\u0003\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0003\u0010\n\u001a\u00020\u000b2\u000e\b\u0003\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\b2\u0010\b\u0003\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\b2\b\b\u0003\u0010\u0010\u001a\u00020\u00112\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÆ\u0001J\u0013\u0010-\u001a\u00020\u00112\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u000200HÖ\u0001J\t\u00101\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u001cR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001a¨\u00062"}, d2 = {"Lcom/talabat/feature/darkstoresflutter/data/model/FlutterCart;", "", "cartId", "", "vendorId", "minimumOrderValue", "", "items", "", "Lcom/talabat/feature/darkstoresflutter/data/model/FlutterCartItem;", "priceSummary", "Lcom/talabat/feature/darkstoresflutter/data/model/FlutterPriceSummary;", "campaigns", "Lcom/talabat/feature/darkstoresflutter/data/model/FlutterCampaign;", "feeDescriptions", "Lcom/talabat/feature/darkstoresflutter/data/model/FlutterFeeDescription;", "isCartUploadInProgress", "", "campaignProgress", "Lcom/talabat/feature/darkstoresflutter/data/model/FlutterCampaignProgressWrapper;", "(Ljava/lang/String;Ljava/lang/String;FLjava/util/List;Lcom/talabat/feature/darkstoresflutter/data/model/FlutterPriceSummary;Ljava/util/List;Ljava/util/List;ZLcom/talabat/feature/darkstoresflutter/data/model/FlutterCampaignProgressWrapper;)V", "getCampaignProgress", "()Lcom/talabat/feature/darkstoresflutter/data/model/FlutterCampaignProgressWrapper;", "getCampaigns", "()Ljava/util/List;", "getCartId", "()Ljava/lang/String;", "getFeeDescriptions", "()Z", "getItems", "getMinimumOrderValue", "()F", "getPriceSummary", "()Lcom/talabat/feature/darkstoresflutter/data/model/FlutterPriceSummary;", "getVendorId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "com_talabat_feature_darkstores-flutter_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FlutterCart {
    @Nullable
    private final FlutterCampaignProgressWrapper campaignProgress;
    @NotNull
    private final List<FlutterCampaign> campaigns;
    @NotNull
    private final String cartId;
    @Nullable
    private final List<FlutterFeeDescription> feeDescriptions;
    private final boolean isCartUploadInProgress;
    @NotNull
    private final List<FlutterCartItem> items;
    private final float minimumOrderValue;
    @NotNull
    private final FlutterPriceSummary priceSummary;
    @NotNull
    private final String vendorId;

    public FlutterCart(@NotNull @Json(name = "cartIdentifier") String str, @NotNull @Json(name = "vendorId") String str2, @Json(name = "minimumOrderValue") float f11, @NotNull @Json(name = "items") List<FlutterCartItem> list, @NotNull @Json(name = "priceSummary") FlutterPriceSummary flutterPriceSummary, @NotNull @Json(name = "campaigns") List<FlutterCampaign> list2, @Nullable @Json(name = "feeDescriptions") List<FlutterFeeDescription> list3, @Json(name = "isCartUploadInProgress") boolean z11, @Nullable @Json(name = "campaignProgress") FlutterCampaignProgressWrapper flutterCampaignProgressWrapper) {
        Intrinsics.checkNotNullParameter(str, FoodCartFlutterDataSourceImpl.cartIdKey);
        Intrinsics.checkNotNullParameter(str2, "vendorId");
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        Intrinsics.checkNotNullParameter(flutterPriceSummary, "priceSummary");
        Intrinsics.checkNotNullParameter(list2, "campaigns");
        this.cartId = str;
        this.vendorId = str2;
        this.minimumOrderValue = f11;
        this.items = list;
        this.priceSummary = flutterPriceSummary;
        this.campaigns = list2;
        this.feeDescriptions = list3;
        this.isCartUploadInProgress = z11;
        this.campaignProgress = flutterCampaignProgressWrapper;
    }

    public static /* synthetic */ FlutterCart copy$default(FlutterCart flutterCart, String str, String str2, float f11, List list, FlutterPriceSummary flutterPriceSummary, List list2, List list3, boolean z11, FlutterCampaignProgressWrapper flutterCampaignProgressWrapper, int i11, Object obj) {
        FlutterCart flutterCart2 = flutterCart;
        int i12 = i11;
        return flutterCart.copy((i12 & 1) != 0 ? flutterCart2.cartId : str, (i12 & 2) != 0 ? flutterCart2.vendorId : str2, (i12 & 4) != 0 ? flutterCart2.minimumOrderValue : f11, (i12 & 8) != 0 ? flutterCart2.items : list, (i12 & 16) != 0 ? flutterCart2.priceSummary : flutterPriceSummary, (i12 & 32) != 0 ? flutterCart2.campaigns : list2, (i12 & 64) != 0 ? flutterCart2.feeDescriptions : list3, (i12 & 128) != 0 ? flutterCart2.isCartUploadInProgress : z11, (i12 & 256) != 0 ? flutterCart2.campaignProgress : flutterCampaignProgressWrapper);
    }

    @NotNull
    public final String component1() {
        return this.cartId;
    }

    @NotNull
    public final String component2() {
        return this.vendorId;
    }

    public final float component3() {
        return this.minimumOrderValue;
    }

    @NotNull
    public final List<FlutterCartItem> component4() {
        return this.items;
    }

    @NotNull
    public final FlutterPriceSummary component5() {
        return this.priceSummary;
    }

    @NotNull
    public final List<FlutterCampaign> component6() {
        return this.campaigns;
    }

    @Nullable
    public final List<FlutterFeeDescription> component7() {
        return this.feeDescriptions;
    }

    public final boolean component8() {
        return this.isCartUploadInProgress;
    }

    @Nullable
    public final FlutterCampaignProgressWrapper component9() {
        return this.campaignProgress;
    }

    @NotNull
    public final FlutterCart copy(@NotNull @Json(name = "cartIdentifier") String str, @NotNull @Json(name = "vendorId") String str2, @Json(name = "minimumOrderValue") float f11, @NotNull @Json(name = "items") List<FlutterCartItem> list, @NotNull @Json(name = "priceSummary") FlutterPriceSummary flutterPriceSummary, @NotNull @Json(name = "campaigns") List<FlutterCampaign> list2, @Nullable @Json(name = "feeDescriptions") List<FlutterFeeDescription> list3, @Json(name = "isCartUploadInProgress") boolean z11, @Nullable @Json(name = "campaignProgress") FlutterCampaignProgressWrapper flutterCampaignProgressWrapper) {
        Intrinsics.checkNotNullParameter(str, FoodCartFlutterDataSourceImpl.cartIdKey);
        Intrinsics.checkNotNullParameter(str2, "vendorId");
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        FlutterPriceSummary flutterPriceSummary2 = flutterPriceSummary;
        Intrinsics.checkNotNullParameter(flutterPriceSummary2, "priceSummary");
        List<FlutterCampaign> list4 = list2;
        Intrinsics.checkNotNullParameter(list4, "campaigns");
        return new FlutterCart(str, str2, f11, list, flutterPriceSummary2, list4, list3, z11, flutterCampaignProgressWrapper);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FlutterCart)) {
            return false;
        }
        FlutterCart flutterCart = (FlutterCart) obj;
        return Intrinsics.areEqual((Object) this.cartId, (Object) flutterCart.cartId) && Intrinsics.areEqual((Object) this.vendorId, (Object) flutterCart.vendorId) && Intrinsics.areEqual((Object) Float.valueOf(this.minimumOrderValue), (Object) Float.valueOf(flutterCart.minimumOrderValue)) && Intrinsics.areEqual((Object) this.items, (Object) flutterCart.items) && Intrinsics.areEqual((Object) this.priceSummary, (Object) flutterCart.priceSummary) && Intrinsics.areEqual((Object) this.campaigns, (Object) flutterCart.campaigns) && Intrinsics.areEqual((Object) this.feeDescriptions, (Object) flutterCart.feeDescriptions) && this.isCartUploadInProgress == flutterCart.isCartUploadInProgress && Intrinsics.areEqual((Object) this.campaignProgress, (Object) flutterCart.campaignProgress);
    }

    @Nullable
    public final FlutterCampaignProgressWrapper getCampaignProgress() {
        return this.campaignProgress;
    }

    @NotNull
    public final List<FlutterCampaign> getCampaigns() {
        return this.campaigns;
    }

    @NotNull
    public final String getCartId() {
        return this.cartId;
    }

    @Nullable
    public final List<FlutterFeeDescription> getFeeDescriptions() {
        return this.feeDescriptions;
    }

    @NotNull
    public final List<FlutterCartItem> getItems() {
        return this.items;
    }

    public final float getMinimumOrderValue() {
        return this.minimumOrderValue;
    }

    @NotNull
    public final FlutterPriceSummary getPriceSummary() {
        return this.priceSummary;
    }

    @NotNull
    public final String getVendorId() {
        return this.vendorId;
    }

    public int hashCode() {
        int hashCode = ((((((((((this.cartId.hashCode() * 31) + this.vendorId.hashCode()) * 31) + Float.floatToIntBits(this.minimumOrderValue)) * 31) + this.items.hashCode()) * 31) + this.priceSummary.hashCode()) * 31) + this.campaigns.hashCode()) * 31;
        List<FlutterFeeDescription> list = this.feeDescriptions;
        int i11 = 0;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        boolean z11 = this.isCartUploadInProgress;
        if (z11) {
            z11 = true;
        }
        int i12 = (hashCode2 + (z11 ? 1 : 0)) * 31;
        FlutterCampaignProgressWrapper flutterCampaignProgressWrapper = this.campaignProgress;
        if (flutterCampaignProgressWrapper != null) {
            i11 = flutterCampaignProgressWrapper.hashCode();
        }
        return i12 + i11;
    }

    public final boolean isCartUploadInProgress() {
        return this.isCartUploadInProgress;
    }

    @NotNull
    public String toString() {
        String str = this.cartId;
        String str2 = this.vendorId;
        float f11 = this.minimumOrderValue;
        List<FlutterCartItem> list = this.items;
        FlutterPriceSummary flutterPriceSummary = this.priceSummary;
        List<FlutterCampaign> list2 = this.campaigns;
        List<FlutterFeeDescription> list3 = this.feeDescriptions;
        boolean z11 = this.isCartUploadInProgress;
        FlutterCampaignProgressWrapper flutterCampaignProgressWrapper = this.campaignProgress;
        return "FlutterCart(cartId=" + str + ", vendorId=" + str2 + ", minimumOrderValue=" + f11 + ", items=" + list + ", priceSummary=" + flutterPriceSummary + ", campaigns=" + list2 + ", feeDescriptions=" + list3 + ", isCartUploadInProgress=" + z11 + ", campaignProgress=" + flutterCampaignProgressWrapper + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FlutterCart(String str, String str2, float f11, List list, FlutterPriceSummary flutterPriceSummary, List list2, List list3, boolean z11, FlutterCampaignProgressWrapper flutterCampaignProgressWrapper, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, f11, (i11 & 8) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, flutterPriceSummary, list2, list3, z11, flutterCampaignProgressWrapper);
    }
}
