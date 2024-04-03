package com.talabat.feature.darkstorescart.data.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/talabat/feature/darkstorescart/data/model/ProductTrigger;", "", "productId", "", "qty", "", "(Ljava/lang/String;I)V", "getProductId", "()Ljava/lang/String;", "getQty", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "com_talabat_feature_darkstores-cart_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ProductTrigger {
    @NotNull
    private final String productId;
    private final int qty;

    public ProductTrigger(@NotNull @Json(name = "product_id") String str, @Json(name = "qty") int i11) {
        Intrinsics.checkNotNullParameter(str, "productId");
        this.productId = str;
        this.qty = i11;
    }

    public static /* synthetic */ ProductTrigger copy$default(ProductTrigger productTrigger, String str, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = productTrigger.productId;
        }
        if ((i12 & 2) != 0) {
            i11 = productTrigger.qty;
        }
        return productTrigger.copy(str, i11);
    }

    @NotNull
    public final String component1() {
        return this.productId;
    }

    public final int component2() {
        return this.qty;
    }

    @NotNull
    public final ProductTrigger copy(@NotNull @Json(name = "product_id") String str, @Json(name = "qty") int i11) {
        Intrinsics.checkNotNullParameter(str, "productId");
        return new ProductTrigger(str, i11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductTrigger)) {
            return false;
        }
        ProductTrigger productTrigger = (ProductTrigger) obj;
        return Intrinsics.areEqual((Object) this.productId, (Object) productTrigger.productId) && this.qty == productTrigger.qty;
    }

    @NotNull
    public final String getProductId() {
        return this.productId;
    }

    public final int getQty() {
        return this.qty;
    }

    public int hashCode() {
        return (this.productId.hashCode() * 31) + this.qty;
    }

    @NotNull
    public String toString() {
        String str = this.productId;
        int i11 = this.qty;
        return "ProductTrigger(productId=" + str + ", qty=" + i11 + ")";
    }
}
