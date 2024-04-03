package com.talabat.core.navigation.domain.screen.checkout;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001Bq\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r¢\u0006\u0002\u0010\u0012J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\rHÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010*\u001a\u00020\bHÆ\u0003J\t\u0010+\u001a\u00020\nHÆ\u0003J\t\u0010,\u001a\u00020\nHÆ\u0003J\u000f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0003J\t\u0010.\u001a\u00020\nHÆ\u0003J\u0001\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\b\u0002\u0010\u000f\u001a\u00020\n2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\rHÆ\u0001J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u00020\bHÖ\u0001J\t\u00104\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u000f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0019R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0019¨\u00065"}, d2 = {"Lcom/talabat/core/navigation/domain/screen/checkout/ExitPointProduct;", "", "id", "", "name", "productDescription", "thumbnail", "quantity", "", "price", "", "originalPrice", "appliedCampaigns", "", "Lcom/talabat/core/navigation/domain/screen/checkout/ExitPointCampaign;", "absoluteDiscount", "sku", "categoryIds", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IFFLjava/util/List;FLjava/lang/String;Ljava/util/List;)V", "getAbsoluteDiscount", "()F", "getAppliedCampaigns", "()Ljava/util/List;", "getCategoryIds", "getId", "()Ljava/lang/String;", "getName", "getOriginalPrice", "getPrice", "getProductDescription", "getQuantity", "()I", "setQuantity", "(I)V", "getSku", "getThumbnail", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "com_talabat_core_navigation_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ExitPointProduct {
    private final float absoluteDiscount;
    @NotNull
    private final List<ExitPointCampaign> appliedCampaigns;
    @Nullable
    private final List<String> categoryIds;
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private final String f55953id;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f55954name;
    private final float originalPrice;
    private final float price;
    @Nullable
    private final String productDescription;
    private int quantity;
    @Nullable
    private final String sku;
    @Nullable
    private final String thumbnail;

    public ExitPointProduct(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4, int i11, float f11, float f12, @NotNull List<ExitPointCampaign> list, float f13, @Nullable String str5, @Nullable List<String> list2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(list, "appliedCampaigns");
        this.f55953id = str;
        this.f55954name = str2;
        this.productDescription = str3;
        this.thumbnail = str4;
        this.quantity = i11;
        this.price = f11;
        this.originalPrice = f12;
        this.appliedCampaigns = list;
        this.absoluteDiscount = f13;
        this.sku = str5;
        this.categoryIds = list2;
    }

    public static /* synthetic */ ExitPointProduct copy$default(ExitPointProduct exitPointProduct, String str, String str2, String str3, String str4, int i11, float f11, float f12, List list, float f13, String str5, List list2, int i12, Object obj) {
        ExitPointProduct exitPointProduct2 = exitPointProduct;
        int i13 = i12;
        return exitPointProduct.copy((i13 & 1) != 0 ? exitPointProduct2.f55953id : str, (i13 & 2) != 0 ? exitPointProduct2.f55954name : str2, (i13 & 4) != 0 ? exitPointProduct2.productDescription : str3, (i13 & 8) != 0 ? exitPointProduct2.thumbnail : str4, (i13 & 16) != 0 ? exitPointProduct2.quantity : i11, (i13 & 32) != 0 ? exitPointProduct2.price : f11, (i13 & 64) != 0 ? exitPointProduct2.originalPrice : f12, (i13 & 128) != 0 ? exitPointProduct2.appliedCampaigns : list, (i13 & 256) != 0 ? exitPointProduct2.absoluteDiscount : f13, (i13 & 512) != 0 ? exitPointProduct2.sku : str5, (i13 & 1024) != 0 ? exitPointProduct2.categoryIds : list2);
    }

    @NotNull
    public final String component1() {
        return this.f55953id;
    }

    @Nullable
    public final String component10() {
        return this.sku;
    }

    @Nullable
    public final List<String> component11() {
        return this.categoryIds;
    }

    @NotNull
    public final String component2() {
        return this.f55954name;
    }

    @Nullable
    public final String component3() {
        return this.productDescription;
    }

    @Nullable
    public final String component4() {
        return this.thumbnail;
    }

    public final int component5() {
        return this.quantity;
    }

    public final float component6() {
        return this.price;
    }

    public final float component7() {
        return this.originalPrice;
    }

    @NotNull
    public final List<ExitPointCampaign> component8() {
        return this.appliedCampaigns;
    }

    public final float component9() {
        return this.absoluteDiscount;
    }

    @NotNull
    public final ExitPointProduct copy(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4, int i11, float f11, float f12, @NotNull List<ExitPointCampaign> list, float f13, @Nullable String str5, @Nullable List<String> list2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "name");
        List<ExitPointCampaign> list3 = list;
        Intrinsics.checkNotNullParameter(list3, "appliedCampaigns");
        return new ExitPointProduct(str, str2, str3, str4, i11, f11, f12, list3, f13, str5, list2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExitPointProduct)) {
            return false;
        }
        ExitPointProduct exitPointProduct = (ExitPointProduct) obj;
        return Intrinsics.areEqual((Object) this.f55953id, (Object) exitPointProduct.f55953id) && Intrinsics.areEqual((Object) this.f55954name, (Object) exitPointProduct.f55954name) && Intrinsics.areEqual((Object) this.productDescription, (Object) exitPointProduct.productDescription) && Intrinsics.areEqual((Object) this.thumbnail, (Object) exitPointProduct.thumbnail) && this.quantity == exitPointProduct.quantity && Intrinsics.areEqual((Object) Float.valueOf(this.price), (Object) Float.valueOf(exitPointProduct.price)) && Intrinsics.areEqual((Object) Float.valueOf(this.originalPrice), (Object) Float.valueOf(exitPointProduct.originalPrice)) && Intrinsics.areEqual((Object) this.appliedCampaigns, (Object) exitPointProduct.appliedCampaigns) && Intrinsics.areEqual((Object) Float.valueOf(this.absoluteDiscount), (Object) Float.valueOf(exitPointProduct.absoluteDiscount)) && Intrinsics.areEqual((Object) this.sku, (Object) exitPointProduct.sku) && Intrinsics.areEqual((Object) this.categoryIds, (Object) exitPointProduct.categoryIds);
    }

    public final float getAbsoluteDiscount() {
        return this.absoluteDiscount;
    }

    @NotNull
    public final List<ExitPointCampaign> getAppliedCampaigns() {
        return this.appliedCampaigns;
    }

    @Nullable
    public final List<String> getCategoryIds() {
        return this.categoryIds;
    }

    @NotNull
    public final String getId() {
        return this.f55953id;
    }

    @NotNull
    public final String getName() {
        return this.f55954name;
    }

    public final float getOriginalPrice() {
        return this.originalPrice;
    }

    public final float getPrice() {
        return this.price;
    }

    @Nullable
    public final String getProductDescription() {
        return this.productDescription;
    }

    public final int getQuantity() {
        return this.quantity;
    }

    @Nullable
    public final String getSku() {
        return this.sku;
    }

    @Nullable
    public final String getThumbnail() {
        return this.thumbnail;
    }

    public int hashCode() {
        int hashCode = ((this.f55953id.hashCode() * 31) + this.f55954name.hashCode()) * 31;
        String str = this.productDescription;
        int i11 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.thumbnail;
        int hashCode3 = (((((((((((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.quantity) * 31) + Float.floatToIntBits(this.price)) * 31) + Float.floatToIntBits(this.originalPrice)) * 31) + this.appliedCampaigns.hashCode()) * 31) + Float.floatToIntBits(this.absoluteDiscount)) * 31;
        String str3 = this.sku;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        List<String> list = this.categoryIds;
        if (list != null) {
            i11 = list.hashCode();
        }
        return hashCode4 + i11;
    }

    public final void setQuantity(int i11) {
        this.quantity = i11;
    }

    @NotNull
    public String toString() {
        String str = this.f55953id;
        String str2 = this.f55954name;
        String str3 = this.productDescription;
        String str4 = this.thumbnail;
        int i11 = this.quantity;
        float f11 = this.price;
        float f12 = this.originalPrice;
        List<ExitPointCampaign> list = this.appliedCampaigns;
        float f13 = this.absoluteDiscount;
        String str5 = this.sku;
        List<String> list2 = this.categoryIds;
        return "ExitPointProduct(id=" + str + ", name=" + str2 + ", productDescription=" + str3 + ", thumbnail=" + str4 + ", quantity=" + i11 + ", price=" + f11 + ", originalPrice=" + f12 + ", appliedCampaigns=" + list + ", absoluteDiscount=" + f13 + ", sku=" + str5 + ", categoryIds=" + list2 + ")";
    }
}
