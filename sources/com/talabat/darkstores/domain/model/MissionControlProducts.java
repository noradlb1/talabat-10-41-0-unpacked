package com.talabat.darkstores.domain.model;

import com.talabat.darkstores.data.SearchCategory;
import com.talabat.feature.darkstorescart.data.model.Product;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B5\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\nHÆ\u0003J?\u0010\u0016\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\u0016\u0010\u001d\u001a\u00020\u00002\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016R\u001c\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\t\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u000eR\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\r¨\u0006\u001f"}, d2 = {"Lcom/talabat/darkstores/domain/model/MissionControlProducts;", "Lcom/talabat/darkstores/domain/model/ProductsHolderWithPagination;", "products", "", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "pageNumber", "", "categories", "Lcom/talabat/darkstores/data/SearchCategory;", "isLast", "", "(Ljava/util/List;ILjava/util/List;Z)V", "getCategories", "()Ljava/util/List;", "()Z", "getPageNumber", "()I", "getProducts", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "toString", "", "withProducts", "newProducts", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MissionControlProducts implements ProductsHolderWithPagination<MissionControlProducts> {
    @Nullable
    private final List<SearchCategory> categories;
    private final boolean isLast;
    private final int pageNumber;
    @NotNull
    private final List<Product> products;

    public MissionControlProducts(@NotNull List<Product> list, int i11, @Nullable List<SearchCategory> list2, boolean z11) {
        Intrinsics.checkNotNullParameter(list, "products");
        this.products = list;
        this.pageNumber = i11;
        this.categories = list2;
        this.isLast = z11;
    }

    public static /* synthetic */ MissionControlProducts copy$default(MissionControlProducts missionControlProducts, List<Product> list, int i11, List<SearchCategory> list2, boolean z11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            list = missionControlProducts.getProducts();
        }
        if ((i12 & 2) != 0) {
            i11 = missionControlProducts.getPageNumber();
        }
        if ((i12 & 4) != 0) {
            list2 = missionControlProducts.getCategories();
        }
        if ((i12 & 8) != 0) {
            z11 = missionControlProducts.isLast();
        }
        return missionControlProducts.copy(list, i11, list2, z11);
    }

    @NotNull
    public final List<Product> component1() {
        return getProducts();
    }

    public final int component2() {
        return getPageNumber();
    }

    @Nullable
    public final List<SearchCategory> component3() {
        return getCategories();
    }

    public final boolean component4() {
        return isLast();
    }

    @NotNull
    public final MissionControlProducts copy(@NotNull List<Product> list, int i11, @Nullable List<SearchCategory> list2, boolean z11) {
        Intrinsics.checkNotNullParameter(list, "products");
        return new MissionControlProducts(list, i11, list2, z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MissionControlProducts)) {
            return false;
        }
        MissionControlProducts missionControlProducts = (MissionControlProducts) obj;
        return Intrinsics.areEqual((Object) getProducts(), (Object) missionControlProducts.getProducts()) && getPageNumber() == missionControlProducts.getPageNumber() && Intrinsics.areEqual((Object) getCategories(), (Object) missionControlProducts.getCategories()) && isLast() == missionControlProducts.isLast();
    }

    @Nullable
    public List<SearchCategory> getCategories() {
        return this.categories;
    }

    public int getPageNumber() {
        return this.pageNumber;
    }

    @NotNull
    public List<Product> getProducts() {
        return this.products;
    }

    public int hashCode() {
        int hashCode = ((((getProducts().hashCode() * 31) + getPageNumber()) * 31) + (getCategories() == null ? 0 : getCategories().hashCode())) * 31;
        boolean isLast2 = isLast();
        if (isLast2) {
            isLast2 = true;
        }
        return hashCode + (isLast2 ? 1 : 0);
    }

    public boolean isLast() {
        return this.isLast;
    }

    @NotNull
    public String toString() {
        List<Product> products2 = getProducts();
        int pageNumber2 = getPageNumber();
        List<SearchCategory> categories2 = getCategories();
        boolean isLast2 = isLast();
        return "MissionControlProducts(products=" + products2 + ", pageNumber=" + pageNumber2 + ", categories=" + categories2 + ", isLast=" + isLast2 + ")";
    }

    @NotNull
    public MissionControlProducts withProducts(@NotNull List<Product> list) {
        Intrinsics.checkNotNullParameter(list, "newProducts");
        return copy$default(this, list, 0, (List) null, false, 14, (Object) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MissionControlProducts(List list, int i11, List list2, boolean z11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, i11, (i12 & 4) != 0 ? null : list2, z11);
    }
}
