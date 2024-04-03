package com.talabat.darkstores.data.tracking;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b \b\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005¢\u0006\u0002\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\nHÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003Je\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u0005HÆ\u0001J\u0013\u0010&\u001a\u00020\u00072\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\u0003HÖ\u0001J\t\u0010)\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013¨\u0006*"}, d2 = {"Lcom/talabat/darkstores/data/tracking/ProductTrackingData;", "", "ageLimit", "", "description", "", "isFavorite", "", "name", "price", "", "quantity", "sku", "nmrAdId", "shopSponsoring", "(ILjava/lang/String;ZLjava/lang/String;FILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAgeLimit", "()I", "getDescription", "()Ljava/lang/String;", "()Z", "getName", "getNmrAdId", "getPrice", "()F", "getQuantity", "getShopSponsoring", "getSku", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ProductTrackingData {
    private final int ageLimit;
    @Nullable
    private final String description;
    private final boolean isFavorite;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f56219name;
    @NotNull
    private final String nmrAdId;
    private final float price;
    private final int quantity;
    @NotNull
    private final String shopSponsoring;
    @NotNull
    private final String sku;

    public ProductTrackingData(int i11, @Nullable String str, boolean z11, @NotNull String str2, float f11, int i12, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(str3, "sku");
        Intrinsics.checkNotNullParameter(str4, ProductTrackingProvider.NMR_AD_ID);
        Intrinsics.checkNotNullParameter(str5, "shopSponsoring");
        this.ageLimit = i11;
        this.description = str;
        this.isFavorite = z11;
        this.f56219name = str2;
        this.price = f11;
        this.quantity = i12;
        this.sku = str3;
        this.nmrAdId = str4;
        this.shopSponsoring = str5;
    }

    public static /* synthetic */ ProductTrackingData copy$default(ProductTrackingData productTrackingData, int i11, String str, boolean z11, String str2, float f11, int i12, String str3, String str4, String str5, int i13, Object obj) {
        ProductTrackingData productTrackingData2 = productTrackingData;
        int i14 = i13;
        return productTrackingData.copy((i14 & 1) != 0 ? productTrackingData2.ageLimit : i11, (i14 & 2) != 0 ? productTrackingData2.description : str, (i14 & 4) != 0 ? productTrackingData2.isFavorite : z11, (i14 & 8) != 0 ? productTrackingData2.f56219name : str2, (i14 & 16) != 0 ? productTrackingData2.price : f11, (i14 & 32) != 0 ? productTrackingData2.quantity : i12, (i14 & 64) != 0 ? productTrackingData2.sku : str3, (i14 & 128) != 0 ? productTrackingData2.nmrAdId : str4, (i14 & 256) != 0 ? productTrackingData2.shopSponsoring : str5);
    }

    public final int component1() {
        return this.ageLimit;
    }

    @Nullable
    public final String component2() {
        return this.description;
    }

    public final boolean component3() {
        return this.isFavorite;
    }

    @NotNull
    public final String component4() {
        return this.f56219name;
    }

    public final float component5() {
        return this.price;
    }

    public final int component6() {
        return this.quantity;
    }

    @NotNull
    public final String component7() {
        return this.sku;
    }

    @NotNull
    public final String component8() {
        return this.nmrAdId;
    }

    @NotNull
    public final String component9() {
        return this.shopSponsoring;
    }

    @NotNull
    public final ProductTrackingData copy(int i11, @Nullable String str, boolean z11, @NotNull String str2, float f11, int i12, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str2, "name");
        String str6 = str3;
        Intrinsics.checkNotNullParameter(str6, "sku");
        String str7 = str4;
        Intrinsics.checkNotNullParameter(str7, ProductTrackingProvider.NMR_AD_ID);
        String str8 = str5;
        Intrinsics.checkNotNullParameter(str8, "shopSponsoring");
        return new ProductTrackingData(i11, str, z11, str2, f11, i12, str6, str7, str8);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductTrackingData)) {
            return false;
        }
        ProductTrackingData productTrackingData = (ProductTrackingData) obj;
        return this.ageLimit == productTrackingData.ageLimit && Intrinsics.areEqual((Object) this.description, (Object) productTrackingData.description) && this.isFavorite == productTrackingData.isFavorite && Intrinsics.areEqual((Object) this.f56219name, (Object) productTrackingData.f56219name) && Intrinsics.areEqual((Object) Float.valueOf(this.price), (Object) Float.valueOf(productTrackingData.price)) && this.quantity == productTrackingData.quantity && Intrinsics.areEqual((Object) this.sku, (Object) productTrackingData.sku) && Intrinsics.areEqual((Object) this.nmrAdId, (Object) productTrackingData.nmrAdId) && Intrinsics.areEqual((Object) this.shopSponsoring, (Object) productTrackingData.shopSponsoring);
    }

    public final int getAgeLimit() {
        return this.ageLimit;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final String getName() {
        return this.f56219name;
    }

    @NotNull
    public final String getNmrAdId() {
        return this.nmrAdId;
    }

    public final float getPrice() {
        return this.price;
    }

    public final int getQuantity() {
        return this.quantity;
    }

    @NotNull
    public final String getShopSponsoring() {
        return this.shopSponsoring;
    }

    @NotNull
    public final String getSku() {
        return this.sku;
    }

    public int hashCode() {
        int i11 = this.ageLimit * 31;
        String str = this.description;
        int hashCode = (i11 + (str == null ? 0 : str.hashCode())) * 31;
        boolean z11 = this.isFavorite;
        if (z11) {
            z11 = true;
        }
        return ((((((((((((hashCode + (z11 ? 1 : 0)) * 31) + this.f56219name.hashCode()) * 31) + Float.floatToIntBits(this.price)) * 31) + this.quantity) * 31) + this.sku.hashCode()) * 31) + this.nmrAdId.hashCode()) * 31) + this.shopSponsoring.hashCode();
    }

    public final boolean isFavorite() {
        return this.isFavorite;
    }

    @NotNull
    public String toString() {
        int i11 = this.ageLimit;
        String str = this.description;
        boolean z11 = this.isFavorite;
        String str2 = this.f56219name;
        float f11 = this.price;
        int i12 = this.quantity;
        String str3 = this.sku;
        String str4 = this.nmrAdId;
        String str5 = this.shopSponsoring;
        return "ProductTrackingData(ageLimit=" + i11 + ", description=" + str + ", isFavorite=" + z11 + ", name=" + str2 + ", price=" + f11 + ", quantity=" + i12 + ", sku=" + str3 + ", nmrAdId=" + str4 + ", shopSponsoring=" + str5 + ")";
    }
}
