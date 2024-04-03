package com.talabat.restaurants.v2.domain.vendors;

import buisnessmodels.FilterEngine;
import com.talabat.darkstores.data.tracking.StoreInfoTrackingProvider;
import com.talabat.helpers.GlobalDataModel;
import datamodels.Restaurant;
import datamodels.filters.SelectablePopularFilter;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001aÃ\u0001\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0018\u00010\u0001j\u0004\u0018\u0001`\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102%\b\u0002\u0010\u0012\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00010\u0013¢\u0006\u0002\b\u00142%\b\u0002\u0010\u0015\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00010\u0013¢\u0006\u0002\b\u00142%\b\u0002\u0010\u0016\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00010\u0013¢\u0006\u0002\b\u0014H\u0000\u001a*\u0010\u0017\u001a\u00020\u00112\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0018\u00010\u0001j\u0004\u0018\u0001`\u000eH\u0000\u001a\u0001\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u0001*\b\u0012\u0004\u0012\u00020\b0\u00012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2%\b\u0002\u0010\u0016\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00010\u0013¢\u0006\u0002\b\u00142%\b\u0002\u0010\u0019\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00010\u0013¢\u0006\u0002\b\u00142%\b\u0002\u0010\u001a\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00010\u0013¢\u0006\u0002\b\u0014H\u0000\"!\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00018BX\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u001b"}, d2 = {"restaurantStatus", "", "", "getRestaurantStatus", "()Ljava/util/List;", "restaurantStatus$delegate", "Lkotlin/Lazy;", "applyFilters", "Ldatamodels/Restaurant;", "restaurants", "filterEngine", "Lbuisnessmodels/FilterEngine;", "popularFilters", "Ldatamodels/filters/SelectablePopularFilter;", "Ldatamodels/SelectablePopularFilters;", "isFilterOrSortingApplied", "Lkotlin/Function0;", "", "applyFilter", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "applyPopularFilters", "applySort", "isAnyFilterApplied", "applyAllSorting", "updateSponsoredSlots", "sortByAvailability", "com_talabat_talabat_talabat"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ApplyVendorListFiltersUseCaseKt {
    @NotNull
    private static final Lazy restaurantStatus$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, ApplyVendorListFiltersUseCaseKt$restaurantStatus$2.INSTANCE);

    @NotNull
    public static final List<Restaurant> applyAllSorting(@NotNull List<? extends Restaurant> list, @Nullable FilterEngine filterEngine, @NotNull Function1<? super List<? extends Restaurant>, ? extends List<? extends Restaurant>> function1, @NotNull Function1<? super List<? extends Restaurant>, ? extends List<? extends Restaurant>> function12, @NotNull Function1<? super List<? extends Restaurant>, ? extends List<? extends Restaurant>> function13) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(function1, "applySort");
        Intrinsics.checkNotNullParameter(function12, "updateSponsoredSlots");
        Intrinsics.checkNotNullParameter(function13, "sortByAvailability");
        return (List) function13.invoke(function1.invoke(function12.invoke(list)));
    }

    public static /* synthetic */ List applyAllSorting$default(List list, FilterEngine filterEngine, Function1 function1, Function1 function12, Function1 function13, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            filterEngine = GlobalDataModel.filterEngine;
        }
        if ((i11 & 2) != 0) {
            function1 = new ApplyVendorListFiltersUseCaseKt$applyAllSorting$1(filterEngine);
        }
        if ((i11 & 4) != 0) {
            function12 = ApplyVendorListFiltersUseCaseKt$applyAllSorting$2.INSTANCE;
        }
        if ((i11 & 8) != 0) {
            function13 = ApplyVendorListFiltersUseCaseKt$applyAllSorting$3.INSTANCE;
        }
        return applyAllSorting(list, filterEngine, function1, function12, function13);
    }

    @NotNull
    public static final List<Restaurant> applyFilters(@NotNull List<? extends Restaurant> list, @Nullable FilterEngine filterEngine, @Nullable List<SelectablePopularFilter> list2, @NotNull Function0<Boolean> function0, @NotNull Function1<? super List<? extends Restaurant>, ? extends List<? extends Restaurant>> function1, @NotNull Function1<? super List<? extends Restaurant>, ? extends List<? extends Restaurant>> function12, @NotNull Function1<? super List<? extends Restaurant>, ? extends List<? extends Restaurant>> function13) {
        Intrinsics.checkNotNullParameter(list, StoreInfoTrackingProvider.SHOP_TYPE_RESTAURANT);
        Intrinsics.checkNotNullParameter(function0, "isFilterOrSortingApplied");
        Intrinsics.checkNotNullParameter(function1, "applyFilter");
        Intrinsics.checkNotNullParameter(function12, "applyPopularFilters");
        Intrinsics.checkNotNullParameter(function13, "applySort");
        if (!function0.invoke().booleanValue()) {
            return list;
        }
        return (List) function13.invoke(function12.invoke(function1.invoke(list)));
    }

    public static /* synthetic */ List applyFilters$default(List list, FilterEngine filterEngine, List list2, Function0 function0, Function1 function1, Function1 function12, Function1 function13, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            filterEngine = GlobalDataModel.filterEngine;
        }
        FilterEngine filterEngine2 = filterEngine;
        if ((i11 & 8) != 0) {
            function0 = new ApplyVendorListFiltersUseCaseKt$applyFilters$1(filterEngine2, list2);
        }
        Function0 function02 = function0;
        if ((i11 & 16) != 0) {
            function1 = new ApplyVendorListFiltersUseCaseKt$applyFilters$2(filterEngine2);
        }
        Function1 function14 = function1;
        if ((i11 & 32) != 0) {
            function12 = new ApplyVendorListFiltersUseCaseKt$applyFilters$3(list2);
        }
        Function1 function15 = function12;
        if ((i11 & 64) != 0) {
            function13 = new ApplyVendorListFiltersUseCaseKt$applyFilters$4(filterEngine2);
        }
        return applyFilters(list, filterEngine2, list2, function02, function14, function15, function13);
    }

    /* access modifiers changed from: private */
    public static final List<Integer> getRestaurantStatus() {
        return (List) restaurantStatus$delegate.getValue();
    }

    public static final boolean isAnyFilterApplied(@Nullable FilterEngine filterEngine, @Nullable List<SelectablePopularFilter> list) {
        boolean z11;
        boolean z12 = true;
        boolean z13 = false;
        if (filterEngine == null || !filterEngine.isAnyKindOfFilterApplied()) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (list != null) {
            Iterable iterable = list;
            if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                Iterator it = iterable.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (((SelectablePopularFilter) it.next()).isOn()) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            z12 = false;
            z13 = z12;
        }
        return z11 | z13;
    }

    public static /* synthetic */ boolean isAnyFilterApplied$default(FilterEngine filterEngine, List list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            filterEngine = GlobalDataModel.filterEngine;
        }
        return isAnyFilterApplied(filterEngine, list);
    }
}
