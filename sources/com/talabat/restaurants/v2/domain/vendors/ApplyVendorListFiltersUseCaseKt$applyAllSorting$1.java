package com.talabat.restaurants.v2.domain.vendors;

import buisnessmodels.FilterEngine;
import datamodels.Restaurant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Ldatamodels/Restaurant;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ApplyVendorListFiltersUseCaseKt$applyAllSorting$1 extends Lambda implements Function1<List<? extends Restaurant>, List<? extends Restaurant>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ FilterEngine f61242g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ApplyVendorListFiltersUseCaseKt$applyAllSorting$1(FilterEngine filterEngine) {
        super(1);
        this.f61242g = filterEngine;
    }

    @NotNull
    public final List<Restaurant> invoke(@NotNull List<? extends Restaurant> list) {
        Intrinsics.checkNotNullParameter(list, "$this$null");
        FilterEngine filterEngine = this.f61242g;
        ArrayList<Restaurant> sortRestaurant = filterEngine != null ? filterEngine.sortRestaurant(new ArrayList(list)) : null;
        return sortRestaurant == null ? list : sortRestaurant;
    }
}
