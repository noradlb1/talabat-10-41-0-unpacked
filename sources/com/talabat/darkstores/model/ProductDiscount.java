package com.talabat.darkstores.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/talabat/darkstores/model/ProductDiscount;", "", "productId", "", "originalPrice", "", "discountedPrice", "(Ljava/lang/String;FF)V", "getDiscountedPrice", "()F", "getOriginalPrice", "getProductId", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ProductDiscount {
    private final float discountedPrice;
    private final float originalPrice;
    @NotNull
    private final String productId;

    public ProductDiscount(@NotNull @Json(name = "product_id") String str, @Json(name = "original_price") float f11, @Json(name = "discounted_price") float f12) {
        Intrinsics.checkNotNullParameter(str, "productId");
        this.productId = str;
        this.originalPrice = f11;
        this.discountedPrice = f12;
    }

    public static /* synthetic */ ProductDiscount copy$default(ProductDiscount productDiscount, String str, float f11, float f12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = productDiscount.productId;
        }
        if ((i11 & 2) != 0) {
            f11 = productDiscount.originalPrice;
        }
        if ((i11 & 4) != 0) {
            f12 = productDiscount.discountedPrice;
        }
        return productDiscount.copy(str, f11, f12);
    }

    @NotNull
    public final String component1() {
        return this.productId;
    }

    public final float component2() {
        return this.originalPrice;
    }

    public final float component3() {
        return this.discountedPrice;
    }

    @NotNull
    public final ProductDiscount copy(@NotNull @Json(name = "product_id") String str, @Json(name = "original_price") float f11, @Json(name = "discounted_price") float f12) {
        Intrinsics.checkNotNullParameter(str, "productId");
        return new ProductDiscount(str, f11, f12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductDiscount)) {
            return false;
        }
        ProductDiscount productDiscount = (ProductDiscount) obj;
        return Intrinsics.areEqual((Object) this.productId, (Object) productDiscount.productId) && Intrinsics.areEqual((Object) Float.valueOf(this.originalPrice), (Object) Float.valueOf(productDiscount.originalPrice)) && Intrinsics.areEqual((Object) Float.valueOf(this.discountedPrice), (Object) Float.valueOf(productDiscount.discountedPrice));
    }

    public final float getDiscountedPrice() {
        return this.discountedPrice;
    }

    public final float getOriginalPrice() {
        return this.originalPrice;
    }

    @NotNull
    public final String getProductId() {
        return this.productId;
    }

    public int hashCode() {
        return (((this.productId.hashCode() * 31) + Float.floatToIntBits(this.originalPrice)) * 31) + Float.floatToIntBits(this.discountedPrice);
    }

    @NotNull
    public String toString() {
        String str = this.productId;
        float f11 = this.originalPrice;
        float f12 = this.discountedPrice;
        return "ProductDiscount(productId=" + str + ", originalPrice=" + f11 + ", discountedPrice=" + f12 + ")";
    }
}
