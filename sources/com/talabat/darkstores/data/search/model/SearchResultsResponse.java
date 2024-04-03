package com.talabat.darkstores.data.search.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import com.talabat.darkstores.feature.tracking.SearchResultScreenType;
import com.talabat.darkstores.model.SearchResponse;
import com.talabat.feature.darkstorescart.data.model.Product;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0002 !B+\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0001\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J/\u0010\u0017\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\u000e\b\u0003\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\""}, d2 = {"Lcom/talabat/darkstores/data/search/model/SearchResultsResponse;", "Lcom/talabat/darkstores/model/SearchResponse;", "filters", "Lcom/talabat/darkstores/data/search/model/Filters;", "itemCounts", "Lcom/talabat/darkstores/data/search/model/SearchResultsResponse$ItemCounts;", "products", "", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "(Lcom/talabat/darkstores/data/search/model/Filters;Lcom/talabat/darkstores/data/search/model/SearchResultsResponse$ItemCounts;Ljava/util/List;)V", "getFilters", "()Lcom/talabat/darkstores/data/search/model/Filters;", "getItemCounts", "()Lcom/talabat/darkstores/data/search/model/SearchResultsResponse$ItemCounts;", "getProducts", "()Ljava/util/List;", "trackingData", "Lcom/talabat/darkstores/model/SearchResponse$TrackingData;", "getTrackingData", "()Lcom/talabat/darkstores/model/SearchResponse$TrackingData;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ItemCounts", "Result", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SearchResultsResponse implements SearchResponse {
    @Nullable
    private final Filters filters;
    @NotNull
    private final ItemCounts itemCounts;
    @NotNull
    private final List<Product> products;
    @NotNull
    private final SearchResponse.TrackingData trackingData;

    @JsonClass(generateAdapter = true)
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/talabat/darkstores/data/search/model/SearchResultsResponse$ItemCounts;", "", "returned", "", "total", "(II)V", "getReturned", "()I", "getTotal", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ItemCounts {
        private final int returned;
        private final int total;

        public ItemCounts(@Json(name = "returned") int i11, @Json(name = "total") int i12) {
            this.returned = i11;
            this.total = i12;
        }

        public static /* synthetic */ ItemCounts copy$default(ItemCounts itemCounts, int i11, int i12, int i13, Object obj) {
            if ((i13 & 1) != 0) {
                i11 = itemCounts.returned;
            }
            if ((i13 & 2) != 0) {
                i12 = itemCounts.total;
            }
            return itemCounts.copy(i11, i12);
        }

        public final int component1() {
            return this.returned;
        }

        public final int component2() {
            return this.total;
        }

        @NotNull
        public final ItemCounts copy(@Json(name = "returned") int i11, @Json(name = "total") int i12) {
            return new ItemCounts(i11, i12);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ItemCounts)) {
                return false;
            }
            ItemCounts itemCounts = (ItemCounts) obj;
            return this.returned == itemCounts.returned && this.total == itemCounts.total;
        }

        public final int getReturned() {
            return this.returned;
        }

        public final int getTotal() {
            return this.total;
        }

        public int hashCode() {
            return (this.returned * 31) + this.total;
        }

        @NotNull
        public String toString() {
            int i11 = this.returned;
            int i12 = this.total;
            return "ItemCounts(returned=" + i11 + ", total=" + i12 + ")";
        }
    }

    @JsonClass(generateAdapter = true)
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/talabat/darkstores/data/search/model/SearchResultsResponse$Result;", "", "product", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "(Lcom/talabat/feature/darkstorescart/data/model/Product;)V", "getProduct", "()Lcom/talabat/feature/darkstorescart/data/model/Product;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Result {
        @NotNull
        private final Product product;

        public Result(@NotNull @Json(name = "payload") Product product2) {
            Intrinsics.checkNotNullParameter(product2, "product");
            this.product = product2;
        }

        public static /* synthetic */ Result copy$default(Result result, Product product2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                product2 = result.product;
            }
            return result.copy(product2);
        }

        @NotNull
        public final Product component1() {
            return this.product;
        }

        @NotNull
        public final Result copy(@NotNull @Json(name = "payload") Product product2) {
            Intrinsics.checkNotNullParameter(product2, "product");
            return new Result(product2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Result) && Intrinsics.areEqual((Object) this.product, (Object) ((Result) obj).product);
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
            return "Result(product=" + product2 + ")";
        }
    }

    public SearchResultsResponse(@Nullable @Json(name = "filters") Filters filters2, @NotNull @Json(name = "item_counts") ItemCounts itemCounts2, @NotNull @Json(name = "products") List<Product> list) {
        Intrinsics.checkNotNullParameter(itemCounts2, "itemCounts");
        Intrinsics.checkNotNullParameter(list, "products");
        this.filters = filters2;
        this.itemCounts = itemCounts2;
        this.products = list;
        boolean isEmpty = list.isEmpty();
        SearchResultScreenType searchResultScreenType = SearchResultScreenType.FULL;
        int returned = itemCounts2.getReturned();
        ArrayList arrayList = new ArrayList();
        for (Product sku : list) {
            String sku2 = sku.getSku();
            sku2 = !(StringsKt__StringsJVMKt.isBlank(sku2) ^ true) ? null : sku2;
            if (sku2 != null) {
                arrayList.add(sku2);
            }
        }
        this.trackingData = new SearchResponse.TrackingData(isEmpty, searchResultScreenType, returned, arrayList);
    }

    public static /* synthetic */ SearchResultsResponse copy$default(SearchResultsResponse searchResultsResponse, Filters filters2, ItemCounts itemCounts2, List<Product> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            filters2 = searchResultsResponse.filters;
        }
        if ((i11 & 2) != 0) {
            itemCounts2 = searchResultsResponse.itemCounts;
        }
        if ((i11 & 4) != 0) {
            list = searchResultsResponse.products;
        }
        return searchResultsResponse.copy(filters2, itemCounts2, list);
    }

    @Nullable
    public final Filters component1() {
        return this.filters;
    }

    @NotNull
    public final ItemCounts component2() {
        return this.itemCounts;
    }

    @NotNull
    public final List<Product> component3() {
        return this.products;
    }

    @NotNull
    public final SearchResultsResponse copy(@Nullable @Json(name = "filters") Filters filters2, @NotNull @Json(name = "item_counts") ItemCounts itemCounts2, @NotNull @Json(name = "products") List<Product> list) {
        Intrinsics.checkNotNullParameter(itemCounts2, "itemCounts");
        Intrinsics.checkNotNullParameter(list, "products");
        return new SearchResultsResponse(filters2, itemCounts2, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SearchResultsResponse)) {
            return false;
        }
        SearchResultsResponse searchResultsResponse = (SearchResultsResponse) obj;
        return Intrinsics.areEqual((Object) this.filters, (Object) searchResultsResponse.filters) && Intrinsics.areEqual((Object) this.itemCounts, (Object) searchResultsResponse.itemCounts) && Intrinsics.areEqual((Object) this.products, (Object) searchResultsResponse.products);
    }

    @Nullable
    public final Filters getFilters() {
        return this.filters;
    }

    @NotNull
    public final ItemCounts getItemCounts() {
        return this.itemCounts;
    }

    @NotNull
    public final List<Product> getProducts() {
        return this.products;
    }

    @NotNull
    public SearchResponse.TrackingData getTrackingData() {
        return this.trackingData;
    }

    public int hashCode() {
        Filters filters2 = this.filters;
        return ((((filters2 == null ? 0 : filters2.hashCode()) * 31) + this.itemCounts.hashCode()) * 31) + this.products.hashCode();
    }

    @NotNull
    public String toString() {
        Filters filters2 = this.filters;
        ItemCounts itemCounts2 = this.itemCounts;
        List<Product> list = this.products;
        return "SearchResultsResponse(filters=" + filters2 + ", itemCounts=" + itemCounts2 + ", products=" + list + ")";
    }
}
