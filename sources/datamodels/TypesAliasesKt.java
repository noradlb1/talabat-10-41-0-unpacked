package datamodels;

import datamodels.filters.SelectableFilter;
import datamodels.filters.SelectablePopularFilter;
import datamodels.filters.SelectableSortType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a4\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\u0004\u0018\u0001`\u00062\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\t\u001a\u001a\u0010\n\u001a\u0004\u0018\u00010\u0001*\u0010\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0004j\u0004\u0018\u0001`\f\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000*\u0016\u0010\r\"\b\u0012\u0004\u0012\u00020\u000e0\u00042\b\u0012\u0004\u0012\u00020\u000e0\u0004*\u0016\u0010\u000f\"\b\u0012\u0004\u0012\u00020\u00100\u00042\b\u0012\u0004\u0012\u00020\u00100\u0004*\u0016\u0010\u0011\"\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0012\u0004\u0012\u00020\u00050\u0004*\u0016\u0010\u0012\"\b\u0012\u0004\u0012\u00020\b0\u00042\b\u0012\u0004\u0012\u00020\b0\u0004*\u0016\u0010\u0013\"\b\u0012\u0004\u0012\u00020\u000b0\u00042\b\u0012\u0004\u0012\u00020\u000b0\u0004¨\u0006\u0014"}, d2 = {"separator", "", "getFilterSlugName", "selectedFilters", "", "Ldatamodels/filters/SelectableFilter;", "Ldatamodels/SelectableFilters;", "selectedPopularFilters", "Ldatamodels/filters/SelectablePopularFilter;", "Ldatamodels/SelectablePopularFilters;", "toSortingSlugName", "Ldatamodels/filters/SelectableSortType;", "Ldatamodels/SelectableSortTypes;", "Filters", "Ldatamodels/Filter;", "Restaurants", "Ldatamodels/Restaurant;", "SelectableFilters", "SelectablePopularFilters", "SelectableSortTypes", "com_talabat_talabatlib_talabatlib"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class TypesAliasesKt {
    @NotNull
    public static final String separator = ";";

    @Nullable
    public static final String getFilterSlugName(@Nullable List<SelectableFilter> list, @Nullable List<SelectablePopularFilter> list2) {
        List list3;
        Collection collection;
        ArrayList arrayList = null;
        if (list == null && list2 == null) {
            return null;
        }
        if (list != null) {
            ArrayList<SelectableFilter> arrayList2 = new ArrayList<>();
            for (Object next : list) {
                if (((SelectableFilter) next).isOn()) {
                    arrayList2.add(next);
                }
            }
            list3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10));
            for (SelectableFilter filter : arrayList2) {
                list3.add(filter.getFilter().slugName);
            }
        } else {
            list3 = null;
        }
        if (list2 != null) {
            ArrayList<SelectablePopularFilter> arrayList3 = new ArrayList<>();
            for (Object next2 : list2) {
                if (((SelectablePopularFilter) next2).isOn()) {
                    arrayList3.add(next2);
                }
            }
            ArrayList arrayList4 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList3, 10));
            for (SelectablePopularFilter filter2 : arrayList3) {
                arrayList4.add(filter2.getFilter().getSlugName());
            }
            arrayList = arrayList4;
        }
        ArrayList arrayList5 = new ArrayList();
        if (list3 == null) {
            list3 = CollectionsKt__CollectionsKt.emptyList();
        }
        arrayList5.addAll(list3);
        if (arrayList != null) {
            collection = arrayList;
        } else {
            collection = CollectionsKt__CollectionsKt.emptyList();
        }
        arrayList5.addAll(collection);
        return CollectionsKt___CollectionsKt.joinToString$default(arrayList5, separator, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, TypesAliasesKt$getFilterSlugName$1.INSTANCE, 30, (Object) null);
    }

    @Nullable
    public static final String toSortingSlugName(@Nullable List<SelectableSortType> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Object next : list) {
            if (((SelectableSortType) next).isOn()) {
                arrayList.add(next);
            }
        }
        return CollectionsKt___CollectionsKt.joinToString$default(arrayList, separator, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, TypesAliasesKt$toSortingSlugName$2.INSTANCE, 30, (Object) null);
    }
}
