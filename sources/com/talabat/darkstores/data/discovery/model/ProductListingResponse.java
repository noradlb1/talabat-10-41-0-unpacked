package com.talabat.darkstores.data.discovery.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import com.talabat.feature.darkstorescart.data.model.Product;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/talabat/darkstores/data/discovery/model/ProductListingResponse;", "", "product", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "requestId", "", "(Lcom/talabat/feature/darkstorescart/data/model/Product;Ljava/lang/String;)V", "getProduct", "()Lcom/talabat/feature/darkstorescart/data/model/Product;", "getRequestId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ProductListingResponse {
    @Nullable
    private final Product product;
    @Nullable
    private final String requestId;

    public ProductListingResponse() {
        this((Product) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public ProductListingResponse(@Nullable @Json(name = "data") Product product2, @Nullable @Json(name = "request_id") String str) {
        this.product = product2;
        this.requestId = str;
    }

    public static /* synthetic */ ProductListingResponse copy$default(ProductListingResponse productListingResponse, Product product2, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            product2 = productListingResponse.product;
        }
        if ((i11 & 2) != 0) {
            str = productListingResponse.requestId;
        }
        return productListingResponse.copy(product2, str);
    }

    @Nullable
    public final Product component1() {
        return this.product;
    }

    @Nullable
    public final String component2() {
        return this.requestId;
    }

    @NotNull
    public final ProductListingResponse copy(@Nullable @Json(name = "data") Product product2, @Nullable @Json(name = "request_id") String str) {
        return new ProductListingResponse(product2, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductListingResponse)) {
            return false;
        }
        ProductListingResponse productListingResponse = (ProductListingResponse) obj;
        return Intrinsics.areEqual((Object) this.product, (Object) productListingResponse.product) && Intrinsics.areEqual((Object) this.requestId, (Object) productListingResponse.requestId);
    }

    @Nullable
    public final Product getProduct() {
        return this.product;
    }

    @Nullable
    public final String getRequestId() {
        return this.requestId;
    }

    public int hashCode() {
        Product product2 = this.product;
        int i11 = 0;
        int hashCode = (product2 == null ? 0 : product2.hashCode()) * 31;
        String str = this.requestId;
        if (str != null) {
            i11 = str.hashCode();
        }
        return hashCode + i11;
    }

    @NotNull
    public String toString() {
        Product product2 = this.product;
        String str = this.requestId;
        return "ProductListingResponse(product=" + product2 + ", requestId=" + str + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ProductListingResponse(Product product2, String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : product2, (i11 & 2) != 0 ? null : str);
    }
}
