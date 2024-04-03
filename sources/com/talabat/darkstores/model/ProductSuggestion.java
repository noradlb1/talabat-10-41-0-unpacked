package com.talabat.darkstores.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import com.talabat.feature.darkstorescart.data.model.Product;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/talabat/darkstores/model/ProductSuggestion;", "Lcom/talabat/darkstores/model/SearchSuggestion;", "product", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "(Lcom/talabat/feature/darkstorescart/data/model/Product;)V", "getProduct", "()Lcom/talabat/feature/darkstorescart/data/model/Product;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ProductSuggestion extends SearchSuggestion {
    @NotNull
    private final Product product;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProductSuggestion(@NotNull @Json(name = "data") Product product2) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(product2, "product");
        this.product = product2;
    }

    public static /* synthetic */ ProductSuggestion copy$default(ProductSuggestion productSuggestion, Product product2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            product2 = productSuggestion.product;
        }
        return productSuggestion.copy(product2);
    }

    @NotNull
    public final Product component1() {
        return this.product;
    }

    @NotNull
    public final ProductSuggestion copy(@NotNull @Json(name = "data") Product product2) {
        Intrinsics.checkNotNullParameter(product2, "product");
        return new ProductSuggestion(product2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ProductSuggestion) && Intrinsics.areEqual((Object) this.product, (Object) ((ProductSuggestion) obj).product);
    }

    @NotNull
    public final Product getProduct() {
        return this.product;
    }

    public int hashCode() {
        return this.product.hashCode();
    }

    @NotNull
    public String toString() {
        Product product2 = this.product;
        return "ProductSuggestion(product=" + product2 + ")";
    }
}
