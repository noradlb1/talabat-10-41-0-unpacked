package com.talabat.darkstores.feature.categories.subcategories;

import com.talabat.feature.darkstorescart.data.model.Product;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\nHÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/talabat/darkstores/feature/categories/subcategories/SubcategoryProduct;", "Lcom/talabat/darkstores/feature/categories/subcategories/SubcategoryItem;", "product", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "headlineIndex", "", "(Lcom/talabat/feature/darkstorescart/data/model/Product;I)V", "getHeadlineIndex", "()I", "id", "", "getId", "()Ljava/lang/String;", "getProduct", "()Lcom/talabat/feature/darkstorescart/data/model/Product;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubcategoryProduct extends SubcategoryItem {
    private final int headlineIndex;
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private final String f56329id;
    @NotNull
    private final Product product;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SubcategoryProduct(@NotNull Product product2, int i11) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(product2, "product");
        this.product = product2;
        this.headlineIndex = i11;
        this.f56329id = product2.getId();
    }

    public static /* synthetic */ SubcategoryProduct copy$default(SubcategoryProduct subcategoryProduct, Product product2, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            product2 = subcategoryProduct.product;
        }
        if ((i12 & 2) != 0) {
            i11 = subcategoryProduct.getHeadlineIndex();
        }
        return subcategoryProduct.copy(product2, i11);
    }

    @NotNull
    public final Product component1() {
        return this.product;
    }

    public final int component2() {
        return getHeadlineIndex();
    }

    @NotNull
    public final SubcategoryProduct copy(@NotNull Product product2, int i11) {
        Intrinsics.checkNotNullParameter(product2, "product");
        return new SubcategoryProduct(product2, i11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubcategoryProduct)) {
            return false;
        }
        SubcategoryProduct subcategoryProduct = (SubcategoryProduct) obj;
        return Intrinsics.areEqual((Object) this.product, (Object) subcategoryProduct.product) && getHeadlineIndex() == subcategoryProduct.getHeadlineIndex();
    }

    public int getHeadlineIndex() {
        return this.headlineIndex;
    }

    @NotNull
    public String getId() {
        return this.f56329id;
    }

    @NotNull
    public final Product getProduct() {
        return this.product;
    }

    public int hashCode() {
        return (this.product.hashCode() * 31) + getHeadlineIndex();
    }

    @NotNull
    public String toString() {
        Product product2 = this.product;
        int headlineIndex2 = getHeadlineIndex();
        return "SubcategoryProduct(product=" + product2 + ", headlineIndex=" + headlineIndex2 + ")";
    }
}
