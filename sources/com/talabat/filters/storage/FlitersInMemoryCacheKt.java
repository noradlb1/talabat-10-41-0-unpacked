package com.talabat.filters.storage;

import datamodels.filters.SelectableSortType;
import datamodels.filters.SortType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.com.talabatlib.Sort;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u0007\u001a\u000e\u0010\b\u001a\u0004\u0018\u00010\t*\u00020\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"COLLECTION_POPULAR_FILTER_KEY", "", "COLLECTION_SORTING_KEY", "RESTAURANTS_POPULAR_FILTER_KEY", "RESTAURANTS_SORTING_KEY", "toSelectableSortType", "Ldatamodels/filters/SelectableSortType;", "Llibrary/talabat/com/talabatlib/Sort;", "toSortType", "Ldatamodels/filters/SortType;", "com_talabat_talabatlib_talabatlib"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class FlitersInMemoryCacheKt {
    @NotNull
    public static final String COLLECTION_POPULAR_FILTER_KEY = "COLLECTION_POPULAR_FILTER_KEY";
    @NotNull
    public static final String COLLECTION_SORTING_KEY = "COLLECTION_SORTING_KEY";
    @NotNull
    public static final String RESTAURANTS_POPULAR_FILTER_KEY = "RESTAURANTS_POPULAR_FILTER_KEY";
    @NotNull
    public static final String RESTAURANTS_SORTING_KEY = "RESTAURANTS_SORTING_KEY";

    @Nullable
    public static final SelectableSortType toSelectableSortType(@NotNull Sort sort) {
        Intrinsics.checkNotNullParameter(sort, "<this>");
        SortType sortType = toSortType(sort.getSlug());
        if (sortType == null) {
            return null;
        }
        return new SelectableSortType(sortType, false, sort.getId());
    }

    private static final SortType toSortType(String str) {
        for (SortType sortType : SortType.values()) {
            if (Intrinsics.areEqual((Object) sortType.getSlug(), (Object) str)) {
                return sortType;
            }
        }
        return null;
    }
}
