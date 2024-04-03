package com.talabat.restaurants.v2.data.vendors;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B3\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0007HÆ\u0003J9\u0010\u0011\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0007HÖ\u0001R\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/talabat/restaurants/v2/data/vendors/FilterParams;", "", "filterIds", "", "", "cuisineIds", "sorting", "", "(Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "getCuisineIds", "()Ljava/util/List;", "getFilterIds", "getSorting", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FilterParams {
    @Nullable
    private final List<Integer> cuisineIds;
    @Nullable
    private final List<Integer> filterIds;
    @Nullable
    private final String sorting;

    public FilterParams(@Nullable List<Integer> list, @Nullable List<Integer> list2, @Nullable String str) {
        this.filterIds = list;
        this.cuisineIds = list2;
        this.sorting = str;
    }

    public static /* synthetic */ FilterParams copy$default(FilterParams filterParams, List<Integer> list, List<Integer> list2, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = filterParams.filterIds;
        }
        if ((i11 & 2) != 0) {
            list2 = filterParams.cuisineIds;
        }
        if ((i11 & 4) != 0) {
            str = filterParams.sorting;
        }
        return filterParams.copy(list, list2, str);
    }

    @Nullable
    public final List<Integer> component1() {
        return this.filterIds;
    }

    @Nullable
    public final List<Integer> component2() {
        return this.cuisineIds;
    }

    @Nullable
    public final String component3() {
        return this.sorting;
    }

    @NotNull
    public final FilterParams copy(@Nullable List<Integer> list, @Nullable List<Integer> list2, @Nullable String str) {
        return new FilterParams(list, list2, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FilterParams)) {
            return false;
        }
        FilterParams filterParams = (FilterParams) obj;
        return Intrinsics.areEqual((Object) this.filterIds, (Object) filterParams.filterIds) && Intrinsics.areEqual((Object) this.cuisineIds, (Object) filterParams.cuisineIds) && Intrinsics.areEqual((Object) this.sorting, (Object) filterParams.sorting);
    }

    @Nullable
    public final List<Integer> getCuisineIds() {
        return this.cuisineIds;
    }

    @Nullable
    public final List<Integer> getFilterIds() {
        return this.filterIds;
    }

    @Nullable
    public final String getSorting() {
        return this.sorting;
    }

    public int hashCode() {
        List<Integer> list = this.filterIds;
        int i11 = 0;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<Integer> list2 = this.cuisineIds;
        int hashCode2 = (hashCode + (list2 == null ? 0 : list2.hashCode())) * 31;
        String str = this.sorting;
        if (str != null) {
            i11 = str.hashCode();
        }
        return hashCode2 + i11;
    }

    @NotNull
    public String toString() {
        List<Integer> list = this.filterIds;
        List<Integer> list2 = this.cuisineIds;
        String str = this.sorting;
        return "FilterParams(filterIds=" + list + ", cuisineIds=" + list2 + ", sorting=" + str + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FilterParams(List list, List list2, String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : list, (i11 & 2) != 0 ? null : list2, str);
    }
}
