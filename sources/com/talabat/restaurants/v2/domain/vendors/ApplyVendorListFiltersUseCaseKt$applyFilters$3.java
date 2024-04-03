package com.talabat.restaurants.v2.domain.vendors;

import datamodels.Restaurant;
import datamodels.filters.SelectablePopularFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Ldatamodels/Restaurant;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ApplyVendorListFiltersUseCaseKt$applyFilters$3 extends Lambda implements Function1<List<? extends Restaurant>, List<? extends Restaurant>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ List<SelectablePopularFilter> f61246g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ApplyVendorListFiltersUseCaseKt$applyFilters$3(List<SelectablePopularFilter> list) {
        super(1);
        this.f61246g = list;
    }

    @NotNull
    public final List<Restaurant> invoke(@NotNull List<? extends Restaurant> list) {
        Intrinsics.checkNotNullParameter(list, "$this$null");
        List<SelectablePopularFilter> list2 = this.f61246g;
        ArrayList arrayList = new ArrayList();
        for (Object next : list) {
            Restaurant restaurant = (Restaurant) next;
            boolean z11 = true;
            if (list2 != null) {
                ArrayList<SelectablePopularFilter> arrayList2 = new ArrayList<>();
                for (Object next2 : list2) {
                    if (((SelectablePopularFilter) next2).isOn()) {
                        arrayList2.add(next2);
                    }
                }
                ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10));
                for (SelectablePopularFilter filter : arrayList2) {
                    arrayList3.add(Boolean.valueOf(filter.getFilter().getPredicate().invoke(restaurant).booleanValue()));
                }
                if (!arrayList3.isEmpty()) {
                    Iterator it = arrayList3.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (!((Boolean) it.next()).booleanValue()) {
                                z11 = false;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
            if (z11) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }
}
