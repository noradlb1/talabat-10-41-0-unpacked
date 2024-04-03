package com.talabat.darkstores.data.mission.control.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import com.talabat.darkstores.data.search.model.Filters;
import com.talabat.feature.darkstorescart.data.model.Product;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B+\u0012\u000e\b\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\bHÆ\u0003J/\u0010\u0013\u001a\u00020\u00002\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/talabat/darkstores/data/mission/control/model/MissionControlProductsResult;", "", "products", "", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "pageInfo", "Lcom/talabat/darkstores/data/mission/control/model/PageInfo;", "filters", "Lcom/talabat/darkstores/data/search/model/Filters;", "(Ljava/util/List;Lcom/talabat/darkstores/data/mission/control/model/PageInfo;Lcom/talabat/darkstores/data/search/model/Filters;)V", "getFilters", "()Lcom/talabat/darkstores/data/search/model/Filters;", "getPageInfo", "()Lcom/talabat/darkstores/data/mission/control/model/PageInfo;", "getProducts", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MissionControlProductsResult {
    @Nullable
    private final Filters filters;
    @NotNull
    private final PageInfo pageInfo;
    @NotNull
    private final List<Product> products;

    public MissionControlProductsResult(@NotNull @Json(name = "products") List<Product> list, @NotNull @Json(name = "page_info") PageInfo pageInfo2, @Nullable @Json(name = "filters") Filters filters2) {
        Intrinsics.checkNotNullParameter(list, "products");
        Intrinsics.checkNotNullParameter(pageInfo2, "pageInfo");
        this.products = list;
        this.pageInfo = pageInfo2;
        this.filters = filters2;
    }

    public static /* synthetic */ MissionControlProductsResult copy$default(MissionControlProductsResult missionControlProductsResult, List<Product> list, PageInfo pageInfo2, Filters filters2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = missionControlProductsResult.products;
        }
        if ((i11 & 2) != 0) {
            pageInfo2 = missionControlProductsResult.pageInfo;
        }
        if ((i11 & 4) != 0) {
            filters2 = missionControlProductsResult.filters;
        }
        return missionControlProductsResult.copy(list, pageInfo2, filters2);
    }

    @NotNull
    public final List<Product> component1() {
        return this.products;
    }

    @NotNull
    public final PageInfo component2() {
        return this.pageInfo;
    }

    @Nullable
    public final Filters component3() {
        return this.filters;
    }

    @NotNull
    public final MissionControlProductsResult copy(@NotNull @Json(name = "products") List<Product> list, @NotNull @Json(name = "page_info") PageInfo pageInfo2, @Nullable @Json(name = "filters") Filters filters2) {
        Intrinsics.checkNotNullParameter(list, "products");
        Intrinsics.checkNotNullParameter(pageInfo2, "pageInfo");
        return new MissionControlProductsResult(list, pageInfo2, filters2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MissionControlProductsResult)) {
            return false;
        }
        MissionControlProductsResult missionControlProductsResult = (MissionControlProductsResult) obj;
        return Intrinsics.areEqual((Object) this.products, (Object) missionControlProductsResult.products) && Intrinsics.areEqual((Object) this.pageInfo, (Object) missionControlProductsResult.pageInfo) && Intrinsics.areEqual((Object) this.filters, (Object) missionControlProductsResult.filters);
    }

    @Nullable
    public final Filters getFilters() {
        return this.filters;
    }

    @NotNull
    public final PageInfo getPageInfo() {
        return this.pageInfo;
    }

    @NotNull
    public final List<Product> getProducts() {
        return this.products;
    }

    public int hashCode() {
        int hashCode = ((this.products.hashCode() * 31) + this.pageInfo.hashCode()) * 31;
        Filters filters2 = this.filters;
        return hashCode + (filters2 == null ? 0 : filters2.hashCode());
    }

    @NotNull
    public String toString() {
        List<Product> list = this.products;
        PageInfo pageInfo2 = this.pageInfo;
        Filters filters2 = this.filters;
        return "MissionControlProductsResult(products=" + list + ", pageInfo=" + pageInfo2 + ", filters=" + filters2 + ")";
    }
}
