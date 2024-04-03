package com.talabat.collectiondetails.data;

import android.util.SparseArray;
import buisnessmodels.FilterEngine;
import com.talabat.filters.storage.FiltersInMemoryCache;
import com.talabat.helpers.GlobalDataModel;
import datamodels.Cuisine;
import datamodels.Filter;
import datamodels.filters.SelectableSortType;
import datamodels.filters.SortType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import library.talabat.com.talabatlib.Sort;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006H\u0016J\u0010\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0018\u0010\f\u001a\u00020\r2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0016J\u0018\u0010\u000f\u001a\u00020\r2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\bH\u0016J\u000e\u0010\u0012\u001a\u0004\u0018\u00010\u0013*\u00020\u0014H\u0002¨\u0006\u0015"}, d2 = {"Lcom/talabat/collectiondetails/data/FiltersDataSourceImpl;", "Lcom/talabat/collectiondetails/data/FiltersDataSource;", "()V", "getSelectedCuisines", "Ljava/util/ArrayList;", "Ldatamodels/Cuisine;", "Lkotlin/collections/ArrayList;", "getSelectedFilters", "", "Ldatamodels/Filter;", "getSorting", "", "saveCollectionsPopularFilters", "", "filters", "saveCollectionsSortingTypes", "sort", "Llibrary/talabat/com/talabatlib/Sort;", "toSortType", "Ldatamodels/filters/SortType;", "", "com_talabat_Components_collectiondetails_collectiondetails"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FiltersDataSourceImpl implements FiltersDataSource {
    private final SortType toSortType(int i11) {
        if (i11 == 0) {
            return SortType.ALPHABETIC;
        }
        if (i11 == 1) {
            return SortType.RATING;
        }
        if (i11 == 3) {
            return SortType.MIN_ORDER;
        }
        if (i11 != 5) {
            return null;
        }
        return SortType.FASTEST_DELIVERY;
    }

    @NotNull
    public ArrayList<Cuisine> getSelectedCuisines() {
        SparseArray<Cuisine> sparseArray;
        ArrayList<Cuisine> arrayList = new ArrayList<>();
        FilterEngine filterEngine = GlobalDataModel.collectionFilterEngine;
        if (!(filterEngine == null || (sparseArray = filterEngine.selectedCuisines) == null)) {
            int size = sparseArray.size();
            for (int i11 = 0; i11 < size; i11++) {
                sparseArray.keyAt(i11);
                arrayList.add(sparseArray.valueAt(i11));
            }
        }
        return arrayList;
    }

    @Nullable
    public List<Filter> getSelectedFilters() {
        FilterEngine filterEngine = GlobalDataModel.collectionFilterEngine;
        if (filterEngine != null) {
            return filterEngine.getSelectedFiltersList();
        }
        return null;
    }

    @Nullable
    public String getSorting() {
        Object obj;
        List<SelectableSortType> collectionSortingTypes = FiltersInMemoryCache.INSTANCE.getCollectionSortingTypes();
        if (collectionSortingTypes == null) {
            return null;
        }
        Iterator it = collectionSortingTypes.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            boolean z11 = true;
            if (toSortType(FilterEngine.getInstance(1).getSelectedSortBy()) != ((SelectableSortType) obj).getType()) {
                z11 = false;
                continue;
            }
            if (z11) {
                break;
            }
        }
        SelectableSortType selectableSortType = (SelectableSortType) obj;
        if (selectableSortType != null) {
            return selectableSortType.getId();
        }
        return null;
    }

    public void saveCollectionsPopularFilters(@Nullable List<? extends Filter> list) {
        List list2;
        FiltersInMemoryCache filtersInMemoryCache = FiltersInMemoryCache.INSTANCE;
        if (list == null || (list2 = CollectionsKt___CollectionsKt.toList(list)) == null) {
            list2 = CollectionsKt__CollectionsKt.emptyList();
        }
        filtersInMemoryCache.saveCollectionsPopularFilters(list2);
    }

    public void saveCollectionsSortingTypes(@Nullable List<Sort> list) {
        FiltersInMemoryCache filtersInMemoryCache = FiltersInMemoryCache.INSTANCE;
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        filtersInMemoryCache.saveCollectionsSortingTypes(list);
    }
}
