package com.talabat.filters.navigation;

import datamodels.Filter;
import datamodels.Restaurant;
import datamodels.filters.SelectableSortType;
import datamodels.filters.SortType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\u001a\u0012\u0010\b\u001a\u00020\t2\n\u0010\n\u001a\u00020\u000b\"\u00020\f\u001aG\u0010\r\u001a\u00020\t2:\u0010\n\u001a\u001e\u0012\u001a\b\u0001\u0012\u0016\u0012\u0004\u0012\u00020\f\u0012\f\u0012\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00100\u000f0\u000e\"\u0016\u0012\u0004\u0012\u00020\f\u0012\f\u0012\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00100\u000f¢\u0006\u0002\u0010\u0011\u001a\u0006\u0010\u0012\u001a\u00020\t\"7\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u00038BX\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0013"}, d2 = {"cache", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getCache", "()Ljava/util/HashMap;", "cache$delegate", "Lkotlin/Lazy;", "initializeAllFiltersStubs", "", "ids", "", "", "initializeAllRestaurantsStubs", "", "Lkotlin/Pair;", "", "([Lkotlin/Pair;)V", "initializeAllSortsStubs", "com_talabat_Components_filters_filters"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class SampleFiltersActivityKt {
    @NotNull
    private static final Lazy cache$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, SampleFiltersActivityKt$cache$2.INSTANCE);

    /* access modifiers changed from: private */
    public static final HashMap<Object, Object> getCache() {
        return (HashMap) cache$delegate.getValue();
    }

    public static final void initializeAllFiltersStubs(@NotNull int... iArr) {
        boolean z11;
        Intrinsics.checkNotNullParameter(iArr, "ids");
        if (iArr.length == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            HashMap<Object, Object> cache = getCache();
            ArrayList arrayList = new ArrayList(iArr.length);
            for (int i11 : iArr) {
                Filter filter = new Filter();
                filter.setId(i11);
                filter.setName(String.valueOf(i11));
                filter.setSlugName(String.valueOf(i11));
                arrayList.add(filter);
            }
            cache.put("AllFilters", arrayList);
        }
    }

    public static final void initializeAllRestaurantsStubs(@NotNull Pair<Integer, ? extends List<Integer>>... pairArr) {
        boolean z11;
        Intrinsics.checkNotNullParameter(pairArr, "ids");
        if (pairArr.length == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            HashMap<Object, Object> cache = getCache();
            ArrayList arrayList = new ArrayList(pairArr.length);
            for (Pair<Integer, ? extends List<Integer>> pair : pairArr) {
                Restaurant restaurant = new Restaurant();
                restaurant.f13872id = pair.getFirst().intValue();
                restaurant.f13873name = String.valueOf(pair.getFirst().intValue());
                List list = (List) pair.getSecond();
                if (list == null) {
                    list = CollectionsKt__CollectionsKt.emptyList();
                }
                restaurant.filtersId = new ArrayList<>(list);
                arrayList.add(restaurant);
            }
            cache.put("AllRestaurants", arrayList);
        }
    }

    public static final void initializeAllSortsStubs() {
        getCache().put("AllSorts", CollectionsKt__CollectionsKt.listOf(new SelectableSortType(SortType.RECOMMENDATION, false, (String) null, 4, (DefaultConstructorMarker) null), new SelectableSortType(SortType.RATING, false, (String) null, 4, (DefaultConstructorMarker) null), new SelectableSortType(SortType.ALPHABETIC, false, (String) null, 4, (DefaultConstructorMarker) null), new SelectableSortType(SortType.MIN_ORDER, false, (String) null, 4, (DefaultConstructorMarker) null), new SelectableSortType(SortType.FASTEST_DELIVERY, false, (String) null, 4, (DefaultConstructorMarker) null)));
    }
}
