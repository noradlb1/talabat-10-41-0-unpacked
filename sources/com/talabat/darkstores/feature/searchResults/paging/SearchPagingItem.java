package com.talabat.darkstores.feature.searchResults.paging;

import com.talabat.darkstores.data.SearchCategory;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/talabat/darkstores/feature/searchResults/paging/SearchPagingItem;", "", "()V", "Categories", "Product", "TotalCount", "Lcom/talabat/darkstores/feature/searchResults/paging/SearchPagingItem$Categories;", "Lcom/talabat/darkstores/feature/searchResults/paging/SearchPagingItem$Product;", "Lcom/talabat/darkstores/feature/searchResults/paging/SearchPagingItem$TotalCount;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class SearchPagingItem {

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/talabat/darkstores/feature/searchResults/paging/SearchPagingItem$Categories;", "Lcom/talabat/darkstores/feature/searchResults/paging/SearchPagingItem;", "categories", "", "Lcom/talabat/darkstores/data/SearchCategory;", "(Ljava/util/List;)V", "getCategories", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Categories extends SearchPagingItem {
        @NotNull
        private final List<SearchCategory> categories;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Categories(@NotNull List<SearchCategory> list) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(list, "categories");
            this.categories = list;
        }

        public static /* synthetic */ Categories copy$default(Categories categories2, List<SearchCategory> list, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                list = categories2.categories;
            }
            return categories2.copy(list);
        }

        @NotNull
        public final List<SearchCategory> component1() {
            return this.categories;
        }

        @NotNull
        public final Categories copy(@NotNull List<SearchCategory> list) {
            Intrinsics.checkNotNullParameter(list, "categories");
            return new Categories(list);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Categories) && Intrinsics.areEqual((Object) this.categories, (Object) ((Categories) obj).categories);
        }

        @NotNull
        public final List<SearchCategory> getCategories() {
            return this.categories;
        }

        public int hashCode() {
            return this.categories.hashCode();
        }

        @NotNull
        public String toString() {
            List<SearchCategory> list = this.categories;
            return "Categories(categories=" + list + ")";
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/talabat/darkstores/feature/searchResults/paging/SearchPagingItem$Product;", "Lcom/talabat/darkstores/feature/searchResults/paging/SearchPagingItem;", "product", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "(Lcom/talabat/feature/darkstorescart/data/model/Product;)V", "getProduct", "()Lcom/talabat/feature/darkstorescart/data/model/Product;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Product extends SearchPagingItem {
        @NotNull
        private final com.talabat.feature.darkstorescart.data.model.Product product;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Product(@NotNull com.talabat.feature.darkstorescart.data.model.Product product2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(product2, "product");
            this.product = product2;
        }

        public static /* synthetic */ Product copy$default(Product product2, com.talabat.feature.darkstorescart.data.model.Product product3, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                product3 = product2.product;
            }
            return product2.copy(product3);
        }

        @NotNull
        public final com.talabat.feature.darkstorescart.data.model.Product component1() {
            return this.product;
        }

        @NotNull
        public final Product copy(@NotNull com.talabat.feature.darkstorescart.data.model.Product product2) {
            Intrinsics.checkNotNullParameter(product2, "product");
            return new Product(product2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Product) && Intrinsics.areEqual((Object) this.product, (Object) ((Product) obj).product);
        }

        @NotNull
        public final com.talabat.feature.darkstorescart.data.model.Product getProduct() {
            return this.product;
        }

        public int hashCode() {
            return this.product.hashCode();
        }

        @NotNull
        public String toString() {
            com.talabat.feature.darkstorescart.data.model.Product product2 = this.product;
            return "Product(product=" + product2 + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/talabat/darkstores/feature/searchResults/paging/SearchPagingItem$TotalCount;", "Lcom/talabat/darkstores/feature/searchResults/paging/SearchPagingItem;", "totalCount", "", "(I)V", "getTotalCount", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class TotalCount extends SearchPagingItem {
        private final int totalCount;

        public TotalCount(int i11) {
            super((DefaultConstructorMarker) null);
            this.totalCount = i11;
        }

        public static /* synthetic */ TotalCount copy$default(TotalCount totalCount2, int i11, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i11 = totalCount2.totalCount;
            }
            return totalCount2.copy(i11);
        }

        public final int component1() {
            return this.totalCount;
        }

        @NotNull
        public final TotalCount copy(int i11) {
            return new TotalCount(i11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof TotalCount) && this.totalCount == ((TotalCount) obj).totalCount;
        }

        public final int getTotalCount() {
            return this.totalCount;
        }

        public int hashCode() {
            return this.totalCount;
        }

        @NotNull
        public String toString() {
            int i11 = this.totalCount;
            return "TotalCount(totalCount=" + i11 + ")";
        }
    }

    private SearchPagingItem() {
    }

    public /* synthetic */ SearchPagingItem(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
