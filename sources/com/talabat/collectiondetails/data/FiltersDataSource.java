package com.talabat.collectiondetails.data;

import datamodels.Cuisine;
import datamodels.Filter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import library.talabat.com.talabatlib.Sort;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005H&J\u0010\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H&J\n\u0010\t\u001a\u0004\u0018\u00010\nH&J\u0018\u0010\u000b\u001a\u00020\f2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H&J\u0018\u0010\u000e\u001a\u00020\f2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0007H&¨\u0006\u0011"}, d2 = {"Lcom/talabat/collectiondetails/data/FiltersDataSource;", "", "getSelectedCuisines", "Ljava/util/ArrayList;", "Ldatamodels/Cuisine;", "Lkotlin/collections/ArrayList;", "getSelectedFilters", "", "Ldatamodels/Filter;", "getSorting", "", "saveCollectionsPopularFilters", "", "filters", "saveCollectionsSortingTypes", "sort", "Llibrary/talabat/com/talabatlib/Sort;", "com_talabat_Components_collectiondetails_collectiondetails"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface FiltersDataSource {
    @NotNull
    ArrayList<Cuisine> getSelectedCuisines();

    @Nullable
    List<Filter> getSelectedFilters();

    @Nullable
    String getSorting();

    void saveCollectionsPopularFilters(@Nullable List<? extends Filter> list);

    void saveCollectionsSortingTypes(@Nullable List<Sort> list);
}
