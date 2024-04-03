package com.talabat.sdsquad.ui.filters;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.talabat.sdsquad.core.BaseSchedulerProvider;
import com.talabat.sdsquad.core.UseCaseHandler;
import com.talabat.sdsquad.data.vendorslist.response.Sort;
import com.talabat.sdsquad.data.vendorslist.response.SortTypes;
import com.talabat.sdsquad.domain.filters.GetFiltersUseCase;
import com.talabat.sdsquad.domain.filters.GetSortUseCase;
import com.talabat.sdsquad.ui.filters.displaymodels.FilterDisplayModel;
import com.talabat.sdsquad.ui.filters.displaymodels.FilterSortWrapper;
import com.talabat.talabatcore.logger.LogManager;
import hu.f;
import hu.g;
import hu.h;
import io.reactivex.Flowable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.reactivestreams.Publisher;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018J\r\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0002\u0010\u001bJ\u001c\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00192\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018J\u0006\u0010 \u001a\u00020\u001dJ\u000e\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u000eJ\u000e\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u0014R'\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f8FX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R'\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\r0\f8FX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0015\u0010\u0010¨\u0006%"}, d2 = {"Lcom/talabat/sdsquad/ui/filters/FiltersViewModel;", "Landroidx/lifecycle/ViewModel;", "mSchedulerProvider", "Lcom/talabat/sdsquad/core/BaseSchedulerProvider;", "mUseCaseHandler", "Lcom/talabat/sdsquad/core/UseCaseHandler;", "mGetFiltersUseCase", "Lcom/talabat/sdsquad/domain/filters/GetFiltersUseCase;", "mGetSortUseCase", "Lcom/talabat/sdsquad/domain/filters/GetSortUseCase;", "(Lcom/talabat/sdsquad/core/BaseSchedulerProvider;Lcom/talabat/sdsquad/core/UseCaseHandler;Lcom/talabat/sdsquad/domain/filters/GetFiltersUseCase;Lcom/talabat/sdsquad/domain/filters/GetSortUseCase;)V", "filtersResponse", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/talabat/sdsquad/ui/filters/displaymodels/FilterDisplayModel;", "getFiltersResponse", "()Landroidx/lifecycle/MutableLiveData;", "filtersResponse$delegate", "Lkotlin/Lazy;", "sortsResponse", "Lcom/talabat/sdsquad/data/vendorslist/response/Sort;", "getSortsResponse", "sortsResponse$delegate", "getSelectedFilters", "Ljava/util/ArrayList;", "", "getSelectedSort", "()Ljava/lang/Integer;", "getSortAndFilters", "", "selectedSort", "selectedFilters", "reset", "setClickedFilter", "filter", "setSelectedSort", "sort", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FiltersViewModel extends ViewModel {
    @NotNull
    private final Lazy filtersResponse$delegate;
    @NotNull
    private final GetFiltersUseCase mGetFiltersUseCase;
    @NotNull
    private final GetSortUseCase mGetSortUseCase;
    @NotNull
    private final BaseSchedulerProvider mSchedulerProvider;
    @NotNull
    private final UseCaseHandler mUseCaseHandler;
    @NotNull
    private final Lazy sortsResponse$delegate;

    public FiltersViewModel(@NotNull BaseSchedulerProvider baseSchedulerProvider, @NotNull UseCaseHandler useCaseHandler, @NotNull GetFiltersUseCase getFiltersUseCase, @NotNull GetSortUseCase getSortUseCase) {
        Intrinsics.checkNotNullParameter(baseSchedulerProvider, "mSchedulerProvider");
        Intrinsics.checkNotNullParameter(useCaseHandler, "mUseCaseHandler");
        Intrinsics.checkNotNullParameter(getFiltersUseCase, "mGetFiltersUseCase");
        Intrinsics.checkNotNullParameter(getSortUseCase, "mGetSortUseCase");
        this.mSchedulerProvider = baseSchedulerProvider;
        this.mUseCaseHandler = useCaseHandler;
        this.mGetFiltersUseCase = getFiltersUseCase;
        this.mGetSortUseCase = getSortUseCase;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.filtersResponse$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, FiltersViewModel$filtersResponse$2.INSTANCE);
        this.sortsResponse$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, FiltersViewModel$sortsResponse$2.INSTANCE);
    }

    /* access modifiers changed from: private */
    /* renamed from: getSortAndFilters$lambda-4  reason: not valid java name */
    public static final FilterSortWrapper m10823getSortAndFilters$lambda4(List list, List list2) {
        Intrinsics.checkNotNullParameter(list, "t1");
        Intrinsics.checkNotNullParameter(list2, "t2");
        return new FilterSortWrapper(list, list2);
    }

    /* access modifiers changed from: private */
    /* renamed from: getSortAndFilters$lambda-5  reason: not valid java name */
    public static final void m10824getSortAndFilters$lambda5(FiltersViewModel filtersViewModel, FilterSortWrapper filterSortWrapper) {
        boolean z11;
        Intrinsics.checkNotNullParameter(filtersViewModel, "this$0");
        Collection filtersList = filterSortWrapper.getFiltersList();
        boolean z12 = false;
        if (filtersList == null || filtersList.isEmpty()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            filtersViewModel.getFiltersResponse().setValue(filterSortWrapper.getFiltersList());
        }
        Collection sortList = filterSortWrapper.getSortList();
        if (sortList == null || sortList.isEmpty()) {
            z12 = true;
        }
        if (!z12) {
            filtersViewModel.getSortsResponse().setValue(filterSortWrapper.getSortList());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: getSortAndFilters$lambda-6  reason: not valid java name */
    public static final void m10825getSortAndFilters$lambda6(Throwable th2) {
        String message = th2.getMessage();
        LogManager.logException(new Exception("grocery: " + message));
    }

    @NotNull
    public final MutableLiveData<List<FilterDisplayModel>> getFiltersResponse() {
        return (MutableLiveData) this.filtersResponse$delegate.getValue();
    }

    @Nullable
    public final ArrayList<Integer> getSelectedFilters() {
        ArrayList<FilterDisplayModel> arrayList;
        List value = getFiltersResponse().getValue();
        if (value != null) {
            arrayList = new ArrayList<>();
            for (Object next : value) {
                if (((FilterDisplayModel) next).isOn()) {
                    arrayList.add(next);
                }
            }
        } else {
            arrayList = null;
        }
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        if (arrayList != null) {
            for (FilterDisplayModel id2 : arrayList) {
                arrayList2.add(Integer.valueOf(id2.getId()));
            }
        }
        return arrayList2;
    }

    @Nullable
    public final Integer getSelectedSort() {
        ArrayList arrayList;
        Sort sort;
        List value = getSortsResponse().getValue();
        if (value != null) {
            arrayList = new ArrayList();
            for (Object next : value) {
                if (((Sort) next).isOn()) {
                    arrayList.add(next);
                }
            }
        } else {
            arrayList = null;
        }
        if (arrayList == null || (sort = (Sort) arrayList.get(0)) == null) {
            return null;
        }
        return Integer.valueOf(sort.getType());
    }

    public final void getSortAndFilters(int i11, @NotNull ArrayList<Integer> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "selectedFilters");
        Flowable.zip((Publisher) this.mUseCaseHandler.execute(this.mGetFiltersUseCase, new GetFiltersUseCase.RequestValues(arrayList)), (Publisher) this.mUseCaseHandler.execute(this.mGetSortUseCase, new GetSortUseCase.RequestValues(i11)), new f()).subscribeOn(this.mSchedulerProvider.io()).observeOn(this.mSchedulerProvider.ui()).subscribe(new g(this), new h());
    }

    @NotNull
    public final MutableLiveData<List<Sort>> getSortsResponse() {
        return (MutableLiveData) this.sortsResponse$delegate.getValue();
    }

    public final void reset() {
        getSortAndFilters(SortTypes.RECOMMENDATION.ordinal(), new ArrayList());
    }

    public final void setClickedFilter(@NotNull FilterDisplayModel filterDisplayModel) {
        Integer num;
        Intrinsics.checkNotNullParameter(filterDisplayModel, "filter");
        List value = getFiltersResponse().getValue();
        boolean z11 = false;
        if (value != null && value.contains(filterDisplayModel)) {
            z11 = true;
        }
        if (z11) {
            List value2 = getFiltersResponse().getValue();
            List list = null;
            if (value2 != null) {
                num = Integer.valueOf(value2.indexOf(filterDisplayModel));
            } else {
                num = null;
            }
            List value3 = getFiltersResponse().getValue();
            if (value3 != null) {
                list = CollectionsKt___CollectionsKt.toMutableList(value3);
            }
            if (list != null) {
                Intrinsics.checkNotNull(num);
                FilterDisplayModel filterDisplayModel2 = (FilterDisplayModel) list.remove(num.intValue());
            }
            if (list != null) {
                Intrinsics.checkNotNull(num);
                list.add(num.intValue(), filterDisplayModel);
            }
            getFiltersResponse().setValue(list);
        }
    }

    public final void setSelectedSort(@NotNull Sort sort) {
        boolean z11;
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(sort, "sort");
        List value = getSortsResponse().getValue();
        if (value == null || !value.contains(sort)) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            List value2 = getSortsResponse().getValue();
            ArrayList arrayList2 = null;
            if (value2 != null) {
                arrayList = new ArrayList();
                for (Object next : value2) {
                    if (((Sort) next).isOn()) {
                        arrayList.add(next);
                    }
                }
            } else {
                arrayList = null;
            }
            if (arrayList != null && (!arrayList.isEmpty())) {
                ((Sort) arrayList.get(0)).setOn(false);
            }
            List value3 = getSortsResponse().getValue();
            if (value3 != null) {
                arrayList2 = new ArrayList();
                for (Object next2 : value3) {
                    if (Intrinsics.areEqual((Object) (Sort) next2, (Object) sort)) {
                        arrayList2.add(next2);
                    }
                }
            }
            if (arrayList2 != null && (!arrayList2.isEmpty())) {
                ((Sort) arrayList2.get(0)).setOn(true);
            }
            getSortsResponse().setValue(getSortsResponse().getValue());
        }
    }
}
