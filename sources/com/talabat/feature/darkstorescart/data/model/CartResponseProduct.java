package com.talabat.feature.darkstorescart.data.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b6\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BË\u0001\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0001\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0001\u0010\u000b\u001a\u00020\n\u0012\u000e\b\u0001\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\b\b\u0003\u0010\u0010\u001a\u00020\b\u0012\u000e\b\u0003\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\b\u0012\n\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u0018J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\bHÆ\u0003J\u000f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00107\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u00108\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010:\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0003J\t\u0010;\u001a\u00020\bHÆ\u0003J\t\u0010<\u001a\u00020\nHÆ\u0003J\t\u0010=\u001a\u00020\nHÆ\u0003J\u000f\u0010>\u001a\b\u0012\u0004\u0012\u00020\r0\u0006HÆ\u0003J\t\u0010?\u001a\u00020\nHÆ\u0003J\t\u0010@\u001a\u00020\nHÆ\u0003JÚ\u0001\u0010A\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0003\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00062\b\b\u0003\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0003\u0010\u000b\u001a\u00020\n2\u000e\b\u0003\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00062\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\n2\b\b\u0003\u0010\u0010\u001a\u00020\b2\u000e\b\u0003\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010BJ\u0013\u0010C\u001a\u00020D2\b\u0010E\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010F\u001a\u00020\bHÖ\u0001J\t\u0010G\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0015\u0010\u0016\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0010\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001aR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010#R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010#R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010#R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b*\u0010!R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b+\u0010\u001cR\u0011\u0010\u000f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001aR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001fR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010#R\u0011\u0010\u000e\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001a¨\u0006H"}, d2 = {"Lcom/talabat/feature/darkstorescart/data/model/CartResponseProduct;", "", "productId", "", "productSku", "productCategoryIds", "", "quantity", "", "price", "", "absoluteDiscount", "appliedCampaigns", "Lcom/talabat/feature/darkstorescart/data/model/CampaignLabel;", "total", "subtotal", "freeQuantity", "tags", "offerText", "tooltipAlertText", "productName", "imageUrl", "ageLimit", "stock", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;IFFLjava/util/List;FFILjava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getAbsoluteDiscount", "()F", "getAgeLimit", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAppliedCampaigns", "()Ljava/util/List;", "getFreeQuantity", "()I", "getImageUrl", "()Ljava/lang/String;", "getOfferText", "getPrice", "getProductCategoryIds", "getProductId", "getProductName", "getProductSku", "getQuantity", "getStock", "getSubtotal", "getTags", "getTooltipAlertText", "getTotal", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;IFFLjava/util/List;FFILjava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/talabat/feature/darkstorescart/data/model/CartResponseProduct;", "equals", "", "other", "hashCode", "toString", "com_talabat_feature_darkstores-cart_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CartResponseProduct {
    private final float absoluteDiscount;
    @Nullable
    private final Integer ageLimit;
    @NotNull
    private final List<CampaignLabel> appliedCampaigns;
    private final int freeQuantity;
    @Nullable
    private final String imageUrl;
    @Nullable
    private final String offerText;
    private final float price;
    @Nullable
    private final List<String> productCategoryIds;
    @NotNull
    private final String productId;
    @Nullable
    private final String productName;
    @Nullable
    private final String productSku;
    private final int quantity;
    @Nullable
    private final Integer stock;
    private final float subtotal;
    @NotNull
    private final List<String> tags;
    @Nullable
    private final String tooltipAlertText;
    private final float total;

    public CartResponseProduct(@NotNull @Json(name = "product_id") String str, @Nullable @Json(name = "product_sku") String str2, @Nullable @Json(name = "product_category_ids") List<String> list, @Json(name = "qty") int i11, float f11, @Json(name = "absolute_discount") float f12, @NotNull @Json(name = "applied_campaigns") List<CampaignLabel> list2, float f13, float f14, @Json(name = "free_qty") int i12, @NotNull @Json(name = "tags") List<String> list3, @Nullable @Json(name = "offer_text") String str3, @Nullable @Json(name = "tooltip_alert_text") String str4, @Nullable @Json(name = "product_name") String str5, @Nullable @Json(name = "product_image_url") String str6, @Nullable @Json(name = "age_limit") Integer num, @Nullable @Json(name = "stock") Integer num2) {
        List<String> list4 = list3;
        Intrinsics.checkNotNullParameter(str, "productId");
        Intrinsics.checkNotNullParameter(list2, "appliedCampaigns");
        Intrinsics.checkNotNullParameter(list4, "tags");
        this.productId = str;
        this.productSku = str2;
        this.productCategoryIds = list;
        this.quantity = i11;
        this.price = f11;
        this.absoluteDiscount = f12;
        this.appliedCampaigns = list2;
        this.total = f13;
        this.subtotal = f14;
        this.freeQuantity = i12;
        this.tags = list4;
        this.offerText = str3;
        this.tooltipAlertText = str4;
        this.productName = str5;
        this.imageUrl = str6;
        this.ageLimit = num;
        this.stock = num2;
    }

    public static /* synthetic */ CartResponseProduct copy$default(CartResponseProduct cartResponseProduct, String str, String str2, List list, int i11, float f11, float f12, List list2, float f13, float f14, int i12, List list3, String str3, String str4, String str5, String str6, Integer num, Integer num2, int i13, Object obj) {
        CartResponseProduct cartResponseProduct2 = cartResponseProduct;
        int i14 = i13;
        return cartResponseProduct.copy((i14 & 1) != 0 ? cartResponseProduct2.productId : str, (i14 & 2) != 0 ? cartResponseProduct2.productSku : str2, (i14 & 4) != 0 ? cartResponseProduct2.productCategoryIds : list, (i14 & 8) != 0 ? cartResponseProduct2.quantity : i11, (i14 & 16) != 0 ? cartResponseProduct2.price : f11, (i14 & 32) != 0 ? cartResponseProduct2.absoluteDiscount : f12, (i14 & 64) != 0 ? cartResponseProduct2.appliedCampaigns : list2, (i14 & 128) != 0 ? cartResponseProduct2.total : f13, (i14 & 256) != 0 ? cartResponseProduct2.subtotal : f14, (i14 & 512) != 0 ? cartResponseProduct2.freeQuantity : i12, (i14 & 1024) != 0 ? cartResponseProduct2.tags : list3, (i14 & 2048) != 0 ? cartResponseProduct2.offerText : str3, (i14 & 4096) != 0 ? cartResponseProduct2.tooltipAlertText : str4, (i14 & 8192) != 0 ? cartResponseProduct2.productName : str5, (i14 & 16384) != 0 ? cartResponseProduct2.imageUrl : str6, (i14 & 32768) != 0 ? cartResponseProduct2.ageLimit : num, (i14 & 65536) != 0 ? cartResponseProduct2.stock : num2);
    }

    @NotNull
    public final String component1() {
        return this.productId;
    }

    public final int component10() {
        return this.freeQuantity;
    }

    @NotNull
    public final List<String> component11() {
        return this.tags;
    }

    @Nullable
    public final String component12() {
        return this.offerText;
    }

    @Nullable
    public final String component13() {
        return this.tooltipAlertText;
    }

    @Nullable
    public final String component14() {
        return this.productName;
    }

    @Nullable
    public final String component15() {
        return this.imageUrl;
    }

    @Nullable
    public final Integer component16() {
        return this.ageLimit;
    }

    @Nullable
    public final Integer component17() {
        return this.stock;
    }

    @Nullable
    public final String component2() {
        return this.productSku;
    }

    @Nullable
    public final List<String> component3() {
        return this.productCategoryIds;
    }

    public final int component4() {
        return this.quantity;
    }

    public final float component5() {
        return this.price;
    }

    public final float component6() {
        return this.absoluteDiscount;
    }

    @NotNull
    public final List<CampaignLabel> component7() {
        return this.appliedCampaigns;
    }

    public final float component8() {
        return this.total;
    }

    public final float component9() {
        return this.subtotal;
    }

    @NotNull
    public final CartResponseProduct copy(@NotNull @Json(name = "product_id") String str, @Nullable @Json(name = "product_sku") String str2, @Nullable @Json(name = "product_category_ids") List<String> list, @Json(name = "qty") int i11, float f11, @Json(name = "absolute_discount") float f12, @NotNull @Json(name = "applied_campaigns") List<CampaignLabel> list2, float f13, float f14, @Json(name = "free_qty") int i12, @NotNull @Json(name = "tags") List<String> list3, @Nullable @Json(name = "offer_text") String str3, @Nullable @Json(name = "tooltip_alert_text") String str4, @Nullable @Json(name = "product_name") String str5, @Nullable @Json(name = "product_image_url") String str6, @Nullable @Json(name = "age_limit") Integer num, @Nullable @Json(name = "stock") Integer num2) {
        String str7 = str;
        Intrinsics.checkNotNullParameter(str7, "productId");
        Intrinsics.checkNotNullParameter(list2, "appliedCampaigns");
        Intrinsics.checkNotNullParameter(list3, "tags");
        return new CartResponseProduct(str7, str2, list, i11, f11, f12, list2, f13, f14, i12, list3, str3, str4, str5, str6, num, num2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CartResponseProduct)) {
            return false;
        }
        CartResponseProduct cartResponseProduct = (CartResponseProduct) obj;
        return Intrinsics.areEqual((Object) this.productId, (Object) cartResponseProduct.productId) && Intrinsics.areEqual((Object) this.productSku, (Object) cartResponseProduct.productSku) && Intrinsics.areEqual((Object) this.productCategoryIds, (Object) cartResponseProduct.productCategoryIds) && this.quantity == cartResponseProduct.quantity && Intrinsics.areEqual((Object) Float.valueOf(this.price), (Object) Float.valueOf(cartResponseProduct.price)) && Intrinsics.areEqual((Object) Float.valueOf(this.absoluteDiscount), (Object) Float.valueOf(cartResponseProduct.absoluteDiscount)) && Intrinsics.areEqual((Object) this.appliedCampaigns, (Object) cartResponseProduct.appliedCampaigns) && Intrinsics.areEqual((Object) Float.valueOf(this.total), (Object) Float.valueOf(cartResponseProduct.total)) && Intrinsics.areEqual((Object) Float.valueOf(this.subtotal), (Object) Float.valueOf(cartResponseProduct.subtotal)) && this.freeQuantity == cartResponseProduct.freeQuantity && Intrinsics.areEqual((Object) this.tags, (Object) cartResponseProduct.tags) && Intrinsics.areEqual((Object) this.offerText, (Object) cartResponseProduct.offerText) && Intrinsics.areEqual((Object) this.tooltipAlertText, (Object) cartResponseProduct.tooltipAlertText) && Intrinsics.areEqual((Object) this.productName, (Object) cartResponseProduct.productName) && Intrinsics.areEqual((Object) this.imageUrl, (Object) cartResponseProduct.imageUrl) && Intrinsics.areEqual((Object) this.ageLimit, (Object) cartResponseProduct.ageLimit) && Intrinsics.areEqual((Object) this.stock, (Object) cartResponseProduct.stock);
    }

    public final float getAbsoluteDiscount() {
        return this.absoluteDiscount;
    }

    @Nullable
    public final Integer getAgeLimit() {
        return this.ageLimit;
    }

    @NotNull
    public final List<CampaignLabel> getAppliedCampaigns() {
        return this.appliedCampaigns;
    }

    public final int getFreeQuantity() {
        return this.freeQuantity;
    }

    @Nullable
    public final String getImageUrl() {
        return this.imageUrl;
    }

    @Nullable
    public final String getOfferText() {
        return this.offerText;
    }

    public final float getPrice() {
        return this.price;
    }

    @Nullable
    public final List<String> getProductCategoryIds() {
        return this.productCategoryIds;
    }

    @NotNull
    public final String getProductId() {
        return this.productId;
    }

    @Nullable
    public final String getProductName() {
        return this.productName;
    }

    @Nullable
    public final String getProductSku() {
        return this.productSku;
    }

    public final int getQuantity() {
        return this.quantity;
    }

    @Nullable
    public final Integer getStock() {
        return this.stock;
    }

    public final float getSubtotal() {
        return this.subtotal;
    }

    @NotNull
    public final List<String> getTags() {
        return this.tags;
    }

    @Nullable
    public final String getTooltipAlertText() {
        return this.tooltipAlertText;
    }

    public final float getTotal() {
        return this.total;
    }

    public int hashCode() {
        int hashCode = this.productId.hashCode() * 31;
        String str = this.productSku;
        int i11 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        List<String> list = this.productCategoryIds;
        int hashCode3 = (((((((((((((((((hashCode2 + (list == null ? 0 : list.hashCode())) * 31) + this.quantity) * 31) + Float.floatToIntBits(this.price)) * 31) + Float.floatToIntBits(this.absoluteDiscount)) * 31) + this.appliedCampaigns.hashCode()) * 31) + Float.floatToIntBits(this.total)) * 31) + Float.floatToIntBits(this.subtotal)) * 31) + this.freeQuantity) * 31) + this.tags.hashCode()) * 31;
        String str2 = this.offerText;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.tooltipAlertText;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.productName;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.imageUrl;
        int hashCode7 = (hashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Integer num = this.ageLimit;
        int hashCode8 = (hashCode7 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.stock;
        if (num2 != null) {
            i11 = num2.hashCode();
        }
        return hashCode8 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.productId;
        String str2 = this.productSku;
        List<String> list = this.productCategoryIds;
        int i11 = this.quantity;
        float f11 = this.price;
        float f12 = this.absoluteDiscount;
        List<CampaignLabel> list2 = this.appliedCampaigns;
        float f13 = this.total;
        float f14 = this.subtotal;
        int i12 = this.freeQuantity;
        List<String> list3 = this.tags;
        String str3 = this.offerText;
        String str4 = this.tooltipAlertText;
        String str5 = this.productName;
        String str6 = this.imageUrl;
        Integer num = this.ageLimit;
        Integer num2 = this.stock;
        return "CartResponseProduct(productId=" + str + ", productSku=" + str2 + ", productCategoryIds=" + list + ", quantity=" + i11 + ", price=" + f11 + ", absoluteDiscount=" + f12 + ", appliedCampaigns=" + list2 + ", total=" + f13 + ", subtotal=" + f14 + ", freeQuantity=" + i12 + ", tags=" + list3 + ", offerText=" + str3 + ", tooltipAlertText=" + str4 + ", productName=" + str5 + ", imageUrl=" + str6 + ", ageLimit=" + num + ", stock=" + num2 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CartResponseProduct(java.lang.String r21, java.lang.String r22, java.util.List r23, int r24, float r25, float r26, java.util.List r27, float r28, float r29, int r30, java.util.List r31, java.lang.String r32, java.lang.String r33, java.lang.String r34, java.lang.String r35, java.lang.Integer r36, java.lang.Integer r37, int r38, kotlin.jvm.internal.DefaultConstructorMarker r39) {
        /*
            r20 = this;
            r0 = r38
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0009
            r1 = 0
            r12 = r1
            goto L_0x000b
        L_0x0009:
            r12 = r30
        L_0x000b:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x0015
            java.util.List r1 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            r13 = r1
            goto L_0x0017
        L_0x0015:
            r13 = r31
        L_0x0017:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            r2 = 0
            if (r1 == 0) goto L_0x001e
            r14 = r2
            goto L_0x0020
        L_0x001e:
            r14 = r32
        L_0x0020:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x0026
            r15 = r2
            goto L_0x0028
        L_0x0026:
            r15 = r33
        L_0x0028:
            r1 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x002f
            r16 = r2
            goto L_0x0031
        L_0x002f:
            r16 = r34
        L_0x0031:
            r1 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x0038
            r17 = r2
            goto L_0x003a
        L_0x0038:
            r17 = r35
        L_0x003a:
            r1 = 32768(0x8000, float:4.5918E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0043
            r18 = r2
            goto L_0x0045
        L_0x0043:
            r18 = r36
        L_0x0045:
            r1 = 65536(0x10000, float:9.18355E-41)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x004d
            r19 = r2
            goto L_0x004f
        L_0x004d:
            r19 = r37
        L_0x004f:
            r2 = r20
            r3 = r21
            r4 = r22
            r5 = r23
            r6 = r24
            r7 = r25
            r8 = r26
            r9 = r27
            r10 = r28
            r11 = r29
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.darkstorescart.data.model.CartResponseProduct.<init>(java.lang.String, java.lang.String, java.util.List, int, float, float, java.util.List, float, float, int, java.util.List, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
