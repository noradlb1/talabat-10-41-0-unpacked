package com.talabat.restaurants.v2.ui.displaymodels;

import com.google.firebase.analytics.FirebaseAnalytics;
import datamodels.FeaturedProductItem;
import datamodels.Restaurant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b(\b\b\u0018\u00002\u00020\u0001By\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u0016J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u000eHÆ\u0003J\t\u0010,\u001a\u00020\u0010HÆ\u0003J\t\u0010-\u001a\u00020\u000eHÆ\u0003J\t\u0010.\u001a\u00020\u0013HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0005HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0005HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\u0001\u00108\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÆ\u0001J\u0013\u00109\u001a\u00020\u000e2\b\u0010:\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010;\u001a\u00020\u0005HÖ\u0001J\t\u0010<\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u001bR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0011\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001bR\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001a¨\u0006="}, d2 = {"Lcom/talabat/restaurants/v2/ui/displaymodels/FeatureProductDisplayModel;", "", "vendorName", "", "vendorId", "", "itemName", "itemId", "deliveryTimeText", "deliveryTimeInteger", "oldPrice", "price", "itemImg", "isDiscount", "", "priceDisplayType", "Lcom/talabat/restaurants/v2/ui/displaymodels/PriceDisplayType;", "showRocketDeliveryTime", "vendor", "Ldatamodels/Restaurant;", "item", "Ldatamodels/FeaturedProductItem;", "(Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/talabat/restaurants/v2/ui/displaymodels/PriceDisplayType;ZLdatamodels/Restaurant;Ldatamodels/FeaturedProductItem;)V", "getDeliveryTimeInteger", "()I", "getDeliveryTimeText", "()Ljava/lang/String;", "()Z", "getItem", "()Ldatamodels/FeaturedProductItem;", "getItemId", "getItemImg", "getItemName", "getOldPrice", "getPrice", "getPriceDisplayType", "()Lcom/talabat/restaurants/v2/ui/displaymodels/PriceDisplayType;", "getShowRocketDeliveryTime", "getVendor", "()Ldatamodels/Restaurant;", "getVendorId", "getVendorName", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FeatureProductDisplayModel {
    private final int deliveryTimeInteger;
    @NotNull
    private final String deliveryTimeText;
    private final boolean isDiscount;
    @Nullable
    private final FeaturedProductItem item;
    private final int itemId;
    @NotNull
    private final String itemImg;
    @NotNull
    private final String itemName;
    @NotNull
    private final String oldPrice;
    @NotNull
    private final String price;
    @NotNull
    private final PriceDisplayType priceDisplayType;
    private final boolean showRocketDeliveryTime;
    @NotNull
    private final Restaurant vendor;
    private final int vendorId;
    @NotNull
    private final String vendorName;

    public FeatureProductDisplayModel(@NotNull String str, int i11, @NotNull String str2, int i12, @NotNull String str3, int i13, @NotNull String str4, @NotNull String str5, @NotNull String str6, boolean z11, @NotNull PriceDisplayType priceDisplayType2, boolean z12, @NotNull Restaurant restaurant, @Nullable FeaturedProductItem featuredProductItem) {
        Intrinsics.checkNotNullParameter(str, "vendorName");
        Intrinsics.checkNotNullParameter(str2, "itemName");
        Intrinsics.checkNotNullParameter(str3, "deliveryTimeText");
        Intrinsics.checkNotNullParameter(str4, "oldPrice");
        Intrinsics.checkNotNullParameter(str5, FirebaseAnalytics.Param.PRICE);
        Intrinsics.checkNotNullParameter(str6, "itemImg");
        Intrinsics.checkNotNullParameter(priceDisplayType2, "priceDisplayType");
        Intrinsics.checkNotNullParameter(restaurant, "vendor");
        this.vendorName = str;
        this.vendorId = i11;
        this.itemName = str2;
        this.itemId = i12;
        this.deliveryTimeText = str3;
        this.deliveryTimeInteger = i13;
        this.oldPrice = str4;
        this.price = str5;
        this.itemImg = str6;
        this.isDiscount = z11;
        this.priceDisplayType = priceDisplayType2;
        this.showRocketDeliveryTime = z12;
        this.vendor = restaurant;
        this.item = featuredProductItem;
    }

    public static /* synthetic */ FeatureProductDisplayModel copy$default(FeatureProductDisplayModel featureProductDisplayModel, String str, int i11, String str2, int i12, String str3, int i13, String str4, String str5, String str6, boolean z11, PriceDisplayType priceDisplayType2, boolean z12, Restaurant restaurant, FeaturedProductItem featuredProductItem, int i14, Object obj) {
        FeatureProductDisplayModel featureProductDisplayModel2 = featureProductDisplayModel;
        int i15 = i14;
        return featureProductDisplayModel.copy((i15 & 1) != 0 ? featureProductDisplayModel2.vendorName : str, (i15 & 2) != 0 ? featureProductDisplayModel2.vendorId : i11, (i15 & 4) != 0 ? featureProductDisplayModel2.itemName : str2, (i15 & 8) != 0 ? featureProductDisplayModel2.itemId : i12, (i15 & 16) != 0 ? featureProductDisplayModel2.deliveryTimeText : str3, (i15 & 32) != 0 ? featureProductDisplayModel2.deliveryTimeInteger : i13, (i15 & 64) != 0 ? featureProductDisplayModel2.oldPrice : str4, (i15 & 128) != 0 ? featureProductDisplayModel2.price : str5, (i15 & 256) != 0 ? featureProductDisplayModel2.itemImg : str6, (i15 & 512) != 0 ? featureProductDisplayModel2.isDiscount : z11, (i15 & 1024) != 0 ? featureProductDisplayModel2.priceDisplayType : priceDisplayType2, (i15 & 2048) != 0 ? featureProductDisplayModel2.showRocketDeliveryTime : z12, (i15 & 4096) != 0 ? featureProductDisplayModel2.vendor : restaurant, (i15 & 8192) != 0 ? featureProductDisplayModel2.item : featuredProductItem);
    }

    @NotNull
    public final String component1() {
        return this.vendorName;
    }

    public final boolean component10() {
        return this.isDiscount;
    }

    @NotNull
    public final PriceDisplayType component11() {
        return this.priceDisplayType;
    }

    public final boolean component12() {
        return this.showRocketDeliveryTime;
    }

    @NotNull
    public final Restaurant component13() {
        return this.vendor;
    }

    @Nullable
    public final FeaturedProductItem component14() {
        return this.item;
    }

    public final int component2() {
        return this.vendorId;
    }

    @NotNull
    public final String component3() {
        return this.itemName;
    }

    public final int component4() {
        return this.itemId;
    }

    @NotNull
    public final String component5() {
        return this.deliveryTimeText;
    }

    public final int component6() {
        return this.deliveryTimeInteger;
    }

    @NotNull
    public final String component7() {
        return this.oldPrice;
    }

    @NotNull
    public final String component8() {
        return this.price;
    }

    @NotNull
    public final String component9() {
        return this.itemImg;
    }

    @NotNull
    public final FeatureProductDisplayModel copy(@NotNull String str, int i11, @NotNull String str2, int i12, @NotNull String str3, int i13, @NotNull String str4, @NotNull String str5, @NotNull String str6, boolean z11, @NotNull PriceDisplayType priceDisplayType2, boolean z12, @NotNull Restaurant restaurant, @Nullable FeaturedProductItem featuredProductItem) {
        String str7 = str;
        Intrinsics.checkNotNullParameter(str7, "vendorName");
        String str8 = str2;
        Intrinsics.checkNotNullParameter(str8, "itemName");
        String str9 = str3;
        Intrinsics.checkNotNullParameter(str9, "deliveryTimeText");
        String str10 = str4;
        Intrinsics.checkNotNullParameter(str10, "oldPrice");
        String str11 = str5;
        Intrinsics.checkNotNullParameter(str11, FirebaseAnalytics.Param.PRICE);
        String str12 = str6;
        Intrinsics.checkNotNullParameter(str12, "itemImg");
        PriceDisplayType priceDisplayType3 = priceDisplayType2;
        Intrinsics.checkNotNullParameter(priceDisplayType3, "priceDisplayType");
        Restaurant restaurant2 = restaurant;
        Intrinsics.checkNotNullParameter(restaurant2, "vendor");
        return new FeatureProductDisplayModel(str7, i11, str8, i12, str9, i13, str10, str11, str12, z11, priceDisplayType3, z12, restaurant2, featuredProductItem);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeatureProductDisplayModel)) {
            return false;
        }
        FeatureProductDisplayModel featureProductDisplayModel = (FeatureProductDisplayModel) obj;
        return Intrinsics.areEqual((Object) this.vendorName, (Object) featureProductDisplayModel.vendorName) && this.vendorId == featureProductDisplayModel.vendorId && Intrinsics.areEqual((Object) this.itemName, (Object) featureProductDisplayModel.itemName) && this.itemId == featureProductDisplayModel.itemId && Intrinsics.areEqual((Object) this.deliveryTimeText, (Object) featureProductDisplayModel.deliveryTimeText) && this.deliveryTimeInteger == featureProductDisplayModel.deliveryTimeInteger && Intrinsics.areEqual((Object) this.oldPrice, (Object) featureProductDisplayModel.oldPrice) && Intrinsics.areEqual((Object) this.price, (Object) featureProductDisplayModel.price) && Intrinsics.areEqual((Object) this.itemImg, (Object) featureProductDisplayModel.itemImg) && this.isDiscount == featureProductDisplayModel.isDiscount && this.priceDisplayType == featureProductDisplayModel.priceDisplayType && this.showRocketDeliveryTime == featureProductDisplayModel.showRocketDeliveryTime && Intrinsics.areEqual((Object) this.vendor, (Object) featureProductDisplayModel.vendor) && Intrinsics.areEqual((Object) this.item, (Object) featureProductDisplayModel.item);
    }

    public final int getDeliveryTimeInteger() {
        return this.deliveryTimeInteger;
    }

    @NotNull
    public final String getDeliveryTimeText() {
        return this.deliveryTimeText;
    }

    @Nullable
    public final FeaturedProductItem getItem() {
        return this.item;
    }

    public final int getItemId() {
        return this.itemId;
    }

    @NotNull
    public final String getItemImg() {
        return this.itemImg;
    }

    @NotNull
    public final String getItemName() {
        return this.itemName;
    }

    @NotNull
    public final String getOldPrice() {
        return this.oldPrice;
    }

    @NotNull
    public final String getPrice() {
        return this.price;
    }

    @NotNull
    public final PriceDisplayType getPriceDisplayType() {
        return this.priceDisplayType;
    }

    public final boolean getShowRocketDeliveryTime() {
        return this.showRocketDeliveryTime;
    }

    @NotNull
    public final Restaurant getVendor() {
        return this.vendor;
    }

    public final int getVendorId() {
        return this.vendorId;
    }

    @NotNull
    public final String getVendorName() {
        return this.vendorName;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((this.vendorName.hashCode() * 31) + this.vendorId) * 31) + this.itemName.hashCode()) * 31) + this.itemId) * 31) + this.deliveryTimeText.hashCode()) * 31) + this.deliveryTimeInteger) * 31) + this.oldPrice.hashCode()) * 31) + this.price.hashCode()) * 31) + this.itemImg.hashCode()) * 31;
        boolean z11 = this.isDiscount;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int hashCode2 = (((hashCode + (z11 ? 1 : 0)) * 31) + this.priceDisplayType.hashCode()) * 31;
        boolean z13 = this.showRocketDeliveryTime;
        if (!z13) {
            z12 = z13;
        }
        int hashCode3 = (((hashCode2 + (z12 ? 1 : 0)) * 31) + this.vendor.hashCode()) * 31;
        FeaturedProductItem featuredProductItem = this.item;
        return hashCode3 + (featuredProductItem == null ? 0 : featuredProductItem.hashCode());
    }

    public final boolean isDiscount() {
        return this.isDiscount;
    }

    @NotNull
    public String toString() {
        String str = this.vendorName;
        int i11 = this.vendorId;
        String str2 = this.itemName;
        int i12 = this.itemId;
        String str3 = this.deliveryTimeText;
        int i13 = this.deliveryTimeInteger;
        String str4 = this.oldPrice;
        String str5 = this.price;
        String str6 = this.itemImg;
        boolean z11 = this.isDiscount;
        PriceDisplayType priceDisplayType2 = this.priceDisplayType;
        boolean z12 = this.showRocketDeliveryTime;
        Restaurant restaurant = this.vendor;
        FeaturedProductItem featuredProductItem = this.item;
        return "FeatureProductDisplayModel(vendorName=" + str + ", vendorId=" + i11 + ", itemName=" + str2 + ", itemId=" + i12 + ", deliveryTimeText=" + str3 + ", deliveryTimeInteger=" + i13 + ", oldPrice=" + str4 + ", price=" + str5 + ", itemImg=" + str6 + ", isDiscount=" + z11 + ", priceDisplayType=" + priceDisplayType2 + ", showRocketDeliveryTime=" + z12 + ", vendor=" + restaurant + ", item=" + featuredProductItem + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FeatureProductDisplayModel(String str, int i11, String str2, int i12, String str3, int i13, String str4, String str5, String str6, boolean z11, PriceDisplayType priceDisplayType2, boolean z12, Restaurant restaurant, FeaturedProductItem featuredProductItem, int i14, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i11, str2, i12, str3, i13, str4, str5, str6, z11, priceDisplayType2, z12, restaurant, (i14 & 8192) != 0 ? null : featuredProductItem);
    }
}
