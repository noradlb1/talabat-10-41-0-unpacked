package com.talabat.darkstores.data;

import com.talabat.darkstores.domain.model.ProductsHolder;
import com.talabat.feature.darkstorescart.data.model.Product;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001BM\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J\u0011\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\rHÆ\u0003JU\u0010\u001f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\tHÖ\u0001J\t\u0010%\u001a\u00020\u0006HÖ\u0001J\u0016\u0010&\u001a\u00020\u00002\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016R\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006("}, d2 = {"Lcom/talabat/darkstores/data/SearchResultData;", "Lcom/talabat/darkstores/domain/model/ProductsHolder;", "products", "", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "swimlaneId", "", "swimlaneName", "totalCount", "", "categories", "Lcom/talabat/darkstores/data/SearchCategory;", "trackingInfo", "Lcom/talabat/darkstores/data/TrackingInfo;", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Lcom/talabat/darkstores/data/TrackingInfo;)V", "getCategories", "()Ljava/util/List;", "getProducts", "getSwimlaneId", "()Ljava/lang/String;", "getSwimlaneName", "getTotalCount", "()I", "getTrackingInfo", "()Lcom/talabat/darkstores/data/TrackingInfo;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "toString", "withProducts", "newProducts", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SearchResultData implements ProductsHolder<SearchResultData> {
    @Nullable
    private final List<SearchCategory> categories;
    @NotNull
    private final List<Product> products;
    @NotNull
    private final String swimlaneId;
    @NotNull
    private final String swimlaneName;
    private final int totalCount;
    @Nullable
    private final TrackingInfo trackingInfo;

    public SearchResultData(@NotNull List<Product> list, @NotNull String str, @NotNull String str2, int i11, @Nullable List<SearchCategory> list2, @Nullable TrackingInfo trackingInfo2) {
        Intrinsics.checkNotNullParameter(list, "products");
        Intrinsics.checkNotNullParameter(str, "swimlaneId");
        Intrinsics.checkNotNullParameter(str2, "swimlaneName");
        this.products = list;
        this.swimlaneId = str;
        this.swimlaneName = str2;
        this.totalCount = i11;
        this.categories = list2;
        this.trackingInfo = trackingInfo2;
    }

    public static /* synthetic */ SearchResultData copy$default(SearchResultData searchResultData, List<Product> list, String str, String str2, int i11, List<SearchCategory> list2, TrackingInfo trackingInfo2, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            list = searchResultData.getProducts();
        }
        if ((i12 & 2) != 0) {
            str = searchResultData.swimlaneId;
        }
        String str3 = str;
        if ((i12 & 4) != 0) {
            str2 = searchResultData.swimlaneName;
        }
        String str4 = str2;
        if ((i12 & 8) != 0) {
            i11 = searchResultData.totalCount;
        }
        int i13 = i11;
        if ((i12 & 16) != 0) {
            list2 = searchResultData.categories;
        }
        List<SearchCategory> list3 = list2;
        if ((i12 & 32) != 0) {
            trackingInfo2 = searchResultData.trackingInfo;
        }
        return searchResultData.copy(list, str3, str4, i13, list3, trackingInfo2);
    }

    @NotNull
    public final List<Product> component1() {
        return getProducts();
    }

    @NotNull
    public final String component2() {
        return this.swimlaneId;
    }

    @NotNull
    public final String component3() {
        return this.swimlaneName;
    }

    public final int component4() {
        return this.totalCount;
    }

    @Nullable
    public final List<SearchCategory> component5() {
        return this.categories;
    }

    @Nullable
    public final TrackingInfo component6() {
        return this.trackingInfo;
    }

    @NotNull
    public final SearchResultData copy(@NotNull List<Product> list, @NotNull String str, @NotNull String str2, int i11, @Nullable List<SearchCategory> list2, @Nullable TrackingInfo trackingInfo2) {
        Intrinsics.checkNotNullParameter(list, "products");
        Intrinsics.checkNotNullParameter(str, "swimlaneId");
        Intrinsics.checkNotNullParameter(str2, "swimlaneName");
        return new SearchResultData(list, str, str2, i11, list2, trackingInfo2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SearchResultData)) {
            return false;
        }
        SearchResultData searchResultData = (SearchResultData) obj;
        return Intrinsics.areEqual((Object) getProducts(), (Object) searchResultData.getProducts()) && Intrinsics.areEqual((Object) this.swimlaneId, (Object) searchResultData.swimlaneId) && Intrinsics.areEqual((Object) this.swimlaneName, (Object) searchResultData.swimlaneName) && this.totalCount == searchResultData.totalCount && Intrinsics.areEqual((Object) this.categories, (Object) searchResultData.categories) && Intrinsics.areEqual((Object) this.trackingInfo, (Object) searchResultData.trackingInfo);
    }

    @Nullable
    public final List<SearchCategory> getCategories() {
        return this.categories;
    }

    @NotNull
    public List<Product> getProducts() {
        return this.products;
    }

    @NotNull
    public final String getSwimlaneId() {
        return this.swimlaneId;
    }

    @NotNull
    public final String getSwimlaneName() {
        return this.swimlaneName;
    }

    public final int getTotalCount() {
        return this.totalCount;
    }

    @Nullable
    public final TrackingInfo getTrackingInfo() {
        return this.trackingInfo;
    }

    public int hashCode() {
        int hashCode = ((((((getProducts().hashCode() * 31) + this.swimlaneId.hashCode()) * 31) + this.swimlaneName.hashCode()) * 31) + this.totalCount) * 31;
        List<SearchCategory> list = this.categories;
        int i11 = 0;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        TrackingInfo trackingInfo2 = this.trackingInfo;
        if (trackingInfo2 != null) {
            i11 = trackingInfo2.hashCode();
        }
        return hashCode2 + i11;
    }

    @NotNull
    public String toString() {
        List<Product> products2 = getProducts();
        String str = this.swimlaneId;
        String str2 = this.swimlaneName;
        int i11 = this.totalCount;
        List<SearchCategory> list = this.categories;
        TrackingInfo trackingInfo2 = this.trackingInfo;
        return "SearchResultData(products=" + products2 + ", swimlaneId=" + str + ", swimlaneName=" + str2 + ", totalCount=" + i11 + ", categories=" + list + ", trackingInfo=" + trackingInfo2 + ")";
    }

    @NotNull
    public SearchResultData withProducts(@NotNull List<Product> list) {
        Intrinsics.checkNotNullParameter(list, "newProducts");
        return copy$default(this, list, (String) null, (String) null, 0, (List) null, (TrackingInfo) null, 62, (Object) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SearchResultData(List list, String str, String str2, int i11, List list2, TrackingInfo trackingInfo2, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i12 & 2) != 0 ? "" : str, (i12 & 4) != 0 ? "" : str2, i11, (i12 & 16) != 0 ? null : list2, (i12 & 32) != 0 ? null : trackingInfo2);
    }
}
