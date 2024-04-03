package com.talabat.filters.storage;

import androidx.annotation.VisibleForTesting;
import com.facebook.share.internal.ShareConstants;
import datamodels.Filter;
import datamodels.filters.FilterType;
import datamodels.filters.SelectablePopularFilter;
import datamodels.filters.SelectableSortType;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.com.talabatlib.Sort;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0007J\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\u0004\u0018\u0001`\u000bJ\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0018\u00010\tj\u0004\u0018\u0001`\u000eJ\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\u0004\u0018\u0001`\u000bJ\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\r\u0018\u00010\tj\u0004\u0018\u0001`\u000eJ\u0014\u0010\u0011\u001a\u00020\u00072\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\tJ\u0014\u0010\u0014\u001a\u00020\u00072\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\tJ\u0014\u0010\u0017\u001a\u00020\u00072\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\tJ\u0014\u0010\u0018\u001a\u00020\u00072\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\tR\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/talabat/filters/storage/FiltersInMemoryCache;", "", "()V", "cache", "", "", "clearCache", "", "getCollectionPopularFilters", "", "Ldatamodels/filters/SelectablePopularFilter;", "Ldatamodels/SelectablePopularFilters;", "getCollectionSortingTypes", "Ldatamodels/filters/SelectableSortType;", "Ldatamodels/SelectableSortTypes;", "getRestaurantsPopularFilters", "getRestaurantsSortingTypes", "saveCollectionsPopularFilters", "filters", "Ldatamodels/Filter;", "saveCollectionsSortingTypes", "sort", "Llibrary/talabat/com/talabatlib/Sort;", "saveRestaurantsPopularFilters", "saveRestaurantsSortingTypes", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FiltersInMemoryCache {
    @NotNull
    public static final FiltersInMemoryCache INSTANCE = new FiltersInMemoryCache();
    @NotNull
    private static Map<String, Object> cache = new LinkedHashMap();

    private FiltersInMemoryCache() {
    }

    @VisibleForTesting
    public final void clearCache() {
        cache = new LinkedHashMap();
    }

    @Nullable
    public final List<SelectablePopularFilter> getCollectionPopularFilters() {
        return (List) cache.get(FlitersInMemoryCacheKt.COLLECTION_POPULAR_FILTER_KEY);
    }

    @Nullable
    public final List<SelectableSortType> getCollectionSortingTypes() {
        return (List) cache.get(FlitersInMemoryCacheKt.COLLECTION_SORTING_KEY);
    }

    @Nullable
    public final List<SelectablePopularFilter> getRestaurantsPopularFilters() {
        return (List) cache.get(FlitersInMemoryCacheKt.RESTAURANTS_POPULAR_FILTER_KEY);
    }

    @Nullable
    public final List<SelectableSortType> getRestaurantsSortingTypes() {
        return (List) cache.get(FlitersInMemoryCacheKt.RESTAURANTS_SORTING_KEY);
    }

    public final void saveCollectionsPopularFilters(@NotNull List<? extends Filter> list) {
        Intrinsics.checkNotNullParameter(list, ShareConstants.WEB_DIALOG_PARAM_FILTERS);
        Map<String, Object> map = cache;
        Iterable<Filter> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (Filter filter : iterable) {
            String name2 = filter.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "it.name");
            String slugName = filter.getSlugName();
            Intrinsics.checkNotNullExpressionValue(slugName, "it.slugName");
            arrayList.add(new SelectablePopularFilter(new FilterType(name2, slugName, (Function1) null, filter.getId(), 4, (DefaultConstructorMarker) null), false, 2, (DefaultConstructorMarker) null));
        }
        map.put(FlitersInMemoryCacheKt.COLLECTION_POPULAR_FILTER_KEY, arrayList);
    }

    public final void saveCollectionsSortingTypes(@NotNull List<Sort> list) {
        Intrinsics.checkNotNullParameter(list, "sort");
        Map<String, Object> map = cache;
        ArrayList arrayList = new ArrayList();
        for (Sort selectableSortType : list) {
            SelectableSortType selectableSortType2 = FlitersInMemoryCacheKt.toSelectableSortType(selectableSortType);
            if (selectableSortType2 != null) {
                arrayList.add(selectableSortType2);
            }
        }
        map.put(FlitersInMemoryCacheKt.COLLECTION_SORTING_KEY, arrayList);
    }

    public final void saveRestaurantsPopularFilters(@NotNull List<? extends Filter> list) {
        Intrinsics.checkNotNullParameter(list, ShareConstants.WEB_DIALOG_PARAM_FILTERS);
        Map<String, Object> map = cache;
        Iterable<Filter> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (Filter filter : iterable) {
            String name2 = filter.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "it.name");
            String slugName = filter.getSlugName();
            Intrinsics.checkNotNullExpressionValue(slugName, "it.slugName");
            arrayList.add(new SelectablePopularFilter(new FilterType(name2, slugName, (Function1) null, filter.getId(), 4, (DefaultConstructorMarker) null), false, 2, (DefaultConstructorMarker) null));
        }
        map.put(FlitersInMemoryCacheKt.RESTAURANTS_POPULAR_FILTER_KEY, arrayList);
    }

    public final void saveRestaurantsSortingTypes(@NotNull List<Sort> list) {
        Intrinsics.checkNotNullParameter(list, "sort");
        Map<String, Object> map = cache;
        ArrayList arrayList = new ArrayList();
        for (Sort selectableSortType : list) {
            SelectableSortType selectableSortType2 = FlitersInMemoryCacheKt.toSelectableSortType(selectableSortType);
            if (selectableSortType2 != null) {
                arrayList.add(selectableSortType2);
            }
        }
        map.put(FlitersInMemoryCacheKt.RESTAURANTS_SORTING_KEY, arrayList);
    }
}
