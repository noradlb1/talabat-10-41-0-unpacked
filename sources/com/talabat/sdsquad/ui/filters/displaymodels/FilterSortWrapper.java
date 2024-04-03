package com.talabat.sdsquad.ui.filters.displaymodels;

import com.talabat.sdsquad.data.vendorslist.response.Sort;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0002\u0010\u0007J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J)\u0010\r\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/talabat/sdsquad/ui/filters/displaymodels/FilterSortWrapper;", "", "filtersList", "", "Lcom/talabat/sdsquad/ui/filters/displaymodels/FilterDisplayModel;", "sortList", "Lcom/talabat/sdsquad/data/vendorslist/response/Sort;", "(Ljava/util/List;Ljava/util/List;)V", "getFiltersList", "()Ljava/util/List;", "getSortList", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FilterSortWrapper {
    @NotNull
    private final List<FilterDisplayModel> filtersList;
    @NotNull
    private final List<Sort> sortList;

    public FilterSortWrapper(@NotNull List<FilterDisplayModel> list, @NotNull List<Sort> list2) {
        Intrinsics.checkNotNullParameter(list, "filtersList");
        Intrinsics.checkNotNullParameter(list2, "sortList");
        this.filtersList = list;
        this.sortList = list2;
    }

    public static /* synthetic */ FilterSortWrapper copy$default(FilterSortWrapper filterSortWrapper, List<FilterDisplayModel> list, List<Sort> list2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = filterSortWrapper.filtersList;
        }
        if ((i11 & 2) != 0) {
            list2 = filterSortWrapper.sortList;
        }
        return filterSortWrapper.copy(list, list2);
    }

    @NotNull
    public final List<FilterDisplayModel> component1() {
        return this.filtersList;
    }

    @NotNull
    public final List<Sort> component2() {
        return this.sortList;
    }

    @NotNull
    public final FilterSortWrapper copy(@NotNull List<FilterDisplayModel> list, @NotNull List<Sort> list2) {
        Intrinsics.checkNotNullParameter(list, "filtersList");
        Intrinsics.checkNotNullParameter(list2, "sortList");
        return new FilterSortWrapper(list, list2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FilterSortWrapper)) {
            return false;
        }
        FilterSortWrapper filterSortWrapper = (FilterSortWrapper) obj;
        return Intrinsics.areEqual((Object) this.filtersList, (Object) filterSortWrapper.filtersList) && Intrinsics.areEqual((Object) this.sortList, (Object) filterSortWrapper.sortList);
    }

    @NotNull
    public final List<FilterDisplayModel> getFiltersList() {
        return this.filtersList;
    }

    @NotNull
    public final List<Sort> getSortList() {
        return this.sortList;
    }

    public int hashCode() {
        return (this.filtersList.hashCode() * 31) + this.sortList.hashCode();
    }

    @NotNull
    public String toString() {
        List<FilterDisplayModel> list = this.filtersList;
        List<Sort> list2 = this.sortList;
        return "FilterSortWrapper(filtersList=" + list + ", sortList=" + list2 + ")";
    }
}
