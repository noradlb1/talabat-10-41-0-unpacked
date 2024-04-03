package com.talabat.filters.presentation;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.talabat.talabatcommon.extentions.CoroutinesKt;
import datamodels.TypesAliasesKt;
import datamodels.filters.Selectable;
import datamodels.filters.SelectableFilter;
import datamodels.filters.SelectablePopularFilter;
import datamodels.filters.SelectableSortType;
import datamodels.filters.Selectables;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0002H\u0000\u001a\f\u0010\u0005\u001a\u00020\u0004*\u00020\u0002H\u0000\u001a\f\u0010\u0006\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a=\u0010\u0007\u001a\u00020\u0001*\u00020\u00022'\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r0\t¢\u0006\u0002\b\u000eH\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a\u0014\u0010\u0010\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0000\u001a\u0014\u0010\u0013\u001a\u00020\f*\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0015H\u0000\u001a\u0014\u0010\u0016\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0018H\u0000\u001a\f\u0010\u0019\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a*\u0010\u001a\u001a\n\u0012\u0004\u0012\u0002H\u001c\u0018\u00010\u001b\"\b\b\u0000\u0010\u001c*\u00020\u001d*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001c0\u001b0\u001eH\u0002\u001a\f\u0010\u001f\u001a\u00020 *\u00020\u0002H\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006!"}, d2 = {"applySelection", "Lkotlinx/coroutines/Job;", "Lcom/talabat/filters/presentation/FiltersViewModel;", "getFiltersSlug", "", "getSortingSlug", "initialize", "launchWithProgress", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lcom/talabat/filters/presentation/FiltersViewModel;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "onFilterClicked", "selectableFilter", "Ldatamodels/filters/SelectableFilter;", "onPopularFilterClicked", "selectablePopularFilter", "Ldatamodels/filters/SelectablePopularFilter;", "onSortClicked", "selectableSortType", "Ldatamodels/filters/SelectableSortType;", "reset", "selected", "", "T", "Ldatamodels/filters/Selectable;", "Landroidx/lifecycle/MutableLiveData;", "selectedFilterSortWrapper", "Ldatamodels/filters/Selectables;", "com_talabat_Components_filters_filters"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class FiltersViewModelKt {
    @NotNull
    public static final Job applySelection(@NotNull FiltersViewModel filtersViewModel) {
        Intrinsics.checkNotNullParameter(filtersViewModel, "<this>");
        return launchWithProgress(filtersViewModel, new FiltersViewModelKt$applySelection$1(filtersViewModel, (Continuation<? super FiltersViewModelKt$applySelection$1>) null));
    }

    @NotNull
    public static final String getFiltersSlug(@NotNull FiltersViewModel filtersViewModel) {
        Intrinsics.checkNotNullParameter(filtersViewModel, "<this>");
        String filterSlugName = TypesAliasesKt.getFilterSlugName(filtersViewModel.getFilters().getValue(), filtersViewModel.getPopularFilters().getValue());
        if (filterSlugName == null) {
            return "";
        }
        return filterSlugName;
    }

    @NotNull
    public static final String getSortingSlug(@NotNull FiltersViewModel filtersViewModel) {
        Intrinsics.checkNotNullParameter(filtersViewModel, "<this>");
        String sortingSlugName = TypesAliasesKt.toSortingSlugName(filtersViewModel.getSorts().getValue());
        if (sortingSlugName == null) {
            return "";
        }
        return sortingSlugName;
    }

    @NotNull
    public static final Job initialize(@NotNull FiltersViewModel filtersViewModel) {
        Intrinsics.checkNotNullParameter(filtersViewModel, "<this>");
        return launchWithProgress(filtersViewModel, new FiltersViewModelKt$initialize$1(filtersViewModel, (Continuation<? super FiltersViewModelKt$initialize$1>) null));
    }

    @NotNull
    public static final Job launchWithProgress(@NotNull FiltersViewModel filtersViewModel, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter(filtersViewModel, "<this>");
        Intrinsics.checkNotNullParameter(function2, "block");
        return CoroutinesKt.launchCatching(ViewModelKt.getViewModelScope(filtersViewModel), new FiltersViewModelKt$launchWithProgress$1(filtersViewModel.getErrors()), filtersViewModel.getDispatcher(), new FiltersViewModelKt$launchWithProgress$2(filtersViewModel, function2, (Continuation<? super FiltersViewModelKt$launchWithProgress$2>) null));
    }

    @NotNull
    public static final Job onFilterClicked(@NotNull FiltersViewModel filtersViewModel, @NotNull SelectableFilter selectableFilter) {
        Intrinsics.checkNotNullParameter(filtersViewModel, "<this>");
        Intrinsics.checkNotNullParameter(selectableFilter, "selectableFilter");
        return launchWithProgress(filtersViewModel, new FiltersViewModelKt$onFilterClicked$1(filtersViewModel, selectableFilter, (Continuation<? super FiltersViewModelKt$onFilterClicked$1>) null));
    }

    public static final void onPopularFilterClicked(@NotNull FiltersViewModel filtersViewModel, @NotNull SelectablePopularFilter selectablePopularFilter) {
        Intrinsics.checkNotNullParameter(filtersViewModel, "<this>");
        Intrinsics.checkNotNullParameter(selectablePopularFilter, "selectablePopularFilter");
        launchWithProgress(filtersViewModel, new FiltersViewModelKt$onPopularFilterClicked$1(filtersViewModel, selectablePopularFilter, (Continuation<? super FiltersViewModelKt$onPopularFilterClicked$1>) null));
    }

    @NotNull
    public static final Job onSortClicked(@NotNull FiltersViewModel filtersViewModel, @NotNull SelectableSortType selectableSortType) {
        Intrinsics.checkNotNullParameter(filtersViewModel, "<this>");
        Intrinsics.checkNotNullParameter(selectableSortType, "selectableSortType");
        return launchWithProgress(filtersViewModel, new FiltersViewModelKt$onSortClicked$1(filtersViewModel, selectableSortType, (Continuation<? super FiltersViewModelKt$onSortClicked$1>) null));
    }

    @NotNull
    public static final Job reset(@NotNull FiltersViewModel filtersViewModel) {
        Intrinsics.checkNotNullParameter(filtersViewModel, "<this>");
        return launchWithProgress(filtersViewModel, new FiltersViewModelKt$reset$1(filtersViewModel, (Continuation<? super FiltersViewModelKt$reset$1>) null));
    }

    private static final <T extends Selectable> List<T> selected(MutableLiveData<List<T>> mutableLiveData) {
        List value = mutableLiveData.getValue();
        if (value == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Object next : value) {
            if (((Selectable) next).isOn()) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    @NotNull
    public static final Selectables selectedFilterSortWrapper(@NotNull FiltersViewModel filtersViewModel) {
        Intrinsics.checkNotNullParameter(filtersViewModel, "<this>");
        List<List<SelectableFilter>> selected = selected(filtersViewModel.getFilters());
        if (selected == null) {
            selected = CollectionsKt__CollectionsKt.emptyList();
        }
        List<List<SelectableSortType>> selected2 = selected(filtersViewModel.getSorts());
        if (selected2 == null) {
            selected2 = CollectionsKt__CollectionsKt.emptyList();
        }
        List<List<SelectablePopularFilter>> selected3 = selected(filtersViewModel.getPopularFilters());
        if (selected3 == null) {
            selected3 = CollectionsKt__CollectionsKt.emptyList();
        }
        return new Selectables(selected, selected2, selected3);
    }
}
