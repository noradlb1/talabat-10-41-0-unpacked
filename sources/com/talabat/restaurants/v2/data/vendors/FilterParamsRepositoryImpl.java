package com.talabat.restaurants.v2.data.vendors;

import android.util.SparseArray;
import buisnessmodels.FilterEngine;
import com.talabat.filters.domain.UseCasesKt;
import com.talabat.filters.storage.FiltersInMemoryCache;
import datamodels.Cuisine;
import datamodels.Filter;
import datamodels.filters.SelectablePopularFilter;
import datamodels.filters.SelectableSortType;
import datamodels.filters.SortType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J$\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0018\u00010\bj\u0004\u0018\u0001`\u000fH\u0002J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0006H\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/talabat/restaurants/v2/data/vendors/FilterParamsRepositoryImpl;", "Lcom/talabat/restaurants/v2/data/vendors/FilterParamsRepository;", "filterEngine", "Lbuisnessmodels/FilterEngine;", "(Lbuisnessmodels/FilterEngine;)V", "getFilterParams", "Lcom/talabat/restaurants/v2/data/vendors/FilterParams;", "getSelectedCuisines", "", "", "getSorting", "", "makeAllSelectedFilters", "selectablePopularFilters", "Ldatamodels/filters/SelectablePopularFilter;", "Ldatamodels/SelectablePopularFilters;", "makeFilterParams", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FilterParamsRepositoryImpl implements FilterParamsRepository {
    @Nullable
    private final FilterEngine filterEngine;

    public FilterParamsRepositoryImpl(@Nullable FilterEngine filterEngine2) {
        this.filterEngine = filterEngine2;
    }

    private final List<Integer> getSelectedCuisines() {
        SparseArray<Cuisine> sparseArray;
        ArrayList arrayList = new ArrayList();
        FilterEngine filterEngine2 = this.filterEngine;
        if (!(filterEngine2 == null || (sparseArray = filterEngine2.selectedCuisines) == null)) {
            int size = sparseArray.size();
            for (int i11 = 0; i11 < size; i11++) {
                sparseArray.keyAt(i11);
                arrayList.add(Integer.valueOf(sparseArray.valueAt(i11).f13848id));
            }
        }
        return arrayList;
    }

    private final String getSorting() {
        Object obj;
        SortType sortType;
        boolean z11;
        List<SelectableSortType> restaurantsSortingTypes = FiltersInMemoryCache.INSTANCE.getRestaurantsSortingTypes();
        if (restaurantsSortingTypes == null) {
            return null;
        }
        Iterator it = restaurantsSortingTypes.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            SelectableSortType selectableSortType = (SelectableSortType) obj;
            FilterEngine filterEngine2 = this.filterEngine;
            if (filterEngine2 != null) {
                sortType = UseCasesKt.toSortType(filterEngine2.getSelectedSortBy());
            } else {
                sortType = null;
            }
            if (sortType == selectableSortType.getType()) {
                z11 = true;
                continue;
            } else {
                z11 = false;
                continue;
            }
            if (z11) {
                break;
            }
        }
        SelectableSortType selectableSortType2 = (SelectableSortType) obj;
        if (selectableSortType2 != null) {
            return selectableSortType2.getId();
        }
        return null;
    }

    private final List<Integer> makeAllSelectedFilters(List<SelectablePopularFilter> list) {
        boolean z11;
        List<Filter> selectedFiltersList;
        ArrayList arrayList = new ArrayList();
        FilterEngine filterEngine2 = this.filterEngine;
        if (!(filterEngine2 == null || (selectedFiltersList = filterEngine2.getSelectedFiltersList()) == null)) {
            for (Filter id2 : selectedFiltersList) {
                arrayList.add(Integer.valueOf(id2.getId()));
            }
        }
        if (list != null) {
            ArrayList<SelectablePopularFilter> arrayList2 = new ArrayList<>();
            for (Object next : list) {
                if (((SelectablePopularFilter) next).getFilter().getId() != -1) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    arrayList2.add(next);
                }
            }
            for (SelectablePopularFilter filter : arrayList2) {
                arrayList.add(Integer.valueOf(filter.getFilter().getId()));
            }
        }
        return arrayList;
    }

    private final FilterParams makeFilterParams() {
        ArrayList arrayList;
        boolean z11;
        boolean z12;
        FilterEngine filterEngine2 = this.filterEngine;
        if (filterEngine2 != null) {
            filterEngine2.getIsFilterApplied();
        }
        FilterEngine filterEngine3 = this.filterEngine;
        if (filterEngine3 != null) {
            filterEngine3.isAnyFilterApplied();
        }
        List<Integer> selectedCuisines = getSelectedCuisines();
        List<SelectablePopularFilter> restaurantsPopularFilters = FiltersInMemoryCache.INSTANCE.getRestaurantsPopularFilters();
        if (restaurantsPopularFilters != null) {
            arrayList = new ArrayList();
            for (Object next : restaurantsPopularFilters) {
                if (((SelectablePopularFilter) next).isOn()) {
                    arrayList.add(next);
                }
            }
        } else {
            arrayList = null;
        }
        List<Integer> makeAllSelectedFilters = makeAllSelectedFilters(arrayList);
        String sorting = getSorting();
        Collection collection = selectedCuisines;
        boolean z13 = false;
        if (collection == null || collection.isEmpty()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            Collection collection2 = makeAllSelectedFilters;
            if (collection2 == null || collection2.isEmpty()) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z12) {
                if (sorting == null || sorting.length() == 0) {
                    z13 = true;
                }
                if (z13) {
                    return null;
                }
            }
        }
        return new FilterParams(makeAllSelectedFilters, selectedCuisines, sorting);
    }

    @Nullable
    public FilterParams getFilterParams() {
        return makeFilterParams();
    }
}
